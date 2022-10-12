<%-- 
    Document   : BusquedaConsultaRestaurante
    Created on : 8/12/2015, 09:09:11 PM
    Author     : Amahury
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <!--Con Internet
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
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
                   <a class="navbar-brand" href="menuPrincipal.jsp">Órden del Día</a>
                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="menu.jsp">Regresar</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Formulario-->
        <div class="container">
            <center><h3>Mis Reservaciones</h3></center>
            <hr>
        </div>  
        <div class="container">
            <form class="form-horizontal" role="form" method="post" name="BorraRest" action="BusquedaBajaRestaurante">
                <div class="form-group">
                    <div class="col-sm-10">
                        <%
                            BD.cDatos sql = new BD.cDatos();
                            try {
                                sql.conectar();
                                ResultSet rsUsr = sql.consulta("call sp_ConsultaReserva('" + id + "');");

                                while (rsUsr.next()) {
                                    String hor = rsUsr.getString("Hora");
                                    String nomf = rsUsr.getString("Restaurante");
                                    String min = rsUsr.getString("Minuto");
                                    String fec = rsUsr.getString("Fecha");

                                    out.print("<div class=\"form-group\">\n"
                                            + "                <label class=\"control-label col-sm-2\" for=\"franchise\" >Restaurante</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"Restaurante\" value='" + nomf + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Fecha</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"descrestaurante\" value='" + fec + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Hora</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"descrestaurante\" value='" + hor + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Minutos</label>\n"
                                            
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"direcrestaurante\" value='" + min + "' readonly required>\n"
                                            + "<hr>                    "
                                            + "</div>\n"
                                            
                                            + "                </div>\n\n\n\n");
                                }
                            } catch (SQLException error) {
                                out.print(error.toString());
                            }

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

          //  out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                response.sendRedirect("OrdenDia");
        %>
        <%            }
        %>
    </body>
</html>