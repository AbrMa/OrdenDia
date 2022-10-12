<%-- 
    Document   : registrar
    Created on : 10-dic-2015, 18:24:18
    Author     : Alejandro
--%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script language=JavaScript>
<!-- 

    function inhabilitar() {

        return false
    }
    function confirmar(){
        var contra1 = document.getElementById("contrasena").value;
        var contra2 = document.getElementById("Confcontrasena").value;
        
        
        if(contra2 !== contra1){
            alert("No coinciden las contraseñas");    
        }
        else{
            alert("Contraseña confirmada");
        }
    }

    document.oncontextmenu = inhabilitar

// --> 
</script>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Órden del Día</title>
        <script type = "text/javascript" src="js/validaciones.js">
        </script>
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
        <!--Menú de Navegación-->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">Órden del Día</a>
                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="iniciarSesion.html">Iniciar Sesión</a></li>
                        <li><a href="ConsultaRestaurante.jsp">Buscar Restaurante</a></li>
                        <li><a href="BusquedaRestauranteConsultaPlatillo.jsp">Buscar Platillo</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Formulario-->
        <div class="container">

            <center><h3>Registro</h3></center>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
                <div class="clearfix"></div>
                <h2 class="section-heading">Empieza Ahora</h2>
                <p class="lead">Una vez registrado podrás disfrutar de todos nuestros servicios.</p>
                
                <img class="img-responsive" src="css/ipad.jpg" alt="">
                
            </div>
            <div class="col-sm-5">
                <div class="panel panel-info">
                <div class="panel-heading">Registro de Usuario</div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" name="Alta" method="Post" Action="AltaUsuario.jsp">
                        <div class="panel-body">
                            <br>
                            <label class="control-label col-sm-2" for="address">Nombre</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name" name="nombre"  onkeypress="return letraVal(event)" maxlength="20" placeholder="Ingresa tu Nombre" required onpaste="return false;">
                            </div>
                        </div>
                        <div class="panel-body">
                            <label class="control-label col-sm-2" for="address">Dirección</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="address" name="direccion" maxlength="20" placeholder="Mar Mediterrano Popotla no 984" required>
                            </div>
                        </div>
                        <div class="panel-body">
                            <label class="control-label col-sm-2" for="email">Correo</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="email" name="correo" placeholder="ejemplo@gmail.com" required maxlength="30">
                            </div>
                        </div>
                        <div class="panel-body">
                            <label class="control-label col-sm-2" for="pwd">Contraseña:</label>
                            <div class="col-sm-10">          
                                <input type="password" class="form-control" id="contrasena" maxlength="20" name="pass" placeholder="Ingresa tu Contraseña" required>
                            </div>
                        </div>
                        <div class="panel-body">
                            <label class="control-label col-sm-2" for="pwd">Confirmar Contraseña:</label>
                            <div class="col-sm-10">          
                                <input type="password" class="form-control" id="Confcontrasena" maxlength="20" name="confpass" placeholder="Confirma tu Contraseña" onchange="confirmar()" required>
                            </div>
                        </div>
                        <div class="panel-body">
                            <label class="control-label col-sm-2" for="phone">Teléfono</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" name="telefono" maxlength="20" placeholder="8794568728"  onpaste="return false;" onkeypress="return solonumeros1(event)" required>
                            </div>
                        </div>
                        <div class="panel-body">
                            <label class="control-label col-sm-2" for="phone">Seleccionar Tipo de Teléfono</label>
                            <div class="col-sm-10">
                                <select class="form-control" NAME="tipo" required>
                                    
                                    <option value="1" >Casa</option>
                                    <option value="2">Célular</option>
                                    <option value="3">Oficina</option>
                                </select>
                            </div>
                        </div>
                        <DIV class="panel-body">
                            <center>
                                <%
                                    ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lcp1RITAAAAAFv2jML1T-o3uRYV28pjcfQBizrE", "6Lcp1RITAAAAAAPEqLCddJ424rJ0Q8ZlKn3JGwq0", false);
                                    out.print(c.createRecaptchaHtml(null, null));
                                %>
                            </center>
                        </div>
                        <div class="panel-body">        
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-info">Registrarse</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            </div>
            </div> 
            <div class="col-sm-1"></div>               
        </div>
    </body>
</html>
