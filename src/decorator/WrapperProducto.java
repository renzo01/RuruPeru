package decorator;


import org.displaytag.decorator.TableDecorator;

import beans.ProductDTO;
import beans.ShopDTO;

public class WrapperProducto extends TableDecorator {
	public String getActualizar() {
		ProductDTO p = (ProductDTO) getCurrentRowObject();
		String cod = p.getIdProd();
		String actualizar = "<a href='admin/mainProductAdmin.jsp?pd="+ cod +"' id='btn_upd_prod' class='btn btn-outline-warning' style='margin-right: 5px;'>Actualizar</a>";
		String eliminar = "<a href='producto?option=dlt&pd="+ cod +"' class='btn btn-outline-danger' style='margin-right: 5px;'>Eliminar</a>";
		return actualizar + eliminar;
	}
	public String getImagen() {
		ProductDTO p = (ProductDTO) getCurrentRowObject();
		return "<img src='images/content/products/" + p.getImgProd() + "' alt='Img-Prod' width='100px'>";
	}
	
	public String getImagenShop() {
		ShopDTO s = (ShopDTO) getCurrentRowObject();
		return "<img src='images/content/products/" + s.getImgProd() + "' alt='Img-Prod' width='100px'>";
	}
}
