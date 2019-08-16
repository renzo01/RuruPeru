<%@page import="beans.ClientDTO"%>
<%@page import="beans.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Usuario</title>

<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/detail-user.css">
<link rel="stylesheet" href="css/mediaRule.css">

<script src="js/jquery.js"></script>
<script src="js/global.js"></script>
<script src="js/detailUser.js"></script>

</head>

<body>

	<div id="container-all">

		<div id="container-content-all">

			<div class="container-content">

				<aside>
					<div class="aside-head">
						<p>Bienvenido Usuario: ${ user.username }</p>
						<div>
							<div>
								<img src="images/userPass/user.png" alt="">
							</div>
							<div>
								<%
									ClientDTO c = (ClientDTO)request.getSession().getAttribute("cli");
									if(c != null) { %>
										<p>Nombre: <%=c.getNomCliente()%></p>
										<p>Apellidos: <%=c.getApeCliente()%></p>
										<p>Email: ${ user.email }</p>
									<%} else { %>
										<p>Email: ${ user.email }</p>
										<p>Teléfono: ${ user.telephone }</p>
									<%}
								%>
								
							</div>
						</div>
					</div>
					<div class="aside-body">
						<ul>
							<li class="head-element-style">
								<ul>
									<li class="head-element-1"><img
										src="images/header/icons/user0.png" alt="ico-perfil"
										width="30px"> <span>Mi Perfil</span></li>
									<li class="body-element-style body-element-1">
										<ul>
											<li><a href="updateUser.jsp" target="ifvista">Editar
													Mi Perfil</a></li>
											<li><a href="close">Salir</a></li>
										</ul>
									</li>
								</ul>
							</li>

							<li class="head-element-style">
								<ul>
									<li class="head-element-2"><img
										src="images/header/icons/user0.png" alt="ico-perfil"
										width="30px"> <span>Mis Pedidos</span></li>
									<li class="body-element-style body-element-2">
										<ul>
											<li><a href="cliente?option=lpcli" target="ifvista">Todos</a></li>
											<li><a href="">Favoritos</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
					</div>

					<div class="cont-btn-provider">
						<a href="infoProvider.jsp" target="ifvista">¿Quiéres ser proveedor?</a>
					</div>
				</aside>

				<section>
					<iframe name="ifvista"></iframe>
				</section>

			</div>

		</div>

		<footer>

			<div id="content-copyright">
				<p>Todos los Derechos Reservados &copy; 2019</p>
			</div>

		</footer>


	</div>
</body>

</html>