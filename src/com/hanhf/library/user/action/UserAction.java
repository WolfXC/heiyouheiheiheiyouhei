package com.hanhf.library.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;

import com.hanhf.library.user.bean.User;
import com.hanhf.library.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

// 控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({ @Result(name = "delete", location = "/user_del.jsp"),
		@Result(name = "update", location = "/user_update.jsp"),
		@Result(name = "toLogin", location = "/admin_index.jsp"),
})
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 依赖资源
	@Resource
	private UserService userService;
	// 该对象用于接收来自于表单的数据
	private User user;
	List<User> listUser;

	// 定义Action
	@Action("addUser")
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			userService.addUser(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("toDeleteUser")
	public String toDelete() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			listUser = userService.findAllUser();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("deleteUser")
	public String delete() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			userService.deleteUser(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("updateUser")
	public String update() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {

			User u = userService.findUserByNameAndPwd(user.getName());
			
			if (u == null) {
				return "failure";
			} else {
				u.setPwd(user.getPwd());
				userService.updateUser(u);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("login")
	public String login() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {

			User u = userService.findUserNameAndPwd(user.getName() , user.getPwd());
			
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("login",u.getName());
			
			return "toLogin";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
		
	// getter & setter

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

}
