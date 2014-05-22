/**
 * 
 */
package com.ennovaresearch.mylibrary.service.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ennovaresearch.mylibrary.model.client.RemoteBook;
import com.ennovaresearch.mylibrary.service.client.LibraryService;

/**
 * @author ennova
 *
 */
@Service("stubLibraryService")
public class StubLibraryServiceImpl implements LibraryService<RemoteBook> {
	private List<RemoteBook> books;
	
	public StubLibraryServiceImpl() {
		books = new ArrayList<RemoteBook>();
		fillLibrary();
	}
	
	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.client.LibraryService#getClassicBooks()
	 */
	@Override
	public List<RemoteBook> getClassicBooks() {
		return books;
	}
	
	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.client.LibraryService#getBookDetail(java.lang.String)
	 */
	@Override
	public RemoteBook getBookDetail(String code){
		if(StringUtils.isEmpty(code))
			return null;
		if(books == null)
			return null;
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getId().equals(code))
				return books.get(i);
		}
		return null;
	}

	private void fillLibrary() {
		RemoteBook b1 = new RemoteBook("OL8485250W", "1536333");
		books.add(b1);
		b1 = new RemoteBook("OL8956427W", "960113");
		books.add(b1);
		b1 = new RemoteBook("OL859305W", "2101360");
		books.add(b1);
		b1 = new RemoteBook("OL8956426W", "2126133");
		books.add(b1);
		b1 = new RemoteBook("OL8485251W", "601604");
		books.add(b1);
		b1 = new RemoteBook("OL8485248W", "600912");
		books.add(b1);
		b1 = new RemoteBook("OL8485252W", "2647139");
		books.add(b1);
	}
}
