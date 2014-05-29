/**
 * 
 */
package com.ennovaresearch.mylibrary.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.ennovaresearch.mylibrary.util.Constants;

/**
 * @author ennova
 *
 */
@Entity
@Table(name = Constants.ModelMetadata.Favorite.TABLE_NAME)
public class Favorite extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2918030497220727665L;
	
	@Id
	@GeneratedValue
	@Column(name = Constants.ModelMetadata.Favorite.COLUMN_ID)
	private Integer id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_favorites", 
		joinColumns = {@JoinColumn(name = Constants.ModelMetadata.Favorite.COLUMN_ID, nullable = false)}, 
		inverseJoinColumns = {@JoinColumn(name = Constants.ModelMetadata.User.COLUMN_ID, nullable = false)}
	)
	private Set<User> users = new HashSet<User>();

	@NotEmpty
	@Column(name = Constants.ModelMetadata.Favorite.COLUMN_ISBN)
	private String isbn;

	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
