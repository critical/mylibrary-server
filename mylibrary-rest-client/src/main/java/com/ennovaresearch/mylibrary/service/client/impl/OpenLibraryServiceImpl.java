/**
 * 
 */
package com.ennovaresearch.mylibrary.service.client.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ennovaresearch.mylibrary.model.client.RemoteBook;
import com.ennovaresearch.mylibrary.service.client.LibraryService;

/**
 * @author ennova
 *
 */
@Service("openLibraryService")
public class OpenLibraryServiceImpl implements LibraryService<RemoteBook> {

	/* (non-Javadoc)
	 * @see com.ennovaresearch.mylibrary.service.client.LibraryService#getClassicBooks()
	 */
	@Override
	public List<RemoteBook> getClassicBooks() {
		something();
		return null;
	}
	
	@Override
	public RemoteBook getBookDetail(String code) {
		return null;
	}
	
	private void something() {
		//curl 'http://openlibrary.org/search.json?author=classic'
		
		//http://covers.openlibrary.org/b/id/258027-S.jpg cover
		
		//http://openlibrary.org/books/OL27448W.json
		/*
{
    cover_i: 258027,
    has_fulltext: true,
    edition_count: 120,
    title: "The Lord of the Rings",
    author_name: [
        "J. R. R. Tolkien"
    ],
    first_publish_year: 1954,
    key: "OL27448W",
    ia: [
        "returnofking00tolk_1",
        "lordofrings00tolk_1",
        "lordofrings00tolk_0",
        "lordofrings00tolk_3",
        "lordofrings00tolk_2",
        "lordofrings00tolk",
        "twotowersbeingse1970tolk",
        "lordofring00tolk",
        "lordofrings56tolk",
        "lordofringstolk00tolk",
        "fellowshipofring00tolk_0"
    ],
    author_key: [
        "OL26320A"
    ],
    public_scan_b: true
}
		 * 
		 */
		/*
		RestTemplate restTemplate = new RestTemplate();	
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);
		Arrays.asList(restTemplate.getForObject("http://openlibrary.org/search.json?author=classic", Book[].class));
		*/
	}
}
