/**
 * 
 */
package com.ennovaresearch.mylibrary.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ennovaresearch.mylibrary.model.Book;
import com.ennovaresearch.mylibrary.model.client.RemoteBook;
import com.ennovaresearch.mylibrary.rest.util.RemoteBookToBook;
import com.ennovaresearch.mylibrary.rest.util.URLMapping;
import com.ennovaresearch.mylibrary.service.client.LibraryService;

/**
 * @author ennova
 *
 */
@Controller
public class BookController {
	private RemoteBookToBook t = new RemoteBookToBook();
	
	@Autowired
	private LibraryService<RemoteBook> stubLibraryService;
	
	@RequestMapping(value = URLMapping.Book.BOOKS_ALL, method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getHotBooks() {
		final ArrayList<Book> result = new ArrayList<Book>();
		
		
		final List<RemoteBook> bks = stubLibraryService.getClassicBooks();
		for (RemoteBook remoteBook : bks) {
			result.add(t.transform(remoteBook));
		}
		return result;
	}
	
	@RequestMapping(value = URLMapping.Book.BOOK_DETAIL, method = RequestMethod.GET)
	@ResponseBody
	public Book getDetail(@PathVariable("code") String code) {
		return t.transform(stubLibraryService.getBookDetail(code));
	}
}
