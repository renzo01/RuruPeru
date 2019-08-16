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
<link rel="stylesheet" href="css/production.css">
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
					<img src="images/content/presentations/pres0.jpg" alt="">
					<div id="banner-letters">
						<h1>Usamos lo mejor</h1>
						<h2>para brindarte lo mejor</h2>
						<h3></h3>
					</div>
				</div>

			</div>

			<div class="container-content">

				<h3>
					<div class="lines-h3"></div>
					<div>Nuestra Producción</div>
					<div class="lines-h3"></div>
				</h3>

				<div class="content-production">

					<!-- <div class="cont-item-production"> -->

					<div class="item-production">
						<div>
							<img src="images/content/presentations/pres3.jpg" alt="">
						</div>
						<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
							Magni et eveniet nihil illum quae suscipit recusandae doloribus
							cum, distinctio ullam, asperiores, aut tempora hic perspiciatis
							fugit nam? Et, quam repellendus!</p>
					</div>

					<div class="item-production">
						<div>
							<img src="images/content/presentations/pres5.jpg" alt="">
						</div>
						<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
							Magni et eveniet nihil illum quae suscipit recusandae doloribus
							cum, distinctio ullam, asperiores, aut tempora hic perspiciatis
							fugit nam? Et, quam repellendus!</p>
					</div>

					<!-- </div>
                    
                    <div class="cont-item-production"> -->

					<div class="item-production">
						<div>
							<img src="images/content/presentations/pres6.jpg" alt="">
						</div>
						<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
							Magni et eveniet nihil illum quae suscipit recusandae doloribus
							cum, distinctio ullam, asperiores, aut tempora hic perspiciatis
							fugit nam? Et, quam repellendus!</p>
					</div>

					<div class="item-production">
						<div>
							<img src="images/content/presentations/pres4.jpg" alt="">
						</div>
						<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
							Magni et eveniet nihil illum quae suscipit recusandae doloribus
							cum, distinctio ullam, asperiores, aut tempora hic perspiciatis
							fugit nam? Et, quam repellendus!</p>
					</div>

					<!-- </div>
                    
                    <div class="cont-item-production"> -->

					<div class="item-production">
						<div>
							<img src="images/content/presentations/pres2.jpg" alt="">
						</div>
						<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
							Magni et eveniet nihil illum quae suscipit recusandae doloribus
							cum, distinctio ullam, asperiores, aut tempora hic perspiciatis
							fugit nam? Et, quam repellendus!</p>
					</div>

					<div class="item-production">
						<div>
							<img src="images/content/presentations/pres1.jpg" alt="">
						</div>
						<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
							Magni et eveniet nihil illum quae suscipit recusandae doloribus
							cum, distinctio ullam, asperiores, aut tempora hic perspiciatis
							fugit nam? Et, quam repellendus!</p>
					</div>

					<!-- </div> -->

				</div>

			</div>

		</div>

		<%-- Include que invoca al pié de página de la WEB --%>
        <jsp:include page="footer.jsp"></jsp:include>

	</div>
</body>

</html>