package com.hanhf.library.reader.dao;

import java.util.List;

import com.hanhf.library.reader.bean.Reader;


public interface ReaderDao {
	void add(Reader reader);

	void update(Reader reader);

	void delete(String no);
	
	void delete(Reader reader);

	Reader findByNo(String no);
	
	Reader findById(Integer id);

	List<Reader> findAll();
}