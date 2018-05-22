package com.newgen.base;

import java.util.List;
import java.util.Map;


/**
 * �?��的Mapper继承这个接口
 * 已经实现民基本的 �?�?�?查接�?不需要重复写
 * @author	
 * @date 2015-2-10
 * @Email: 
 * @version
 */
public interface BaseMapper<T>{
	/**
	 * 返回分页后的数据
	 * @param List
	 * @param t
	 * @return
	 */
	public List<T> query(Map<String, Object> map);
	
	
	/**
	 * 返回所有数据
	 * @param t
	 * @return List<T>
	 */
	public List<T> queryAll(T t);

	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;

	/**
	 * 更新数据
	 * @param t
	 * @throws Exception
	 */
	public void update(T t) throws Exception;

	/**
	 * 返回某一条数据
	 * @param id
	 * @return T
	 */
	public T getById(String id);

	/**
	 * 保存数据
	 * @param t
	 * @throws Exception
	 */
	public void add(T t) throws Exception;
	
	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception
	 */
	public void delete(String[] ids)throws Exception;
}
