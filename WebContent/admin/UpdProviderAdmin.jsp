<%@page import="dao.MySqlCategoryDAO"%>
<%@page import="org.apache.poi.hssf.record.CategorySeriesAxisRecord"%>
<%@page import="beans.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style>
#cont-addUpd-prod-all {
	background: rgba(0, 0, 0, 0.5);
	position: fixed;
	top: 0px;
	height: 100vh;
	width: 100%;
	z-index: 200;
}

#cont-addUpd-prod-all>div {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 3rem;
}

#cont-addUpd-prod-all>div>div {
	margin: auto;
	padding: 0.5rem;
	background: white;
	border-radius: 10px;
}
</style>
<div id="cont-addUpd-prod-all">
	<div>
		<div>
			<form action="Producto">
				<h2 class="bg-dark text-light"
					style="border-radius: 5px; padding-bottom: 5px;">Actualizar los datos del Proveedor</h2>
				<label hidden="true">${param.cod}</label>
				<label hidden="true">${param.usu}</label>
				<table>
					<tr>
						<td><span>Ingrese una descripcion:</span></td>
						<td><textarea class="form-control" id="DescTA" rows="5"
								cols="31">${param.des }</textarea></td>
					</tr>
					<tr>
						<td><span>Ingrese una RUC:</span></td>
						<td><input value="${param.ruc}" pattern="\d"
							class="form-control" type="text" placeholder="numero de RUC"></td>
					</tr>
					<tr>
						<td><span>Ingrese una direccion:</span></td>
						<td><textarea class="form-control" id="DescTA2" rows="3"
								cols="31">${param.dir }</textarea></td>
					</tr>
				</table>
				<br>
				<div style="float: right;">
					<button class="btn btn-outline-success" name="option" value="update">Actualizar</button>
					<button id="btn_close_add_prod" class="btn btn-outline-danger"
						type="button">Cancelar</button>
				</div>

			</form>

		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		var cont_add_prod = $('#cont-addUpd-prod-all');
		var btn_close_add_prod = $('#btn_close_add_prod');
		btn_close_add_prod.on('click', function() {
			cont_add_prod.fadeToggle();
		});
	});
</script>