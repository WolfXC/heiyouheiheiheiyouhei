package com.hanhf.library.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.book.dao.BookDao;
import com.hanhf.library.type.bean.Type;

@Service
public class BookServiceImpl implements BookService {
	
	@Resource
	private BookDao bookDao
	;
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.add(book);

	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
		
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.delete(book);
		
	}

	@Override
	public Book findBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id);
	}

	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}
	
	@Override
	public List<Type> toTiaojian(){
		// TODO Auto-generated method stub
		return bookDao.toTiaojian();
		
	}
	
	@Override
	public List<Book> findTiaojianBook(){
		
		return bookDao.findTiaojianBook();
		
	}
	

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	

}
