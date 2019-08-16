<%@page import="beans.CategoryDTO"%>
<%@page import="dao.MySqlCategoryDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="beans.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>RuruPerú</title>

<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/product.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/mediaRule.css">

<script src="js/jquery.js"></script>
<script src="js/global.js"></script>
<script src="js/login.js"></script>

</head>

<body>

	<%-- Include que invoca a los formularios: Login, Registrar y Resetear password --%>
    <jsp:include page="logRegReset.jsp"></jsp:include>
    
    <%-- Include que invoca al modal de compras --%>
	<jsp:include page="modalShop.jsp"></jsp:include>
    
	<div id="container-all">

		<div id="container-content-all">
			
			<%-- Include que invoca a la cabecera de la WEB --%>
			<jsp:include page="headerIf.jsp"></jsp:include>

			<div class="content-banners">

				<div id="banner-principal">
					<img src="images/content/presentations/pres1.jpg" alt="">
					<div id="banner-letters">
						<h1>Productos de primera calidad</h1>
						<h2>para su pleno bienestar</h2>
						<h3></h3>
					</div>
				</div>

			</div>

			<div class="container-content">

				<!-- <h3>
                    <div class="lines-h3"></div>
                    <div>Adquiere en línea</div>
                    <div class="lines-h3"></div>
                </h3> -->
				<h5>Realiza una búsqueda</h5>
				<div id="search-product">

					<form action="producto">
						<div class="search-fields">
							<label for="prod_name">Producto:</label> <input type="text"
								name="prod_name">
						</div>
						<div class="search-fields">
							<label for="prod_cat">Categoría:</label>
							<select name="prod_cat">
								<option value="0">Seleccione</option>
								<%
									ArrayList<CategoryDTO> lcat = new MySqlCategoryDAO().listAll();
									if(lcat != null) {
										for(CategoryDTO c : lcat) { %>
											<option value="<%=c.getIdCategoria()%>"><%=c.getDescCategoria()%></option>
										<%}
									}
								%>
							</select>
						</div>
						<div class="search-fields">
							<label for="prod_pre_min">Precio mínimo:</label> <input
								type="number" name="prod_pre_min" step="any">
						</div>
						<div class="search-fields">
							<label for="prod_pre_max">Precio máximo:</label> <input
								type="number" name="prod_pre_max" step="any">
						</div>
						<div>
							<button id="btn-search" name="option" value="lpc">Buscar</button>
						</div>
					</form>

				</div>

				<div class="content-products">

					<%
                    	ArrayList<ProductDTO> lprod = (ArrayList<ProductDTO>)request.getAttribute("lprod");
                    	
                    	if(lprod != null) {
                    		DecimalFormat df = new DecimalFormat("00.00");
                    		String pres = "";
                    		
                    		for(ProductDTO p : lprod) {
                    			pres = df.format(p.getPrecProd()) + "";%>
					<article class="content-products-images">
						<a href="producto?option=gpbs&pd=<%=p.getIdProd()%>" target="_blank" class="anchor-products">
							<div class="content-images-price">
								<img class="images-products"
									src="images/content/products/<%=p.getImgProd()%>" alt="">
								<div class="product-price">
									<div class="price-denomitation">S/</div>
									<div class="price-int">
										<%=pres.substring(0, 2)%><div class="price-decimal">.<%=pres.substring(pres.length() - 2)%></div>
									</div>
								</div>
							</div>
							<h4><%=p.getNomProd() %></h4>
							<hr>
						</a>
						<figcaption><%=p.getDescProd() %></figcaption>
						<img class="icon-cinta" src="images/content/products/cinta.png" alt="" title="Certificado premium">
						<hr>
						<div>
							<a href="producto?option=gpbs&pd=<%=p.getIdProd()%>" target="_blank" class="btn-send-detail-p">ADQUIRIR</a>
						</div>
					</article>
					<%		}
                    	}
                    %>

				</div>

			</div>

		</div>

		<%-- Include que invoca al pié de página de la WEB --%>
        <jsp:include page="footer.jsp"></jsp:include>
        
	</div>
</body>

</html>