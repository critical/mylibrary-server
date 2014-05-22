/**
 * 
 */
package com.ennovaresearch.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ennovaresearch.mylibrary.model.Favorite;

/**
 * @author ennova
 *
 */
@Repository("favoriteRepository")
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
	
	@Query("select f from Favorite f where f.isbn = :isbn")
	public Favorite findByISBN(@Param("isbn") String isbn);
}
