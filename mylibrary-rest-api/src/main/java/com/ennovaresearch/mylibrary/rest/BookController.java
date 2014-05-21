/**
 * 
 */
package com.ennovaresearch.mylibrary.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ennovaresearch.mylibrary.model.Book;
import com.ennovaresearch.mylibrary.model.User;
import com.ennovaresearch.mylibrary.service.UserService;

/**
 * @author ennova
 *
 */
@Controller
@RequestMapping(value = "books")
public class BookController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getHotBooks() {
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
		
		userService.findAll();
		
		Book b1 = new Book("Lo Hobbit", "8888-9999-1111");
		ArrayList<Book> a = new ArrayList<Book>();
		a.add(b1);
		b1 = new Book("Tolkien", "2222-3399-1881");
		a.add(b1);
		return a;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAll();
	}
}
