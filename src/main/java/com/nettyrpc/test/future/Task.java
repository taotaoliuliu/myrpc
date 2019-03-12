package com.nettyrpc.test.future;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Callable<Integer> {
	
	
	private int total;
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	/**
	 * 内部单例类
	 * @author Administrator
	 *
	 */
	static class Singleton {
		
		

		private static Task instance;
		
		static {
			instance = new Task();
		}
		
		public static Task getInstance() {
			return instance;
		}
		
	}
	
	public static Task getInstance() {
		return Singleton.getInstance();
	}
	
	
	
	
	public ReentrantLock lock = new ReentrantLock();
	public TestFuture future;
	
	

	public TestFuture getFuture() {
		return future;
	}

	public void setFuture(TestFuture future) {
		this.future = future;
	}




	public Condition connected = lock.newCondition();

	public void signalAvailableHandler() {
		lock.lock();
		try {
			connected.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void waitingForHandler() throws InterruptedException {
		lock.lock();
		try {
			connected.await();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public Integer call() throws Exception {
	//	waitingForHandler();
		
		Thread.sleep(5000);

		System.out.println("子线程在进行计算111");
		// Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		MyResult re=new MyResult();
		re.setTotal(sum);
		future.done(re);
		return sum;
	}
}
