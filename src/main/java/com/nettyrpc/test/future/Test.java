package com.nettyrpc.test.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	
	
	public  void signalAvailableHandler() {
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
	
	public  static final ReentrantLock lock = new ReentrantLock();
	

	public static final Condition connected = lock.newCondition();
    public static void main(String[] args) throws Exception {
    		
    	
    
       // ExecutorService executor = Executors.newCachedThreadPool();
        
        
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(16, 16, 600L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(65536));
        Task task = new Task();
        
        Task2 task2 = new Task2();
     
        
        Future<Integer> result = threadPoolExecutor.submit(task);
      
        //需求线程要等待2返回之后 才能执行
     
        Future<Integer> result2 = threadPoolExecutor.submit(task2);
     //   executor.shutdown();
         
        try {
            //Thread.sleep(1000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
         
        System.out.println("主线程在执行任务");
         
        try {
            System.out.println("task运行结果"+result.get());
            System.out.println("task运行结果22:"+result2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        System.out.println("所有任务执行完毕");
    }
}