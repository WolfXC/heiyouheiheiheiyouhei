package com.hanhf.library.book.dao;

import java.util.List;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.type.bean.Type;

public interface BookDao {

	void add(Book book);
	
	void update(Book book);
	
	void delete(Book book);

	Book findById(Integer id);

	List<Book> findAll();

	List<Type> toTiaojian();

	List<Book> findTiaojianBook();
}
