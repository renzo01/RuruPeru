package decorator;

import org.displaytag.decorator.TableDecorator;

import beans.ProviderDTO;

public class WrapperProvider extends TableDecorator {
	public String getOperaciones() {
		ProviderDTO p = (ProviderDTO) getCurrentRowObject();
		String cod = p.getIdProveedor();
		int usu = p.getIdUsu();
		String des = p.getDesProveedor();
		String ruc = p.getRucProveedor();
		String dir = p.getDirProveedor();
		String actualizar = "<a href ='admin/UpdProviderAdmin.jsp?cod="+cod+"&usu="+usu+"&des="+des+"&ruc="+ruc+"&dir="+dir+"' style='margin-right:5px;' class='btn btn-outline-warning'>Actualizar</a>";
		String eliminar = "<a href ='proveedor?option=delProv&cod="+cod+"' class='btn btn-outline-danger'>Eliminar</a>";
		return actualizar+eliminar;
	}
}
