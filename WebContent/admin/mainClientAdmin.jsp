<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="admin/css/bootstrap.min.css">
<link rel="stylesheet" href="admin/css/mainProduct.css">
<script type="text/javascript" src="admin/js/jquery.js"></script>
<script type="text/javascript" src="admin/js/bootstrap.min.js"></script>
</head>
<body>
	<header class="text-center mb-3" style="border-bottom: 2px solid #343a40">
		<h1 style="padding-bottom: 1%; color = #343a40">Administrador Clientes</h1>
	</header>
	<section>
		<div>
			<a href="../cliente?option=lCli" style="margin-left: 10px;" class= "btn btn-outline-info btn-sm">Actualizar</a>
		</div>
		<br>
		<div class="row text-center">
			<display:table name = "lClient" class= "table" decorator="decorator.WrapperClient">
				<display:column property="idCliente" title="Codigo"></display:column>
				<display:column property="nomCliente" title="Nombre"></display:column>
				<display:column property="apeCliente" title="Apellido"></display:column>
				<display:column property="dniCli" title="DNI"></display:column>
				<display:column property="fechNacCli" title="Fecha de Nacimiento"></display:column>
				<display:column property="dirCli" title="Direccion"></display:column>
				<display:column property="genCli" title="Genero"></display:column>
				<display:column property="operaciones" title="Operaciones"></display:column>
			</display:table>
		</div>
	</section>
	<!--<jsp:include page="uptClienteAdmin.jsp"></jsp:include>-->
</body>


<!-- <script>
	$(document).ready(function() {
		var btn_udt_client = $('#btn-udt-client');
		var cont_add_prod = $('#cont-udt-client-all');
		
		btn_udt_client.on('click', function() {
			cont_add_prod.fadeToggle();
		});
	});
</script>
 -->
</html>