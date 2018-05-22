package com.nettyrpc.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.nettyrpc.test.client.HelloService;
import com.nettyrpc.test.server.HelloServiceImpl;

public class Demo {
	
	public static void main(String[] args) {
		
		
		

ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(16, 16, 600L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(65536));
	    
	    
	    
	    threadPoolExecutor.execute(new Runnable(){

			@Override
			public void run() {
				
				
				
				System.out.println(Thread.currentThread().getName());
				
				
				
				
				
			}
	    	
	    	
	    });
		
		
		
		
		
		

		
	}
	
	@Test
	public void testProxy(){
		
		HelloService create = MyProxyClient.create(HelloService.class);
		
		String hello = create.hello("ffff");
		
		System.out.println(hello);
		
		
		
		
		System.out.println(create);
	}

}
