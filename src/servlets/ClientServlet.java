package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ClientDTO;
import beans.ShopDTO;
import beans.UserDTO;
import services.ClientService;
import services.OrderService;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/cliente")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService cs = new ClientService();
	private OrderService ds = new OrderService();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		
		switch(option) {
		case "lCli":
			listAll(request, response); break;
		case "addCli":
			add(request, response); break;
		case "updCli":
			update(request, response); break;
		case "dltCli":
			delete(request, response); break;
		case "addupdCli":
			addUpdate(request, response); break;
		case "logCli":
			getClientByUser(request, response); break;
		case "lpcli":
			getDetailOrderByClient(request, response); break;
		case "udtCliAdmin": udtCliAdmin(request,response); break;
		default:
			break;
		}
		
	}

	private void udtCliAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nombre,apellido,dni,fecnac,dir,gen,mensaje;
		cod = request.getParameter("cod");
		nombre  = request.getParameter("nombre");
		apellido  = request.getParameter("apellido");
		dni = request.getParameter("dni");
		fecnac = request.getParameter("fecnac");
		dir = request.getParameter("dir");
		gen = request.getParameter("gen");
		ClientDTO c = new ClientDTO();
		c.setIdCliente(cod);
		c.setNomCliente(nombre);
		c.setApeCliente(apellido);
		c.setDniCli(dni);
		c.setFechNacCli(fecnac);
		c.setDirCli(dir);
		c.setGenCli(gen);
		
		int ok = cs.updateClientByAdmin(c);
		if(ok != 0) {
			mensaje = "Se ha actualizado correctamente";
		}else {
			mensaje = "No se a podido actualizar";
		}
		request.setAttribute("mensaje", mensaje);
		listAll(request, response);
	}
	private void getDetailOrderByClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Dentro de obtener detailOrder por Cliente");
		ClientDTO c = (ClientDTO)request.getSession().getAttribute("cli");
		
		if(c != null) {
			ArrayList<ShopDTO> ldocli = new ArrayList<ShopDTO>();
			ldocli = ds.getDetailOrderByClient(c.getIdCliente());
			request.getSession().setAttribute("ldocli", ldocli);
			System.out.println("Dentro de obprod: " + ldocli);
		}
		System.out.println("Cliente: " + c);
		request.getRequestDispatcher("/allProducts.jsp").forward(request, response);
	}

	private void getClientByUser(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Dentro de obtener Cliente");
		String mensaje;
		
		UserDTO u = (UserDTO)request.getSession().getAttribute("user");
		ClientDTO c = cs.searchByUser(u.getIdUsu());
		
		if(c == null) {
			mensaje = "Cliente no existe";
		} else {
			mensaje = "Cliente existe";
		}
		
		request.setAttribute("mensajeLogCli", mensaje);
		
		request.getSession().setAttribute("cli", c);
		System.out.println("Mensaje de Login de cliente: " + mensaje);
		
	}

	private void addUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Dentro de addUpdate Cliente");
		
		UserDTO u = (UserDTO)request.getSession().getAttribute("user");
		ClientDTO c = cs.searchByUser(u.getIdUsu());
		
		if(c == null) {
			add(request, response);
		} else {
			update(request, response);
		}
		
	}

	private void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dentro de listar todo Clientes");
		String mensaje;
		
		ArrayList<ClientDTO> lClient = cs.listAllForAdmin();
		
		if(lClient != null) {
			mensaje = "No hay Clientes";
		}else {
			mensaje = "Clientes cargados";
		}
		System.out.println(mensaje);
		request.setAttribute("lClient", lClient);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("admin/mainClientAdmin.jsp").forward(request, response);
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de add Cliente");
		
		int idDepa;
		String username, password, email, telephone, fotoUsu;
		String url, mensaje;
		String nomCliente, apeCliente, dniCli, dirCli, fechNacCli, genCli;
		
		idDepa = Integer.parseInt(request.getParameter("reg_depa"));
		username = request.getParameter("reg_username");
		password = request.getParameter("reg_password");
		email = request.getParameter("reg_email");
		telephone = request.getParameter("reg_phone");
		fotoUsu = request.getParameter("reg_file");
		nomCliente = request.getParameter("reg_name");
		apeCliente = request.getParameter("reg_lname");
		dniCli = request.getParameter("reg_dni");
		dirCli = request.getParameter("reg_dir");
		fechNacCli = request.getParameter("reg_fecnac");
		genCli = request.getParameter("reg_gen");
		
		ClientDTO c = new ClientDTO();
		UserDTO u = (UserDTO)request.getSession().getAttribute("user");
		c.setIdUsu(u.getIdUsu());
		c.setIdDepa(idDepa);
		c.setUsername(username);
		c.setPassword(password);
		c.setEmail(email);
		c.setTelephone(telephone);
		c.setFotoUsu(fotoUsu);
		c.setNomCliente(nomCliente);
		c.setApeCliente(apeCliente);
		c.setDniCli(dniCli);
		c.setDirCli(dirCli);
		c.setFechNacCli(fechNacCli);
		c.setGenCli(genCli);
		
		int rs = cs.add(c);
		
		if(rs == 0) {
			mensaje = "Error al registrar cliente";
		} else {
			mensaje = "Actualizado correctamente";
		}
		url = "/updateUser.jsp";
		
		request.getSession().setAttribute("cli", c);
		request.setAttribute("msjCli", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de Update Cliente");
		
		int idDepa;
		String username, password, email, telephone, fotoUsu;
		String url, mensaje;
		String nomCliente, apeCliente, dniCli, fechNacCli, genCli;
		
		idDepa = Integer.parseInt(request.getParameter("reg_depa"));
		username = request.getParameter("reg_username");
		password = request.getParameter("reg_password");
		email = request.getParameter("reg_email");
		telephone = request.getParameter("reg_phone");
		fotoUsu = request.getParameter("reg_file");
		nomCliente = request.getParameter("reg_name");
		apeCliente = request.getParameter("reg_lname");
		dniCli = request.getParameter("reg_dni");
		fechNacCli = request.getParameter("reg_fecnac");
		genCli = request.getParameter("reg_gen");
		
		ClientDTO c = (ClientDTO)request.getSession().getAttribute("cli");
		c.setIdDepa(idDepa);
		c.setUsername(username);
		c.setPassword(password);
		c.setEmail(email);
		c.setTelephone(telephone);
		c.setFotoUsu(fotoUsu);
		c.setNomCliente(nomCliente);
		c.setApeCliente(apeCliente);
		c.setDniCli(dniCli);
		c.setFechNacCli(fechNacCli);
		c.setGenCli(genCli);
		
		int rs = cs.update(c);
		
		if(rs == 0) {
			mensaje = "Error al actualizar cliente";
		} else {
			mensaje = "Datos ctualizados correctamente";
		}
		url = "/updateUser.jsp";
		
		request.getSession().setAttribute("cli", c);
		request.setAttribute("msjCli", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("cd");
		String mensaje;
		int ok = cs.delete(cod);
		if(ok == 0) {
			mensaje = "Error al eliminar cliente";
		}else {
			mensaje = "Eliminado correctamente";
		}
		System.out.println("Mensaje delete: " + mensaje + " Código: " + cod);
		request.setAttribute("mensaje", mensaje);
		listAll(request,response);
		
	}

}
