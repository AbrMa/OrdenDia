<%-- 
    Document   : buscarPlatilloModificar
    Created on : 5/12/2015, 03:39:18 PM
    Author     : Carmen
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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
            if (user != null && pass != null && id != null && nom != null && tel != null && tip != null && dir != null) {
        %>
        <!--Menú de Navegación-->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">Órden del Día</a>
                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="registrar.html">Registrarse</a></li>
                        <li><a href="iniciarSesion.html">Iniciar Sesión</a></li>
                        <li><a href="buscarRestaurante.html">Buscar Restaurante</a></li>
                        <li><a href="buscarPlatillo.html">Buscar Platillo</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Formulario-->
        <div class="container">
            <center><h3>Modificar Platillo</h3></center>
            <hr>
        </div>  
        <div class="container">
            <form class="form-horizontal" role="form" name="modificar" method="Post" Action="AltaPlatillo">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="phone">Platillo</label>
                    <div class="col-sm-10">
                        <select class="form-control" NAME="platillo" required>                    
                            <%
                                BD.cDatos sql = new BD.cDatos();
                                try {
                                    sql.conectar();
                                    ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo2('"+id+"');");  

                                    while (rsUsr.next()) {
                                        String plati = rsUsr.getString("idPlatillo");
                                        String nomf = rsUsr.getString("Nombre");
                                        out.print("<option value=" + plati + ">" + nomf + "</option>\n");
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
                        <a href="modificarPlatillo2.html"><button type="button" class="btn btn-warning">Botón Provisional Avanzar Modificar Platillo</button></a>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <a href="menuRestaurante.html"><button type="button" class="btn btn-warning">Botón Provisional Menú Restaurante</button></a>
                    </div>
                </div>
            </form>
        </div>
        <%} else {

            //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8084/OrdenDia1.1/'/>");
                response.sendRedirect("OrdenDia");
        %>
        <%            }
        %>
    </body>
</html>
