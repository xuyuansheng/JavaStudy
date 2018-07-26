package com.java.study.javastudy.jvm.oom;

/**
 * java虚拟机栈和本地方法栈溢出
 * VM Args：-Xoss 设置本地方法栈大小 jvm1.6实际无效
 *          -Xss128k  栈容量大小
 *          结果分析: 单个线程下，无论是由于栈帧太大，还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出的都是StackOverflowError异常。
 */
public class JVMStackOverFlowError {


    public static void main(String[] args) {

        JavaVMStackSOF  javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length : "+javaVMStackSOF.stackLength);
            throw e;
        }

    }

   static  class JavaVMStackSOF{
        private int stackLength = 1;
        public void  stackLeak(){
            stackLength++;
            stackLeak();
        }
    }

}
