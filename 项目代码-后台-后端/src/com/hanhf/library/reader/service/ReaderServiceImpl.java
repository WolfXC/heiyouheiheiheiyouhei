package com.hanhf.library.reader.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanhf.library.reader.bean.Reader;
import com.hanhf.library.reader.dao.ReaderDao;



// 服务，用于注解业务逻辑层
@Service
public class ReaderServiceImpl implements ReaderService {
	// 依赖资源
	@Resource
	private ReaderDao readerDao;

	@Override
	public void addReader(Reader reader) {
		readerDao.add(reader);
	}

	@Override
	public void updateReader(Reader reader) {
		readerDao.update(reader);
	}

	@Override
	public void deleteReader(Reader reader) {
		readerDao.delete(reader);
	}

	@Override
	public Reader findReaderByNo(String no) {
		return readerDao.findByNo(no);
	}
	
	@Override
	public void deleteReader(String no) {
		readerDao.delete(no);
	}
	
	@Override
	public Reader findReaderById(Integer id){
		return readerDao.findById(id);
	}

	@Override
	public List<Reader> findAllReader() {
		return readerDao.findAll();
	}

	// getter & setter

	public ReaderDao getReaderDao() {
		return readerDao;
	}

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}
}
