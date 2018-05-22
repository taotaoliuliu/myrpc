package com.nettyrpc.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class TestReentrantLock {
	
	@Test
	public void test(){
		
		
		ExecutorService exec = Executors.newFixedThreadPool(4);
		
		runtest test =new runtest();
		
		
		exec.submit(test);
		exec.submit(test);
		exec.submit(test);
		exec.submit(test);
		exec.submit(test);
		
		exec.submit(test);
		
		
	}

	
	
	public static void main(String[] args) {
	
		 final ExecutorService exec = Executors.newFixedThreadPool(4);

         final ReentrantLock lock = new ReentrantLock();

         final Condition con = lock.newCondition();

         final int time = 5;

         int aa=10;
  
         MyRunnable myRunnable =new MyRunnable(aa);
         
         Future<?> submit = exec.submit(myRunnable);
         Future<?> submit2 = exec.submit(myRunnable);
      

        // exec.shutdown();
  
     /*    final Runnable add = new Runnable() {
        	 
        	    int aa=10;

           public void run() {

             System.out.println("Pre " + lock);

             lock.lock();

             try {
            	 
            	 aa=aa+1;

             //  con.await(time, TimeUnit.SECONDS);

             } catch (Exception e) {

               e.printStackTrace();

             } finally {

               System.out.println("Post " + lock.toString());

               lock.unlock();

             }

           }

         };*/

        /* for(int index = 0; index < 10; index++)

           exec.submit(myRunnable);*/

       //  exec.shutdown();

       }
		
		
	}
	
