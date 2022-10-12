<%-- 
    Document   : registrarRestaurante
    Created on : 1/12/2015, 01:36:30 PM
    Author     : Alumno
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
        <script src="http://maps.googleapis.com/maps/api/js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <!--Con Internet
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        -->
        <script>
            var myCenter[] = new google.maps.LatLng(51.508742, - 0.120850);
                    function initialize()
                    {
                        var mapProp = {
                            center: myCenter,
                            zoom: 5,
                            mapTypeId: google.maps.MapTypeId.ROADMAP
                        };

                        var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

                        var marker = new google.maps.Marker({
                            position: myCenter,
                            title: 'Click to TlaxcalaYork'
                        });
                        marker.setMap(map);

// Zoom to 9 when clicking on marker
                        google.maps.event.addListener(marker, 'click', function () {
                            map.setZoom(9);
                            map.setCenter(marker.getPosition());
                        });
                    }
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>

    </head>
    <body onload="recargas();">
        <%
            if (user != null && pass != null && id != null && nom != null && tel != null && tip != null && dir != null) {
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
        <!--Formulario-->
        <div class="container">
            <center><h3>Registrar Restaurante</h3></center>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <div class="clearfix"></div>
                <h2 class="section-heading">Registrar Restaurante</h2>
                <p class="lead">Empieza un nuevo negocio.</p>

                <img class="img-responsive" src="css/res.jpg" alt="">

            </div>
            <div class="col-sm-5">
                <br>
                <div class="panel panel-primary">
                    <div class="panel-heading">Registrar Restaurante</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" name="Alta" method="Post" Action="AltaRestaurante" enctype="multipart/form-data">
                            <div class="panel-body">
                                <label class="control-label col-sm-2" for="restaurant">Nombre Restaurante</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="restaurant" name="Restaurante" placeholder="Vips" maxlength="20" required>
                                    <input type="password" hidden value="<%out.print(id);%>"  id="franchise" name="id"  required readonly>
                                </div>
                            </div>
                            <div class="panel-body">
                                <label class="control-label col-sm-2" for="franchiseDescription">Descripción Restaurante</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="franchiseDescription" maxlength="30" name="descripcionRestaurante" placeholder="La mejor comida del mundo nigga" required>
                                </div>
                            </div>
                            <center><div   class="panel-body" id="googleMap" style="width:250px;height:190px;"></div></center>

                            <div class="panel-body">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary">Registrar</button>
                                </div>
                            </div>  
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-1"></div>
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

            //    out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
            response.sendRedirect("OrdenDia");
        %>
        <%            }
        %>
    </body>
</html>