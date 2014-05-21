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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.ennovaresearch.mylibrary.util.Constants;

/**
 * @author ennova
 *
 */
@Entity
@Table(name = Constants.ModelMetadata.User.TABLE_NAME)
@XmlRootElement
public class User extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1151717952435001084L;
	
	@Id
	@GeneratedValue
	@Column(name = Constants.ModelMetadata.User.COLUMN_ID)
	private Integer id;

	@NotEmpty
	@Column(name = Constants.ModelMetadata.User.COLUMN_UID)
	private String uid;
	
	@NotEmpty
	@Email
	@Column(name = Constants.ModelMetadata.User.COLUMN_EMAIL)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
	private Set<Favorite> favorites = new HashSet<Favorite>();

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}
}
