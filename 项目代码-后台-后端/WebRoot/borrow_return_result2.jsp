<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>福州市数字图书馆系统</title>
<style type="text/css">
body {
	font: 12px 宋体;
}

#div1 {
	width: 80%;
	margin: auto;
	border: #000 solid 1px;
}

h3 {
	background-color: #069;
	color: #FFF;
	text-align: center;
	margin: 0px;
	padding: 10px;
}

#table1 {
	line-height: 20px;
	margin: 10px;
	width: 100%;
}

p {
	text-align: center;
}

a {
	color: #00F;
	text-decoration: none;
}
</style>
</head>

<body>
	<div id="div1">
		<h3>归还结果</h3>
		<table id="table1">
			<tr>
				<td width="15%">书籍编号</td>
				<td width="40%">书籍名称</td>
				<td width="15%">会员编号</td>
				<td width="15%">会员名称</td>
				<td width="15%">操作员</td>
			</tr>
			<tr>
				<td>${br.bookNo}</td>
				<td>${br.bookName}</td>
				<td>${br.readerNo}</td>
				<td>${br.readerName}</td>
				<td>${oper}</td>
			</tr>
		</table>
	</div>
</body>
</html>
