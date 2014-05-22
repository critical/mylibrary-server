/**
 * 
 */
package com.ennovaresearch.mylibrary.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ennovaresearch.mylibrary.model.Favorite;
import com.ennovaresearch.mylibrary.model.User;
import com.ennovaresearch.mylibrary.rest.util.URLMapping;
import com.ennovaresearch.mylibrary.service.FavoriteService;
import com.ennovaresearch.mylibrary.service.UserService;

/**
 * @author ennova
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private FavoriteService favoriteService;
	
	@RequestMapping(value = URLMapping.User.USERS_ALL, method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAll();
	}
	
	@RequestMapping(value = URLMapping.User.USERS_ALL, method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		if(user == null)
			return null;
		User u = userService.findByUid(user.getUid());
		if(u == null) {
			u = userService.save(user);
		}
		return u;
	}

	@RequestMapping(value = URLMapping.User.USER_FAVORITES, method = RequestMethod.GET)
	@ResponseBody
	public List<Favorite> getFavorites(@PathVariable("uid") String uid) {
		return userService.findAllFavoritesOfUser(uid);
	}
	
	@RequestMapping(value = URLMapping.Favorite.FAVORITE_ALL, method = RequestMethod.GET)
	@ResponseBody
	public List<Favorite> getAllFavorites() {
		return favoriteService.findAll();
	}
	
	@RequestMapping(value = URLMapping.User.USER_FAVORITES_SAVE, method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Favorite saveFavorite(@PathVariable("uid") String uid, @RequestBody Favorite favorite) {
		final User u = userService.findByUid(uid);
		if(u != null) {
			Favorite f = favoriteService.findByISBN(favorite.getIsbn());
			Set<User> users = new HashSet<User>();
			users.add(u);
			if(f == null) {
				f = new Favorite();
				f.setIsbn(favorite.getIsbn());	
			}
			f.setUsers(users);
			f = favoriteService.save(f);
			
			return f;
		}
		return null;
	}
	
}
