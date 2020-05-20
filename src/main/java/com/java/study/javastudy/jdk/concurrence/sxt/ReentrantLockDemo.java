package com.java.study.javastudy.jdk.concurrence.sxt;

/**
 * 可重入锁: 如果持有锁的对象是自己时,那么还可以再次获得锁   + 计数器增加 1
 */

public class ReentrantLockDemo {
	/**  不可重入锁  */
	Lock lock = new Lock();

	/**
	 * 不可重入锁测试
	 */
	public void unReenTryTest() {
		/** 获取到锁   */
		lock.lock();
		/**  执行业务代码,但是代码内部又一次获取这个锁,因为不可重入 陷入无限等待 */
		doSomeThing();
		lock.unlock();
	}

	public void doSomeThing() {
		lock.lock();
		System.out.println(" 做点什么好呢? ...");
		lock.unlock();
	}

	public static void main(String[] args) {
		/**  测试不可重入锁  */
//		new ReentrantLockDemo().unReenTryTest();

		new ReentrantLockDemo().reenTryLockTest();

	}
	/**   可重入锁 */
	ReenTryLock reenTryLock =new ReenTryLock();


	/**
	 * 可重入锁测试
	 */
	public void reenTryLockTest() {
		reenTryLock.lock();
		doSomeThing2();
		reenTryLock.unlock();
	}

	public  void  doSomeThing2(){
		reenTryLock.lock();
		System.out.println(" 我已经拿到了 "+reenTryLock.getCount()+" 次锁了 .. 并且正在干活! ");
		reenTryLock.unlock();
	}

}

/**
 * 自己先实现一个不可重入锁
 */
class Lock {
	/**
	 * 锁是否已被占用 默认: false
	 */
	private boolean ifLocked = false;

	public synchronized void lock() {
		while (ifLocked) {
			try {
				/**  如果锁被占用,则进入等待 */
				System.out.println(" 锁已被占用 请等待");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/**  lock 被使用 */
		}
		System.out.println(" 锁刚刚已经被占用了 , 下次进来的就要开始等待了 . . ");
		ifLocked = true;
	}

	public synchronized void unlock() {
		ifLocked = false;
		System.out.println("锁已被释放 可以来抢了 ....");
		this.notify();
	}
}

/**
 * 自己实现一个可重入锁
 */
class ReenTryLock {

	// 占用次锁的线程
	private Runnable lockByWho = null;
	// 计数器
	private int count = 0;
	/**
	 * 锁是否已被占用 默认: false
	 */
	private boolean ifLocked = false;

	public synchronized void lock() {
		Thread currentThread = Thread.currentThread();
		while (ifLocked && lockByWho != currentThread) {
			try {
				/**  如果锁被占用,则进入等待 */
				System.out.println(" 锁已被占用 请等待");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/**  lock 被使用 */
		}

		ifLocked = true;
		lockByWho = currentThread;
		count++;
		System.out.println(" 我已经拿到了 "+count+" 次锁了 .. ");
	}

	public synchronized void unlock() {

		if (Thread.currentThread() == lockByWho) {
			System.out.println(" 我已经释放第 "+count+" 次拿到的锁了 .. ");
			count--;
			if (count == 0) {
				/**  多重进入的锁都被释放 */
				ifLocked = false;
				lockByWho = null;
				System.out.println("锁已被彻底释放 大家都可以来抢了 ....");
				this.notify();
			}
		}
	}

	public int getCount() {
		return count;
	}
}