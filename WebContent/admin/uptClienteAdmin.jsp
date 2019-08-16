<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<div
	style="background: rgba(0, 0, 0, 0.5); position: fixed; top: 0px; height: 100vh; width: 100%; z-index: 200;">
	<div
		style="display: flex; justify-content: center; align-items: center; padding: 3rem;">
		<div>
			<div
				style="margin: auto; background: white; border-radius: 5px; padding-bottom: 30px;">
				<h2
					style="border-bottom: 2px solid #343a40; text-align: center; padding-bottom: 0.5rem;">Actualizar
					Cliente</h2>

				<form action="cliente" style="padding: 0.5rem;" method="post">
					<input value="${param.cod }" name = "cod" hidden="true">
					<table>
						<tr>
							<td><span>Nombre</span></td>
							<td><input name="nombre" type="text" value="${param.nom}" class="form-control"></td>
						</tr>
						<tr>
							<td><span>Apellido</span></td>
							<td><input name = "apellido" value = "${param.ape }" type="text" class="form-control"></td>
						</tr>
						<tr>
							<td><span>DNI</span></td>
							<td><input name ="dni" value="${param.dni }" type="text" class="form-control"></td>
						</tr>
						<tr>
							<td><span>Direccion</span></td>
							<td><input name ="dir" value="${param.dir }" type="text" class="form-control"></td>
						</tr>
						<tr>
							<td><span>Fecha de nacimiento</span></td>
							<td><input name ="fecnac" value="${param.fecnac}" type="date" class="form-control"></td>
						</tr>
						<tr>
							<td><span>Genero</span></td>
							<td><select name="gen"  class="form-control">
									<option>Seleccione</option>
									<option value="M">Masculino</option>
									<option value="F">Feminino</option>
							</select></td>
						</tr>
					</table>
					<div style="float: right; padding-top: 10px;">
						<button type="submit" name = "option" value="udtCliAdmin" class="btn btn-outline-success">Actualizar</button>
						<button type="button" class="btn btn-outline-danger">Cancelar</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>
