<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="admin/css/bootstrap.min.css">
<link rel="stylesheet" href="admin/css/mainProduct.css">
<script type="text/javascript" src="admin/js/jquery.js"></script>
<script type="text/javascript" src="admin/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header class="text-center mb-3" style="border-bottom: 2px solid #343a40">
		<h1 style="padding-bottom: 1%; color = #343a40">Operaciones de administrador para ventas Productos</h1>
	</header>
	<section>
		<div>
			<a href="../carrito?option=listShop" style="margin-left: 10px;"
				class="btn btn-outline-info btn-sm">Actulizar</a>

		</div>
		<div class="row text-center">
			<display:table name="listado" class="table" decorator="decorator.WrapperShopSale">
				<display:column property="nroPedido" title="N° Pedido"></display:column>
				<display:column property="idCliente" title="ID Cliente"></display:column>
				<display:column property="fecPedido" title="Fecha del pedido"></display:column>
				<display:column property="dirPedido" title="Direccion"></display:column>
				<display:column property="cantTotal" title="Cant. Pedidos"></display:column>
				<display:column property="descPedido" title="Descuento"></display:column>
				<display:column property="total" title = "Total"></display:column>
				<display:column property="estPedido" title = "Estado"></display:column>
				<display:column property="delete" title="Operaciones"></display:column>
			</display:table>
		</div>
	</section>
</body>
</html>