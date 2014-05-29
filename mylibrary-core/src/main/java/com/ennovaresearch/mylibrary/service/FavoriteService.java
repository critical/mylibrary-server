/**
 * 
 */
package com.ennovaresearch.mylibrary.service;

import java.util.List;

import com.ennovaresearch.mylibrary.model.Favorite;

/**
 * @author ennova
 *
 */
public interface FavoriteService extends CommonService<Favorite> {
	public List<Favorite> findAll();
	
	public Favorite findByISBN(String isbn);
}
