package com.nettyrpc.test;

import java.lang.reflect.Proxy;

import com.nettyrpc.client.proxy.ObjectProxy;

public class MyProxyClient {

	
	
	
	@SuppressWarnings("unchecked")
    public static <T> T create(Class<T> interfaceClass) {
		
		
		return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}
		
		
		, new MyInvocationHandler<T>(interfaceClass));
		
     /*   return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new ObjectProxy<T>(interfaceClass)
        );*/
    }
	
	
	
	
}
