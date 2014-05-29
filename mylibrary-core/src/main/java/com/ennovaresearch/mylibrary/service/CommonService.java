/**
 * 
 */
package com.ennovaresearch.mylibrary.service;


/**
 * @author ennova
 *
 */
public interface CommonService<T> {
	
	/**
	 * @param id
	 * @return
	 */
	public T findById(Integer id);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id);
	
	/**
	 * @param object
	 * @return
	 */
	public boolean delete(T object);
	
	/**
	 * @param object
	 * @return
	 */
	public T save(T object);
}
