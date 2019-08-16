<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin</title>
    
</dependency>
	
    <!-- Importar Estilos -->
    <link rel="stylesheet" href="../css/global.css">
    <link rel="stylesheet" href="../css/admin/index.css">
</head>

<body>
    <div id="container-admin-all">

        <div class="cont-admin-title">
            <div>
                <img src="../images/header/logo.png" alt="">
            </div>
            <h2>Bienvenido al área de administración</h2>
            <div>
                <div>
                    <label>Usuario administrador:</label>
                    <label>Usuario admin</label>
                </div>

                <div>
                    <label>Última conexión:</label>
                    <label>16:00pm 20-06-2019</label>
                </div>
            </div>
        </div>
        
        <div id="cont-admin-elements-all">

            <div class="cont-admin-elements">

                <a href="../producto?option=lstAllADM">
                    <div class="admin-alements">
                        <img src="img/products.png" alt="">
                        <h2>Panel de Productos</h2>
                    </div>
                </a>
                

                <a href="../cliente?option=lCli">
                    <div class="admin-alements">
                        <img src="img/customer.png" alt="">
                        <h2>Panel de Usuarios</h2>
                    </div>
                </a>

                <a href="../proveedor?option=listAll">
                    <div class="admin-alements">
                        <img src="img/provider.png" alt="">
                        <h2>Panel de Proveedores</h2>
                    </div>
                </a>

            </div>

            <div class="cont-admin-elements">

                <a href="../carrito?option=listShop">
                    <div class="admin-alements">
                        <img src="img/sales.png" alt="">
                        <h2>Panel de Ventas</h2>
                    </div>
                </a>

                <a href="#">
                    <div class="admin-alements">
                        <img src="img/ceo.png" alt="">
                        <h2>Panel de CEO</h2>
                    </div>
                </a>

                <a href="#">
                    <div class="admin-alements">
                        <img src="img/config.png" alt="">
                        <h2>Panel de Configuraciones</h2>
                    </div>
                </a>

            </div>

        </div>

    </div>
</body>

</html>