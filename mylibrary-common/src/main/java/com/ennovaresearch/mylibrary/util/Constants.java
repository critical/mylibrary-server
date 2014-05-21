/**
 * 
 */
package com.ennovaresearch.mylibrary.util;

/**
 * @author ennova
 *
 */
public final class Constants {
	
	/**
	 * @author ennova
	 *
	 */
	public static final class ModelMetadata {
		public static final String COLUMN_ID = "id";
		
		/**
		 * @author ennova
		 *
		 */
		public static final class User {
			public static final String TABLE_NAME = "users";
			public static final String COLUMN_EMAIL = "email";
			public static final String COLUMN_UID = "uid";
		}
		
		/**
		 * @author ennova
		 *
		 */
		public static final class Favorite {
			public static final String TABLE_NAME = "favorites";
			public static final String COLUMN_ISBN = "isbn";
		}
	}
}
