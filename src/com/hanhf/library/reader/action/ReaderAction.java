package com.hanhf.library.reader.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.hanhf.library.reader.bean.Reader;
import com.hanhf.library.reader.service.ReaderService;
import com.opensymphony.xwork2.ActionSupport;

// 控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({ @Result(name = "add", location = "/reader_add_result.jsp"),
	 @Result(name = "toupdate", location = "/reader_update_result1.jsp"),
	 @Result(name = "update", location = "/reader_update_result2.jsp")
})
public class ReaderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 依赖资源
	@Resource
	private ReaderService readerService;
	// 该对象用于接收来自于表单的数据
	private Reader reader;
	private String no;
	private Integer id;

	// 定义Action
	@Action("addReader")
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			readerService.addReader(reader);
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("delReader")
	public String delete() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			reader = readerService.findReaderByNo(no);
			if(reader == null){
				return "failue";
			}else{
			readerService.deleteReader(reader);
			return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Action("toUpdateReader")
	public String update(){
		try{
			
			reader = readerService.findReaderByNo(no);
			return "toupdate";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	@Action("updateReader")
	public String update1(){
		try{
			
			readerService.updateReader(reader);
			reader = readerService.findReaderById(reader.getId());
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	

	// getter & setter

	public ReaderService getReaderService() {
		return readerService;
	}

	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
}
