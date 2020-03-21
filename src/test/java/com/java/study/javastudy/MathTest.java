package com.java.study.javastudy;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @program: java-study
 * @description: Math的测试类
 * @author: Mr.Xu
 * @create: 2019/7/9 22:28
 */
public class MathTest {
    @Test
    public void testBloomFilter() {

        char a=49;

        for (int i = 48; i < 128; i++) {
            System.out.print((char)i);
            System.out.print(" ");
        }

        System.out.println((char)1);

    }

    @Test
    public void testProbability() {

        long repeatCount = 0L;

        BloomFilter<Long> longBloomFilter = BloomFilter.create(Funnels.longFunnel(), 100000000, 1E-7);
        long hundredThousand = 100000;
        long oneBillion = 100000000L;
        for (int i = 0; i < hundredThousand; i++) {
            /*  从1亿个数中去10万个不重复的随机数 */
            long next = getNext(1L, oneBillion);

            /*  取到的数对10万取余 */
            long yushu = next % hundredThousand;
            while (!longBloomFilter.put(yushu)) {
                next = getNext(1L, oneBillion);
                /*  取到的数对10万取余 */
                yushu = next % hundredThousand;
                repeatCount++;
            }
        }
        System.out.println(repeatCount);
        System.out.println(hundredThousand);
    }

    static BloomFilter<Long> getLong = BloomFilter.create(Funnels.longFunnel(), 100000000, 1E-7);

    /**
     * 在一个范围内取不重复的数
     *
     * @param start
     * @param end
     * @return
     */
    private long getNext(Long start, Long end) {
        /*  从1亿个数中去10万个不重复的随机数 */
        long next = RandomUtils.nextLong(start, end);
        while (!getLong.put(next)) {
            next = RandomUtils.nextLong(start, end);
        }
        return next;
    }

    @Test
    public void test() {
        System.out.println("绝对值 double = " + Math.abs(-2.3333333333343344232D));
        System.out.println("绝对值 float = " + Math.abs(-2.2111111111111111111111111111111111134F));
        System.out.println("绝对值 int = " + Math.abs(-931141235));
        System.out.println("绝对值 long = " + Math.abs(-3211212112142L));
        System.out.println("=====================================");
        System.out.println("两个数的和 int = " + Math.addExact(999999999, 999999999));
        System.out.println("两个数的和 long = " + Math.addExact(1323243242343222344L, 6323243242343222344L));
        System.out.println("两个数的和 int = " + (0x7fffffff + 632));
        System.out.println("两个数的和 long = " + (6323243242343222344L + 6323243242343222344L));

        System.out.println("=====================================");
        System.out.println("向上取整 double = " + Math.ceil(23.99999999999999999999999932D));
        System.out.println("=====================================");
        System.out.println("向下取整 double = " + Math.floor(23.9932D));

        System.out.println("=====================================");
        System.out.println("使用第二个浮点参数的符号返回第一个浮点参数 float = " + Math.copySign(23.232322F, -223.583F));
        System.out.println("使用第二个浮点参数的符号返回第一个浮点参数 float = " + Math.copySign(-23.232322F, 423.9847F));
        System.out.println("使用第二个浮点参数的符号返回第一个浮点参数 double = " + Math.copySign(232.93D, -42323.08853F));
        System.out.println("使用第二个浮点参数的符号返回第一个浮点参数 double = " + Math.copySign(-232.322D, 5234.23F));


        System.out.println("=====================================");
        System.out.println("减一 int = " + Math.decrementExact(234L));
        System.out.println("减一 double = " + Math.decrementExact(234L));

        System.out.println("=====================================");
        System.out.println("加一 int = " + Math.incrementExact(234L));
        System.out.println("加一 double = " + Math.incrementExact(234L));

        System.out.println("=====================================");
        System.out.println("返回小于或等于代数商的最大 int = " + Math.floorDiv(9, 3));
        System.out.println("返回小于或等于代数商的最大 long = " + Math.floorDiv(241L, 2L));

        System.out.println("=====================================");
        System.out.println("返回 int参数的底部模数 int = " + Math.floorMod(9, 4));
        System.out.println("返回 int参数的底部模数 int = " + Math.floorMod(-9, 4));
        System.out.println("返回 long参数的底模数  double = " + Math.floorMod(241L, 2L));
        System.out.println("返回 long参数的底模数  double = " + Math.floorMod(-241L, 2L));


    }

}
