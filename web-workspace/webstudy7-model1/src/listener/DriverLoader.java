package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.DBInfo;

/**
 * Application Lifecycle Listener implementation class DriverLoader
 *
 */
public class DriverLoader implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DriverLoader() {
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
    public void contextInitialized(ServletContextEvent arg0)  
    { 
    	try 
    	{
			Class.forName(DBInfo.DRIVER);
			System.out.println("contextInitialized() Driver Loading");
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		}
    }
	
}
