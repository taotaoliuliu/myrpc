package com.nettyrpc.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;


public class AQSTest {

    private static Sync sync;

	static class Sync extends AbstractQueuedSynchronizer{
		

		 
        //future status
        private final int done = 1;
        private final int pending = 0;

		@Override
		protected boolean tryAcquire(int arg) {
				
			return getState() == done;
		}

		@Override
		protected boolean tryRelease(int arg) {
			// TODO Auto-generated method stub
			 if (getState() == pending) {
	                if (compareAndSetState(pending, done)) {
	                    return true;
	                }
	            }
	            return false;	
	            
		
		}
		
		 public boolean isDone() {
	            getState();
	            return getState() == done;
	        }

		
		
	}
	
	
	public static void main(String[] args) {
		sync=new Sync();
		
		System.out.println(sync.isDone()+"1111111111");

		
		
		sync.acquire(1);
		
		System.out.println(sync.isDone()+"2222222222");

		System.out.println("aaaaaaaaa");
		
		sync.release(1);
		System.out.println(sync.isDone()+"33333333333");

		System.out.println("bbbbbbb");

	}
	
}
