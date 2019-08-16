
DROP DATABASE IF EXISTS DB_RURUPERU;

CREATE DATABASE DB_RURUPERU;

USE DB_RURUPERU;


Create Table Usuario (
	idUsu int,
    username varchar(25) not null,
    passwordUsu varchar(20) not null,
    emailUsu varchar(40) not null,
    fotoUsu varchar(255),
    tlfUsu varchar(40),
    idDepa int,
    state varchar(15) default 'Activo'
);

Alter table Usuario add constraint PK_usuario_idUsu primary key (idUsu);
Alter table Usuario modify column idUsu int auto_increment;

create table Cliente (
	idCliente char(8) not null,  -- CLI00001
    idUsu int not null,
	nomCliente varchar(40) not null,
	apeCliente varchar(50) not null,
	dniCli char(8) not null,
    dirCli varchar(250) not null,
	fecNacCli Date not null,
	genCli char(1) not null
);

Alter table Cliente add Constraint PK_cliente_idCliente primary key (idCliente);
Alter table Cliente add Constraint FK_cliente_idCliente foreign key (idUsu) references Usuario(idUsu);
Alter table Cliente add Constraint UNK_cliente_dniCli unique (dniCli);

create table puntaje (
	idPun int not null,
    idCli char(8) not null,
    numPun int(2) not null,
    desPun varchar(255)
);

-- Drop table puntaje;

Alter table puntaje add Constraint PK_puntaje_idPun primary key (idPun);
Alter table puntaje add Constraint FK_puntaje_idCli foreign key (idCli) references Cliente(idCliente);
Alter table puntaje add Constraint UNK_puntaje_idCli UNIQUE (idCli);

Create table Proveedor (
	idProv char(5) not null,
    idUsu int not null,
	desProv varchar(255),
	rucProv varchar(15) not null,
	dirProv varchar(100) not null
);

Alter table Proveedor add constraint PK_proveedor_idProv primary key (idProv);
Alter table Proveedor add constraint FK_usuario_idUsu foreign key (idUsu) references Usuario(idUsu);
Alter table Proveedor add constraint UNK_proveedor_rucProv UNIQUE (rucProv);

Create table Categoria (
	idCat char(5) not null,
    desCat varchar(50) not null
);

Alter table Categoria add constraint PK_categoria_idCat primary key (idCat);

Create table Producto (
	idProd char(5) not null,
    idCat char(5) not null,
	nomProd varchar(25) not null,
	desProd varchar(255) not null,
	preProd decimal(6,2) not null,
	stockProd int not null check (stock >= 0),
    imgProd varchar(255)
);

Alter table Producto add constraint PK_producto_idProd primary key (idProd);
Alter table Producto add constraint FK_producto_idCat Foreign key (idCat) references Categoria(idCat);

Create table Departamento (
	idDepa int not null,
	nomDep varchar(40) not null
);

Alter table Departamento add constraint PK_Departamento_IdDepa primary key (idDepa);
select * from cliente;
INSERT INTO Departamento (idDepa, nomDep) VALUES
(1, 'AMAZONAS'),
(2, 'ANCASH'),
(3, 'APURIMAC'),
(4, 'AREQUIPA'),
(5, 'AYACUCHO'),
(6, 'CAJAMARCA'),
(7, 'CALLAO'),
(8, 'CUSCO'),
(9, 'HUANCAVELICA'),
(10, 'HUANUCO'),
(11, 'ICA'),
(12, 'JUNIN'),
(13, 'LA LIBERTAD'),
(14, 'LAMBAYEQUE'),
(15, 'LIMA'),
(16, 'LORETO'),
(17, 'MADRE DE DIOS'),
(18, 'MOQUEGUA'),
(19, 'PASCO'),
(20, 'PIURA'),
(21, 'PUNO'),
(22, 'SAN MARTIN'),
(23, 'TACNA'),
(24, 'TUMBES'),
(25, 'UCAYALI');

CREATE TABLE Provincia (
 idProvin int not null,
 idDepa int not null,
 nomProvin varchar(50) not null
);

Alter table Provincia add constraint PK_provincia_idProvin primary key (idProvin, idDepa);
Alter table Provincia add constraint FK_provincia_idDepa foreign key (idProvin) references Departamento(idDepa);

Create table Distrito (
	idDis int not null,
    idDepa int not null,
    idProvin int not null,
	nomDis varchar(25) not null
);

Alter table Distrito add constraint PK_distrito primary key (idDis, idDepa, idProvin);
Alter table Distrito add constraint FK_distrito_IdDepa foreign key (idDepa) references Departamento(idDepa);
Alter table Distrito add constraint FK_distrito_idProvin foreign key (idProvin) references Provincia(idProvin);

Create table Pedido (
	nroPedido char(9) not null, -- PED000001
    idCliente char(8) not null,
    cantTotal int not null,
	descPedido decimal(5,2) not null,
	fecPedido date not null,
	dirPedido varchar(100) not null,
    totalPedido decimal(6,2) not null,
    estPedido varchar(15) default "Activo"
);


Alter table Pedido add constraint PK_Pedido_NroPedido primary key (nroPedido);
Alter table Pedido add constraint FK_Pedido_idCliente Foreign key (idCliente) references Cliente(idCliente);

Create table DetallePedido (
	nroPedido char(9) not null,
	idProducto char(5) not null,
	cantidad int not null,
	preProd decimal(6,2) not null,
    descuento decimal not null,
    subtotal decimal(6,2) not null
);
-- Drop table DetallePedido;
alter table DetallePedido add constraint PK_DetallePedido primary key (nroPedido, idProducto);
Alter table DetallePedido add constraint FK_DetallePedido_NroPedido foreign key (nroPedido) references Pedido(nroPedido);
Alter table DetallePedido add constraint FK_DetallePedido_IdProducto foreign key (idProducto) references Producto(idProd);

create table favorite (
	idfav serial,
    idCliente char(5) not null,
    idProducto char(5) not null
);
-- drop table favorite;
alter table favorite add constraint PK_favorite_IdFav primary key (idfav,idCliente,idProducto);
alter table favorite add constraint FK_favorite_IdCliente foreign key (idCliente) references Cliente(idCliente);
alter table favorite add constraint FK_favorite_IdProducto foreign key (idProducto) references Producto(idProd);

create table Boleta (
	idBoleta char(7),
    idCliente char(5),
    fechaBoleta date,
    totalBoleta decimal(6,2),
    IGV decimal(6,2)
);
-- alter table boleta drop primary key;
alter table boleta add constraint PK_Boleta primary key (idBoleta);
alter table boleta add constraint FK_Boleta_IdCliente foreign key (idCliente) references Cliente(idCliente);

-- drop table boleta;

create table DetalleBoleta(
	idBoleta char(7),
    idProd char(5),
    cantProd int,
    desPrd varchar(100),
    preuniProd decimal(6,2),
    descuento decimal,
    importe decimal(6,2)
);

alter table DetalleBoleta add constraint PK_DetalleBoleta primary key (idBoleta, idProd);
alter table DetalleBoleta add constraint FK_DetalleBoleta_IdBoleta foreign key (idBoleta) references Boleta(idBoleta);
alter table DetalleBoleta add constraint Fk_DetalleBoleta_IdProd foreign key (idProd) references Producto(idProd);

Create table Beneficio (
	idBen int primary key,
    descBen varchar(150)
);

Create table producto_beneficio (
    idProd char(5),
    idBen int
);

Alter table producto_beneficio add constraint PK_product_beneficio primary key (idProd, idBen);
Alter table producto_beneficio add constraint FK_product_beneficio_IdProd foreign key (idProd) references Producto(idProd);
Alter table producto_beneficio add constraint FK_product_beneficio_IdBen foreign key (idBen) references Beneficio(idBen);

/*--------------- INICIO: PROCEDIMIENTOS PARA BENEFICIOS ------------------------------*/
DELIMITER $$
Create procedure usp_insert_benefit(idBen int, descBen varchar(150))
BEGIN
	INSERT INTO Beneficio Values(idBen, descBen);
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_benefit_all()
BEGIN
	Select * from Beneficio;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_benefitsByProduct(xidProd char(5))
BEGIN
	Select b.idBen, b.descBen from Beneficio b
    INNER JOIN producto_beneficio pb
    ON b.idBen = pb.idBen
    WHERE pb.idProd = xidProd;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_insert_benefitsByProduct(xidProd char(5), xidBen int)
BEGIN
	INSERT INTO producto_beneficio VALUES(xidProd, xidBen);
END $$
DELIMITER ;
/*--------------- FIN: PROCEDIMIENTOS PARA BENEFICIOS ------------------------------*/

/*--------------- INICIO: PROCEDIMIENTOS PARA USUARIO ------------------------------*/
DELIMITER $$
Create procedure usp_insert_user
(xusername varchar(25), xpasswordUsu varchar(40),
 xemailUsu varchar(40), xfotoUsu varchar(255), xtlfUsu varchar(40), xidDepa int)
BEGIN
	INSERT INTO Usuario VALUES(null, xusername, xpasswordUsu, xemailUsu, xfotoUsu, xtlfUsu, xidDepa, default);
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_update_user
(xidUsu int, xusername varchar(25), xpasswordUsu varchar(40),
 xemailUsu varchar(40), xfotoUsu varchar(255), xtlfUsu varchar(40), xidDepa int)
BEGIN
	UPDATE Usuario 
    SET username = xusername,
		passwordUsu = xpasswordUsu,
        emailUsu = xemailUsu,
        fotoUsu = xfotoUsu,
        tlfUsu = xtlfUsu,
        idDepa = xidDepa
	WHERE idUsu = xidUsu;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_ActiveOrDesactive_user(xidUsu int, xstate varchar(15))
BEGIN
	UPDATE Usuario
    SET state = xstate
    WHERE idUsu = xidUsu;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_user(xemailUsu varchar(40), xpasswordUsu varchar(40))
BEGIN
	Select * From Usuario
    WHERE (emailUsu = xemailUsu and passwordUsu = xpasswordUsu) and (state = 'Activo');
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_user_all()
BEGIN
	Select * From Usuario;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_userByState(xstate varchar(15))
BEGIN
	Select * From Usuario where state = xstate;
END $$
DELIMITER ;
/*------------------ FIN: PROCEDIMIENTOS PARA USUARIO ------------------------------*/

/*------------------ INICIO: PROCEDIMIENTOS PARA CLIENTE ------------------------------*/
DELIMITER $$
Create procedure usp_insert_client
(xidCliente char(8), xidUsu int, xnomCliente varchar(40),
 xapeCliente varchar(50), xdniCli char(8), xdirCli varchar(250), xfecNacCli date, xgenCli char(1))
 BEGIN
	INSERT INTO Cliente VALUES
    (xidCliente, xidUsu, xnomCliente, 
	 xapeCliente, xdniCli, xdirCli, xfecNacCli, xgenCli);
 END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_update_client
(xidUsu int, xusername varchar(25), xpasswordUsu varchar(40),
 xemailUsu varchar(40), xfotoUsu varchar(255), xtlfUsu varchar(40), xidDepa int,
xidCliente char(8), xnomCliente varchar(40),
 xapeCliente varchar(50), xdniCli char(8), xdirCli varchar(250), xfecNacCli date, xgenCli char(1))
 BEGIN
	UPDATE Usuario
    SET username = xusername,
		passwordUsu = xpasswordUsu,
        emailUsu = xemailUsu,
        fotoUsu = xfotoUsu,
        tlfUsu = xtlfUsu,
        idDepa = xidDepa
    WHERE idUsu = xidUsu;
    
	UPDATE Cliente 
    SET nomCliente = xnomCliente,
        apeCliente = xapeCliente,
        dniCli = xdniCli,
        dirCli = xdirCli,
        fecNacCli = xfecNacCli,
        genCli = xgenCli
	WHERE idCliente = xidCliente;
 END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_delete_client(xidCliente char(8))
 BEGIN
	DELETE FROM Cliente WHERE idCliente = xidCliente;
 END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_insertUpdate_client
(xidUsu int, xusername varchar(25), xpasswordUsu varchar(40),
 xemailUsu varchar(40), xfotoUsu varchar(255), xtlfUsu varchar(40), xidDepa int,
xidCliente char(8), xnomCliente varchar(40),
 xapeCliente varchar(50), xdniCli char(8), xdirCli varchar(250), xfecNacCli date, xgenCli char(1))
 BEGIN
	IF(xoption = 0) THEN
	Call usp_insert_client(xidCliente, xidUsu, xnomCliente, xapeCliente, xdniCli, xfecNacCli, xgenCli);
    ELSEIF (xoption = 1) THEN
    Call usp_update_client(xidUsu, xusername, xpasswordUsu, xemailUsu, xfotoUsu, xtlfUsu, xidDepa,
						   xidCliente, xnomCliente, xapeCliente, xdniCli, xfecNacCli, xgenCli);
    END IF;
 END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_client_all()
BEGIN
	Select u.idUsu,
		   u.username,
           u.passwordUsu,
           u.emailUsu,
           u.fotoUsu,
           u.tlfUsu,
           u.idDepa,
		   c.idCliente,
           c.nomCliente,
           c.apeCliente,
           c.dniCli,
           c.fecNacCli,
           c.genCli,
           u.state
    from Cliente c
	INNER JOIN Usuario u
    ON u.idUsu = c.idusu
    WHERE u.idUsu = c.idUsu;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_clientByUser(xidUsu int)
BEGIN
	Select * from Cliente
    Where idUsu = xidUsu;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_clientByState(xstate varchar(15))
BEGIN
	Select u.idUsu,
		   u.username,
           u.passwordUsu,
           u.emailUsu,
           u.fotoUsu,
           u.tlfUsu,
           u.idDepa,
		   c.idCliente,
           c.nomCliente,
           c.apeCliente,
           c.dniCli,
           c.fecNacCli,
           c.genCli,
           u.state
	from Cliente c
    INNER JOIN Usuario u
    ON c.idUsu = u.idUsu
    Where (c.idUsu = u.idUsu) and (u.state = xstate);
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_search_client(xidCliente char(8))
BEGIN
	Select * from Cliente
    Where idCliente = xidCliente;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_lastIdClient_client()
BEGIN
	Select MAX(idCliente) from Cliente;
END $$
DELIMITER ;

/*------------------ FIN: PROCEDIMIENTOS PARA CLIENTE ------------------------------*/

/*--------------- INICIO: PROCEDIMIENTOS PARA CATEGORÍA ------------------------------*/
DELIMITER $$
Create procedure usp_insert_category(xidCat char(5), xdesCat varchar(50))
BEGIN
	INSERT INTO Categoria
    Values(xidCat, xdesCat);
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_update_category(xidCat char(5), xdesCat varchar(50))
BEGIN
	UPDATE Categoria
    SET desCat = xdesCat
    WHERE idCat = xidCat;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_delete_category(xidCat char(5))
BEGIN
	DELETE FROM Categoria WHERE idCat = xidCat;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_category(xidCat char(5))
BEGIN
	Select * From Categoria
    WHERE idCat = xidCat;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_category_all()
BEGIN
	Select * From Categoria;
END $$
DELIMITER ;

/*--------------- FIN: PROCEDIMIENTOS PARA CATEGORÍA ------------------------------*/

/*--------------- INICIO: PROCEDIMIENTOS PARA PRODUCTO ------------------------------*/
DELIMITER $$
Create procedure usp_insert_product
(xidProd char(5), xidCat char(5), xnomProd varchar(25),
 xdesProd varchar(255), xpreProd decimal(6,2), xstockProd int, ximgProd varchar(255))
BEGIN
	INSERT INTO Producto 
    VALUES(xidProd, xidCat, xnomProd, 
		   xdesProd, xpreProd, xstockProd, ximgProd);
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_update_product
(xidProd char(5), xidCat char(5), xnomProd varchar(25),
 xdesProd varchar(255), xpreProd decimal(6,2), xstockProd int, ximgProd varchar(255))
BEGIN
	UPDATE Producto 
    SET idCat = xidCat,
		nomProd = xnomProd,
        desProd = xdesProd,
        preProd = xpreProd,
        stockProd = xstockProd,
        imgProd = ximgProd
	WHERE idProd = xidProd;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_delete_product(xidProd char(5))
BEGIN
	DELETE FROM producto_beneficio WHERE idProd = xidProd;
	DELETE FROM Producto WHERE idProd = xidProd;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_products_by_category(xidCat char(5))
BEGIN
	Select * From Producto
    WHERE idCat = xidCat;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_product_all()
BEGIN
	Select * From Producto;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_productById(xidProd char(5))
BEGIN
	Select * from Producto
    WHERE idProd = xidProd;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_lastIdProd_product()
BEGIN
	Select MAX(idProd) from Producto;
END $$
DELIMITER ;
/*------------------ FIN: PROCEDIMIENTOS PARA PRODUCTO ------------------------------*/


/*------------------ INICIO: PROCEDIMIENTOS PARA PEDIDOS ------------------------------*/

DELIMITER $$
Create procedure usp_insert_order
(xnroPedido char(9), xidCliente char(8), xcantTotal int,
 xdescPedido decimal(5,2), xfecPedido date, xdirPedido varchar(100),
 xtotalPedido decimal(5,2))
BEGIN
	INSERT INTO Pedido VALUES
    (xnroPedido, xidCliente, xcantTotal, 
     xdescPedido, xfecPedido, xdirPedido, xtotalPedido, default);
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_delete_order(xnroPedido char(9))
BEGIN
	DELETE FROM Pedido WHERE nroPedido = xnroPedido;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_desactive_order(xnroPedido char(9))
BEGIN
	UPDATE Pedido
    SET estPedido = 'Desactivado'
    WHERE nroPedido = xnroPedido;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_order_all()
BEGIN
	Select * from Pedido;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_orderByOrder(xnroPedido char(9))
BEGIN
	Select * from Pedido
    Where nroPedido = xnroPedido;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_orderByState(xestPedido varchar(15))
BEGIN
	Select * from Pedido where estPedido = xestPedido;
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_lastIdOrder_order()
BEGIN
	Select MAX(nroPedido) from Pedido;
END $$
DELIMITER ;

/*------------------ FIN: PROCEDIMIENTOS PARA PEDIDOS ------------------------------*/

/*------------------ INICIO: PROCEDIMIENTOS PARA DETALLE PEDIDO ------------------------------*/

DELIMITER $$
Create procedure usp_insert_detailOrder
(xnroPedido char(9), xidProducto char(5), xcantidad int,
 xpreProd decimal(6,2), xdescuento decimal, xsubtotal decimal(6,2))
 BEGIN
	INSERT INTO DetallePedido VALUES
    (xnroPedido, xidProducto, xcantidad, xpreProd, 
     xdescuento, xsubtotal);
     
     UPDATE Producto
     SET stockProd = stockProd - xcantidad where idProd = xidProducto;
 END $$
DELIMITER ;
Select * from Producto;
DELIMITER $$
Create procedure usp_delete_detailOrder(xnroPedido char(9))
 BEGIN
	INSERT INTO DetallePedido VALUES
    (xnroPedido, xidProducto, xcantidad, xpreProd, 
     xdescuento, xsubtotal);
 END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_detailOrder_all()
 BEGIN
	SELECT * FROM DetallePedido;
 END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_detailOrderByOrder(xnroPedido char(9))
 BEGIN
	SELECT pr.idProd,
		   pr.nomProd,
           pr.imgProd,
           d.cantidad,
           d.preProd,
           d.subtotal
	FROM DetallePedido d
    INNER JOIN Producto pr
    ON pr.idProd = d.idProducto
    Where d.nroPedido = xnroPedido
    Order by pr.idProd;
 END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_detailOrderByClient(xidClient char(8))
 BEGIN
	SELECT pr.idProd,
		   pr.nomProd, 
           pr.imgProd,
           d.cantidad,
           d.preProd,
           d.subtotal
	FROM DetallePedido d
    INNER JOIN Pedido p
    ON p.nroPedido = d.nroPedido
    INNER JOIN Producto pr
    ON pr.idProd = d.idProducto
    Where p.idCliente = xidClient and p.estPedido = 'Activo'
    Order by p.fecPedido, p.nroPedido;
 END $$
DELIMITER ;

/*------------------ FIN: PROCEDIMIENTOS PARA DETALLE PEDIDO ------------------------------*/

/*------------------ INICIO: PROCEDIMIENTOS PARA  BUSCAR DEPARTAMENTOS ------------------------------*/

DELIMITER $$
Create procedure usp_get_department_all()
BEGIN
	Select * from Departamento;
END $$
DELIMITER ;

/*------------------ FIN: PROCEDIMIENTOS PARA  BUSCAR DEPARTAMENTOS ------------------------------*/

/*------------------ INICIO: PROCEDIMIENTOS PARA  BUSCAR PRODUCTOS ------------------------------*/

DELIMITER $$
Create procedure usp_get_productsByCondition
(xnomProd varchar(25), xidCat char(5), xpremin decimal, xpremax decimal)
BEGIN
	Select p.*
    FROM Producto p
    WHERE p.nomProd LIKE concat(xnomProd, '%') or p.idCat = xidCat or
		  (p.preProd BETWEEN xpremin and xpremax);
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_productsByName
(xnomProd varchar(25))
BEGIN
	Select p.*
    FROM Producto p
    WHERE p.nomProd LIKE concat(xnomProd, '%');
END $$
DELIMITER ;

DELIMITER $$
Create procedure usp_get_productsByCategory
(xidCat char(5))
BEGIN
	Select p.*
    FROM Producto p
    WHERE p.idCat = xidCat;
END $$
DELIMITER ;

Call usp_get_productsByCondition('Prod', null, 0, 0);


/*------------------ FIN: PROCEDIMIENTOS PARA  BUSCAR PRODUCTOS ------------------------------*/

/*----------------- INSERCIÓN DE CATEGORÍAS -----------------------*/
Call usp_insert_category('CAT01', 'Categoría 001');
Call usp_insert_category('CAT02', 'Categoría 002');
Call usp_insert_category('CAT03', 'Categoría 003');

/*----------------- INSERCIÓN DE USUARIOS -----------------------*/
Call usp_insert_user
('Usuario1', 'password01', 'usuario1@gmail.com', 'C:/perfiles/001.png', '987654321', 4);
Call usp_insert_user
('Usuario2', 'password02', 'usuario2@gmail.com', 'C:/perfiles/002.png', '987654322', 5);
Call usp_insert_user
('Usuario3', 'password03', 'usuario3@gmail.com', 'C:/perfiles/003.png', '987654323', 6);
Call usp_insert_user
('Usuario4', 'password04', 'usuario4@gmail.com', 'C:/perfiles/004.png', '987654324', 7);
Call usp_insert_user
('Usuario5', 'password05', 'usuario5@gmail.com', 'C:/perfiles/005.png', '987654325', 8);
Call usp_insert_user
('Usuario6', 'password06', 'usuario6@gmail.com', 'C:/perfiles/006.png', '987654326', 15);
Call usp_insert_user
('Usuario7', 'password07', 'usuario7@gmail.com', 'C:/perfiles/007.png', '987654327', 15);

/*----------------- INSERCIÓN DE CLIENTES ------------------------*/
Call usp_insert_client('CLI00001', 1, 'Gepeto', 'Girafales', '87654321', 'La vencindad del chavo', '1990/10/10', 'M');
/*----------------- INSERCIÓN DE PRODUCTOS -----------------------*/
Call usp_insert_product
('PR001', 'CAT01', 'Producto 001', 'Descripción del producto 001', 10.00, 15, 'PR001.jpg');
Call usp_insert_product
('PR002', 'CAT01', 'Producto 002', 'Descripción del producto 002', 20.00, 18, 'PR002.jpg');
Call usp_insert_product
('PR003', 'CAT01', 'Producto 003', 'Descripción del producto 003', 30.00, 25, 'PR003.jpg');
Call usp_insert_product
('PR004', 'CAT02', 'Producto 004', 'Descripción del producto 004', 40.00, 33, 'PR004.jpg');
Call usp_insert_product
('PR005', 'CAT02', 'Producto 005', 'Descripción del producto 005', 50.00, 42, 'PR005.jpg');
Call usp_insert_product
('PR006', 'CAT02', 'Producto 006', 'Descripción del producto 006', 60.00, 17, 'PR006.jpg');
Call usp_insert_product
('PR007', 'CAT03', 'Producto 007', 'Descripción del producto 007', 70.00, 14, 'PR007.jpg');
Call usp_insert_product
('PR008', 'CAT03', 'Producto 008', 'Descripción del producto 008', 40.00, 45, 'PR008.jpg');
Call usp_insert_product
('PR009', 'CAT03', 'Producto 009', 'Descripción del producto 009', 60.00, 17, 'PR009.jpg');
Call usp_insert_product
('PR010', 'CAT01', 'Producto 010', 'Descripción del producto 010', 16.00, 21, 'PR010.jpg');
Call usp_insert_product
('PR011', 'CAT01', 'Producto 011', 'Descripción del producto 011', 24.00, 53, 'PR011.jpg');
Call usp_insert_product
('PR012', 'CAT01', 'Producto 012', 'Descripción del producto 012', 35.00, 26, 'PR012.jpg');
Call usp_insert_product
('PR013', 'CAT02', 'Producto 013', 'Descripción del producto 013', 18.00, 20, 'PR013.jpg');
Call usp_insert_product
('PR014', 'CAT03', 'Producto 014', 'Descripción del producto 014', 33.00, 7, 'PR014.jpg');
Call usp_insert_product
('PR015', 'CAT02', 'Producto 015', 'Descripción del producto 015', 44.00, 4, 'PR015.jpg');
Call usp_insert_product
('PR016', 'CAT02', 'Producto 016', 'Descripción del producto 016', 55.00, 25, 'PR016.jpg');
Call usp_insert_product
('PR017', 'CAT02', 'Producto 017', 'Descripción del producto 017', 70.00, 70, 'PR017.jpg');
Call usp_insert_product
('PR018', 'CAT02', 'Producto 018', 'Descripción del producto 018', 70.00, 70, 'PR018.jpg');
Call usp_insert_product
('PR019', 'CAT02', 'Producto 019', 'Descripción del producto 019', 70.00, 70, 'PR019.jpg');
Call usp_insert_product
('PR020', 'CAT03', 'Producto 020', 'Descripción del producto 020', 70.00, 70, 'PR020.jpg');
Call usp_insert_product
('PR021', 'CAT03', 'Producto 021', 'Descripción del producto 021', 70.00, 70, 'PR021.jpg');
Call usp_insert_product
('PR022', 'CAT01', 'Producto 022', 'Descripción del producto 022', 70.00, 70, 'PR022.jpg');
Call usp_insert_product
('PR023', 'CAT01', 'Producto 023', 'Descripción del producto 023', 70.00, 70, 'PR023.jpg');
Call usp_insert_product
('PR024', 'CAT01', 'Producto 024', 'Descripción del producto 024', 70.00, 70, 'PR024.jpg');

/*----------------- INSERCIÓN DE BENEFICIOS -----------------------*/

Call usp_insert_benefit(1, 'Beneficio 1');
Call usp_insert_benefit(2, 'Beneficio 2');
Call usp_insert_benefit(3, 'Beneficio 3');
Call usp_insert_benefit(4, 'Beneficio 4');
Call usp_insert_benefit(5, 'Beneficio 5');
Call usp_insert_benefit(6, 'Beneficio 6');
Call usp_insert_benefit(7, 'Beneficio 7');

Call usp_insert_benefitsByProduct('PR001', 1);
Call usp_insert_benefitsByProduct('PR001', 2);
Call usp_insert_benefitsByProduct('PR001', 3);
Call usp_insert_benefitsByProduct('PR002', 1);
Call usp_insert_benefitsByProduct('PR002', 2);
Call usp_insert_benefitsByProduct('PR003', 3);
Call usp_insert_benefitsByProduct('PR004', 4);
Call usp_insert_benefitsByProduct('PR005', 5);
Call usp_insert_benefitsByProduct('PR006', 6);
Call usp_insert_benefitsByProduct('PR007', 7);

-- INSERT INTO Cliente values('CLI00001', 1, 'Nombre de Cliente 1', 'Apellido Cliente 1', '78654321', '2019-05-16', 'M');

/*--------------------- CONSULTAS --------------------------------------------*/
Call usp_get_user_all();
Call usp_get_product_all();
Call usp_get_category_all();
Call usp_get_order_all();
Call usp_get_client_all();
Call usp_get_benefit_all();

Select * from DetallePedido;
Select * from Pedido;

Call usp_get_benefitsByProduct('PR001');
Call usp_get_clientByUser(1);
Call usp_lastIdProd_product();
Call usp_lastIdClient_client();
Call usp_lastIdOrder_order();
Call usp_get_orderByOrder('PED000001');
