<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<header>
	<div>
		<a href="index.jsp">
			<img id="logo" src="images/header/logo.png" alt="">
		</a>
	</div>
	<div id="btn-main">
		<button>
			<img src="images/header/main1.png" alt="">
		</button>
	</div>
	<nav>
		<ul>
			<li><a href="index.jsp">INICIO</a>
				<div class="list-bottom-line"></div></li>
			<li><a href="producto?option=lstAll">PRODUCTOS</a>
				<div class="list-bottom-line"></div></li>
			<li><a href="production.jsp">PRODUCCIÓN</a>
				<div class="list-bottom-line"></div></li>
			<li><a href="company.jsp">CONÓCENOS</a>
				<div class="list-bottom-line"></div></li>
			<li><a href="UserServlet?option=bcli&usu=${user.idUsu}" target="_blank" id="btn_user_loqueado">${ user.username }</a>
				<div class="list-bottom-line"></div>
				<!--  <ul class="detail-user-login">
					<li><a href="detail-user.jsp">Panel de Control</a></li>
					<li><a href="#">Salir</a></li>
				</ul>
				-->
			</li>
		</ul>
	</nav>
</header>