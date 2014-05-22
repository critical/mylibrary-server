/**
 * 
 */
package com.ennovaresearch.mylibrary.service;

import java.util.List;

import com.ennovaresearch.mylibrary.model.Favorite;
import com.ennovaresearch.mylibrary.model.User;


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
	public List<Favorite> findAllFavoritesOfUser(String uid);
	
	/**
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);
	
	/**
	 * @return
	 */
	public List<User> findAll();
}
