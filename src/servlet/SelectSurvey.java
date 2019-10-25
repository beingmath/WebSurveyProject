package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Survey;
import service.SurveyService;
@WebServlet("/SelectSurvey")
public class SelectSurvey extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Survey> Surveys = SurveyService.SelectSurvey();
			// JSONArray jsonArray2 =JSONArray.fromObject(Surveys);
		//	System.out.println(jsonArray2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
