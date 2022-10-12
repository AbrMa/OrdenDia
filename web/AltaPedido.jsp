<%-- 
    Document   : AltaPedido
    Created on : 10-dic-2015, 22:10:41
    Author     : Alejandro
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <script type = "text/javascript">
        </script>
        <meta charset="utf-8">
        <link href="css/thumbnail-gallery.css" rel="stylesheet">
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
                    </ul>
                </div>
            </div>
        </nav>
        <!--Formulario-->
        <div class="container">
            <center><h3>Buscar Restaurante</h3></center>
            <hr>
        </div>  
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <div class="clearfix"></div>
                <h2 class="section-heading">Buscar</h2>
                <p class="lead">Localiza alguno de tus restaurantes para ordenar comida .</p>

                <img class="img-responsive" src="css/restaurantes.jpg" alt="">

            </div>
            <div class="col-sm-5">
                <br>
                <div class="panel panel-success">
                    <div class="panel-heading">Buscar Restaurante</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" method="post" name="Pedido" action="AltaPedidoYa.jsp">
                            <div class="panel-body">
                                <label class="control-label col-sm-2" for="franchise">Seleccione un restaurante</label>
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
                                    <button type="submit" class="btn btn-success">Seleccionar</button>
                                </div>
                            </div>
                            <div class="panel-body">        
                                <div class="col-sm-offset-2 col-sm-10">

                                </div>
                            </div>
                        </form>


                    </div>
                </div>
            </div>

            <div class="col-sm-1"></div>
        </div>
        <div><br></div>
        <div class="container">
            <hr>
        </div>  
        <div class="container">
            
            <%
                                try{
                                    sql.conectar();
                                    ResultSet rsUsr = sql.consulta("call sp_ConsultaRestauranteFull();");  
                                    int contador = 0;
                                    while (rsUsr.next()) {
                                         String descrip = rsUsr.getString("Descripcion");
                                        String nomf = rsUsr.getString("Nombre");
                                        String img = rsUsr.getString("foto");
                                        String direc = rsUsr.getString("Direccion");
                                        
                                        if(contador ==0){
                                            out.print("<div class='row'>");
                                        }
                                        out.print("<div class='col-sm-3'>"
                                                +"<a class='thumbnail' href='#'>"
                                                +"<img class='img-responsive imagenSucha' src='"+ request.getContextPath()+"/"+ rsUsr.getString("foto")+"'>"
                                                +"<center><p><b>"+nomf+"</b></p>"
                                                +"<p>"+descrip+"</p><p>"+direc+"</p></center>"
                                                +"</a>"
                                                +"</div>");
                                        
                                        contador++;
                                        if(contador == 4){
                                            out.print("</div>");
                                            contador = 0;
                                        }
                                    
                           
                                         }
                                } catch (SQLException error) {
                                    out.print(error.toString());
                                }

                           
                            %>

            
        </div>
        
        <!--
        <div class="container">
            <form class="form-horizontal" role="form" method="post" name="BorraRest" action="#">
                <div class="form-group">
                    <div class="col-sm-10">
                            <%
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
        -->
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
            response.sendRedirect("menuUsuarioCliente.jsp");
            //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
        %>
        <%            }
        %>
    </body>
</html>

