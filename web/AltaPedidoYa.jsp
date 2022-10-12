<%-- 
    Document   : AltaPedidoYa
    Created on : 10-dic-2015, 22:13:32
    Author     : Alejandro
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type = "text/javascript" src="js/validaciones.js">
        </script>
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
                    <a class="navbar-brand" href="menuPrincipal.jsp">Órden del Día</a>
                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><%out.print(user);%><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="CierraSesion">Cerrar Sesión</a></li>
                                <li><a href="UserNameServlet">Chat</a></li>
                                <li><a href="PreCambioUsuario.jsp">Cambiar Datos</a></li>
                                <li><a href="PreBajaUsuario.jsp">Dar de baja</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Buscar<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Buscar Platillo</a></li>
                                <li><a href="#">Buscar Restaurante</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" id="notif">Ordenes pendientes : *cargando*<span class="caret"></span></a>
                            <ul class="dropdown-menu" id="lista">

                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Formulario-->
        <div class="container">
            <center><h3>Realizar Pedido</h3></center>
            <hr>
        </div>  
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <div class="clearfix"></div>
                <h2 class="section-heading">Alta</h2>
                <p class="lead">A solo un paso de alegrar a tu estomago .</p>

                <img class="img-responsive" src="css/deli.jpg" alt="">

            </div>
            <div class="col-sm-5">
                <br>
                <div class="panel panel-success">
                    <div class="panel-heading">Platillo</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" name="Alta" method="Post" Action="AltaPedido">
                            <div class="panel-body">
                                <label class="control-label col-sm-2" for="phone">Platillo</label>
                                <div class="col-sm-10">
                                    <select class="form-control" NAME="Platillo" required>                    
                                        <%
                                            BD.cDatos sql = new BD.cDatos();
                                            try {
                                                sql.conectar();
                                                String rest = request.getParameter("restaurante");
                                                ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo2('" + rest + "');");

                                                while (rsUsr.next()) {
                                                    String plat = rsUsr.getString("idPlatillo");
                                                    String nomf = rsUsr.getString("Nombre");
                                                    out.print("<option value=" + plat + ">" + nomf + "</option>\n");
                                                }
                                            } catch (SQLException error) {
                                                out.print(error.toString());
                                            }

                                        %>
                                    </select>
                                    <div class="panel-body">
                                        <label class="control-label col-sm-2" for="dishDescription">Cantidad</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="cantidad" name="cantidad" placeholder="1" onkeypress="return solonumeros1(event)"  required>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">        
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-success">Ordenar</button>
                                    </div>
                                </div>

                            </div>
                        </form>

                    </div>
                </div>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <%            
            String rest = request.getParameter("restaurante");
            
            
            out.print("<div class='container'><center><h3>Platillos</h3></center><hr></div>"
                    + "<div class='container'>");
            try {
                sql.conectar();
                ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo2('" + rest + "');");
                int contador = 0;
                while (rsUsr.next()) {
                    String plat = rsUsr.getString("idPlatillo");
                    String nomf = rsUsr.getString("Nombre");
                    String descrip = rsUsr.getString("Descripcion");
                    String prec = rsUsr.getString("Precio");

                    if (contador == 0) {
                        out.print("<div class='row'>");
                    }
                    out.print("<div class='col-sm-3'>"
                            + "<a class='thumbnail' href='#'>"
                            + "<img class='img-responsive imagenSucha' src='" + request.getContextPath() + "/" + rsUsr.getString("foto") + "'>"
                            + "<center><p><b>" + nomf + "</b></p>"
                            + "<p>" + descrip + "</p><p>$ " + prec + "</p></center>"
                            + "</a>"
                            + "</div>");

                    contador++;
                    if (contador == 4) {
                        out.print("</div>");
                        contador = 0;

                    }

                }
                out.print("</div>");
            } catch (SQLException error) {
                out.print(error.toString());
            }

        %>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p class="copyright text-muted small">Copyright &copy;  GreenNote 2015. All Rights Reserved</p>
                    </div>
                </div>
            </div>
        </footer>
        <%} else {

            //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
            response.sendRedirect("menuUsuarioCliente.jsp");
        %>
        <%            }
        %>
    </body>
</html>
