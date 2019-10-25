<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="pojo.Survey" %>
	<%@page import="service.SurveyService" %>
	 <%@page import="java.util.*"%>
 <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>问卷调研系统</title>
<link rel="stylesheet" href="admin.css">
</head>
<body>
<div class="content">
<div class="top">问卷调研系统
</div>
<div class="line"></div>
<div class="left">
<ul class="ullist">
<li>
<div >调查课题查询<div class="task">
<ul>
<li><a href="SurveyTaskQuery.jsp">调查课题查询</a></li>
</ul>
</div></div>
</li>
<li>
<div >个人信息管理<div class="task"><ul><li>个人信息管理</li></ul></div>

</div>
</li>
<li>
<div >我要留言<div class="task"><ul><li>我要留言</li></ul></div></div>
</li>
<li>
<div >我要答题<div class="task"><ul><li><a href="">我要答题</a></li></ul></div></div>
</li>
<li>
<div >退出登录<div class="task"><ul><li><a href="exitservlet">退出登录</a></li></ul></div></div>
</li>
</ul>
</div>
<div class="right">
<table border="1" width="800" style="text-align:center">

			<tr>
				<td><font size="5" color="red">课题</font></td>
				<td><font size="5" color="red">调查时间</font></td>
				<td><font size="5" color="red">操作</font></td>
			</tr>
				<%
				List<Survey> sur = SurveyService.SelectSurvey();
				for (Survey survey : sur) {
			%>
			<tr>
				<td><%=survey.getTask()%></td>
				<td><%=survey.getTime()%></td>
				<td><a href="javascript:;"><font
						color="red">查看</font></a>
				<a href="SelfSurvey.jsp?task=<%=survey.getTask()%>"><font
						color="red">我要调查</font></a></td>
			</tr>
			<%
				}
			%>
			
</div>

</div>
</body>
</html>