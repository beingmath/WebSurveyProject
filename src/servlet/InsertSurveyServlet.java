package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Survey;
import service.SurveyService;
@WebServlet("/InsertSurveyServlet")
public class InsertSurveyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/text;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String issue = request.getParameter("issue");
		String time = request.getParameter("time");
		String introdution = request.getParameter("introdution");
		Survey survey=new Survey(issue,Integer.parseInt(time),introdution);
		try {
			SurveyService.inserSurvey(survey);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
