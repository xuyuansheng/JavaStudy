package com.java.study.javastudy.jvm.gc;

/**
 * 根搜索算法： 通过一系列名为”GC Roots“的对象作为起点，从这些节点向下搜索，找不到（即不可达）则表明
 * 此对象不可用，可以回收
 *
 * ”GC Roots“ 包含以下几种：
 *      虚拟机栈（栈帧中的本地变量表）中的引用对象
 *      方法区中的类静态属性引用的对象
 *      方法区中的常量应用的对象
 *      本地方法栈中JNI（即一般说的native方法）引用的对象
 *
 *
 * 此代码演示的两点：
 * 1.对象可以在被GC时自我拯救
 * 2.自救的机会只有一次，因为对象的finalize()方法只会被系统自动调用一次。
 *
 * 结果分析： 代码中两次gc 第一次因为finalize()被执行，自救成功，第二次失败
 *
 */
public class FinalizeEscapGC {

    private static  FinalizeEscapGC  SAVE_HOOK =null;

    public  void  isAlive(){
        System.out.println("是滴！俺还活着。");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 方法被执行！");
        //将自己引用到 FinalizeEscapGC.SAVE_HOOK 静态属性上，以此来自救
        FinalizeEscapGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapGC();
        //第一次成功自救
        SAVE_HOOK = null;
        System.gc();
        //因为Finalizer方法优先级很低，暂停5秒 等一下
        Thread.sleep(500);
        if(SAVE_HOOK==null){
            System.out.println("第一次自救失败！");
        }else {
            SAVE_HOOK.isAlive();
        }
//----------------------------------我是华丽的分割线------------------------------------------------
        //第二次自救失败
        SAVE_HOOK = null;
        System.gc();
        //因为Finalizer方法优先级很低，暂停5秒 等一下
        Thread.sleep(500);
        if(SAVE_HOOK==null){
            System.out.println("第二次自救失败！");
        }else {
            SAVE_HOOK.isAlive();
        }

    }



}
