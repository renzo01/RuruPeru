<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<link rel="stylesheet" href="admin/css/bootstrap.min.css">
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/allProducts.css">

<script type="text/javascript" src="admin/js/bootstrap.min.js"></script>
<div id="cont-allProducts-all">

	<div class="cont-allProducts-form">

		<form action="">

			<div class="fields-allProducts">
				<label for="allp_desc">Buscar:</label> <input type="text"
					name="allp_desc" placeholder="Ingrese descripción de producto">
			</div>

			<div class="fields-allProducts">
				<label for="allp_desc">Categoría</label> <select name="allp_cat">
					<option value="0">Categoría 1</option>
					<option value="1">Categoría 2</option>
					<option value="2">Categoría 3</option>
				</select>
			</div>

			<div class="fields-allProducts">
				<label for="allp_desc">Mayor Precio:</label>
				<button type="button" id="btn-order-up">&#9650;</button>
			</div>

			<div class="fields-allProducts">
				<label for="allp_desc">Menor Precio:</label>
				<button type="button" id="btn-order-down">&#9660;</button>
			</div>

			<div>
				<button id="btn-allp-form">Consultar</button>
			</div>
		</form>

	</div>

	<div id="cont-allProducts-title">

		<h3>Lista de Productos Adquiridos</h3>

	</div>

	<div class="cont-allProducts-table">
		
		<display:table name="${ ldocli }" class="table" decorator="decorator.WrapperProducto">
			<display:column property="imagenShop" title="Producto"></display:column>
			<display:column property="nomProd" title="Nombre"></display:column>
			<display:column property="cantProd" title="Cantidad"></display:column>
			<display:column property="preProd"  title="Precio"></display:column>
			<display:column property="subTotalProd"  title="Subtotal"></display:column>
		</display:table>

	</div>

</div>
