<%-- 
    Document   : ConsultaRestaurante
    Created on : 27/04/2016, 10:52:07 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <div class="bannerMenuP">

            <div class="container">

                <div class="row">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-2">
                        <a href="ConsultaRestaurantePorNombre.jsp">
                            <center>
                                <font color="FF8783" size="5">
                                <i class="fa fa-fax fa-fw fa-5x"></i> <br>
                                </font>
                                <font color="white"><b><h2>Busqueda por nombre</h2></b></font>
                            </center>
                        </a>
                    </div>
                    <div class="col-sm-2">
                        <a href="ConsultaRestauranteFull.jsp">
                            <center>
                                <font color="1AB2A3" size="5">
                                <i class="fa fa-user fa-fw fa-5x"></i> <br>
                                </font>
                                <font color="white"><b><h2>Todos los Restaurantes</h2></b></font>
                            </center>
                        </a>
                    </div>
                    <div class="col-sm-4"></div>
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

        <a  name="contact"></a>
    </body>
</html>
