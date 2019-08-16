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
	#cont-addUpd-prod-all > div {
		display: flex;
		justify-content: center;
		align-items: center;
		padding: 3rem;
	}
	#cont-addUpd-prod-all > div > div {
		margin: auto;
		padding: 0.5rem;
		background: white;
		border-radius: 10px;
	}
</style>
	<div id="cont-addUpd-prod-all">
		<div>
		<div>
		<form action="Producto?option">
			<h2 class="bg-dark text-light" style="border-radius: 5px; padding-bottom: 5px; text-align: center">Eleminacion de producto</h2>
			<label hidden="true">${p.idProd}</label>
			<table>
				<tr>
					
					<td><span>Codigo:</span></td>
					<td><input class="form-control" type="text" disabled="disabled" value="${p.idProd} "></td>

				</tr>
				<tr>
					<td><span>Nombre:</span></td>
					<td><input class="form-control" disabled="disabled" value="${p.nomProd} " type="text"></td>
				</tr>
				<tr>
					<td><span>Stock:</span></td>
					<td><input class="form-control" disabled="disabled" value="${p.stockProd} " type="text"></td>
				</tr>
			</table>
			<div style="float: right; margin-top: 2%;">
				<button class="btn btn-outline-danger" value= "dlt">Eliminar</button>
				<button id="btn_close_detaProd"  class="btn btn-outline-danger" type="button">Cancelar</button>
			</div>
			
		</form>
		
		</div>
		</div>
		<label hidden="true" id="defValTA">${p.descProd}</label>
	</div>
	<script>
		var cont_add_prod = $('#cont-addUpd-prod-all');
		var btn_close_detaProd = $('#btn_close_detaProd');
		btn_close_detaProd.click(function() {
			(this).fadeToggle();
		});
		function setValueForTextArea(){
			var x = document.getElementById("defValTA").value;
			document.getElementById("DescTA").value = x; 
		}
</script>