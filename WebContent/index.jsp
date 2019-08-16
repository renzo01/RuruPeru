<%@page import="java.util.ArrayList"%>
<%@page import="beans.ProductDTO"%>
<%@page import="services.ProductService"%>
<%@page import="java.text.DecimalFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>RuruPerú</title>

<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/mediaRule.css">

<script src="js/jquery.js"></script>
<script src="js/global.js"></script>
<script src="js/login.js"></script>
<script src="js/index.js"></script>

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
					<video src="videos/licor.mp4" muted autoplay loop></video>
					<div id="banner-letters">
						<h1>... Siente la bebida que</h1>
						<h2>le da el toque dulce a tu vida ...</h2>
						<h3></h3>
					</div>
				</div>

			</div>

			<div class="container-content">

				<h3>
					<div class="lines-h3"></div>
					<div>Algunos de nuestros productos</div>
					<div class="lines-h3"></div>
				</h3>

				<div class="content-products">
					<!-- <div class="content-articles"> -->

					<%
                    	ArrayList<ProductDTO> lprod = new ProductService().listAll(); 
                    	
                    	if(lprod != null) {
                    		DecimalFormat df = new DecimalFormat("00.00");
                    		
                    		int cont = 0;
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
					<%	cont++; if(cont == 6) { break;}}
                    	}
                    %>

				</div>

			</div>

		</div>

		<%-- Include que invoca al pié de página de la WEB --%>
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
</body>
	<script type="text/javascript">
		if("${ msgSuccess }" != "") {
			alert("${ msgSuccess }");
		}
	</script>
</html>