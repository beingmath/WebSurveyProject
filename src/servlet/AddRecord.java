package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Option;
import pojo.Record;
import pojo.User;
import service.QuestionService;
import service.RecordService;
@WebServlet("/AddRecord")
public class AddRecord extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String is=request.getParameter("i");
		if(is==null) {
			response.sendRedirect("user.html");
		}else if(is.equals("1")) {
			doone(request, response);
		}else{
			dotwo(request, response);
		}
		
	 }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//多个问题
   	public static void dotwo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String task=request.getParameter("task");
		 String[] type=request.getParameterValues("type");
		 String[] pro=request.getParameterValues("pro");
		 User user = (User) request.getSession().getAttribute(User.SESSION_NAME);
		 for(int i=0;i<type.length;i++) {
			 String optionsu="";
			 if(type[i].equals("0")) {//单选
				 String option=request.getParameter(pro[i]);
				 if(option!=null) {
	 //Record(String task, String pro, int type, String a, String b, String c, String d, String useroption,String username)
						try {
							 Option options  = QuestionService.SelectByQuestion(pro[i]);
					 Record record=new Record(task,pro[i],Integer.parseInt(type[i]),options.getA(),options.getB(),options.getC(),options.getD(),option,user.getName());
							RecordService.insertRecord(record);
						} catch (Exception e) {
							
						}
				 }
			 }if(type[i].equals("1")) {//多选
				 try {
				 String[] optionse=request.getParameterValues(pro[i]);
				 if(optionse!=null) {
					 for(String optionss:optionse) {
						 optionsu+=optionss;
					 }
					 Option options  = QuestionService.SelectByQuestion(pro[i]);
					 Record record=new Record(task,pro[i],Integer.parseInt(type[i]),options.getA(),options.getB(),options.getC(),options.getD(),optionsu,user.getName());
					 RecordService.insertRecord(record);
				 }
				 }catch(Exception e) {
				 }
				 
			 }
		 }
		 response.sendRedirect("user.html");
	}


//一个问题
public static void doone(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String task=request.getParameter("task");
	String type=request.getParameter("type");
	String pro=request.getParameter("pro");
	User user = (User) request.getSession().getAttribute(User.SESSION_NAME);
	if(type.equals("0")) {//单选
		 String option=request.getParameter(pro);
		 if(option!=null) {
//Record(String task, String pro, int type, String a, String b, String c, String d, String useroption,String username)
				try {
					 Option options  = QuestionService.SelectByQuestion(pro);
			 Record record=new Record(task,pro,Integer.parseInt(type),options.getA(),options.getB(),options.getC(),options.getD(),option,user.getName());
					RecordService.insertRecord(record);
				} catch (Exception e) {
					
				}
		 }
	 }if(type.equals("1")) {//多选
		 String optionsu="";
		 try {
		 String[] optionse=request.getParameterValues(pro);
		 if(optionse!=null) {
			 for(String optionss:optionse) {
				 optionsu+=optionss;
			 }
			 Option options  = QuestionService.SelectByQuestion(pro);
			 Record record=new Record(task,pro,Integer.parseInt(type),options.getA(),options.getB(),options.getC(),options.getD(),optionsu,user.getName());
			 RecordService.insertRecord(record);
		 }
		 }
		 catch(Exception e) {
		 }
		 
	 }

          response.sendRedirect("user.html");
}

}



