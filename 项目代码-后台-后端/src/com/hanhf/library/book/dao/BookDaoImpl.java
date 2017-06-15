package com.hanhf.library.book.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hanhf.library.book.bean.Book;
import com.hanhf.library.type.bean.Type;

//�ֿ⣬����ע��DAO��
@Repository
// DAO��ͨ���̳���HibernateDaoSupport��
// HibernateDaoSupport���ṩ�˴�������õ����ݲ���
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

	// ��ѯͼ��ģ��
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Book");
	}

	// ��������ѯģ��
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Book> findAll(final Book condition) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						List result = null;

						Criteria criteria = session.createCriteria(Book.class);
						// 5����ѯ����
						if (!StringUtils.isBlank(condition.getBookNo())) {
							criteria.add(Restrictions.like("bookNo", "%"
									+ condition.getBookNo() + "%"));
						}

						if (!StringUtils.isBlank(condition.getBookName())) {
							criteria.add(Restrictions.like("bookName", "%"
									+ condition.getBookName() + "%"));
						}

						if (!StringUtils.isBlank(condition.getPublisher())) {
							criteria.add(Restrictions.like("publisher", "%"
									+ condition.getPublisher() + "%"));
						}

						if (!StringUtils.isBlank(condition.getAuthor())) {
							criteria.add(Restrictions.like("author", "%"
									+ condition.getAuthor() + "%"));
						}

						if (condition.getType().getId() != 0) {
							criteria.add(Restrictions.eq("type.id",
									condition.getType().getId()));
						}

						// ��ҳ�趨
						// criteria.setFirstResult((pageNo - 1) * pageSize);
						// criteria.setMaxResults(pageSize);

						result = criteria.list();

						return result;

					}

				});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll1(Book book) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Book");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findType() {
		return this.getHibernateTemplate().find("from Type");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Book findBookByNo(String book_no) {
		List<Book> list;
		list = this.getHibernateTemplate().find("from Book where book_no=?",
				book_no);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	
}
