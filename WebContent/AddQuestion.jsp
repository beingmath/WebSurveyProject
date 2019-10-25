<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>问卷调查管理系统界面</title>
<link rel="stylesheet" href="admin.css">
<script src="jquery-3.3.1.min.js"></script>
<script src="admin.js"></script>
</head>
<body>
	<div class="content">
		<div class="top">问卷调研管理系统</div>
		<div class="line"></div>
		<div class="left">
			<ul class="ullist">
				<li>
					<div>
						调查课题管理
						<div class="task">
							<ul>
								<li><a href="TaskManage.jsp" class="TaskManage">调查课题管理</a></li>
								<li><a href="javascript:;" class="addTask">添加新课题</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<div>
						留言信息管理
						<div class="task">
							<ul>
								<li><a href="javascript:;" class="AddQuest">留言信息管理</a></li>
							</ul>
						</div>

					</div>
				</li>
				<li>
					<div>
						注册用户管理
						<div class="task">
							<ul>
								<li><a href="javascript:;">注册用户管理</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<div>
						调查记录查询
						<div class="task">
							<ul>
								<li><a href="javascript:;">调查记录查询</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<div>
						修改个人密码
						<div class="task">
							<ul>
								<li><a href="javascript:;">修改个人密码</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<div>
						退出登录
						<div class="task">
							<ul>
								<li><a href="javascript:;">退出登录</a></li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="right">
			<div class="subject"></div>
			<div class="question" style="display:block">
				<form action="insertQuestion" method="post" >
				<input type="hidden" name="task" value="<%=request.getParameter("task")%>">
					<div class="Borleft2">问题</div>
					<div class="Borright2">
						<input name="pro"
							style="width: 200px; height: 30px; margin-left: 10px; margin-top: 8px">
					</div>
					<div class="Borleft2">问题类型</div>
					<div class="Borright2">
						<select name="type"  style="height: 25px; width: 80px;">
							<option value="0">单选题</option>
							<option value="1">多选题</option>
						</select>
					</div>
					<div class="Borleft2">A选项</div>
					<div class="Borright2">
						<input name="A"
							style="width: 200px; height: 30px; margin-left: 10px; margin-top: 8px">
					</div>
					<div class="Borleft2">B选项</div>
					<div class="Borright2">
						<input name="B"
							style="width: 200px; height: 30px; margin-left: 10px; margin-top: 8px">
					</div>
					<div class="Borleft2">C选项</div>
					<div class="Borright2">
						<input name="C"
							style="width: 200px; height: 30px; margin-left: 10px; margin-top: 8px">
					</div>
					<div class="Borleft2">D选项</div>
					<div class="Borright2">
						<input name="D"
							style="width: 200px; height: 30px; margin-left: 10px; margin-top: 8px">
					</div>
					<div class="Borleft2">操作</div>
					<div class="Borright2">
						<input type="submit" value="提交">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置">
						&nbsp;&nbsp;&nbsp;
						
					</div></form>
			</div>
		</div>
	</div>
	</div>

	</div>
</body>
</html>