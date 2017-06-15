package com.hanhf.library.reader.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hanhf.library.reader.bean.Reader;

@Repository
public class ReaderDaoImpl extends HibernateDaoSupport implements ReaderDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	@Override
	public void add(Reader reader) {
		this.getHibernateTemplate().save(reader);
	}

	@Override
	public void update(Reader reader) {
		this.getHibernateTemplate().update(reader);

	}

	@Override
	public void delete(String no) {
		this.getHibernateTemplate().delete(no);

	}
	
	@Override
	public Reader findById(Integer id){
		return this.getHibernateTemplate().get(Reader.class, id);
	}
	
	@Override
	public void delete(Reader reader) {
		this.getHibernateTemplate().delete(reader);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Reader findByNo(String no) {
		List<Reader> list = this.getHibernateTemplate().find("from Reader where no = ?" , no);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reader> findAll() {
		return this.getHibernateTemplate().find("from Reader");
	}

}
