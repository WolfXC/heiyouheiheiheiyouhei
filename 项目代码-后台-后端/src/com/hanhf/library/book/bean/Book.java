package com.hanhf.library.book.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hanhf.library.type.bean.Type;

//ʵ�壨Hibernate�Զ�ɨ��ʱ���������д���ע����࣬������ӳ���ϵ��
@Entity
//��ʵ����ӳ������ݱ�
@Table(name = "tbl_book")
public class Book {
	private Integer bookId;
	private String bookNo;
	private String bookName;
	private Type type;
	private String author;
	private Double price;
	private Integer quantity;
	private String publisher;
	private String remark;
	
	// ������ΪID����
		@Id
		// �������ɷ�ʽ������
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
		// ����������������"generator"����һ�ж�Ӧ����ָ����������
		@SequenceGenerator(name = "generator", sequenceName = "seq_book")
		// �����������ݱ��е�ӳ���ֶ�
		
		@Column(name = "book_id")
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Column(name="book_no")
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	@Column(name="book_name")
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@ManyToOne
	@JoinColumn(name="type_id")
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Column(name="author")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name="price")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name="quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column(name="publisher")
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}