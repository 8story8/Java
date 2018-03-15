package step6;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
    	System.out.println("contextDestroyed()");
    }

	/**
     * Web Application 최초 시작 시점
     * -> ServletContext 객체를 생성
     *     -> 생성 직후에 contextInitialized() 메서드가 호출
     *         -> 단 한 번 실행되므로 DB Driver Loading 작업을 한다.
     *
     */
    public void contextInitialized(ServletContextEvent event) 
    { 
    	String db_driver = event.getServletContext().getInitParameter("db_driver");
         
        try 
        {
        	Class.forName(db_driver);
 			System.out.println("contextInitialized() 실행시 Driver Loading");
 		} 
        catch (ClassNotFoundException e) 
        {
 			e.printStackTrace();
 		}
    }
}
