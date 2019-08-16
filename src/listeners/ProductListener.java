package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import servlets.ProductServlet;

/**
 * Application Lifecycle Listener implementation class ProductListener
 *
 */
@WebListener
public class ProductListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ProductListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         
    	System.out.println("Sesión de producto");
    	
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
