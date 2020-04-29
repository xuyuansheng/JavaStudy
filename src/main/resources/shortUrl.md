#记一次短链系统设计:
 ##遇到的问题:   
  1. 发号器选择(最终选择为使用乐观锁方式实现的数据库发号)  
  2. 数据存储(mysql)  
  3. 为什么不使用雪花算法发号  
  4. 发号器并发测试tps不高怎么解决  
  5. mysql数据库字段值默认不区分大小写,导致短链重复

## 发号器选择:

1: 雪花算法 ,   
2:数据库乐观锁发号(不停的更新数据库中的一条数据来发号) 3:多个数据库乐观锁发号器(相当于2的扩展)  

## 数据存储:

1,关系数据库mysql存储,数据结构上使用分库分表和读写分离,使用的组件是ShardingJdbc ,分库是通过业务去区分,不同的业务场景数据存储到不同的库中, 每个库中直接使用100个表来存储数据 
分库字段为dbShare,路由规则为 :database-strategy.inline.algorithm-expression = ds$->{dbShare}      

分表字段为 tableShare, 路由规则为: table-strategy.inline.algorithm-expression = t_shorturl$->{tableShare % 100}      

2,使用Hbase(因为不熟悉,所以没使用)   

## 为什么不使用雪花算法发号:

   首先我们的短链是一个62进制的字符串(网上的短链生成规则都是这个,原理是低进制转换为高进制长度会减短,具体请自行百度),这个字符串是通过发号器分发的一个Long类型数据转换而来,  
雪花算法的正好是生成一个Long类型数据,看起来很合适,但是,雪花算法的发号是随着时间增长而增长的,即使把起始偏移量设置的很接近当前时间,但是很快会增长到一个很大的数字,这时转换后的短链至少都会有10位长度,但是我们的要求是6为最多,所以只能抛弃这个方案  

## 发号器并发测试tps不高怎么解决:

  1.首先发号不能一个一个发,这样单点发号器肯定不能抗住很高的并发,所以我们可以一段一段的发,比如每次发给一个微服务的实例1000个号,预存到内存,这样就可以减少很多并发,不过这个方案的问题是一旦服务重启,那么内存中未消耗的号码会被浪费,这时就要根据你们自己的业务来权衡这个值需要设置为多少了. 
  2.即使分段发,当你有批量生成短链的业务时,这样每一次请求就会消耗更多的号,如 :你每次发1000个号 ,但是批量接口每次也消耗1000个号,那么这样就和一次发一个好没有区别了.  
    对于2的问题解决方案: 
    2.1 限制批量接口的生成数量,不能超过发号的个数1/10,但是这样每次发号需要更多个,那么浪费的可能也更大  
    2.2 水平扩展,发号器相当于数据表中一条数据而已(具体实现后面有介绍),那么我们可以使用100个发号器,每个发号器发不同段的号码,如:1发号器发出的号码对100取余都是1 ,2发号器发出的号码对100取余都是2 ,以此类推. 这样就可以瞬间把并发能力提高100倍.这样90%的业务场景都能抗住非常高的tps了
      

## mysql数据库字段值默认不区分大小写,导致短链重复:

  因为mysql数据库的值不区分大小写,那么发号后的短链gd,gD,Gd,GD在数据库中都是同一个号(因为测试环境我使用的3个表,所以肯定有一个数据会重复插入),但是实际应该是多个,那么插入数据库时就会违反了唯一索引原则,导致插入失败.但是因为一开始不知道这个问题,一直以为是发号器问题,导致发号重复了,经过千辛万苦的排出得出这么个结论.唉...  
  

## 发号器: 数据库中字段

  
   id:  发号器id ,   
   min_id:  当前发号器已经发出号码段的最小id  
   max_id:  当前发号器已经发出号码段的最大id 
   step:   每次发号的个数 
   (number_step: 发号的间隔,实际是你有多少个发号器就是多少,发号开始后就不能改变,此字段我没有存在数据库,而是放在发号的业务代码中,且这个字段是跟具体的发号实现相关的,所以看个人选择)   
   
   **原理** : 乐观锁 ,每次发号先查数据库,然后以发号器id 和查到的max_id(min_id)作为条件来更新表数据,如果成功表示发号成功,失败则发号失败,此时你可以再尝试重新发号即可. 
   

## 数据表的字段 :

id , shortUrl ,longUrl ,dbShare ,tableShare , 其他业务字段等
   
   

## 分库分表的配置 :

   ####所有数据源配置 共有两个主库master0，master1，四个从库master0slave0，master0slave1，master1slave0，master1slave1
   spring.shardingsphere.datasource.names = master0,master1,master0slave0,master1slave0
   \#master0 主库0 作为默认库使用
   spring.shardingsphere.datasource.master0.type = com.zaxxer.hikari.HikariDataSource
   spring.shardingsphere.datasource.master0.driver-class-name = com.mysql.cj.jdbc.Driver
   spring.shardingsphere.datasource.master0.jdbc-url = jdbc:mysql://xxx:3306/short_url?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai
   spring.shardingsphere.datasource.master0.username = 
   spring.shardingsphere.datasource.master0.password = 
   \#master0slave0 主库0的从库0
   spring.shardingsphere.datasource.master0slave0.type = com.zaxxer.hikari.HikariDataSource
   spring.shardingsphere.datasource.master0slave0.driver-class-name = com.mysql.cj.jdbc.Driver
   spring.shardingsphere.datasource.master0slave0.jdbc-url = jdbc:mysql://xxx:3306/short_url?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai
   spring.shardingsphere.datasource.master0slave0.username = 
   spring.shardingsphere.datasource.master0slave0.password = 
   
   \#master1 主库1 要配置分库规则才能定位到这个库
   spring.shardingsphere.datasource.master1.type = com.zaxxer.hikari.HikariDataSource
   spring.shardingsphere.datasource.master1.driver-class-name = com.mysql.cj.jdbc.Driver
   spring.shardingsphere.datasource.master1.jdbc-url = jdbc:mysql://xxx:3306/short_url?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai
   spring.shardingsphere.datasource.master1.username = 
   spring.shardingsphere.datasource.master1.password = 
   \#master1slave0 主库1的从库0
   spring.shardingsphere.datasource.master1slave0.type = com.zaxxer.hikari.HikariDataSource
   spring.shardingsphere.datasource.master1slave0.driver-class-name = com.mysql.cj.jdbc.Driver
   spring.shardingsphere.datasource.master1slave0.jdbc-url = jdbc:mysql://xxx:3306/short_url?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai
   spring.shardingsphere.datasource.master1slave0.username = 
   spring.shardingsphere.datasource.master1slave0.password = 
   
   \#t_shorturl表的分库分表策略配置
   spring.shardingsphere.sharding.tables.t_shorturl.actual-data-nodes = ds$->{0..1}.t_shorturl$->{0..99}
   spring.shardingsphere.sharding.tables.t_shorturl.database-strategy.inline.sharding-column = dbShare
   spring.shardingsphere.sharding.tables.t_shorturl.database-strategy.inline.algorithm-expression = ds$->{dbShare}
   spring.shardingsphere.sharding.tables.t_shorturl.table-strategy.inline.sharding-column = tableShare
   spring.shardingsphere.sharding.tables.t_shorturl.table-strategy.inline.algorithm-expression = t_shorturl$->{tableShare % 100}
   
   \#读写分离主从配置
   spring.shardingsphere.sharding.master-slave-rules.ds0.master-data-source-name = master0
   spring.shardingsphere.sharding.master-slave-rules.ds0.slave-data-source-names = master0slave0
   spring.shardingsphere.sharding.master-slave-rules.ds1.master-data-source-name = master1
   spring.shardingsphere.sharding.master-slave-rules.ds1.slave-data-source-names = master1slave0
   \#日志打印配置
   spring.shardingsphere.props.sql.show = false
   \#不参与分库分表的默认库配置 (即:master0,master0slave0 会作为默认的库用来读写)
   spring.shardingsphere.sharding.default-data-source-name = ds0



## 发号器代码:

```
import com.ec.business.shorturl.domain.NumberDTO;
import com.ec.business.shorturl.infrastructure.GeneratorMapper;
import com.ec.common.config.ShortUrlApolloConfig;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 标志生成器(发号器)
 *
 * @author 020102
 */
@Repository
public class SignGenerator {

    /**  一些配置属性  */
    @Autowired
    private ShortUrlApolloConfig shortUrlApolloConfig;

    @Autowired
    public SignGenerator(GeneratorMapper dbGenerator) {
        this.dbGenerator = dbGenerator;
    }

    /**  操作数据库Mapper */
    private final GeneratorMapper dbGenerator;

    private NumberDTO numberDtoRange = null;

    /**
     * 发号步长,此值一旦确定就不能改变
     */
    private final Long numberStep = 100L;


    /**
     * 发号器
     *
     * @param times 重试次数
     * @return
     */
    public Long getNumber(Integer times) {
        Long number = null;
        while (times > 0 && (number = this.getNumber()) == null) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
            times--;
        }
        return number;
    }


    /**
     * 发号器
     *
     * @return 号码结果
     */
    private Long getNumber() {
        synchronized (SignGenerator.class) {
            if (numberDtoRange == null || numberDtoRange.getNextNumber() > numberDtoRange.getCurrent_max_id()) {
                /* 还没发过号 或者 已使用完了则重新获取号段 */
                numberDtoRange = getNumberRange(RandomUtils.nextInt(1, 101));
            }
            if (numberDtoRange == null) {
                /* 发号失败 */
                return null;
            } else {
                /* 发号成功 */
                Long number = numberDtoRange.getNextNumber();
                numberDtoRange.setNextNumber(number + numberStep);
                return number;
            }
        }
    }


    /**
     * 获取号段
     * shortUrlApolloConfig.getIncrementStep() 为每次发号个数
     * @param id 发号器id
     * @return
     */
    private NumberDTO getNumberRange(Integer id) {
        NumberDTO byId = dbGenerator.getByGeneratorId(id);
        Long oldMax = byId.getCurrent_max_id();
        byId.setOld_current_max_id(oldMax);
        byId.setCurrent_min_id(oldMax + numberStep);
        byId.setCurrent_max_id(oldMax + shortUrlApolloConfig.getIncrementStep() * numberStep);
        byId.setNextNumber(byId.getCurrent_min_id());
        byId.setIncrement_step(shortUrlApolloConfig.getIncrementStep());
        int update = dbGenerator.update(byId);
        if (update > 0) {
            return byId;
        } else {
            return null;
        }
    }

}

```
