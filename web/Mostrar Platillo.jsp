<%-- 
    Document   : Mostrar Platillo
    Created on : 29/04/2016, 01:44:19 PM
    Author     : Alumno
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
        <link rel="shortcut icon" href="css/tenedor.png" />
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--Con Internet
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        -->

    </head>
    <body>

     
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
            <center><h3>Buscar Platillo</h3></center>
            <hr>
        </div>
        <div class="row">

            <form class="form-horizontal" role="form" method="post" name="BorraPlat2" action="">
                <div class="form-group">
                    <div class="col-sm-10">             
                        <%
                            String rest = request.getParameter("restaurante");
                            BD.cDatos sql = new BD.cDatos();
                            try {
                                sql.conectar();
                                ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo2('" + rest + "');");

                                while (rsUsr.next()) {
                                    String plat = rsUsr.getString("idPlatillo");
                                    String nomf = rsUsr.getString("Nombre");
                                    String descrip = rsUsr.getString("Descripcion");
                                    String prec = rsUsr.getString("Precio");

                                    out.print("          <div class=\"panel panel-info\">\n"
                                            + "                <div class=\"panel-heading\">" + nomf + "</div>\n"
                                            + "                <div class=\"panel-body\">\n"
                                            + " <div class=\"panel-body\">  \n"
                                            + "<div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Nombre Platillo</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"Platillo\" value='" + nomf + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                </div>\n"
                                            + " <div class=\"panel-body\">  \n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Descripcion Platillo</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"descripcion\" value='" + descrip + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                </div>\n"
                                            + "                </div>\n"
                                            + " <div class=\"panel-body\">  \n"
                                            + "                <div class=\"form-group\">\n"
                                            + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Precio</label>\n"
                                            + "                    <div class=\"col-sm-10\">\n"
                                            + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"precio\" value='" + prec + "' readonly required>\n"
                                            + "                    </div>\n"
                                            + "                    </div>\n"
                                            + "                    </div>\n"
                                            + "               <div class=\"col-sm-10\">\n"
                                            + "                      <img class=\"img-responsive\" src=\"" + request.getContextPath() + "/" + rsUsr.getString("foto") + "\"/>\n"
                                            + "              </div>\n"
                                            + "              </div>\n"
                                            + "              </div>\n"
                                            + "              </div>\n"
                                            + "                 ");
                                }
                            } catch (SQLException error) {
                                out.print(error.toString());
                            }

                        %>
                    </div>
                </div>
                <div class="panel-body">        
                </div>
                <div class="panel-body">        
                    <div class="col-sm-offset-2 col-sm-10">

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

</body>
</html>
