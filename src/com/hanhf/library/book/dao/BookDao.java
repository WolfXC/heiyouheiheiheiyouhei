package com.hanhf.library.book.dao;

import java.util.List;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.type.bean.Type;


public interface BookDao {
	void add(Book book);
	void delete(Book book);
	void update(Book book);
	Book findById(Integer Id);
	List<Book> findAll();
	List<Type> findType();
	List<Book> findAll(Book condition);
	
	Book findBookByNo(String book_no);
	List<Book> findAll1(Book book);
	
}