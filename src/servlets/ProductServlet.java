package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BenefitDTO;
import beans.ProductDTO;
import services.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/producto")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps = new ProductService();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dentro del servlet producto");

		String option = request.getParameter("option");

		switch (option) {
		case "add":
			add(request, response);
			break;
		case "upd":
			update(request, response);
			break;
		case "dlt":
			delete(request, response);
			break;
		case "lstAll":
			listAll(request, response);
			break;
		case "lprod":
			getProductById(request, response);
			break;
		case "gpbs":
			getProductByIdSession(request, response);
			break;
		case "lben":
			getBenefitsByProduct(request, response);
			break;
		case "lpc":
			getProductsByCondition(request, response);
			break;
		case "lstAllADM":
			lstAllADM(request, response);
			break;
		case "chargeData":
			chargeData(request, response);
			break;
		case "chargeDataDel":
			chargeDataDel(request, response);
			break;
		default:
			break;
		}

	}

	private void chargeDataDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cod = request.getParameter("pd");

		ProductService ps = new ProductService();

		ProductDTO p = ps.getProductById(cod);

		request.getSession().setAttribute("p", p);

		request.getRequestDispatcher("admin/DeltProductAdmin.jsp").forward(request, response);

	}

	private void chargeData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cod = request.getParameter("pd");

		ProductService ps = new ProductService();

		ProductDTO p = ps.getProductById(cod);

		request.getSession().setAttribute("p", p);

		request.getRequestDispatcher("admin/InsertUpdProductAdmin.jsp").forward(request, response);

	}

	private void lstAllADM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ProductDTO> listadoAdm = ps.listAll();
		System.out.println("Dentro del main de admin producto");
		request.getSession().setAttribute("listadoAdm", listadoAdm);
		request.getRequestDispatcher("admin/mainProductAdmin.jsp").forward(request, response);
	}

	private void getProductsByCondition(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dentro de listar por condición");

		String xnomProd, xidCat;
		String bpremin, bpremax;
		double xpremin, xpremax;
		xnomProd = request.getParameter("prod_name");
		xidCat = request.getParameter("prod_cat");
		bpremin = request.getParameter("prod_pre_min");
		bpremax = request.getParameter("prod_pre_max");

		xpremin = 0;
		xpremax = 10000;

		ArrayList<ProductDTO> lprod;

		if (xnomProd.equals("") && bpremin.equals("") && bpremax.equals("") && xidCat.equals("0")) {

			lprod = ps.listAll();

		} else {
			if (!xnomProd.equals("")) {
				lprod = ps.getProductsByCondition(xnomProd, xidCat, xpremin, xpremax);
			} else {
				if (!xidCat.equals("0")) {
					System.out.println("Buscar por cate");
					lprod = ps.getProductsByCondition(null, xidCat, 0, 0);
				} else {
					if (!bpremin.equals("")) {
						System.out.println("Precio min: " + bpremin);
						xpremin = Double.parseDouble(bpremin);
					}
					if (!bpremax.equals("")) {
						System.out.println("Precio max: " + bpremax);
						xpremax = Double.parseDouble(bpremax);
						;
					}
					lprod = ps.getProductsByCondition(null, null, xpremin, xpremax);
				}
			}
		}

		String mensaje, url;

		if (lprod == null) {
			mensaje = "No hay productos con la búsqueda realizada";
		} else {
			mensaje = "";
		}
		url = "/products.jsp";
		System.out.println("Categoría: " + xidCat);
		request.setAttribute("lprod", lprod);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void getBenefitsByProduct(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Dentro de obtener beneficios");

		String mensaje, xidProd;

		xidProd = request.getParameter("pd");

		ArrayList<BenefitDTO> lben = ps.listBenefitsByProduct(xidProd);

		if (lben == null) {
			mensaje = "No hay beneficios";
		} else {
			mensaje = "Beneficios cargados";
		}

		request.getSession().setAttribute("lben", lben);
		request.setAttribute("msgben", mensaje);
	}

	private void getProductByIdSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dentro de obtener producto");

		String url, mensaje, xidProd;

		xidProd = request.getParameter("pd");

		ProductDTO p = ps.getProductById(xidProd);

		if (p == null) {
			mensaje = "No existe el producto";
		} else {
			mensaje = "Producto seleccionado: " + p.getIdProd();
		}
		url = "/detail-product.jsp?p=" + p.getIdProd();

		request.getSession().setAttribute("gp", p);
		request.setAttribute("msg", mensaje);
		getBenefitsByProduct(request, response);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void getProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dentro de obtener producto");

		String url, mensaje, xidProd;

		xidProd = request.getParameter("pd");

		ProductDTO p = ps.getProductById(xidProd);

		if (p == null) {
			mensaje = "No existe el producto";
		} else {
			mensaje = "Producto seleccionado: " + p.getIdProd();
		}
		url = "/detail-product.jsp?p=" + p.getIdProd();

		request.setAttribute("prod", p);
		request.setAttribute("msg", mensaje);
		getBenefitsByProduct(request, response);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de agregar producto");

		String imgProd, nomProd, idCat, descProd, mensaje, url;
		double preProd;
		int stockProd;

		imgProd = request.getParameter("reg_imageProd");
		nomProd = request.getParameter("reg_nameProd");
		idCat = request.getParameter("reg_catProd");
		descProd = request.getParameter("reg_descProd");
		preProd = Double.parseDouble(request.getParameter("reg_preProd"));
		stockProd = Integer.parseInt(request.getParameter("reg_stockProd"));

		ProductDTO p = new ProductDTO();
		p.setImgProd(imgProd);
		p.setNomProd(nomProd);
		p.setIdCat(idCat);
		p.setDescProd(descProd);
		p.setPrecProd(preProd);
		p.setStockProd(stockProd);

		int rs = ps.add(p);

		if (rs == 0) {
			mensaje = "Error al registrar producto";
		} else {
			mensaje = "Registrado Correctamente";
		}
		url = "admin/mainProductAdmin.jsp";
		System.out.println("Mensaje de agregar: " + mensaje);
		request.setAttribute("msgAddProd", mensaje);
		lstAllADM(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Dentro de actualizar");

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de delete product");

		String codProd = request.getParameter("pd");
		String mensaje, url;
		int rs = ps.delete(codProd);

		if (rs == 0) {
			mensaje = "Error al eliminar producto";
		} else {
			mensaje = "Eliminado correctamente";
		}
		url = "admin/mainProductAdmin.jsp";
		System.out.println("Mensaje delete: " + mensaje + " Código: " + codProd);
		request.setAttribute("msgDltProd", mensaje);
		lstAllADM(request, response);
	}

	private void listAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dentro de listar todo");

		String mensaje, url;

		ArrayList<ProductDTO> lprod = ps.listAll();

		if (lprod == null) {
			mensaje = "No hay productos";
		} else {
			mensaje = "Productos cargados";
		}
		url = "/products.jsp";

		request.setAttribute("lprod", lprod);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
