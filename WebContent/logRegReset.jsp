<%@page import="services.UserService"%>
<%@page import="beans.DepartamentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<div id="cont-log-reg-reset">

	<div id="container-log-reg-1" class="container-log-reg">

		<div>
			<h3>INGRESAR AL SISTEMA</h3>
			<button class="btn_close_log_reg close_log_reg">X</button>
		</div>

		<div id="cont-log-reg">

			<div class="log-reg">

				<form action="UserServlet" method="GET">

					<div class="log-reg-fields">
						<label for="log_email"> <img src="images/userPass/user.png"alt=""></label>
						<input type="email" name="log_email" placeholder="Correo electrónico (Email)">
					</div>

					<div class="log-reg-fields">
						<label for="log_pass"> <img src="images/userPass/key.png"
							alt="">
						</label>
						<input type="password" name="log_pass"placeholder="">
					</div>

					<div>
						<button id="btn_login" class="btn_log_reg_reset" name="option" value="logUser">INGRESAR</button>
					</div>
				</form>

				<div id="cont-soc-register">
					<h4>Continúe con:</h4>
					<div id="red_soc">
						<div>
							<a href="#"> <img src="images/socialNet/fb.png"> <span>Facebook</span>
							</a>
						</div>
						<div>
							<a href="#"> <img src="images/socialNet/tw.png"> <span>Twitter</span>
							</a>
						</div>
					</div>

					<p>
						¿No tiene una cuenta? <a class="form_reg_user anchor_user">Regístrese</a>
					</p>
					<p>
						¿Olvidó su contraseña? <a class="form_reset_user anchor_user">Restablecer</a>
					</p>
				</div>

			</div>

		</div>

	</div>

	<div id="container-log-reg-2" class="container-log-reg">

		<div>
			<h3>CREAR CUENTA</h3>
			<button class="btn_close_log_reg close_log_reg">X</button>
		</div>

		<div id="cont-log-reg">

			<div class="log-reg">

				<form action="UserServlet" method="POST">

					<div class="log-reg-fields">
						<label for="reg_user"> <img src="images/userPass/user.png"
							alt="">
						</label> <input type="text" name="reg_user" placeholder="Crear usuario">
					</div>

					<div class="log-reg-fields">
						<label for="reg_pass0"> <img src="images/userPass/key.png"
							alt="">
						</label> <input type="password" name="reg_pass0"
							placeholder="Crear Contraseña">
					</div>

					<div class="log-reg-fields">
						<label for="reg_pass1"> <img src="images/userPass/key.png"
							alt="">
						</label> <input type="password" name="reg_pass1"
							placeholder="Confirmar contraseña">
					</div>

					<div class="log-reg-fields">
						<label for="reg_email"> <img
							src="images/register/email.png" alt="">
						</label> <input type="email" name="reg_email"
							placeholder="Correo electrónico (Email)">
					</div>

					<div class="log-reg-fields">
						<label for="reg_phone"> <img
							src="images/register/telephone.png" alt="">
						</label> <input type="text" name="reg_phone"
							placeholder="Número de contacto">
					</div>
<!--  
					<div class="log-reg-fields">
						<label for="reg_gender"> <img
							src="images/register/gender.png" alt="">
						</label> <select name="reg_gender" id="reg_gender">
							<option value="Varón">Varón</option>
							<option value="Mujer">Mujer</option>
							<option value="none">Sin especificar</option>
						</select>
					</div>
-->					

					<div class="log-reg-fields">
						<label for="reg_depa"> <img
							src="images/register/gender.png" alt="">
						</label>
						<select name="reg_depa">
							<option value="0">Seleccione departamento</option>
							<%
								ArrayList<DepartamentDTO> ldepa = new UserService().listDepas();
								
								if(ldepa != null) {
									for(DepartamentDTO d : ldepa) { %>
										<option value="<%=d.getIdDepa()%>"><%=d.getDescDepa()%></option>
									<%}
								}
							%>
						</select>
					</div>
<!--  
					<div class="log-reg-fields">
						<label for="reg_photo">Elegir una imagen de perfil</label>
						<input type="file" name="reg_photo">
					</div>
-->					
					<div>
						<button id="btn_register" class="btn_log_reg_reset" name="option" value="nuser">REGISTRARME</button>
					</div>

				</form>

				<div id="cont-soc-register">
					<h4>Continúe con:</h4>
					<div id="red_soc">
						<div>
							<a href="#"> <img src="images/socialNet/fb.png"> <span>Facebook</span>
							</a>
						</div>
						<div>
							<a href="#"> <img src="images/socialNet/tw.png"> <span>Twitter</span>
							</a>
						</div>
					</div>

					<p>
						¿Ya tiene una cuenta? <a class="form_login_user anchor_user">Ingresar</a>
					</p>
					<p>
						¿Olvidó su contraseña? <a class="form_reset_user anchor_user">Restablecer
							contraseña</a>
					</p>
				</div>

			</div>

		</div>

	</div>

	<div id="container-log-reg-3" class="container-log-reg">

		<div>
			<h3>RESTABLECER CONTRASEÑA</h3>
			<button class="btn_close_log_reg close_log_reg">X</button>
		</div>

		<div id="cont-log-reg">

			<div class="log-reg">

				<form action="" method="POST">

					<div class="log-reg-fields">
						<label for="reset_email"> <img
							src="images/register/email.png" alt="">
						</label> <input type="email" name="reset_email"
							placeholder="Correo electrónico (Email)">
					</div>

					<div>
						<button id="btn_reset" class="btn_log_reg_reset">ENVIAR</button>
					</div>

				</form>

				<div id="cont-soc-register">
					<h4>Continúe con:</h4>
					<div id="red_soc">
						<div>
							<a href="#"> <img src="images/socialNet/fb.png"> <span>Facebook</span>
							</a>
						</div>
						<div>
							<a href="#"> <img src="images/socialNet/tw.png"> <span>Twitter</span>
							</a>
						</div>
					</div>

					<p>
						¿Ya tiene una cuenta? <a class="form_login_user anchor_user">Ingresar</a>
					</p>
					<p>
						¿No tienes una cuenta? <a class="form_reg_user anchor_user">Regístrate</a>
					</p>
				</div>

			</div>

		</div>

	</div>

</div>