/**
 * 
 */
package com.ennovaresearch.mylibrary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ennovaresearch.mylibrary.model.Favorite;
import com.ennovaresearch.mylibrary.repository.FavoriteRepository;
import com.ennovaresearch.mylibrary.service.FavoriteService;

/**
 * @author ennova
 *
 */
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Override
	public List<Favorite> findAll() {
		return favoriteRepository.findAll();
	}
	
	public Favorite findByISBN(String isbn) {
		return favoriteRepository.findByISBN(isbn);
	}
	
	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.CommonService#findById(java.lang.Integer)
	 */
	@Override
	public Favorite findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean delete(Favorite object) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.CommonService#save(java.lang.Object)
	 */
	@Override
	public Favorite save(Favorite object) {
		// TODO Auto-generated method stub
		return null;
	}

}
