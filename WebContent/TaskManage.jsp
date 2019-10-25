<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.util.*"%>
 <%@page import="java.util.List"%>
 <%@page import="pojo.Survey"%>
 <%@page import="service.SurveyService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>问卷调查管理系统界面</title>
</head>
<link rel="stylesheet" href="admin.css">
<script src="jquery-3.3.1.min.js"></script>
<script src="admin.js"></script>
</head>
<body>
<div class="content">
<div class="top">问卷调研管理系统
</div>
<div class="line"></div>
<div class="left">
<ul class="ullist">
<li>
<div >调查课题管理<div class="task">
<ul>
<li ><a href="javascript:;"  class="TaskManage">调查课题管理</a></li>
<li><a href="javascript:;" class="addTask">添加新课题</a></li>
</ul>
</div></div>
</li>
<li>
<div >留言信息管理<div class="task"><ul><li><a href="javascript:;" class="AddQuest">留言信息管理</a></li></ul></div>

</div>
</li>
<li>
<div >注册用户管理<div class="task"><ul><li><a href="javascript:;">注册用户管理</a></li></ul></div></div>
</li>
<li>
<div>调查记录查询<div class="task"><ul><li><a href="record.jsp">调查记录查询</a></li></ul></div></div>
</li>
<li>
<div >修改个人密码<div class="task"><ul><li><a href="javascript:;">修改个人密码</a></li></ul></div></div>
</li>
<li>
<div >退出登录<div class="task"><ul><li><a href="exitservlet">退出登录</a></li></ul></div></div>
</li>
</ul>
</div>
<div class="right">
<div class="subject"></div>
<div class="question"></div>
<div class="taskManage">
<table border="1"  >
		<tr>
			<td style="width:150px;height:50px;"><font size="5" color="red" >课题</font></td>
				<td style="width:150px;height:50px;"> <font size="5" color="red" width="300px" > 调查时间</font></td>
				<td style="width:300px;height:50px;"><font size="5" color="red" width="300px" >操作</font></td>
			</tr>
			<%
				List<Survey> survey = SurveyService.SelectSurvey();
				for (Survey sur : survey) {
			%>
			<tr>
				<td class="taskOption"><%=sur.getTask()%></td>
				<td><%=sur.getTime()%></td>
				<td><a href="DeleteSurveyServlet?task=<%=sur.getTask()%>"><font
						color="red">删除</font></a>
						<a  href="AddQuestion.jsp?task=<%=sur.getTask()%>" ><font
						color="red">添加问题管理</font></a>
							<a  href="javascript:;" ><font
						color="red">调查题目管理</font></a>
			</tr>
			<%
				}
				
			%>
			
      </table>
</div>
</div>
</div>
</body>
</html>