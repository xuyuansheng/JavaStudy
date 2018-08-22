package com.java.study.javastudy.jvm.gc;

/**
 * 引用计数器gc算法： 给对象添加一个引用计数器，每当有一个地方引用他时，计数器就加1 ，引用失效就减1，任何时刻任何
 * 计数器为0的对象就会被回收
 * 优点：实现简单 判断效率高  缺点：不能解决对象互相引用问题
 * 测试结果： 发生了gc行为，证明jvm使用的不是计数器算法
 *  VM Args： -XX:+PrintGCDetails  打印gc日志
 */
public class ReferenceCounter {


    public static void main(String[] args) {
        CountGC a = new CountGC();
        CountGC b = new CountGC();
        a.instence = b;
        b.instence = a;

        a =null;
        b=null;
        System.gc();

    }

    static class CountGC {

        public Object instence = null;

        private static int _1MB = 1024 * 1024;
        /**
         * 此属性唯一的意义就是占用点内存，以便在GC日志中看清是否被回收过
         */
        private byte[] bigSize = new byte[_1MB];
    }

}
