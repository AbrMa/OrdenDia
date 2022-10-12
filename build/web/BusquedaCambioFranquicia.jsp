<%-- 
    Doc
ument   : BusquedaCambioFranquicia
    Created on : 2/12/2015, 08:26:50 AM
    Author     : Alumno
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
            <center><h3>Buscar Franquicia</h3></center>
            <hr>
        </div>  
        <div class="container">
            <form class="form-horizontal" role="form" method="post" name="BorraFranq" action="BusquedaCambioFranquicia">
                <div class="form-group">
                        <label class="control-label col-sm-2" for="franchise">Nombre Franquicia</label>
                    <div class="col-sm-10">
                        <select class="form-control" NAME="franquicia" required>                    
                            <%
                                BD.cDatos sql = new BD.cDatos();
                                try {
                                    sql.conectar();
                                    ResultSet rsUsr = sql.consulta("call sp_ConsultaFranquicia2('"+id+"');");  

                                    while (rsUsr.next()) {
                                        String franq = rsUsr.getString("idFranquicia");
                                        String nomf = rsUsr.getString("Nombre");
                                        out.print("<option value=" + franq + ">" + nomf + "</option>\n");
                                    }
                                } catch (SQLException error) {
                                    out.print(error.toString());
                                }

                            %>
                        </select>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Buscar</button>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                      
                    </div>
                </div>
            </form>
        </div>
         <%} else {

            //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                response.sendRedirect("OrdenDia");
         %>
        <%            }
        %>
    </body>
</html>

