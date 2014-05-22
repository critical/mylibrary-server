/**
 * 
 */
package com.ennovaresearch.mylibrary.model.client;


/**
 * @author ennova
 *
 */
public class RemoteBook {
	private String id;
	private String idCover;
	
	/**
	 * 
	 */
	public RemoteBook() {
	}
	
	/**
	 * @param id
	 * @param idCover
	 */
	public RemoteBook(String id, String idCover) {
		this.id = id;
		this.idCover = idCover;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdCover() {
		return idCover;
	}
	public void setIdCover(String idCover) {
		this.idCover = idCover;
	}
	
	
}
