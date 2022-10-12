<%-- 
    Document   : Correo
    Created on : 10/12/2015, 08:00:56 PM
    Author     : Amahury
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Órden del Día</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="shortcut icon" href="css/tenedor.png" />
        <!--Con Internet
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        -->
    </head>
    <body>
          <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="menuPrincipal.jsp">Órden del Día</a>
                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.html">Regresar</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    <div class="container">
        <div class="container">
            <center><h3>Recuperar Contraseña</h3></center>
            <hr>
        </div> 
            <form class="form-horizontal" role="form" name="Alta" method="Post" Action="Mail">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="phone">Correo</label>
                        <div class="col-sm-10">
                        <input type="text" class="form-control" id="address" name="mail"  placeholder="correo@gmail.com" required>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <center> <button type="submit" class="btn btn-default">Enviar</button></center>
                    </div>
                </div>        
            </form>
        </div>
    </body>
</html>
