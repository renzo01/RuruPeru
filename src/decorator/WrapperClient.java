package decorator;

import org.displaytag.decorator.TableDecorator;

import beans.ClientDTO;

public class WrapperClient extends TableDecorator {
	public String getOperaciones() {
		ClientDTO c = (ClientDTO) getCurrentRowObject();
		String cod = c.getIdCliente();
		String nom = c.getNomCliente();
		String ape = c.getApeCliente();
		String dni = c.getDniCli();
		String dir = c.getDirCli();
		String fecnac =c.getFechNacCli();
		String gen = c.getGenCli();
		String Actualizar = "<a href='admin/uptClienteAdmin.jsp?pd="+ cod +"&nom="+nom+"&ape="+ape+"&dni="+dni+"&dir="+dir+"&fecnac="+fecnac+"&gen="+gen+"' id='btn_upd_prod' class='btn btn-outline-warning' style='margin-right: 5px;'>Actualizar</a>";
		String Eliminar = "<a href='producto?option=dlt&pd="+ cod +"' class='btn btn-outline-danger' style='margin-right: 5px;'>Eliminar</a>";
		return Actualizar + Eliminar;
	}
}
