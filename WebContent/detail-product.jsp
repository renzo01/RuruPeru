<%@page import="beans.BenefitDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="beans.ProductDTO"%>
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
<link rel="stylesheet" href="css/detail-product.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/mediaRule.css">

<script src="js/jquery.js"></script>
<script src="js/global.js"></script>
<script src="js/login.js"></script>

</head>

<body>

	<%-- Include que invoca a los formularios: Login, Registrar y Resetear password --%>
	<jsp:include page="logRegReset.jsp"></jsp:include>

	<%-- Include que invoca al modal de Carrito de compras --%>
	<jsp:include page="modalShop.jsp"></jsp:include>

	<div id="container-all">

		<div id="container-content-all">

			<%-- Include que invoca a la cabecera de la WEB --%>
			<jsp:include page="headerIf.jsp"></jsp:include>

			<div class="container-content">
				<h3>
					<div class="lines-h3"></div>
					<div>${ gp.nomProd }</div>
					<div class="lines-h3"></div>
				</h3>

				<div class="content-products">

					<div class="cont-detail-product">

						<p>${ gp.descProd }</p>

						<!-- <img src="images/content/presentations/pres0.jpg" alt=""> -->

						<article class="content-products-images">
								<div class="content-images-price">
									<img class="images-products"
										src="images/content/products/${ gp.imgProd }" alt="">
									<div class="product-price">
										<div class="price-denomitation">S/</div>
										<div class="price-int">${ gp.precProd }</div>
									</div>
								</div>
								<hr>
								<img class="icon-cinta" src="images/content/products/cinta.png"
									alt="" title="Certificado premium">
								<hr>
								<div class="cont-benefits">
									<h4>Beneficios:</h4>
									<ul>
										<%
											ArrayList<BenefitDTO> lben = (ArrayList<BenefitDTO>) request.getSession().getAttribute("lben");

											if (lben != null) {
												for (BenefitDTO b : lben) {
										%>
										<li>&#10004;&nbsp;<%=b.getDescBen()%></li>
										<%
											}
											}
										%>
									</ul>
								</div>
								<div class="cont-cant-add-shop">
								<form action="carrito">
									<div>
										<button type="button" class="btn-cant-add-shop-down">&#9668;</button>
										<input type="number" value="1" min="1" name="k">
										<button type="button" class="btn-cant-add-shop-up">&#9658;</button>
									</div>
									<button name="option" value="add" class="btn-art-add-shop">AÑADIR AL CARRITO</button>
									</div>
								</form>
						</article>

					</div>

				</div>

			</div>

		</div>

		<%-- Include que invoca al pié de página de la WEB --%>
		<jsp:include page="footer.jsp"></jsp:include>

	</div>
</body>
	<script>
		$('.btn-cant-add-shop-down').on('click', function() {
			var input = $("input[name='k']");
			var cant = $("input[name='k']").val();
			cant--;
			if(cant <= 0) {
				cant = 1;
			}
			input.val(cant);
		});
		
		$('.btn-cant-add-shop-up').on('click', function() {
			var input = $("input[name='k']");
			var cant = $("input[name='k']").val();
			cant++;
			input.val(cant);
		});
		
	</script>
</html>