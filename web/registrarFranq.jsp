<%-- 
    Document   : registrarFranq
    Created on : 27/11/2015, 10:51:43 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
          <%
         
            String user = (String) session.getAttribute("varUsuario");
            String pass = (String) session.getAttribute("Pass");
            String id = (String) session.getAttribute("id");
            String nom = (String) session.getAttribute("nombre");
            String tel = (String) session.getAttribute("Telefono");
            String tip = (String) session.getAttribute("Tipo");
            String dir = (String) session.getAttribute("Direc");
            if (user != null && pass !=null && id !=null && nom !=null && tel !=null && tip !=null && dir !=null) {
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
            <center><h3>Registrar Franquicia</h3></center>
            <hr>
        </div>  
        <div class="container">
            <form class="form-horizontal" role="form" method="post" name="AltaFranq" action="AltaFranquicia">
               
                <div class="form-group">
                        <label class="control-label col-sm-2" for="franchise">Nombre Franquicia</label>
                    <div class="col-sm-10">
                        <input type="password" value="<%out.print(id);%>" hidden id="franchise" name="id" readonly  required>
                        <input type="text" class="form-control" id="franchise" name="franquicia" placeholder="Helados Holanda" required>
                    </div>
                </div>
                <div class="form-group">
                        <label class="control-label col-sm-2" for="franchiseDescription">Descripción Franquicia</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="franchiseDescription" name="descripcionFranquicia" placeholder="Helados muy Ricos" required>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Registrar</button>
                    </div>
                </div>
                
            </form>
        </div>
   <%} else {

                //   out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                response.sendRedirect("OrdenDia");
        %>
   
    <%            }
    %>
    </body>
</html>
