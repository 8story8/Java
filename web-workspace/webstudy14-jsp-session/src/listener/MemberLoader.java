package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MemberLoader
 *
 */
@WebListener
public class MemberLoader implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MemberLoader() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("memberInfo", "Bourbon 모범생");	
    }
	
}
