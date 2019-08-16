package decorator;

import org.displaytag.decorator.TableDecorator;

import beans.OrderDTO;
import beans.ShopDTO;

public class WrapperShopSale extends TableDecorator {

	public String getImageProd() {
		ShopDTO s = (ShopDTO)getCurrentRowObject();
		
		String img = "<img src='images/content/products/" + s.getImgProd() + "' width='100px'>";
		
		return img;
	}
	public String getDelete() {
		OrderDTO o = (OrderDTO) getCurrentRowObject();
		String numPed =o.getNroPedido();
		return  "<a href='carrito?option=dltAdmin&pd="+ numPed +"' class='btn btn-outline-danger' style='margin-right: 5px;'>Eliminar</a>";
	}
	
}
