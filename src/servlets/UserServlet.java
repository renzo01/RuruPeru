package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ClientDTO;
import beans.UserDTO;
import services.ClientService;
import services.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	UserService us = new UserService();
	ClientService cs = new ClientService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Dentro del Servlet Usuario");
		
		String option = request.getParameter("option");
		
		switch(option) {
		case "logUser":
			getUserByEmailPass(request, response);
			break;
		case "updUser":
			updateUserById(request, response);
			break;
		case "lUsers":
			getAll(request, response); 
			break;
		case "nuser":
			addUser(request, response); break;
		case "bcli":
			searchClientByUsu(request, response); break;
		default:
			break;
		}
	}

	private void searchClientByUsu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Dentro de buscar cliente por idUsu");
		
		int xidUsu = Integer.parseInt(request.getParameter("usu"));
		
		ClientDTO c = cs.searchByUser(xidUsu);
		
		if(c != null) {
			request.getSession().setAttribute("cli", c);
		}
		
		request.getRequestDispatcher("/detail-user.jsp").forward(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email, password, username, mensaje, url, foto, telephone;
		int depa;
		username = request.getParameter("reg_user");
		password = request.getParameter("reg_pass0");
		email = request.getParameter("reg_email");
		foto = request.getParameter("upd_image");
		depa = Integer.parseInt(request.getParameter("reg_depa"));
		telephone = request.getParameter("reg_phone");
		
		UserDTO u = new UserDTO();
		
		u.setEmail(email);
		u.setFotoUsu("");
		u.setIdDepa(depa);
		u.setPassword(password);
		u.setTelephone(telephone);
		u.setUsername(username);
		
		int rs = us.addUser(u);
		
		if(rs == 0){
			mensaje = "No se ha registrado el usuario";
		} else {
			mensaje = "Registrado correctamente";
		}
		url = "/index.jsp";
		
		request.setAttribute("mensajeAdd", mensaje);
		request.getSession().setAttribute("user", u);
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Dentro de obtener todos los usuarios");
		
		String mensaje, url;
		ArrayList<UserDTO> lista = us.getAll();
		
		if(lista == null) {
			mensaje = "No hay usuarios registrados";
		} else {
			mensaje = "Lista cargada correctamente";
		}
		url = "/listadoUsers.jsp";
		
		request.getSession().setAttribute("listaUsers", lista);
		request.setAttribute("mensajeList", mensaje);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void getUserByEmailPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Dentro de obtener usuario");
		String email, password, mensaje, url;
		
		email = request.getParameter("log_email");
		password = request.getParameter("log_pass");
		
		UserDTO u = us.getByEmailPass(email, password);
		
		if(u == null) {
			mensaje = "El email o la contraseña son inválidos";
		} else {
			mensaje = "Logueado correctamente";
		}
		url = "/index.jsp";
		
		request.setAttribute("mensajeLog", mensaje);
		
		request.getSession().setAttribute("user", u);
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("Mensaje de Login: " + mensaje);
		
	}

	private void updateUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dentro de actualizar usuario");
		
		int code;
		String email, password, username, mensaje, url, foto, telephone;
		
		code = Integer.parseInt(request.getParameter("upd_code"));
		username = request.getParameter("upd_user");
		password = request.getParameter("upd_pass0");
		email = request.getParameter("upd_email");
		foto = request.getParameter("upd_image");
		telephone = request.getParameter("upd_phone");
		
		UserDTO u = new UserDTO();
		
		u.setIdUsu(code);
		u.setEmail(email);
		u.setFotoUsu(foto);
		u.setPassword(password);
		u.setTelephone(telephone);
		u.setUsername(username);
		
		
		int rs = us.updateUserByid(u);
		
		if(rs == 0){
			mensaje = "No ha actualizado el usuario";
		} else {
			mensaje = "Actualizado correctamente";
		}
		url = "/detail-user.jsp";
		
		request.setAttribute("mensajeUpd", mensaje);
		request.getSession().setAttribute("user", u);
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("Mensaje de Actualizar: " + mensaje);
	}

}
