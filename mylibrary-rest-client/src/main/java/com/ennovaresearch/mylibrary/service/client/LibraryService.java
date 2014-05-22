/**
 * 
 */
package com.ennovaresearch.mylibrary.service.client;

import java.util.List;

/**
 * @author ennova
 *
 */
public interface LibraryService<T> {
	
	/**
	 * @return
	 */
	public List<T> getClassicBooks();
	
	/**
	 * @param code
	 * @return
	 */
	public T getBookDetail(String code);
}
