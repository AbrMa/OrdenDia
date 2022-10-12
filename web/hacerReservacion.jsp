
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
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
                                <li><a href="BusquedaRestauranteConsultaPlatillo.jsp">Buscar Platillo</a></li>
                                <li><a href="ConsultaRestaurante.jsp">Buscar Restaurante</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Formulario-->
        <div class="container">
            <center><h3>Hacer Reservación</h3></center>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <div class="clearfix"></div>
                <h2 class="section-heading">Bienvenido</h2>
                <p class="lead">Con a la Orden del Día podrás administrar restaurantes y ordenar comida desde la comodidad de tu casa .</p>
                
                <img class="img-responsive" src="css/hamburger.jpg" alt="">
                
            </div>
            <div class="col-sm-5">
                <br>
                <div class="panel panel-success">
                     <div class="panel-heading">Iniciar Sesión de Usuario</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" name="Alta" method="Post" Action="AltaReservacion">
                <div class="panel-body">
                    <label class="control-label col-sm-2" for="phone">Restaurante</label>
                    <div class="col-sm-10">
                        <input type="password" value="<%out.print(id);%>" hidden id="franchise" name="id"  required readonly>
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
                    <label class="control-label col-sm-2" for="hour">Hora</label>
                    <div class="col-sm-10">
                        <select class="panel-body" NAME="hora" required>
                            <option value="0">Selecciona Una Opción</option>
                            <option value="10">10 hrs.</option>
                            <option value="11">11 hrs.</option>
                            <option value="12">12 hrs.</option>
                            <option value="13">13 hrs.</option>
                            <option value="14">14 hrs.</option>
                            <option value="15">15 hrs.</option>
                            <option value="16">16 hrs.</option>
                            <option value="17">17 hrs.</option>
                            <option value="18">18 hrs.</option>
                            <option value="19">19 hrs</option>
                            <option value="20">20 hrs</option>
                            <option value="21">21 hrs.</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body">
                    <label class="control-label col-sm-2" for="minute">Minuto</label>
                    <div class="col-sm-10">
                        <select class="panel-body" NAME="minuto" required>
                            <option value="0">Selecciona Una Opción</option>
                            <option value="5">5 min.</option>
                            <option value="15">15 min.</option>
                            <option value="20">20 min.</option>
                            <option value="25">25 min.</option>
                            <option value="30">30 min.</option>
                            <option value="35">35 min.</option>
                            <option value="40">40 min.</option>
                            <option value="45">45 min.</option>
                            <option value="50">50 min.</option>
                            <option value="55">55 min.</option>
                        </select>
                    </div>
                </div>
                <div class="panel-body">
                    <label class="control-label col-sm-2" for="fecha">Fecha</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="fecha" name="fecha" placeholder="24/12/15" required>
                    </div>
                </div>
                <div class="panel-body">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Reservar</button>
                    </div>
                </div>

            </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="container">
            
        </div>
        <%} else {

            // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8084/OrdenDia1.1/'/>");
                response.sendRedirect("menuUsuarioCliente.jsp");
        %>
        <%            }
        %>
    </body>
</html>
