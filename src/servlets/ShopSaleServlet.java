package servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ClientDTO;
import beans.DetailOrderDTO;
import beans.OrderDTO;
import beans.ProductDTO;
import beans.ShopDTO;
import beans.UserDTO;
import services.ClientService;
import services.OrderService;
import services.ProductService;

/**
 * Servlet implementation class ShopSaleServlet
 */
@WebServlet("/carrito")
public class ShopSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps = new ProductService();
	private OrderService os = new OrderService();
	private ClientService cs = new ClientService();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("option");

		switch (option) {
		case "bus":
			searchProdById(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "dlt":
			delete(request, response);
			break;
		case "dltAdmin":
			deleteAdmin(request, response);
			break;
		case "mdf":
			modifyArt(request, response);
			break;
		case "confirm_shop":
			shopProducts(request, response);
			break;
		case "listShop":
			listShop(request, response);
			break;
		default:
			break;
		}
	}

	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al admin -v -del");
		String numPed = request.getParameter("pd");
		String mensaje;
		int rs = os.deleteByOrdNum(numPed);

		if (rs == 0) {
			mensaje = "Error al eliminar el prod";
		} else {
			mensaje = "Eliminado correctamente";
		}
		System.out.println("Mensaje delete: " + mensaje + " Código: " + numPed);
		request.setAttribute("mensaje", mensaje);
		listShop(request, response);
	}

	private void listShop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<OrderDTO> listSale = os.listAll();
		request.setAttribute("listado", listSale);
		request.getRequestDispatcher("admin/mainSalesAdmin.jsp").forward(request, response);
		System.out.println("Entro en el servlet carrito");
	}

	private void shopProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dentro de comprar productos");
		String mensaje = "Usuario no logueado";
		String mensaje2 = "";
		UserDTO u = (UserDTO) request.getSession().getAttribute("user");

		if (u != null) {
			ClientDTO c = cs.searchByUser(u.getIdUsu());
			if (c != null) {
				addOrder(request, response, c);
				ArrayList<ShopDTO> glord = new ArrayList<ShopDTO>();
				if (glord.isEmpty()) {
					mensaje2 = "<h3 class='list-shop-empty'>Lista vacía</h3>";
				} else {
					mensaje2 = "";
				}
				System.out.println("mensaje de lista: " + mensaje2);

				request.getSession().setAttribute("mshop", mensaje2);
				request.getSession().setAttribute("glord", glord);
				request.getSession().setAttribute("cantArt", 0);
				request.getSession().setAttribute("descuentoShop", 0.0);
				request.getSession().setAttribute("subTotal", 0.0);
				request.getSession().setAttribute("totalShop", 0.0);
				mensaje = "Compra exitosa";
			} else {
				mensaje = "Complete su información para poder comprar";
			}
		}
		request.setAttribute("msgSuccess", mensaje);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void addDetailOrder(HttpServletRequest request, HttpServletResponse response, String nroPedido) {

		System.out.println("Dentro de agregar detalle boleta");

		@SuppressWarnings("unchecked")
		ArrayList<ShopDTO> glord = (ArrayList<ShopDTO>) request.getSession().getAttribute("glord");

		ArrayList<DetailOrderDTO> ldo = new ArrayList<DetailOrderDTO>();

		for (ShopDTO s : glord) {
			DetailOrderDTO d = new DetailOrderDTO();
			d.setNroPedido(nroPedido);
			d.setIdProducto(s.getIdProd());
			d.setPreProd(s.getPreProd());
			d.setCantidad(s.getCantProd());
			d.setDescuento(d.getDescuento());
			d.setSubtotal(s.getSubTotalProd());

			ldo.add(d);
		}

		for (DetailOrderDTO d : ldo) {
			os.registerDetailOrder(d);
		}
	}

	private void addOrder(HttpServletRequest request, HttpServletResponse response, ClientDTO c) {

		System.out.println("Dentro de agregar boleta");

		int cantArt;
		double descuentoShop, totalShop;

		cantArt = (int) request.getSession().getAttribute("cantArt");
		descuentoShop = (double) request.getSession().getAttribute("descuentoShop");
		totalShop = (double) request.getSession().getAttribute("totalShop");

		DecimalFormat df = new DecimalFormat("000000");

		String nroPedido = "PED000001";

		if (os.lastIdOrder() != null) {
			String lastNroPedido = os.lastIdOrder().substring(4);
			// PED000001
			nroPedido = "PED" + df.format(Integer.parseInt(lastNroPedido) + 1);
		}

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fecPedido = sdf.format(date);

		OrderDTO o = new OrderDTO();
		o.setNroPedido(nroPedido);
		o.setIdCliente(c.getIdCliente());
		o.setDirPedido(c.getDirCli());
		o.setFecPedido(fecPedido);
		o.setCantTotal(cantArt);
		o.setTotal(totalShop);
		o.setDescPedido(descuentoShop);

		os.registerOrder(o);

		addDetailOrder(request, response, o.getNroPedido());
	}

	private void modifyArt(HttpServletRequest request, HttpServletResponse response) {

		@SuppressWarnings("unchecked")
		ArrayList<ShopDTO> glord = (ArrayList<ShopDTO>) request.getSession().getAttribute("glord");
		int nk = Integer.parseInt(request.getParameter("nk"));
		int i = Integer.parseInt(request.getParameter("i"));
		int cantProd = glord.get(i).getCantProd();
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de detele del carro de compras");

		int i = Integer.parseInt(request.getParameter("i"));

		String url = "/detail-product.jsp";
		String mensaje;

		@SuppressWarnings("unchecked")
		ArrayList<ShopDTO> glord = (ArrayList<ShopDTO>) request.getSession().getAttribute("glord");
		double precio = glord.get(i).getPreProd();
		int cantProd = glord.get(i).getCantProd();
		int cantArt = (int) request.getSession().getAttribute("cantArt");
		double subTotal = (double) request.getSession().getAttribute("subTotal");
		double descuentoShop = (double) request.getSession().getAttribute("descuentoShop");
		double totalShop = (double) request.getSession().getAttribute("totalShop");

		cantArt--;
		subTotal -= precio * cantProd;
		totalShop = subTotal - descuentoShop;
		glord.remove(i);

		if (glord.isEmpty()) {
			mensaje = "<h3 class='list-shop-empty'>Lista vacía</h3>";
		} else {
			mensaje = "";
		}
		System.out.println("Iniciando en: " + glord);

		request.getSession().setAttribute("mshop", mensaje);
		request.getSession().setAttribute("glord", glord);
		request.getSession().setAttribute("cantArt", cantArt);
		request.getSession().setAttribute("subTotal", subTotal);
		request.getSession().setAttribute("totalShop", totalShop);

		request.getRequestDispatcher(url).forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de agregar al carrito");

		int cantProd = Integer.parseInt(request.getParameter("k"));

		ProductDTO p = (ProductDTO) request.getSession().getAttribute("gp");
		System.out.println("Producto: " + p);
		String idProd = p.getIdProd();
		String imgProd = p.getImgProd();
		String nomProd = p.getNomProd();
		double preProd = p.getPrecProd();

		@SuppressWarnings("unchecked")
		ArrayList<ShopDTO> glord = (ArrayList<ShopDTO>) request.getSession().getAttribute("glord");
		int cantArt = (int) request.getSession().getAttribute("cantArt");
		double subTotal = (double) request.getSession().getAttribute("subTotal");
		double descuentoShop = (double) request.getSession().getAttribute("descuentoShop");
		double totalShop = (double) request.getSession().getAttribute("totalShop");

		String msgadd = "";

		for (ShopDTO ss : glord) {
			String ip = ss.getIdProd();
			if (ip.equals(p.getIdProd())) {
				msgadd = "Ya agregó este producto";
			} else {
				msgadd = "";
			}
		}

		ShopDTO s = new ShopDTO();
		s.setIdProd(idProd);
		s.setImgProd(imgProd);
		s.setNomProd(nomProd);
		s.setCantProd(cantProd);
		s.setPreProd(preProd);
		s.setSubTotalProd(cantProd * preProd);
		glord.add(s);
		cantArt++;
		subTotal += s.getSubTotalProd();
		totalShop = subTotal - descuentoShop;

		String url = "/detail-product.jsp";
		String mensaje;

		if (glord.isEmpty()) {
			mensaje = "<h3 class='list-shop-empty'>Lista vacía</h3>";
		} else {
			mensaje = "";
		}
		System.out.println("Iniciando en: " + glord);

		request.getSession().setAttribute("mshop", mensaje);
		request.getSession().setAttribute("glord", glord);
		request.getSession().setAttribute("cantArt", cantArt);
		request.getSession().setAttribute("subTotal", subTotal);
		request.getSession().setAttribute("totalShop", totalShop);

		request.getRequestDispatcher(url).forward(request, response);
	}

	private void searchProdById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dentro de buscar");

		String xidProd = request.getParameter("pd");
		String url = "/detail-product.jsp";

		ProductDTO gp = ps.getProductById(xidProd);

		System.out.println("Producto: " + gp);
		request.getSession().setAttribute("gp", gp);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
