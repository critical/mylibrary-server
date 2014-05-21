/**
 * 
 */
package com.ennovaresearch.mylibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ennovaresearch.mylibrary.model.User;

/**
 * @author Fabio
 *
 */
@Repository("userReporitory")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.email = :email")
	public User findByEmail(@Param("email") String email);
}
