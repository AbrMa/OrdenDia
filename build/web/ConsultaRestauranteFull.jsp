<%-- 
    Document   : ConsultaRestauranteFull
    Created on : 10/12/2015, 09:25:51 PM
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
            <form class="form-horizontal" role="form" method="post" name="BorraRest" action="#">
                <div class="form-group">
                    <div class="col-sm-10">
                            <%
                                BD.cDatos sql = new BD.cDatos();
                                String nom = request.getParameter("restaurante");
                                try{
                                    sql.conectar();
                                    ResultSet rsUsr = sql.consulta("call sp_ConsultaRestauranteFull();");  

                                    while (rsUsr.next()) {
                                         String descrip = rsUsr.getString("Descripcion");
                                        String nomf = rsUsr.getString("Nombre");
                                        String img = rsUsr.getString("foto");
                                        String direc = rsUsr.getString("Direccion");
                                        
                                        out.print("          <div class=\"panel panel-info\">\n"
                                                    + "                <div class=\"panel-heading\">" + nomf + "</div>\n"
                                                    + "                <div class=\"panel-body\">\n"
                                                    + " <div class=\"panel-body\">  \n"
                                                    + "<div class=\"form-group\">\n"
                                                    + "                <label class=\"control-label col-sm-2\" for=\"franchise\" >Nombre Restaurante</label>\n"
                                                    + "                    <div class=\"col-sm-10\">\n"
                                                    + "                        <input tyzpe=\"text\" class=\"form-control\" id=\"franchise\" name=\"Restaurante\" value='" + nomf + "' readonly required>\n"
                                                    + "                    </div>\n"
                                                    + "                </div>\n"
                                                    + "                </div>\n"
                                                    + " <div class=\"panel-body\">  \n"
                                                    + "                <div class=\"form-group\">\n"
                                                    + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Descripcion Restaurante</label>\n"
                                                    + "                    <div class=\"col-sm-10\">\n"
                                                    + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"descrestaurante\" value='" + descrip + "' readonly required>\n"
                                                    + "                    </div>\n"
                                                    + "                </div>\n"
                                                    + "                </div>\n"
                                                    + " <div class=\"panel-body\">  \n"
                                                    + "                <div class=\"form-group\">\n"
                                                    + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Direccion Restaurante</label>\n"
                                                    + "                    <div class=\"col-sm-10\">\n"
                                                    + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"direcrestaurante\" value='" + direc + "' readonly required>\n"
                                                    + "                    </div>\n"
                                                    + "                </div>\n"
                                                    + "                </div>\n"
                                                    + "                 <div class=\"form-group\">\n"
                                                    + "                <label class=\"control-label col-sm-2\" for=\"franchise\">" + nomf + "</label>\n"
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
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" hrf="menuPrincipal.jsp" class="btn btn-default">Menu</button>
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
