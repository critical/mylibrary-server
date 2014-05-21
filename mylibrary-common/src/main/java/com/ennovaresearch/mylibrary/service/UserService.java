/**
 * 
 */
package com.ennovaresearch.mylibrary.service;

import java.util.List;

import com.ennovaresearch.mylibrary.util.Constants.ModelMetadata.Favorite;
import com.ennovaresearch.mylibrary.util.Constants.ModelMetadata.User;

/**
 * @author ennova
 *
 */
public interface UserService extends CommonService<User> {
	/**
	 * @param email
	 * @param uid
	 * @return
	 */
	public User save(String email, String uid);
	
	/**
	 * @return
	 */
	public List<Favorite> findAllFavorites();
}
