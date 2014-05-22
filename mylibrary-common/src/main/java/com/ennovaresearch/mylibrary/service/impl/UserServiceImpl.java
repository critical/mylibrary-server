/**
 * 
 */
package com.ennovaresearch.mylibrary.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ennovaresearch.mylibrary.model.Favorite;
import com.ennovaresearch.mylibrary.model.User;
import com.ennovaresearch.mylibrary.repository.UserRepository;
import com.ennovaresearch.mylibrary.service.UserService;

/**
 * @author Fabio
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.CommonService#findById(java.lang.Integer)
	 */
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.UserService#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.UserService#findAll()
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.CommonService#deleteById(java.lang.Integer)
	 */
	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.CommonService#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(User object) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.CommonService#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public User save(User object) {
		return userRepository.save(object);
	}

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.UserService#save(java.lang.String, java.lang.String)
	 */
	@Override
	public User save(String email, String uid) {
		User u = new User();
		u.setUid(uid);
		u.setEmail(email);
		return userRepository.save(u);
	}

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.UserService#findAllFavoritesOfUser(java.lang.String)
	 */
	@Override
	public List<Favorite> findAllFavoritesOfUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
