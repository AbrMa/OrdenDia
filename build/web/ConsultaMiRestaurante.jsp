<%-- 
    Document   : BusquedaConsultaRestaurante
    Created on : 8/12/2015, 09:09:11 PM
    Author     : Amahury
--%>
<!DOCTYPE html>
<%-- 
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
function initialize() {
  var mapProp = {
    center:new google.maps.LatLng(51.508742,-0.120850),
    zoom:5,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>

body
<div id="googleMap" style="width:500px;height:380px;"></div>
--%>


<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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
        <link href="css/thumbnail-gallery.css" rel="stylesheet">
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
function initialize() {
  var mapProp = {
    center:new google.maps.LatLng(51.508742,-0.120850),
    zoom:5,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
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
                                <li><a href="#">Buscar Restaurante</a></li>
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
            <center><h3>Mis Restaurantes</h3></center>
            <hr>
        </div>  
        <div class="container">
            
            <%
                                BD.cDatos sql = new BD.cDatos();
                                try{
                                    sql.conectar();
                                    ResultSet rsUsr = sql.consulta("call sp_ConsultaRestaurante2('" + id + "');");
                                    int contador = 0;
                                    while (rsUsr.next()) {
                                         String descrip = rsUsr.getString("Descripcion");
                                        String nomf = rsUsr.getString("Nombre");
                                        String img = rsUsr.getString("foto");
                                        String direc = rsUsr.getString("Direccion");
                                        String rest = rsUsr.getString("idRestaurante");

                                        
                                        if(contador ==0){
                                            out.print("<div class='row'>");
                                        }
                                        out.print("<div class='col-sm-3'>"
                                                +"<a class='thumbnail' href='#'>"
                                                +"<img class='img-responsive imagenSucha' src='"+ request.getContextPath()+"/"+ rsUsr.getString("foto")+"'>"
                                                +"<center><p><b>"+nomf+"</b></p>"
                                                +"<p>"+descrip+"</p><p>"+direc+"</p></center>"
                                                +"</a>"
                                                +"<form class=\"form-horizontal\" role=\"form\" method=\"post\" name=\"BajaRest\" action=\"PreConsultaPlatillo.jsp\">\n"
                                                +"<input type='hidden' name='restaurante' value='"+rest+"'><input type='hidden' name='Restaurante' value='"+nomf+"'><input type='hidden' name='descrestaurante' value='"+descrip+"'><input type='hidden' name='direcrestaurante' value='"+direc+"'>"
                                                +"<center><button type=\"submit\" class=\"btn btn-danger\">Platillos "+nomf+"</button>\n</center>"
                                                +"</form>"
                                                +"</div>");
                                        
                                        contador++;
                                        if(contador == 4){
                                            out.print("</div>");
                                            contador = 0;
                                        }
                           
                                         }
                                } catch (SQLException error) {
                                    out.print(error.toString());
                                }

                           
                            %>

            
        </div>
        <div id="googleMap" style="width:250px;height:190px;"></div>
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

           // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                 response.sendRedirect("OrdenDia");
        %>
        <%            }
        %>
    </body>
</html>

