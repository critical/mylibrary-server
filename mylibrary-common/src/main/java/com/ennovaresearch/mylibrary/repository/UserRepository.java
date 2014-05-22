/**
 * 
 */
package com.ennovaresearch.mylibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ennovaresearch.mylibrary.model.Favorite;
import com.ennovaresearch.mylibrary.model.User;

/**
 * @author Fabio
 *
 */
@Repository("userReporitory")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.email = :email")
	public User findByEmail(@Param("email") String email);
	
	@Query("select u from User u where u.uid = :uid")
	public User findByUid(@Param("uid") String uid);
	
	@Query("select f from Favorite f join f.users u where u.uid = :uid")
	public List<Favorite> findAllFavoritesOfUser(@Param("uid") String uid);
}
