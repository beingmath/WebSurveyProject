package listener;

import java.io.IOException;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import pojo.User;

/**
 * Application Lifecycle Listener implementation class OffListener
 *
 */
@WebListener
public class OffListener implements HttpSessionListener {

   
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @throws IOException 
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se,HttpServletResponse hr) throws IOException  { 
         // TODO Auto-generated method stub
    	HttpSession session = se.getSession();
		hr.sendRedirect("login.html");
    }

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
