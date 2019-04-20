package com.java.study.javastudy.concurrence.sxt;


/**
 * 协作模型:生产者消费者实现方式一: 管程法
 */

public class Cotest01 {

	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor("生产者",container).start();
		new Consumer("消费者",container).start();
	}
}

// 生产者 (多线程)

class Productor extends Thread {

	private SynContainer synContainer;

	public Productor(String name, SynContainer synContainer) {
		super(name);
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		//一个线程生产的馒头
		for (int i = 0; i < 100; i++) {
			synContainer.push(new Steamedbun(i));
			System.out.println("生产的馒头id为: " + i);
		}

	}
}
// 消费者 (多线程)

class Consumer extends Thread {

	private SynContainer synContainer;

	public Consumer(String name,SynContainer synContainer) {
		super(name);
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		//一个线程消费的馒头
		for (int i = 0; i < 100; i++) {
			Steamedbun bun = synContainer.pop();
			System.out.println("消费的馒头id为 : " + bun.id);
		}

	}
}

//缓冲区  栈方式 先进后出 后进先出方式消费
class SynContainer {
	Steamedbun[] buns = new Steamedbun[10]; //存储容器
	int count = 0; //计数器 缓冲区中的馒头个数

	//存储 生产 放入一个馒头到队尾
	public synchronized void push(Steamedbun bun) {
		//存在空间
		if (count >= buns.length) {
			// 空间不足  不能生产
			try {
				this.wait();// wait() 等待会释放锁
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buns[count] = bun;
		count++;
		// 向里面存入了数据  可以通知消费者来消费了
		this.notifyAll();
	}

	//获取 消费
	public synchronized Steamedbun pop() {
		//何时消费 容器中是否存在数据
		if(count<1){
			//  容器没有馒头了  等待生产者生产
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		Steamedbun bun = buns[count];
		// 已经消费了一个了,释放出来了空间了   可以通知生产者继续生产了
		this.notifyAll();
		return bun;
	}
}

//馒头(被消费的物品)
//馒头
class Steamedbun {
	int id;

	public Steamedbun(int id) {
		this.id = id;
	}

}
