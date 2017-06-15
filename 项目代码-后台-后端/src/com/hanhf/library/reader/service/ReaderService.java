package com.hanhf.library.reader.service;

import java.util.List;

import com.hanhf.library.reader.bean.Reader;



public interface ReaderService {
	void addReader(Reader reader);

	void updateReader(Reader reader);

	void deleteReader(String no);
	
	void deleteReader(Reader reader);
	
	Reader findReaderByNo(String no);
	
	Reader findReaderById(Integer id);

	List<Reader> findAllReader();
}
