<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.util.*"%>
 <%@page import="java.util.List"%>
 <%@page import="pojo.Record"%>
 <%@page import="service.RecordService"%>
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
<li ><a href="TaskManage.jsp"  class="TaskManage">调查课题管理</a></li>
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
<div>调查记录查询<div class="task"><ul><li><a href="javascript:;" class="record">调查记录查询</a></li></ul></div></div>
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
<div class="records">
<table border="1"  style="text-align:center">
		<tr>
				<th><font size="5" color="red">所属课题</font></th>
				<th><font size="5" color="red">问题</font></th>
				<th><font size="5" color="red">问题类型</font></th>
				<th><font size="5" color="red">A选项</font></th>
				<th><font size="5" color="red">B选项</font></th>
				<th><font size="5" color="red">C选项</font></th>
				<th><font size="5" color="red">D选项</font></th>
				<th><font size="5" color="red">用户选择</font></th>
				<th><font size="5" color="red">用户名</font></th>
			</tr>
			<%
				List<Record> Records = RecordService.selectRecord();
				for (Record rec : Records) {
			%>
			<tr>
				<td><%=rec.getTask()%></td>
				<td><%=rec.getPro()%></td>
				<td><%=(rec.getType()==0)?"单选题":"多选题"%></td>
				<td><%=rec.getA()%></td>
				<td><%=rec.getB()%></td>
				<td><%=rec.getC()%></td>
				<td><%=rec.getD()%></td>
				<td><%=rec.getUseroption()%></td>
				<td><%=rec.getUsername()%></td>
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