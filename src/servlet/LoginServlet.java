package servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.User;
import service.UserService;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String role = request.getParameter("role");
		System.out.println(name+pwd+role);
		User user=new User(name,pwd,role);
		try {
			Boolean isReg = UserService.findUser(user);
			System.out.println(isReg);
			//注册用户
			if(isReg&&role.equals("user")) {
				HttpSession session = request.getSession();
				session.setAttribute(User.SESSION_NAME, user);
				response.sendRedirect("user.html");
				
			}
			//管理员
			if(isReg&&role.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute(User.SESSION_NAME,user);
				response.sendRedirect("admin.html");
			
			}else if(!isReg) {
				response.sendRedirect("login.html");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
