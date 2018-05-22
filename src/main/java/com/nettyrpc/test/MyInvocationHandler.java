package com.nettyrpc.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import com.nettyrpc.test.client.HelloService;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

public class MyInvocationHandler<T> implements InvocationHandler{
	
	
	  private Class<T> clazz;

	  public MyInvocationHandler(Class<T> clazz) {
	        this.clazz = clazz;
	    }
	
	
	
	
	
	
	
	
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		List<Class> allClassByInterface = ClassUtil.getAllClassByInterface(clazz);
		
		
		System.out.println(allClassByInterface.get(0));
		
		//clazz.getDeclaredClasses()
		
		
		
		Class<?> serviceClass = clazz.getClass().getDeclaringClass();
			
		
		 //FastClass serviceFastClass = FastClass.create(serviceClass);
	     //FastMethod serviceFastMethod = serviceFastClass.getMethod(name, args);
		
		
		//Method method2 = serviceClass.getMethod(methodname, method.getParameterTypes());
      //  method2.setAccessible(true);

			
		
		Class<?>[] declaredClasses = clazz.getDeclaredClasses();
  
        return method.invoke(allClassByInterface.get(0).newInstance(), args);
        
        
        
	}
	
	public static void main(String[] args) {
		
		List<Class> allClassByInterface = ClassUtil.getAllClassByInterface(HelloService.class);
		
		
		System.out.println(allClassByInterface.size());
		
		
		
		
	}

}
