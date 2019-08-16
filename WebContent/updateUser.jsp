<%@page import="services.UserService"%>
<%@page import="beans.DepartamentDTO"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/updateUser.css">
<script src="js/jquery.js"></script>

<div id="container-all-update-user">

    <div id="container-update-user">

        <div>
            <h3>ACTUALIZAR MIS DATOS</h3>
        </div>

        <div id="cont-log-reg">

            <div class="log-reg">

                <form action="cliente" method="POST">
                
                    <div class="update-user-fields">
                        <label for="reg_username">
                            <img src="images/userPass/user.png" alt="">
                        </label>
                        <input type="text" name="reg_username" placeholder="Mi usuario" value="${user.username}">
                    </div>
                    <!-- 
                    <div class="update-user-fields">
                        <label for="reg_file">
                            <img src="images/userPass/user.png" alt="">
                        </label>
                        <input type="file" name="reg_file">
                    </div>
                     -->
                    <div class="update-user-fields">
                        <label for="reg_email">
                            <img src="images/register/email.png" alt="">
                        </label>
                        <input type="email" name="reg_email" placeholder="Correo electrónico (Email)" value="${user.email}">
                    </div>
                    
                    <div class="update-user-fields">
                        <label for="reg_username">
                            <img src="images/userPass/user.png" alt="">
                        </label>
                        <input type="password" name="reg_password" value="${user.password}">
                    </div>

                    <div class="update-user-fields">
                        <label for="reg_name">
                            <img src="images/userPass/name.png" alt="">
                        </label>
                        <input type="text" name="reg_name" placeholder="Mi nombre" value="${cli.nomCliente}">
                    </div>

                    <div class="update-user-fields">
                        <label for="reg_lname">
                            <img src="images/userPass/name.png" alt="">
                        </label>
                        <input type="password" name="reg_lname" placeholder="Mis apellidos" value="${cli.apeCliente}">
                    </div>

                    <div class="update-user-fields">
                        <label for="reg_phone">
                            <img src="images/register/telephone.png" alt="">
                        </label>
                        <input type="text" name="reg_phone" placeholder="Número de contacto" value="${user.telephone}">
                    </div>
                    
                    <div class="update-user-fields">
                        <label for="reg_dni">
                            <img src="images/register/identity.png" alt="">
                        </label>
                        <input type="text" name="reg_dni" placeholder="Ingrese su N° de DNI" value="${cli.dniCli}">
                    </div>
                    
                    <div class="update-user-fields" title="Donde recibirá los productos adquiridos">
                        <label for="reg_dir">
                            <img src="images/register/mapa.png" alt="">
                        </label>
                        <input type="text" name="reg_dir" placeholder="Ingrese su dirección" value="${cli.dirCli}">
                    </div>
                    
                    <div class="update-user-fields">
                        <label for="reg_fecnac">
                            <img src="images/register/calendar.png" alt="">
                        </label>
                        <input type="date" name="reg_fecnac" placeholder="Ingrese su fecha de nacimiento" value="${cli.fechNacCli}">
                    </div>
                    
                    <div class="update-user-fields">
                        <label for="reg_gen">
                            <img src="images/register/gender.png" alt="">
                        </label>
                        <select name="reg_gen" value="${cli.genCli}">
                        	<option value="M">Varón</option>
                        	<option value="F">Mujer</option>
                        	<option value="O">Sin especificar</option>
                        </select>
                    </div>
                    
                    <div class="update-user-fields">
                        <label for="reg_depa">
                            <img src="images/register/wai.png" alt="">
                        </label>
                        <select name="reg_depa" value="${user.idDepa}">
                        	<option value="0">Eliga su departamento</option>
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

                    <div>
                        <button id="btn_updateToCli" name="option" value="addupdCli">Actualizar mi perfil</button>
                    </div>

                </form>
            </div>
            
            <p style="text-align: center; color: black; padding: 1rem; margin: 2rem;">${ msjCli }</p>

        </div>

    </div>

</div>

</div>