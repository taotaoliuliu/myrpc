package com.nettyrpc.server;

import com.nettyrpc.test.client.HelloServiceImpl;

public class Demo {

	
		public static void main(String[] args) {
			
			
			
			HelloServiceImpl hello =new HelloServiceImpl();
			
			String simpleName = hello.getClass().getAnnotation(RpcService.class).value().getSimpleName();
			String name = hello.getClass().getAnnotation(RpcService.class).value().getName();
			
			
			System.out.println(simpleName+"###########"+name);
			
			
		}
}
