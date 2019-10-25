$(function() {
	var $isclickTask = true;
	var $isclickQuest = true;
	var $value;
	var $subject = $(".subject");
	var $question = $(".question");
	var $taskManage = $(".taskManage");
	var $record=$(".records");
	var $task = createTask();
	var $quest = createQuestion();
	$(".addTask").click(function() {
		if ($isclickTask) {
			$question.css("display", "none");
			$taskManage.css("display", "none");
			$record.css("display","none");
			$subject.css("display", "block");
			$subject.append($task);
			$isclickTask = false;
			$isclickQuest = true;
			$quest.remove();
		}
	});
	$(".AddQue").click(function() {
		$isclickQuest = true;
		$value = $(this).attr("value");
		console.log($value);
		if ($isclickQuest) {
			$subject.css("display", "none");
			$taskManage.css("display", "none");
			$record.css("display","none");
			$question.css("display", "block");
			$question.append($quest);
			$isclickQuest = false;
			$isclickTask = true;
			$task.remove();
		}
	});
	$(".AddQuest").click(function() {
	});
	$(".TaskManage").click(function() {
		$subject.css("display", "none");
		$question.css("display", "none");
		$record.css("display","none");
		$taskManage.css("display", "block");
		$isclickTask = true;
		var $isclickQuest = true;

	});
	$(".record").click(function(){
		$subject.css("display", "none");
		$question.css("display", "none");
		$taskManage.css("display", "none");
		$record.css("display","block");
	});

	$(".right").delegate(".tasksubmit", "click", function() {
		var $issue = $(".issue").val();
		var $time = $(".time").val();
		var $introdution = $(".introdution").val();
		$.ajax({
			url : 'InsertSurveyServlet',
			type : 'post',
			data : {
				'issue' : $issue,
				'time' : $time,
				'introdution' : $introdution
			},
			success : function() {
				alert("添加成功");
				$(".issue").val("");
				$(".time").val("");
				$(".introdution").val("");
				window.location.href = "admin.html";

			},
			error : function() {
				alert('请求失败 ');
			}
		})

	});
	$(".right").delegate(".taskreset", "click", function() {
		var xinxi = document.getElementsByTagName("input");
		for (var i = 0; i < 2; i++) {
			xinxi[i].value = "";
		}
		$(".introdution").val("");
	});

	// 创建课题
	function createTask() {
		var $task = $("   <div class=\"Borleft\">调查课题</div>"
				+ "	<div class=\"Borright\"><input class=\"issue\" style=\"width:200px;height:30px;margin-left:10px;margin-top:8px\"></div>"
				+ "	<div class=\"Borleft\">调查时间</div>"
				+ "	<div class=\"Borright\"><input class=\"time\" style=\"width:200px;height:30px;margin-left:10px;margin-top:8px\"></div>"
				+ "	<div class=\"Borleft1\">调查简介</div>"
				+ "	<div class=\"Borright1\">"
				+ "	<textarea  class=\"introdution\" cols=\"50\" style=\"width: 448px; height: 146px;margin-left:10px;\"></textarea>"
				+ "	</div>"
				+ "	<div class=\"Borleft\">操作</div>"
				+ "	<div class=\"Borright\">"
				+ "	<button class=\"tasksubmit\" style=\"margin-top:10px;\">提交</button>&nbsp;&nbsp;&nbsp;"
				+ "	<button class=\"taskreset\" style=\"margin-top:10px;\">重置</button>&nbsp;&nbsp;&nbsp;"
				+ "	<button class=\"back\" style=\"margin-top:10px;\">返回</button>"
				+ "	</div>" + "	</div>");
		return $task;
	}
	$(".right").delegate(".submitQue", "click", function() {
		var $pro = $(".pro").val();
		var $option = $(".type option:selected").val();
		var $a = $(".A").val();
		var $b = $(".B").val();
		var $c = $(".C").val();
		var $d = $(".D").val();
		$.ajax({
			url : 'InsertSurveyServlet',
			type : 'post',
			data : {
				'issue' : $issue,
				'time' : $time,
				'introdution' : $introdution
			},
			success : function() {
				alert("添加成功");
				$(".issue").val("");
				$(".time").val("");
				$(".introdution").val("");
				window.location.href = "admin.html";

			},
			error : function() {
				alert('请求失败 ');
			}
		})

	});
	// 创建问题
	function createQuestion() {
		var $question = $("  </div>"
				+ "<div class=\"Borleft2\">问题</div>"
				+ "<div class=\"Borright2\"><input class=\"pro\" style=\"width:200px;height:30px;margin-left:10px;margin-top:8px\"></div>"
				+ "<div class=\"Borleft2\">问题类型</div>"
				+ "<div class=\"Borright2\">"
				+ "  <select class=\"type\" name=\"option\" style=\"height:25px;width:80px;\">"
				+ "   <option value=\"single\">单选题</option>"
				+ "    <option value=\"multiple\">多选题</option>"
				+ "   </select>"
				+ "  </div>"
				+ "   <div class=\"Borleft2\">A选项</div>"
				+ "<div class=\"Borright2\"><input class=\"A\" style=\"width:200px;height:30px;margin-left:10px;margin-top:8px\"></div>"
				+ "<div class=\"Borleft2\">B选项</div>"
				+ "<div class=\"Borright2\"><input class=\"B\" style=\"width:200px;height:30px;margin-left:10px;margin-top:8px\"></div>"
				+ "<div class=\"Borleft2\">C选项</div>"
				+ "<div class=\"Borright2\"><input class=\"C\" style=\"width:200px;height:30px;margin-left:10px;margin-top:8px\"></div>"
				+ "<div class=\"Borleft2\">D选项</div>"
				+ "<div class=\"Borright2\"><input class=\"D\" style=\"width:200px;height:30px;margin-left:10px;margin-top:8px\"></div>"
				+ "<div class=\"Borleft2\">操作</div>"
				+ "<div class=\"Borright2\">"
				+ "<button style=\"margin-top:10px;\" class=\"submitQue\">提交</button>&nbsp;&nbsp;&nbsp;"
				+ "	<button style=\"margin-top:10px;\">重置</button>&nbsp;&nbsp;&nbsp;"
				+ "	<button style=\"margin-top:10px;\">返回</button>" + "</div>" +

				"</div>" + "</div>");
		return $question;
	}
	function createtaskManage() {
		var $taskManage = $("<table border=\"1\"  >"
				+ "	<tr>"
				+ "	<td style=\"width:150px;height:50px;\"><font size=\"5\" color=\"red\" >课题</font></td>"
				+ "	<td style=\"width:150px;height:50px;\"> <font size=\"5\" color=\"red\" width=\"300px\" > 调查时间</font></td>"
				+ "	<td style=\"width:300px;height:50px;\"><font size=\"5\" color=\"red\" width=\"300px\" >操作</font></td>"
				+ "	</tr>" + "  </table>");
		return $taskManage;
	}
})