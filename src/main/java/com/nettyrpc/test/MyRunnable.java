package com.nettyrpc.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable{
	
	
	  final ReentrantLock lock = new ReentrantLock();

      final Condition con = lock.newCondition();
      final Condition con2 = lock.newCondition();
	
	public int aa;
	
	public MyRunnable(int aa){
		
		this.aa=aa;
		
	}

	@Override
	public void run() {
		
		try {
			
			lock.lock();
			con2.await();

			aa=aa+1;
			System.out.println(aa);
			//con.signal();
			
			
			//con2.await();
			
			System.out.println("@@@"+Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			lock.unlock();
		}
		
	}

}
