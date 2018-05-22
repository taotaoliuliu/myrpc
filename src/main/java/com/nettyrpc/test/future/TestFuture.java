package com.nettyrpc.test.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFuture implements Future<Object>{

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		
		System.out.println("ISdone");
		
		return false;
	}

	@Override
	public Object get() throws InterruptedException, ExecutionException {
		return "dddddddddd";
	}

	@Override
	public Object get(long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		try {
			
			List<TestFuture> list =new ArrayList<TestFuture>();
			
			
			TestFuture future =new TestFuture();
			
			TestFuture future2 =new TestFuture();
			
			
			list.add(future);
			list.add(future2);
			
			
			for(TestFuture test : list){
				
				
				System.out.println(test.get());
				
			}
			
				
			
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
