package com.hanhf.library.book.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.type.bean.Type;
//仓库，用于注解DAO类
@Repository
//DAO类通常继承自HibernateDaoSupport类
//HibernateDaoSupport类提供了大多数常用的数据操作
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {
	// HibernateDaoSupport类依赖于SessionFactory
	// 需要提供set方法并加上依赖资源的注解
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
	
	//显示所有图书
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Book");

	}

	//跳转到条件查询页面
	@SuppressWarnings("unchecked")
	@Override
	public List<Type> toTiaojian() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Type");
	}
	
	//按条件查询图书
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findTiaojianBook() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Book");
	}
}
