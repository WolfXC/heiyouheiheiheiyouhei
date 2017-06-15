package com.hanhf.library.book.service;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hanhf.library.book.bean.Book;
import com.hanhf.library.book.dao.BookDao;
import com.hanhf.library.type.bean.Type;

// 服务，用于注解业务逻辑层
@Service
public class BookServiceImpl implements BookService {
	// 依赖资源
	@Resource
	private BookDao bookDao;
	private List<Type> list;
	private List<Book> bookList;
 
	
	@Override
	public void addBook(Book book) {
		bookDao.add(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.update(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookDao.delete(book);
	}

	@Override
	public Book findBookById(Integer id) {
		return bookDao.findById(id);
	}
	//查询图书模块
	@Override
	public List<Book> findAllBook() {
		return bookDao.findAll();
	}
	@Override
	public List<Type> findType(){
		return bookDao.findType();
	}
	
	public  Book findBookByNo(String book_no){
		return bookDao.findBookByNo(book_no);
	}
	//按条件查询模块
	@Override
	public List<Book> findAllBook(Book condition) {
		return bookDao.findAll(condition);
	}
	
	@Override
	public List<Book> findAllBook1(Book book) {
		// TODO Auto-generated method stub
		return bookDao.findAll1(book);
	}
	
	
	// getter & setter
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Type> getList() {
		return list;
	}

	public void setList(List<Type> list) {
		this.list = list;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	
}
