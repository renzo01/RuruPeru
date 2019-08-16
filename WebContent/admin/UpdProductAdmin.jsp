<%@page import="beans.ProductDTO"%>
<%@page import="services.ProductService"%>
<%@page import="dao.MySqlCategoryDAO"%>
<%@page import="org.apache.poi.hssf.record.CategorySeriesAxisRecord"%>
<%@page import="beans.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/admin/insertUpdProductAdm.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<div id="cont-upd-prod-all">
	<div>
		<div>
			<h2 class="">Actualizar Producto</h2>
			<form action="producto">
				<table>
					<tr>
						<%
							String xidProd = request.getParameter("pd");
							ProductDTO p = new ProductService().getProductById(xidProd);
						%>
						<td><span>Ingrese una imagen:</span></td>
						<td><input type="file" name="reg_imageProd"
							class="form-control-file"></td>

					</tr>
					<tr>
						<td><span>Nombre:</span></td>
						<td><input type="text" name="reg_nameProd"
							class="form-control" value="<%=p.getNomProd()%>"></td>
					</tr>
					<tr>
						<td><span>Categoria</span></td>
						<td><select name="reg_catProd" class="form-control"
							value="<%=p.getIdCat()%>">
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
						<td><span>Descripcion:</span></td>
						<td><textarea class="form-control" id="DescTA"
								name="reg_descProd" rows="5" cols="31"
								value="<%=p.getDescProd()%>"></textarea></td>
					</tr>
					<tr>
						<td><span>Precio:</span></td>
						<td><input name="reg_preProd" class="form-control"
							type="text" placeholder="Moneda (S/)"
							value="<%=p.getPrecProd()%>"></td>
					</tr>
					<tr>
						<td><span>Stock:</span></td>
						<td><input name="reg_stockProd" class="form-control"
							type="text" value="<%=p.getStockProd()%>"></td>
					</tr>
				</table>
				<br>
				<div style="float: right;">
					<a href="producto?option=upd&pd=<%=p.getIdProd()%>"
						class="btn btn-outline-success">Actualizar</a>
					<button id="btn_close_updProd" class="btn btn-outline-danger"
						type="button">Cancelar</button>
				</div>

			</form>

		</div>
	</div>
	<label hidden="true" id="defValTA">${p.descProd}</label>
</div>
<script>
	$(document).ready(function() {
		var cont_upd_prod = $('#cont-upd-prod-all');
		var btn_close_updProd = $('#btn_close_updProd');
		btn_close_updProd.on('click', function() {
			cont_upd_prod.fadeToggle();
		});
	});
	function setValueForTextArea() {
		var x = document.getElementById("defValTA").value;
		document.getElementById("DescTA").value = x;
	}
</script>