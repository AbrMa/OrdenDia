<%-- 
    Document   : PreCambioUsuario
    Created on : 26-nov-2015, 20:07:35
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="css/tenedor.png" />
        <script src="js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

        <!--Con Internet
       <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
       <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        -->
    </head>
    <body>
        <%
            String user = (String) session.getAttribute("varUsuario");
            String pass = (String) session.getAttribute("Pass");
            String id = (String) session.getAttribute("id");
            String nom = (String) session.getAttribute("nombre");
            String tel = (String) session.getAttribute("Telefono");
            String tip = (String) session.getAttribute("Tipo");
            String dir = (String) session.getAttribute("Direc");
            if (user != null && pass != null && id != null && nom != null && tel != null && tip != null && dir != null) {
        %>
        <!--Menú de Navegación-->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="menu.jsp" class="navbar-brand">Órden del Día</a>
                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><%out.print(user);%></a></li> 
                        <li><a href="CierraSesion">Cerrar Sesión</a></li>                      
                        <li><a href="PreBajaUsuario.jsp">Dar de baja</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Menú de Bienvenida-->

    <center><h3>Ingrese sus nuevos datos</h3></center>
    <hr>
    <div class="container">
        <form class="form-horizontal" role="form" name="Cambio" method="Post" Action="CambioUsuario.jsp">
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">Nombre</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="nombre"  value="<%out.print(nom);%>" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="address">Dirección</label>
                <div class="col-sm-10">                 
                    <input type="text" class="form-control" id="address" name="direccion" value="<%out.print(dir);%>" placeholder="Mar Mediterrano Popotla no 984" required>
                    <input type="email" hidden id="email" readonly  name="correo" value="<%out.print(user);%>" placeholder="ejemplo@gmail.com" required>
                    <input type="password" hidden id="contrasena" readonly name="pass" value="<%out.print(pass);%>" placeholder="Ingresa tu Contraseña" required>
                    <input type="text" hidden id="type" name="telefono" readonly value="<%out.print(tip);%>" placeholder="8794568728" required>
                </div>
            </div>            
            <div class="form-group">        
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-info">Cambiar</button>
                </div>
            </div>
        </form>
    </div>
    <%} else {

       // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
    response.sendRedirect("OrdenDia");
    %>

    <%            }
    %>
</body>
</html>
