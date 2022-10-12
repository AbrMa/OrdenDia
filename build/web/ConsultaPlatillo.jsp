<%-- 
    Document   : ConsultaPlatillo
    Created on : 10/12/2015, 11:04:48 PM
    Author     : Carmen
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
         <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
        <link rel="shortcut icon" href="css/tenedor.png" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>
    <body>
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
            <center><h3>Informacion</h3></center>
            <hr>
        </div>  
        <div class="container">
            <form class="form-horizontal" role="form" method="post" name="BorraRest" action="ModificarPlatillo.jsp">
                <div class="form-group">
                    <div class="col-sm-10">
                        <%
                           BD.cDatos sql = new BD.cDatos();
                           String nomf = request.getParameter("platillo");
                                            try {
                                                sql.conectar();
                                                ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo('" + nomf + "');");

                                while (rsUsr.next()) {
                                    
                                    String nom = rsUsr.getString("Nombre");
                                    String idRest = rsUsr.getString("idRestaurante");
                                    String prec = rsUsr.getString("Precio");
                                    String descrip = rsUsr.getString("Descripcion");
                                    
                                    out.print("<div class=\"form-group\">\n"
                                           
                                           
                                               + "                    <div class=\"col-sm-10\">\n"
                                            + "  "
                                            + "                      <input type=\"text\"  id=\"franchise\" name=\"Restaurante\" value='" + idRest + "' HIDDEN required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Nombre Platillo</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"platillo\" value='" + nom + "' readonly  required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Descripcion Platillo</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"descripcion\" value='" + descrip + "'  required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Precio</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"precio\" value='" + prec + "'  required>\n"
                                            + "                    </div>\n"
                                            + "               <div class=\"col-sm-10\">\n"
                                            + "                      <img class=\"img-responsive\" src=\"" + request.getContextPath() + "/" + rsUsr.getString("foto") + "\"/>\n"
                                            + "              </div>\n"
                                            + "                </div>\n\n\n");
                                }
                            } catch (SQLException error) {
                                out.print(error.toString());
                            }

                        %>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit"  class="btn btn-default">Cambiar</button>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
