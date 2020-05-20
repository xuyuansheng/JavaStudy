package com.java.study.javastudy.jdk.concurrence.sxt;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS
 */
public class CasDemo {
	/**
	 * 库存
	 */

	private static AtomicInteger atomicInteger = new AtomicInteger(5);
	static Map<String, String> finalResult = new ConcurrentHashMap<>();

	public static void main(String[] args) throws InterruptedException {

		ThreadLocal<Integer> get = ThreadLocal.withInitial(() -> 0);


		/**   6  个线程去抢5 个商品*/
		for (int i = 0; i < 6; i++) {
			new Thread(() -> {
				Thread t = Thread.currentThread();


				int result = 0;

				do {
					result = atomicInteger.decrementAndGet();
					if (result < 0 && get.get() == 0) {
						/**  此时表示刚刚进来抢就没有了  一个都没抢到  */
						String str = t.getName() + " 你一个都没抢到 , 下次再来吧 ... ";
						System.out.println(str);
						finalResult.put(t.getName(), str);
					} else if (result < 0 && get.get() > 0) {
						String str = t.getName() + " 抢到了" + get.get() + "个商品 , 还剩余 0----" + " 个 ..";
						System.out.println(str);
						finalResult.put(t.getName(), str);
					} else if (result == 0) {
						int getN = get.get() + 1;
						get.set(getN);
						String str = t.getName() + " 抢到了" + get.get() + "个商品 , 这已经是最后一个了 恭喜你.";
						System.out.println(str);
						finalResult.put(t.getName(), str);
					} else {
						int getN = get.get() + 1;
						get.set(getN);
						String str = t.getName() + " 抢到了" + get.get() + "个商品 , 还剩余 " + result + "---= 个 ..";
						System.out.println(str);
						finalResult.put(t.getName(), str);
					}

				} while (result > 0);
			}).start();


		}
		/**  此处需要暂停一下  不然你输出的同时其他线程正在向里面添加数据 导致输出的结果不对 */
		Thread.sleep(3000);
		System.out.println("===================================");
		finalResult.entrySet().stream().forEach((v) -> {
			System.out.println(v.getValue());
		});

	}

}
