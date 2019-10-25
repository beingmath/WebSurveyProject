<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="pojo.Question" %>
	<%@page import="service.QuestionService" %>
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
<form action="AddRecord" method="post">
<table border="1" width="1301" style="text-align:center">

			<tr>
				<th><font size="5" color="red">序号</font></th>
				<th><font size="5" color="red">问题</font></th>
				<th><font size="5" color="red">A选项</font></th>
				<th><font size="5" color="red">B选项</font></th>
				<th><font size="5" color="red">C选项</font></th>
				<th><font size="5" color="red">D选项</font></th>
				<th><font size="5" color="red">问题类型</font></th>
				<th><font size="5" color="red">我的答案</font></th>
			</tr>
				<%
				String task=request.getParameter("task");
				List<Question> question = QuestionService.SelectQuestionByTask(task);
				int i=1;
				for (Question que : question) {
					
					Boolean single=que.getType()==0;
			%>
			<tr>
				<td>第<%=i++%>题</td>
				<td><%=que.getPro()%></td>
				<td><%=que.getA()%></td>
				<td><%=que.getB()%></td>
				<td><%=que.getC()%></td>
				<td><%=que.getD()%></td>
				<td><%=single?"单选题":"多选题"%></td>
				<td>
				<input type="hidden" value="<%=task%>" name="task">
				<input type="hidden" value="<%=(question==null)?0:question.size()%>" name="i">
				<input type="hidden" value="<%=que.getPro()%>" name="pro">
				<input type="hidden" value="<%=que.getType()%>" name="type">
				<input type="<%=single?"radio":"checkbox"%>" name="<%=que.getPro() %>" value="A">A
				<input type="<%=single?"radio":"checkbox"%>" name="<%=que.getPro() %>" value="B">B
				<input type="<%=single?"radio":"checkbox"%>" name="<%=que.getPro() %>" value="C">C
				<input type="<%=single?"radio":"checkbox"%>" name="<%=que.getPro() %>" value="D">D
				</td>
			</tr>
			<%
				}
			%>
			</table>
			</br>
			</br>
			</br>
			</br>
			</br><div style="text-align:center;">
			<input type="submit" value="提交调查"></div>
			</form>
</div>
</div>
</body>
</html>