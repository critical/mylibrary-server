/**
 * 
 */
package com.ennovaresearch.mylibrary.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ennovaresearch.mylibrary.util.Constants;

/**
 * @author ennova
 *
 */
public class BaseModel {
	@Id
	@GeneratedValue
	@Column(name = Constants.ModelMetadata.COLUMN_ID)
	private Integer id;
}
