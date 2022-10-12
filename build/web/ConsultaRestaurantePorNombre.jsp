<%-- 
    Document   : ConsultaRestaurantePorNombre
    Created on : 27/04/2016, 11:14:13 AM
    Author     : Alumno
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <script type = "text/javascript">
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
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="menuPrincipal.jsp">Órden del Día</a>
                </div>
            </div>
        </nav>
        <!--Menú de Bienvenida-->
        <div class="container">
            <center><h3>Busqueda Restaurante</h3></center>
            <hr>
        </div>
        <div class="col-sm-5">
                
                <div class="panel panel-primary">
                    <div class="panel-heading">Buscar Restaurante</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" method="post" name="BorraRest" action="ConsulRestNom">
                            <div class="panel-body">
                                <label class="control-label col-sm-2" for="franchise">Nombre Restaurantes</label>
                                <div class="col-sm-10">
                                    <select class="form-control" NAME="restaurante" required>                    
                                        <%
                                            BD.cDatos sql = new BD.cDatos();
                                            try {
                                                sql.conectar();
                                                ResultSet rsUsr = sql.consulta("call sp_ConsultaRestauranteFull();");

                                                while (rsUsr.next()) {
                                                    String rest = rsUsr.getString("idRestaurante");
                                                    String nomf = rsUsr.getString("Nombre");
                                                    out.print("<option value=" + rest + ">" + nomf + "</option>\n");
                                                }
                                            } catch (SQLException error) {
                                                out.print(error.toString());
                                            }

                                        %>
                                    </select>
                                </div>
                            </div>
                            <div class="panel-body">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary">Buscar</button>
                                </div>
                            </div>
                        </form>
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

    </body>
</html>
