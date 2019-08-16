<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://displaytag.sf.net"  prefix="display"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Administrador -Proveedor-</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="admin/css/bootstrap.min.css">
<link rel="stylesheet" href="admin/css/mainProduct.css">
<script type="text/javascript" src="admin/js/bootstrap.min.js"></script>
</head>
<body>
	<header class="text-center mb-3" style="border-bottom: 2px solid #343a40">
		<h1 class="text-center" style="padding-bottom: 1%; color = #343a40">Administrador de Proveedores</h1>
	</header>

	<section>
		 <a href="proveedor?option=listAll" style="margin-left: 10px;" class="btn btn-outline-info btn-sm">Actualizar</a>
		<a href="admin/InsertNewProvider.jsp" id="btn-add-prov" class="btn btn-outline-success btn-sm">Agregar Proveedor</a>
		<br>
		<div class="row text-center">
		<display:table name="${ listadoAdm }" class="table" decorator="decorator.WrapperProvider">
			<display:column property="idProveedor"  title="Codigo"></display:column>			
			<display:column property="desProveedor" title="Descripcion"></display:column>
			<display:column property="rucProveedor" title="RUC"></display:column>
			<display:column property="dirProveedor"  title="Dirección"></display:column>
			<display:column property="operaciones" title="Operaciones"></display:column>
		</display:table>
		</div>
	</section>	
	<div hidden="true">
		<jsp:include page="InsertUpdProductAdmin.jsp"></jsp:include>
	</div>		
	<div hidden="true">
		<jsp:include page="DeltProductAdmin.jsp"></jsp:include>
	</div>
	
</body>

<script>
	$(document).ready(function() {
		var btn_add_prov = $('#btn-add-prov');
		var cont_add_prov = $('#cont-addUpd-prov-all');
		
		btn_add_prov.on('click', function() {
			cont_add_prov.fadeToggle();
		});
		
	});
</script>

</html>