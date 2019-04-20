package com.java.study.javastudy.concurrence.sxt;

/**
 *   volatile 关键字的作用
 */
public class VolatileDemo {

	private volatile static int num = 0;

	public static void main(String[] args) throws InterruptedException {


		new Thread(() -> {
			while (num == 0) {
				/**  此处不要做任何操作,让电脑工作大道极限,然后再在后面改变num的值 发现循环还是没有结束  */
				/**   但是如果把num 加上volatile 关键字  就可以防止num的改变没有刷新回主内存,就可以保证数据的可见性了
				 *  但是注意 volatile不能保证操作的原子性 */

			}
		}).start();

		Thread.sleep(2000);
		num = 1;
	}

}

/**
 * 双重检测 的单例模式
 *
 */
class DubboCheckedVolatileSingleton {


	public static void main(String[] args) {
		DubboCheckedVolatileSingleton dubboCheckedVolatileSingleton;
		new Thread(() -> {
			DubboCheckedVolatileSingleton.getInstance().print();
		}, "name").start();

		DubboCheckedVolatileSingleton.getInstance().print();

	}

	/**
	 * 此处volatile关键字是保证对象创建完了立即同步到主存,防止其他线程拿到空引用  注意:volatile说法还没得到验证
	 */
	private static DubboCheckedVolatileSingleton dubboCheckedVolatileSingleton;

	private DubboCheckedVolatileSingleton() {
		try {
			/**  模拟大对象创建太耗时 */

			if (dubboCheckedVolatileSingleton==null) {
				System.out.println("线程 "+Thread.currentThread().getName()+" 正在慢慢的创建对象");
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static DubboCheckedVolatileSingleton getInstance() {
		/**  第一重check 如果有对象了就直接返回实例,防止不必要的锁 */
		if (dubboCheckedVolatileSingleton != null) {
			return dubboCheckedVolatileSingleton;
		}
		synchronized (DubboCheckedVolatileSingleton.class) {
				/**  第二重check */
			if (dubboCheckedVolatileSingleton != null) {
				return dubboCheckedVolatileSingleton;
			}
			dubboCheckedVolatileSingleton = new DubboCheckedVolatileSingleton();
		}

		return dubboCheckedVolatileSingleton;
	}


	private void print(){
		System.out.println("输出了啥啥啥"+Thread.currentThread().getName()+"--->"+this);
	}

}