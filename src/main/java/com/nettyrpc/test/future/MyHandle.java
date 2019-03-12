package com.nettyrpc.test.future;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyHandle {

    private ConcurrentHashMap<String, TestFuture> pendingRPC = new ConcurrentHashMap<String, TestFuture>();

	public TestFuture send(Task task){
		
		TestFuture futre =new TestFuture();
		
		task.setFuture(futre);

		ExecutorService ex = Executors.newCachedThreadPool();

        ex.submit(task);
        
        Task instance = Task.getInstance();
        //Thread.sleep("");
     //   futre.done(instance);
        
        pendingRPC.put("xx", futre);
		
		return futre;
	}

}
