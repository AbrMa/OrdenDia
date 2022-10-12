<%-- 
    Document   : ConsultaOrden
    Created on : 25/04/2016, 09:30:53 PM
    Author     : Alumno
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
        <div class="container">
            <center><h3>Mis Pedidos</h3></center>
            <hr>
        </div>  
        <div class="container">
            <form class="form-horizontal" role="form" method="post" name="BorraRest" action="BusquedaBajaRestaurante">
                <div class="form-group">
                    <div class="col-sm-10">
                        <%
                            BD.cDatos sql = new BD.cDatos();
                            ResultSet rs;
                            int cont = 0;
                            /*int id;
                            id = IdPersona*/
                            try{
                                sql.conectar();
                                rs = sql.consulta("call notif2("+id+",5);");
                                while(rs.next()){
                                    out.println("<li>Usuario: "+rs.getString("ordeno")+"<br>Platillo: "+rs.getString("platillo")+"<br>Cantidad : "+rs.getInt("cantidad")+"<br><input type=button value='Listo' onclick='marca("+rs.getInt("id")+");'></li>");
                                }                                                   
                                sql.cierraConexion();
                            } catch(Exception ex){

                            }               
                            /*String rest = request.getParameter("restaurante");
                            BD.cDatos sql = new BD.cDatos();
                            try {
                                sql.conectar();
                                ResultSet rsUsr = sql.consulta("call sp_ConsultaPedidoAdmin('" + rest + "';");

                                while (rsUsr.next()) {
                                    String restt = rsUsr.getString("idRestaurante");
                                    String nomf = rsUsr.getString("Nombre");
                                    String pers = rsUsr.getString("idPersona");
                                    int tot;
                                    int cant = Integer.parseInt(rsUsr.getString("Cantidad"));
                                    int prec = Integer.parseInt(rsUsr.getString("Precio"));
                                    tot = cant * prec;
                                    out.print("<div class=\"form-group\">\n"
                                            + "                <label class=\"control-label col-sm-2\" for=\"franchise\" >Nombre Platillo</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"Restaurante\" value='" + nomf + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Restaurante</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"descrestaurante\" value='" + restt + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Costo</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"direcrestaurante\" value='" + tot + "' readonly required>\n"
                                            + "                <hr>    "
                                            + "</div>\n"
                                            + "                </div>\n\n\n\n");
                                }
                            } catch (SQLException error) {
                                out.print(error.toString());
                            }
*/
                        %>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">

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
