package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductDTO;
import beans.ProviderDTO;
import services.ProviderService;

/**
 * Servlet implementation class ProviderServlet
 */
@WebServlet("/proveedor")
public class ProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProviderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	ProviderService ps = new ProviderService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String option = req.getParameter("option");
		
		switch (option) {
		case "listAll": listAll(req,resp); break;
		case "uptProv": uptProv(req,resp); break;
		case "addProv": addProv(req,resp); break;
		case "delProv": delProv(req,resp); break;
		case "chargeData" : chargeData(req,resp); break;
		case "chargeDataDel" : chargeDataDel(req,resp); break;
		default:
			break;
		}
		super.service(req, resp);
	}

	private void addProv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entro al servlete para gregar");
		int codUser ;
		String des,ruc,dir,mensaje; 
		
		codUser = Integer.parseInt( req.getParameter("cod"));
		des = req.getParameter("des");
		ruc = req.getParameter("ruc");
		dir = req.getParameter("dir");
		
		ProviderDTO p =new ProviderDTO();
		p.setIdUsu(codUser);
		p.setDesProveedor(des);
		p.setRucProveedor(ruc);
		p.setDirProveedor(dir);
		
		int ok = ps.add(p);
		if(ok != 0) {
			mensaje = "Se ha registrado correctamente";
		}else {
			mensaje = "No se pudo registrar";
		}
		req.getRequestDispatcher("admin/mainProveedorAdmin.jsp").forward(req, resp);
	}

	private void chargeDataDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cod = req.getParameter("pc");
		
		ProviderService  ps = new ProviderService();
		
		ProviderDTO p = ps.getAllbyId(cod);
		
		req.getSession().setAttribute("p", p);
		req.getRequestDispatcher("admin/DelProviderAdmin.jsp").forward(req, resp);
	}

	private void chargeData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cod = req.getParameter("pc");
		
		ProviderService  ps = new ProviderService();
		
		ProviderDTO p = ps.getAllbyId(cod);
		
		req.getSession().setAttribute("p", p);
		req.getRequestDispatcher("admin/UpdProviderAdmin.jsp").forward(req, resp);
	}

	private void delProv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idProv = req.getParameter("cod");
		String mensaje = "Todo Mal";
		int ok = ps.EliminarProviders(idProv);
		if(ok != 0) {
			mensaje = "Todo bien";
		}
		System.out.println(mensaje);
		listAll(req, resp);
	}

	private void uptProv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idProv = req.getParameter("idProveedor");
		int idUsu = Integer.parseInt(req.getParameter("idUsu"));
		String descProv = req.getParameter("desProveedor");
		String rucProv = req.getParameter("rucProveedor");
		String dirProv = req.getParameter("dirProveedor");
		String mensaje = "Todo Mal";
		
		ProviderDTO p = new ProviderDTO();
		p.setIdProveedor(idProv);
		p.setIdUsu(idUsu);
		p.setDesProveedor(descProv);
		p.setRucProveedor(rucProv);
		p.setDirProveedor(dirProv);
		
		int ok  = ps.UpdateProviders(p);
		if(ok != 0) {
			mensaje = "Todo OK";
		}
		req.setAttribute("mensaje", mensaje);
		req.getRequestDispatcher("admin/mainProveedorAdmin.jsp").forward(req, resp);
	}

	private void listAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entro al servlet Proveedor");
		ArrayList<ProviderDTO> listadoAdm = ps.listOfProviders();
		req.setAttribute("listadoAdm", listadoAdm);
		req.getRequestDispatcher("admin/mainProveedorAdmin.jsp").forward(req, resp);
		
	}
}
