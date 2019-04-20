package com.java.study.javastudy.concurrence.sxt;

/**
 * ThreadLocal:每个线程自身的存储本地、局部区域
 *  get/set/initialValue
 *  官方建议使用private static 修饰
 * @author
 *
 */
public class ThreadLocalDemo {

	/**  创建一个静态threadLocal变量  给个初始值 200  */
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()-> 200);


	public static void main(String[] args) {
		//获取值
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		//设置值
		threadLocal.set(99);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

		new Thread(new MyRun()).start();
	}


	public static  class MyRun implements Runnable{


		public MyRun() {
				/**  注意 此处还是在这个线程的父线程内,拿到的值是父线程内的值, 所以在这里改变的值是不会应用到子线程的  */
			System.out.println(Thread.currentThread().getName()+"   constructor-->"+threadLocal.get());
			threadLocal.set(23);
		}

		public void run() {
				/**  此处拿到的threadLocal的值是初始化时候的值,其他线程的改变不会造成影响 */
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
				/**  此时的改变会在本线程内造成影响 */
			threadLocal.set((int)(Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}
	}
}
