package com.hanhf.library.book.service;

import java.util.List;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.type.bean.Type;

public interface BookService {
	
void addBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(Book book);

	Book findBookById(Integer id);

	List<Book> findAllBook();

	List<Type> toTiaojian();

	List<Book> findTiaojianBook();

}
