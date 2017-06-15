package com.hanhf.library.book.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.type.bean.Type;
//�ֿ⣬����ע��DAO��
@Repository
//DAO��ͨ���̳���HibernateDaoSupport��
//HibernateDaoSupport���ṩ�˴�������õ����ݲ���
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {
	// HibernateDaoSupport��������SessionFactory
	// ��Ҫ�ṩset����������������Դ��ע��
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(book);
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(book);
	}

	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Book.class, id);
	}
	
	//��ʾ����ͼ��
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Book");

	}

	//��ת��������ѯҳ��
	@SuppressWarnings("unchecked")
	@Override
	public List<Type> toTiaojian() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Type");
	}
	
	//��������ѯͼ��
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findTiaojianBook() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Book");
	}
}
