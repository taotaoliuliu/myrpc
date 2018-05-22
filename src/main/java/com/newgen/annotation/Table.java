package com.newgen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value=ElementType.TYPE)//表示该注解用于类上面  
@Retention(RetentionPolicy.RUNTIME) //运行时可以通过反射取得  
public @interface Table {

	
	public String name() default "";  
	
	
}
