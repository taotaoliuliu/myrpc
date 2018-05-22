package com.nettyrpc.test.future;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Callable<Integer> {
	public ReentrantLock lock = new ReentrantLock();

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
		waitingForHandler();

		System.out.println("子线程在进行计算111");
		// Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}
