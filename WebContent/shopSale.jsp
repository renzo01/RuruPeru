<%@page import="beans.ShopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"  %>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Mi Lista</title>
<link rel="stylesheet" href="admin/css/bootstrap.min.css">
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/shopSale.css">
<link rel="stylesheet" href="css/mediaRule.css">

<script src="js/jquery.js"></script>
<script src="js/global.js"></script>
<script src="js/login.js"></script>
<body>
	
	<header>
	<div>
	<a href="index.jsp">
		<img id="logo" src="images/header/logo.png" alt="">
	</a>
	</div>
</header>
	
	<%-- Include que invoca a los formularios: Login, Registrar y Resetear password --%>
	<jsp:include page="logRegReset.jsp"></jsp:include>
	
	<div id="container-shop-sale">

		<section id="cont-shopSale-section">
			<div>
				<div>
					<h3>Lista de Artículos</h3>
				</div>

				<div class="cont-form-shop">
					
					<display:table name="${ glord }" class="table" decorator="decorator.WrapperShopSale">
					
					<display:column property="imageProd" title="Producto"></display:column>
					<display:column property="nomProd" title="Nombre"></display:column>
					<display:column property="preProd" title="Precio"></display:column>
					<display:column property="cantProd" title="Cantidad"></display:column>
					<display:column property="subTotalProd" title="Subtotal"></display:column>
					
					</display:table>

				</div>
			</div>
		</section>

		<aside id="cont-shopSale-aside">
			<div id="cont-aside-shop">

				<div>
					<h3>Resumen de Pedido</h3>
				</div>
				<form action="carrito">
					<div class="fields_shop">
						<label for="prod_cantArt">Cantidad total:</label> <input
							type="text" name="prod_cantArt" value="${ cantArt }" readonly>
					</div>
					<div class="fields_shop">
						<label for="prod_descon">Subtotal:</label> <input type="text"
							name="prod_subtotal" value="S/ ${ subTotal }" readonly>
					</div>
					<div class="fields_shop">
						<label for="prod_descon">Descuento:</label> <input type="text"
							name="prod_descon" value="S/ ${ descuentoShop }" readonly>
					</div>
					<div class="fields_shop">
						<label for="prod_total_pagar">Total a Pagar:</label> <input
							type="text" name="prod_total_pagar" value="S/ ${ totalShop }" readonly>
					</div>
					<p>El costo de envío no está incluído.</p>
					<div>
						<button name="option" value="confirm_shop">Comprar</button>
					</div>
				</form>

			</div>
		</aside>
	</div>

	<footer>

		<div class="content-footer">

			<div class="content-contact-social">
				<h3>Contáctenos</h3>
				<p>
					<img src="images/content/rs/whatsapp3.png" alt=""> +51
					987-654-321
				</p>
				<p>
					<img src="images/header/icons/email0.png" alt="">
					info@ruruperu.pe
				</p>
				<p>
					<img src="images/header/icons/location0.png" alt="">
					Av.Aviación 321 San Borja, Lima.
				</p>
			</div>

			<div class="content-contact-social">
				<h3>Entérate más en nuestras redes sociales</h3>

				<div>
					<a href="#"> <img class="img-social" src="" alt="">
					</a> <a href="#"> <img class="img-social" src="" alt="">
					</a> <a href="#"> <img class="img-social" src="" alt="">
					</a>

				</div>
			</div>

			<div>

				<h3>Suscríbete a nuestro boletín personalizado</h3>

				<div id="idx-cont-form">

					<form action="">

						<div class="idx-cont-fields">
							<input type="text" placeholder="INGRESE SU NOMBRE"
								name="idx_name" pattern="[a-zA-Z]{1,25}">
						</div>

						<div class="idx-cont-fields">
							<input type="email" placeholder="INGRESE SU CORREO ELECTRÓNICO"
								name="idx_email" pattern="[a-zA-Z]{1,25}">
						</div>

						<div>
							<button>Suscribirme</button>
						</div>

					</form>

				</div>

			</div>

		</div>
		<div id="content-copyright">
			<p>Todos los Derechos Reservados &copy; 2019</p>
		</div>

	</footer>
</body>