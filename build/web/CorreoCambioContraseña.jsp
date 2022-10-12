<%-- 
    Document   : CorreoCambioContraseña
    Created on : 11/12/2015, 10:50:01 AM
    Author     : Alumno
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
    <div class="container">
        <div class="container">
            <center><h3>Recuperar Contraseña </h3></center>
            <hr>
        </div> 
            <form class="form-horizontal" role="form" name="Alta" method="Post" Action="CorreoCambioMail.jsp">
                <%          
                                String contra = request.getParameter("m");
                %>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd">Nueva Contraseña:</label>
                    <div class="col-sm-10">  
                        <input type="password" class="form-control" id="contrasena" name="pass1" placeholder="Ingresa tu Contraseña" required>
                    </div>
                </div>
                <input type="hidden" name="compara" value="<%=contra%>">
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Enviar</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html> 
