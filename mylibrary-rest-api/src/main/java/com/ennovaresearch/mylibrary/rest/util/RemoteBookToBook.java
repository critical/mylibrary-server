/**
 * 
 */
package com.ennovaresearch.mylibrary.rest.util;

import org.springframework.cglib.core.Transformer;

import com.ennovaresearch.mylibrary.model.Book;
import com.ennovaresearch.mylibrary.model.client.RemoteBook;

/**
 * @author ennova
 *
 */
public class RemoteBookToBook implements Transformer {

	/* (non-Javadoc)
	 * @see org.springframework.cglib.core.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Book transform(Object arg0) {
		if(arg0 instanceof RemoteBook) {
			return new Book(((RemoteBook) arg0).getId(), ((RemoteBook) arg0).getIdCover());
		}
		return null;
	}

}
