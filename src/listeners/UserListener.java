package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import beans.ShopDTO;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class UserListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         
    	System.out.println("Escuchando...: " + arg0.getSession().getId());
    	
    	ArrayList<ShopDTO> glord = new ArrayList<ShopDTO>();
    	int cantArt = 0;
    	double subTotal = 0.0;
    	double totalShop = 0.0;
    	double descuentoShop = 0.0;
    	
    	String mensaje;
		
    	if(glord.isEmpty()) {
			mensaje = "<h3 class='list-shop-empty'>Lista vacía</h3>";
		} else {
			mensaje = "";
		}
		System.out.println("Iniciando en: " + glord);
		
		arg0.getSession().setAttribute("mshop", mensaje);
    	arg0.getSession().setAttribute("glord", glord);
    	arg0.getSession().setAttribute("cantArt", cantArt);
    	arg0.getSession().setAttribute("subTotal", subTotal);
    	arg0.getSession().setAttribute("descuentoShop", descuentoShop);
    	arg0.getSession().setAttribute("totalShop", totalShop);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  {
    	
    	System.out.println("Terminando...: " + arg0.getSession().getId());
    }
	
}
