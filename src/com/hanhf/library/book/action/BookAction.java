package com.hanhf.library.book.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.book.service.BookService;
import com.hanhf.library.type.bean.Type;
import com.hanhf.library.type.service.TypeService;
import com.opensymphony.xwork2.ActionSupport;



//控制器，用于注解Action类
@Controller
//父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({@Result(name="toadd",location="/book_add.jsp"),
			@Result(name="update",location="/book_update_result.jsp"),
			@Result(name="query",location="/book_query.jsp"),
			@Result(name="queryResult",location="/book_query_result.jsp"),
			@Result(name="queryResult2",location="/book_query_result.jsp")
			})
public class BookAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 依赖资源
	@Resource
	private BookService bookService;
	@Resource
	private TypeService typeService;
	// 该对象用于接收来自于表单的数据
	private Book book;
	private Type type;
	private String book_no;
	private List<Type> typeList;
	private List<Book> bookList;
	
	

	// 定义Action
	@Action("book")
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			 bookService.addBook(book);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	// 定义Action
		@Action("toAddBook")
		public String toAddBook() {
			// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
			try {
				typeList = bookService.findType();
				return "toadd";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failure";
			}
		}
		
		@Action("toUpDate")
		public String toUpDate(){
			try {
				book = bookService.findBookByNo(book.getBookNo());
				typeList = typeService.findAllType();
				if (book == null) {
					return "failure";
				} else {
					return "update";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return"failure";
			}
		}
		
		// 定义Action
				@Action("update")
				public String update() {
					// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
					try {
						 bookService.updateBook(book);
						return "success";
					} catch (Exception e) {
						e.printStackTrace();
						return "failure";
					}
				}
				
				// 定义Action
				@Action("delbook")
				public String delbook() {
					// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
					try {
						book = bookService.findBookByNo(book.getBookNo());
						if (book == null) {
							return "failure";
						} else {
							bookService.deleteBook(book);
						}
							return "success";
					} catch (Exception e) {
						e.printStackTrace();
						return "failure";
					}
				}
				// 定义Action
				@Action("toQuery")
				public String toquery() {
					// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
					try {
						typeList= typeService.findAllType();
						if(typeList==null){
							return "failure";
						}else{
						return "query";
						}
					} catch (Exception e) {
						e.printStackTrace();
						return "failure";
					}
				}
				
				// 定义Action
				@Action("query")
				public String query() {
					// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
					try {
						//异常处
						bookList = bookService.findAllBook(book);
						return "queryResult";
					}
					catch (Exception e) {
						e.printStackTrace();
						return "failure";
					}
				}
				
				//toAllbok.do

				// 定义Action
				@Action("toAllbok")
				public String Allbook() {
					// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
					try {
						//异常处
						bookList = bookService.findAllBook1(book);
						return "queryResult";
					}
					catch (Exception e) {
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

				public TypeService getTypeService() {
					return typeService;
				}

				public void setTypeService(TypeService typeService) {
					this.typeService = typeService;
				}

				public Book getBook() {
					return book;
				}

				public void setBook(Book book) {
					this.book = book;
				}

				public Type getType() {
					return type;
				}

				public void setType(Type type) {
					this.type = type;
				}

				public String getBookNo() {
					return book_no;
				}

				public void setBookNo(String book_no) {
					this.book_no = book_no;
				}

				public List<Type> getTypeList() {
					return typeList;
				}

				public void setTypeList(List<Type> typeList) {
					this.typeList = typeList;
				}

				public List<Book> getBookList() {
					return bookList;
				}

				public void setBookList(List<Book> bookList) {
					this.bookList = bookList;
				}
				
		
}
