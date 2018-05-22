package com.newgen.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
	
	   /** 
     * 首字母转大写 
     * @param s 
     * @return 
     */  
    public static String toUpperCaseFirstOne(String s)  
    {  
        if(Character.isUpperCase(s.charAt(0)))  
            return s;  
        else  
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();  
    } 
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		User user = new User();  
        user.setId(1);  
        user.setName("wang");  
        user.setAge(89);  
        
        Class  userClazz = user.getClass();  
        
      ///  userClazz.
        
        
        Table table = (Table) userClazz.getAnnotation(Table.class); //得到类的注解   
        System.out.println("表名称 ： "+table.name() ); //取得注解的名称 属性  
        
        
        Field[] fields = userClazz.getDeclaredFields();
        
        System.out.println(fields.length);
        
        for(int i=0;i<fields.length;i++ ){ 
        	
        	   Field field = fields[i]; 
        	   
        	   field.setAccessible(true);//可以访问私有变量 
        	   
        	   System.out.println(field.getName());
        	   
        	   Column column  = field.getAnnotation(Column.class );//得到属性上的注解 
        	   
        	   
               System.out.println( "column的注解名称:"+column.value()+"   注解：isKey===  "+column.isKey() );//打印属性上的注解
               String fieldName = field.getName(); //得到属性名称  
               
               Method method = userClazz.getMethod("get"+toUpperCaseFirstOne(fieldName) );//调用get取得该对象的值  
               System.out.println( fieldName + "  调用字段get方法取出字段值  "+  method.invoke(user) );  
        	
        	
        }
        
        
        
        
        
		
		
	}

}
