<%-- 
    Document   : menu
    Created on : 16-nov-2015, 9:57:42
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = (String) session.getAttribute("varUsuario");
    String pass = (String) session.getAttribute("Pass");
    String id = (String) session.getAttribute("id");
    String nom = (String) session.getAttribute("nombre");
    String tel = (String) session.getAttribute("Telefono");
    String tip = (String) session.getAttribute("Tipo");
    String dir = (String) session.getAttribute("Direc");
%>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <script type = "text/javascript">
            var intevalo;
            function marca(_id) {
                $.ajax({
                    type: 'POST',
                    url: 'Marca',
                    data: {
                        id: _id
                    }
                }).done(function (respuesta) {
                    clearInterval(intervalo);
                    notifica();
                    recargas();
                });
            }
            function notifica2() {
                $.ajax({
                    type: 'POST',
                    url: 'notificaciones',
                    data: {
                        tipo: 2,
                        id: <%=id%>
                    }
                }).done(function (respuesta) {
                    document.getElementById("lista").innerHTML = respuesta;
                });
            }
            function notifica() {
                $.ajax({
                    type: 'POST',
                    url: 'notificaciones',
                    data: {
                        tipo: 1,
                        id: <%=id%>
                    }
                }).done(function (respuesta) {
                    document.getElementById("notif").innerHTML = "Ordenes pendientes :" + respuesta;
                    notifica2();
                });
            }
            function recargas() {
                intervalo = setInterval(notifica, 3000);
            }
            function nobackbutton() {
                window.location.hash = "no-back-button";
                window.location.hash = "Again-No-back-button"; //chrome
                window.onhashchange = function () {
                    window.location.hash = "no-back-button";
                }
                recargas();
            }
        </script>
       

        <meta charset="utf-8">
         <link href="css/landing-page.css" rel="stylesheet">
        <link href="css/estilacho.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="css/tenedor.png" />
        <script src="js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
         <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
         <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <!--Con Internet
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        -->
    </head>
    <body onload="recargas();">
        <%      
            if (user != null && pass !=null && id !=null && nom !=null && tel !=null && tip !=null && dir !=null) {
        %>
        <!--Menú de Navegación-->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="menuPrincipal.jsp">Órden del Día</a>
                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><%out.print(user);%><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="CierraSesion">Cerrar Sesión</a></li>
                                <li><a href="UserNameServlet">Chat</a></li>
                                <li><a href="PreCambioUsuario.jsp">Cambiar Datos</a></li>
                                <li><a href="PreBajaUsuario.jsp">Dar de baja</a></li>
                            </ul>
                        </li>
                       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Buscar<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="BusquedaRestauranteConsultaPlatillo.jsp">Buscar Platillo</a></li>
                                <li><a href="ConsultaRestaurante.jsp">Buscar Restaurante</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" id="notif">Ordenes pendientes : *cargando*<span class="caret"></span></a>
                            <ul class="dropdown-menu" id="lista">

                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Menú de Bienvenida-->
        <div class="container">
            <center><h3>Menú Administrar</h3></center>
            <hr>
        </div>
        <div class="container">
            <center>
            <h3>Bienvenido</h3>
            <p>¿Qué Desea Hacer?</p>
            </center>
        </div>
        <div class="bannerMenuA">

            <div class="container">

                <div class="row"><center>
            <div class="col-sm-4"></div>
            <div class="col-sm-2">
                <a href="menuFranquicia.jsp">
                    <center>
                        <font color="F24207" size="5">
                        <i class="fa fa-cogs fa-fw fa-5x"></i> <br>
                        </font>
                        <font clas color="white"><b><h2>Mis Restaurantes</h2></b></font>
                    </center>
                </a>    
            </div>
            <div class="col-sm-2">
                <a href="menuRestaurante.jsp">
                    <center>
                        <font color="F21B07" size="5">
                        <i class="fa fa-cog fa-fw fa-5x"></i> <br>
                        </font>
                        <font color="white"><b><h2>Administrar Restaurante</h2></b></font>
                    </center>
                </a>
            </div>
            <div class="col-sm-4"></div>
            </center>
        </div>

            </div>


        </div>
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p class="copyright text-muted small">Copyright &copy;  GreenNote 2015. All Rights Reserved</p>
                    </div>
                </div>
            </div>
        </footer>
       
        <%} else {

                //   out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                response.sendRedirect("OrdenDia");
}
        %>

</body>
</html>
</html>
