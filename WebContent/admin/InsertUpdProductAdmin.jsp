<%@page import="services.ProductService"%>
<%@page import="dao.MySqlCategoryDAO"%>
<%@page import="org.apache.poi.hssf.record.CategorySeriesAxisRecord"%>
<%@page import="beans.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/admin/insertUpdProductAdm.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<div id="cont-addUpd-prod-all">
	<div>
		<div>
		<h2 class="">Registrar Producto</h2>
			<form action="producto">
				<table>
					<tr>

						<td><span>Ingrese una imagen:</span></td>
						<td><input type="file" name="reg_imageProd" class="form-control-file"></td>

					</tr>
					<tr>
						<td><span>Ingrese un nombre:</span></td>
						<td><input type="text" name="reg_nameProd" class="form-control"></td>
					</tr>
					<tr>
						<td><span>Ingrese una categoria</span></td>
						<td><select name="reg_catProd" class="form-control">
								<option value="0">Seleccionar</option>
								<%
									ArrayList<CategoryDTO> ca = new ProductService().listCategories();
									for (CategoryDTO c : ca) {
								%>
								<option value="<%=c.getIdCategoria()%>"><%=c.getDescCategoria()%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td><span>Ingrese una descripcion:</span></td>
						<td><textarea class="form-control" id="DescTA" name="reg_descProd" rows="5" cols="31"></textarea></td>
					</tr>
					<tr>
						<td><span>Ingrese una precio:</span></td>
						<td><input name="reg_preProd" class="form-control" 
						type="text" placeholder="Moneda (S/)"></td>
					</tr>
					<tr>
						<td><span>Ingrese un stock:</span></td>
						<td><input name="reg_stockProd" class="form-control" type="text"></td>
					</tr>
				</table>
				<br>
				<div style="float: right;">
					<button class="btn btn-outline-success" name="option" value="add">Ingresar</button>
					<button id="btn_close_addProd" class="btn btn-outline-danger" type="button">Cancelar</button>
				</div>

			</form>

		</div>
	</div>
	<label hidden="true" id="defValTA">${p.descProd}</label>
</div>
<script>
	$(document).ready(function() {
		var cont_add_prod = $('#cont-addUpd-prod-all');
		var btn_close_addProd = $('#btn_close_addProd');
		btn_close_addProd.on('click', function() {
			cont_add_prod.fadeToggle();
		});
	});
	function setValueForTextArea() {
		var x = document.getElementById("defValTA").value;
		document.getElementById("DescTA").value = x;
	}
</script>