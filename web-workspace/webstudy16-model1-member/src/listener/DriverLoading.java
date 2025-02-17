package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.DBInfo;

/**
 * Application Lifecycle Listener implementation class MemberListener
 *
 */
@WebListener
public class DriverLoading implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DriverLoading() {
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
    public void contextInitialized(ServletContextEvent arg0){ 
    	try
    	{
			Class.forName(DBInfo.DRIVER);
			System.out.println("contextInitialize() Driver Loading");
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		}
    }
}
