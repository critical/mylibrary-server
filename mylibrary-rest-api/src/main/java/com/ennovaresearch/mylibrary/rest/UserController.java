/**
 * 
 */
package com.ennovaresearch.mylibrary.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ennovaresearch.mylibrary.model.Favorite;
import com.ennovaresearch.mylibrary.model.User;
import com.ennovaresearch.mylibrary.rest.util.URLMapping;
import com.ennovaresearch.mylibrary.service.UserService;

/**
 * @author ennova
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = URLMapping.User.USERS_ALL, method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAll();
	}
	
	
	@RequestMapping(value = URLMapping.User.USER_FAVORITES, method = RequestMethod.GET)
	@ResponseBody
	public List<Favorite> getFavorites(@PathVariable("uid") String uid) {
		return userService.findAllFavoritesOfUser(uid);
	}
}
