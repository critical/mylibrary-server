/**
 * 
 */
package com.ennovaresearch.mylibrary.rest.util;

/**
 * @author ennova
 *
 */
public class URLMapping {
	
	/**
	 * @author ennova
	 *
	 */
	public static final class User {
		public static final String USERS_ALL = "/users";
		public static final String USER_DETAIL = "/users/{uid}";
		public static final String USER_FAVORITES = "/users/{uid}/favorites";
		public static final String USER_FAVORITES_SAVE = "/users/{uid}/favorites/save";
		
	}
	
	/**
	 * @author ennova
	 *
	 */
	public static final class Book {
		public static final String BOOKS_ALL = "/books";
		public static final String BOOK_DETAIL = "/books/{code}";
	}
	
	public static final class Favorite {
		public static final String FAVORITE_ALL = "/favorites";
	}
}
