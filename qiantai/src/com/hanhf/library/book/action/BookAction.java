package com.hanhf.library.book.action;


import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.book.service.BookService;
import com.hanhf.library.type.bean.Type;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


//控制器，用于注解Action类
@Controller
//父包（参见struts.xml文件）
@ParentPackage("ssh")
public class BookAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;	
	//依赖资源
	@Resource
	private BookService bookService;
	private Book book;
	List<Book> bookList;
	List<Type> typeList;
	String book_no;
	String book_name;
	Type type;
	String publisher;
	String auther;
	
	
	
	@Action("bookFindAll")
	public String find()
	{
		try{
			
			bookList = bookService.findAllBook();
			return "list";
			
		}catch (Exception e) {
			e.printStackTrace();
			
			return "failure";
		}
	}
	
	@Action("toBookTiaojian")
	public String Findtiaojian(){
		try{
			
		List<Type> type = bookService.toTiaojian();
		ActionContext context = ActionContext.getContext();
		context.getSession().put("type" , type);
		return "totiaojian";
		}catch(Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	@Action("Tiaojian")
	public String Find(){
		try{
			List<Book> tbook = bookService.findTiaojianBook();
			ActionContext context = ActionContext.getContext();
			context.getSession().put("tbook" , tbook);
			return "tiaojianchaxun";
		}catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	@Action("toBorrow")
	public String Borrow(){
		try{
			
			
			return "tiaojianchaxun";
		}catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public String getBook_no() {
		return book_no;
	}

	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}
	
	
}
