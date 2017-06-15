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
	@Table(name = "TBL_BOOK")
public class Book {
	
	private Integer book_id;
	private String book_no;
	private String book_name;
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
		@SequenceGenerator(name = "generator", sequenceName = "SEQ_BOOK")
		// �����������ݱ��е�ӳ���ֶ�
		@Column(name = "BOOK_ID")
	
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	@Column(name = "BOOK_NO")
	public String getBook_no() {
		return book_no;
	}
	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}
	@Column(name = "BOOK_NAME")
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Column(name = "AUTHOR")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "PRICE")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Column(name = "QUANTITY")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column(name = "PUBLISHER")
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
