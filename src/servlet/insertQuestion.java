package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Question;
import service.QuestionService;

/**
 * Servlet implementation class insertQuestion
 */
@WebServlet("/insertQuestion")
public class insertQuestion extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String pro=	request.getParameter("pro");
	String type=request.getParameter("type");
	String A=	request.getParameter("A");
	String B=	request.getParameter("B");
	String C=	request.getParameter("C");
	String D=	request.getParameter("D");
	String task=request.getParameter("task");
	Question que=new Question(pro,Integer.parseInt(type),A,B,C,D,task);
	try {
		QuestionService.insertQuestion(que);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	response.sendRedirect("admin.html");
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
