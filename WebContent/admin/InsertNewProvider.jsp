<%@page import="services.UserService"%>
<%@page import="beans.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<div
	style="background: rgba(0, 0, 0, 0.5); position: fixed; top: 0px; height: 100vh; width: 100%; z-index: 200;">
	<div
		style="display: flex; justify-content: center; align-items: center; padding: 3rem;">
		<div
			style="margin: auto; background: white; border-radius: 5px; padding-bottom: 30px;">
			<h2
				style="border-bottom: 2px solid #343a40; text-align: center; padding-bottom: 0.5rem;">Ingresar
				un nuevo Proveedor</h2>
			<form action="admnin/proveedor?option=addProv" style="padding: 0.5rem;" method="post">
				<table class="">
					<tr>
						<td><span>Codigo de Usuario</span></td>
						<td><select name ="cod" class="form-control">
								<%
									UserService u = new UserService();
									ArrayList<UserDTO> d = u.getAll();
									if (d != null) {
										for (UserDTO us : d) {
								%>
								<option value="<%=us.getIdUsu()%>"><%=us.getUsername()%></option>
								<%
									}
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td><span>Descripcion</span></td>
						<td><textarea name = "des" rows="5" cols=31 " class="form-control"></textarea></td>
					</tr>
					<tr>
						<td><span>Ruc</span></td>
						<td><input type="text" name = "ruc" class="form-control"></td>
					</tr>
					<tr>
						<td><span>Direccion</span></td>
						<td><textarea rows="5" cols="31" name = "dir" class="form-control"></textarea></td>
					</tr>
				</table>
				<div style="float: right">
					<button type="submit" class="btn btn-outline-success">Registrar</button>
					<a href="mainProveedorAdmin.jsp" class="btn btn-outline-danger">regresar</a>
				</div>
			</form>
		</div>
	</div>
</div>