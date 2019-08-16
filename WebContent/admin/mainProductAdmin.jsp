<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Administrador -Producto-</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="admin/css/bootstrap.min.css">
<link rel="stylesheet" href="admin/css/mainProduct.css">
<!-- <link rel="stylesheet" href="css/displayTag/displaytag.css">
<link rel="stylesheet" href="css/displayTag/screen.css">  -->
<script type="text/javascript" src="admin/js/bootstrap.min.js"></script>

</head>
<body>
	<header class="text-center mb-3" style="border-bottom: 2px solid #343a40">
		<h1 class="text-center" style="padding-bottom: 1%; color = #343a40">Administrador de Productos</h1>
	</header>
	<!-- <nav>
		<a>
			<button>Ingresar Producto</button>
		</a> <a>
			<button>Actualizar Producto</button>
		</a> <a>
			<button>Eliminar Producto</button>
		</a>
		</nav> 
	-->
	<section>
		<a href="producto?option=lstAllADM" style="margin-left: 10px;" class="btn btn-outline-info btn-sm">Actualizar</a>
		<button id="btn-add-prod" class="btn btn-outline-success btn-sm" type="button">Agregar Producto</button>
		<br>
		<div class="row text-center">
		<display:table name="${ listadoAdm }" class="table" decorator="decorator.WrapperProducto">
			<display:column property="idProd"  title="Codigo"></display:column>
			<display:column property="imagen" title="Imagen"></display:column>
			<display:column property="nomProd" title="Nombre"></display:column>
			<display:column property="stockProd" title="Stock"></display:column>
			<display:column property="precProd"  title="Precio"></display:column>
			<display:column property="actualizar" title="Operaciones"></display:column>
		</display:table>
		</div>
		
	</section>
		<jsp:include page="InsertUpdProductAdmin.jsp"></jsp:include>
	<div hidden="true">
		<jsp:include page="DeltProductAdmin.jsp"></jsp:include>
	</div>
</body>

<script>
	$(document).ready(function() {
		var btn_add_prod = $('#btn-add-prod');
		var cont_add_prod = $('#cont-addUpd-prod-all');
		
		btn_add_prod.on('click', function() {
			cont_add_prod.fadeToggle();
		});
		
		var btn_upd_prod = $('#btn_upd_prod');
		var cont_upd_prod_all = $('#cont-upd-prod-all');
		
		btn_add_prod.on('click', function() {
			cont_upd_prod_all.fadeToggle();
		});
	});
</script>
</html>