<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>福州市数字图书馆系统</title>
<style type="text/css">
body { background-color: #09F; font: 12px 宋体;}
.level1 { border: #000 solid 1px; background-color: #069; color: #FFF; list-style: none; text-align: center; padding: 0px; line-height: 20px; margin-top: 20px;}
.level2 { background-color: #FFF; color: #00F; list-style: none; text-align: center; padding: 0px;}
a { color: #00F; text-decoration: none;}
h3 { background-color: #069; color: #FFF; text-align: center; margin: 0px; padding: 10px;}
.orange { color: orange;}
</style>
</head>

<body>
<h3>福州市数字图书馆系统<br />后台管理系统<br /><br /><span class="orange">欢迎您，${session.login}</span></h3>
<ul class="level1">
    <li>
    	借阅管理
        <ul class="level2">
        
            <li><a href="borrow_query.jsp" target="main">借阅查询</a></li>
        </ul>
    </li>
	
	<li>
    	图书管理
        <ul class="level2">
        	
            <li><a href="toQuery.do" target="main">按条件查询</a></li>
            <li><a href="toAllbok.do" target="main">显示所有图书</a></li>
        </ul>
    </li>
    <li>
    
    </li>
    <li>
    
    </li>
    <li>
    	
    </li>
</ul>
</body>
</html>

