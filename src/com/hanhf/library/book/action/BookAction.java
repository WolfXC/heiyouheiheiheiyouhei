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



//������������ע��Action��
@Controller
//�������μ�struts.xml�ļ���
@ParentPackage("ssh")
@Results({@Result(name="toadd",location="/book_add.jsp"),
			@Result(name="update",location="/book_update_result.jsp"),
			@Result(name="query",location="/book_query.jsp"),
			@Result(name="queryResult",location="/book_query_result.jsp"),
			@Result(name="queryResult2",location="/book_query_result.jsp")
			})
public class BookAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// ������Դ
	@Resource
	private BookService bookService;
	@Resource
	private TypeService typeService;
	// �ö������ڽ��������ڱ�������
	private Book book;
	private Type type;
	private String book_no;
	private List<Type> typeList;
	private List<Book> bookList;
	
	

	// ����Action
	@Action("book")
	public String add() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
		try {
			 bookService.addBook(book);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	// ����Action
		@Action("toAddBook")
		public String toAddBook() {
			// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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
		
		// ����Action
				@Action("update")
				public String update() {
					// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
					try {
						 bookService.updateBook(book);
						return "success";
					} catch (Exception e) {
						e.printStackTrace();
						return "failure";
					}
				}
				
				// ����Action
				@Action("delbook")
				public String delbook() {
					// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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
				// ����Action
				@Action("toQuery")
				public String toquery() {
					// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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
				
				// ����Action
				@Action("query")
				public String query() {
					// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
					try {
						//�쳣��
						bookList = bookService.findAllBook(book);
						return "queryResult";
					}
					catch (Exception e) {
						e.printStackTrace();
						return "failure";
					}
				}
				
				//toAllbok.do

				// ����Action
				@Action("toAllbok")
				public String Allbook() {
					// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
					try {
						//�쳣��
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
