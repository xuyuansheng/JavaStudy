package com.java.study.javastudy;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: java-study
 * @description: Math的测试类
 * @author: Mr.Xu
 * @create: 2019/7/9 22:28
 */
public class MathTest {

    @Test
    public void testSimpleMath() {
        int pow_2 = (int) Math.pow(2, -2);
        int pow_1 = (int) Math.pow(2, -1);
        int pow0 = (int) Math.pow(2, 0);
        int pow1 = (int) Math.pow(2, 1);
        int pow2 = (int) Math.pow(2, 2);

        StringBuffer stringBuffer = new StringBuffer("*****");
        stringBuffer.replace(0, 3, "|");
    }

    @Test
    public void testBloomFilter() {

        char[][] chars = new char[][]{{1, 2, 3}, {1, 2, 3}};
        char[][] array = new char[][]{
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};

        new MathTest().numIslands(array);
    }

    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = xLen > 0 ? grid[0].length : 0;
        int islands = 0;
        Queue<int[]> queue = new LinkedBlockingDeque();
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                char aChar = grid[i][j];
                if (aChar == '1') {
                    islands++;
                    queue.add(new int[]{i, j});
                    deepSearch(grid, queue, xLen, yLen);
                }
            }
        }
        return islands;
    }

    private void deepSearch(char[][] grid, Queue<int[]> queue, int xLen, int yLen) {
        int[][] coordinate = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            grid[poll[0]][poll[1]] = '0';
            for (int k = 0; k < 4; k++) {
                int xt = poll[0] + coordinate[k][0];
                int yt = poll[1] + coordinate[k][1];
                if (xt < 0 || xt >= xLen || yt < 0 || yt >= yLen || grid[xt][yt] == '0') {
                    continue;
                }
                queue.add(new int[]{xt, yt});
                /*  广度优先时防止同一个数据重复进入队列 */
                grid[xt][yt] = '0';
            }
        }
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


        System.out.println(String.format("返回以E为底的对数 Math.log(%s) = " + Math.log(Math.E), "E"));
        System.out.println(String.format("返回以10为底的对数 Math.log10(%s) = " + Math.log10(10), 10));
        System.out.println(String.format("返回(n+1)以E为底的对数 Math.log1p(%s) = " + Math.log1p(Math.E - 1), "Math.E-1"));

        System.out.println(String.format("绝对值 = Math.abs(%s) " + Math.abs(-2.3333333333343344232D), "-2.3333333333343344232D"));
        System.out.println("两个数的和  Math.addExact(a,b) = " + Math.addExact(1212231242312124L, 1232142131212L));


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
