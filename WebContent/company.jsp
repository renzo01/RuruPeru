<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RuruPerú</title>

    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/contact.css">
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
                    <img src="images/content/presentations/pres7.jpg" alt="">
                    <div id="banner-letters">
                        <h1>Encuéntranos siempre</h1>
                        <h2>y en cualquier momento</h2>
                        <h3></h3>
                    </div>
                </div>

            </div>

            <div class="container-content">

                <div id="cont-img-adult-cellphone">
                    <img src="images/content/banners/adult-cellphone.jpg" alt="">
                </div>

                <div id="information-contact">

                    <h3>Búscanos en las redes sociales como:</h3>

                    <div>
                        <p>
                            <a href="#">
                                <img class="contact-social" src="images/content/rs/fb2.png" alt="">
                                <span>facebook.com/elnombredelaempresa</span>
                            </a>
                        </p>

                        <p>
                            <a href="#">
                                <img class="contact-social" src="images/content/rs/tw2.png" alt="">
                                <span>twitter.com/elnombredelaempresa</span>
                            </a>

                        </p>

                        <p>
                            <a href="#">
                                <img class="contact-social" src="images/content/rs/pt2.png" alt="">
                                <span>pinterest.com/elnombredelaempresa</span>
                            </a>

                        </p>
                    </div>

                </div>

            </div>

        </div>
		
		<%-- Include que invoca al pié de página de la WEB --%>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>

</html>