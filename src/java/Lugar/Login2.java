/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lugar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luigi
 */
@WebServlet(name = "SesionUsuario", urlPatterns = {"/SesionUsuario"})
public class Login2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();

            String correo = (String) request.getParameter("correo");
            String pass = (String) request.getParameter("pass");
            if (correo.equals("prueba@gmail.com") && pass.equals("123")) {
                out.print("<!DOCTYPE html>\n"
                        + "<!--\n"
                        + "To change this license header, choose License Headers in Project Properties.\n"
                        + "To change this template file, choose Tools | Templates\n"
                        + "and open the template in the editor.\n"
                        + "-->\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>Órden del Día</title>\n"
                        + "        <meta charset=\"utf-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>\n"
                        + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n"
                        + "        <link rel=\"shortcut icon\" href=\"css/tenedor.png\" />\n"
                        + "        <script src='http://maps.googleapis.com/maps/api/js'></script>\n"
                        + "        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>\n"
                        + "        <style>\n"
                        + "            html, body{\n"
                        + "                width: 100%;\n"
                        + "                height: 100%;\n"
                        + "            }\n"
                        + "\n"
                        + "            .contextmenu{\n"
                        + "                visibility:hidden;\n"
                        + "                background:#ffffff;\n"
                        + "                border:1px solid #8888FF;\n"
                        + "                z-index: 1;  \n"
                        + "                position: relative;\n"
                        + "                width: 200px;\n"
                        + "            }\n"
                        + "\n"
                        + "            //Menu en el mapa\n"
                        + "            .contextmenu div{\n"
                        + "            }\n"
                        + "            #div-map{\n"
                        + "                margin: 0;\n"
                        + "                border: transparent;\n"
                        + "            }\n"
                        + "            #div-link{\n"
                        + "                text-decoration: none;  \n"
                        + "            }\n"
                        + "            #div-context{\n"
                        + "                margin: 0;\n"
                        + "                padding: 5%;\n"
                        + "                border: transparent;\n"
                        + "            }\n"
                        + "            .table-registro{\n"
                        + "                width: 80%;\n"
                        + "\n"
                        + "            }\n"
                        + "            .td-label{\n"
                        + "                width: 15%;\n"
                        + "                padding: 2%;\n"
                        + "                height: auto;\n"
                        + "            }\n"
                        + "            .td-input{\n"
                        + "                width: 77%;\n"
                        + "                padding: 2%;\n"
                        + "                height: auto;\n"
                        + "            }\n"
                        + "            .input-all{\n"
                        + "                width: 100%;\n"
                        + "            }\n"
                        + "            .mapa-div{\n"
                        + "                width: 100%;\n"
                        + "                height: 200px;\n"
                        + "            }\n"
                        + "\n"
                        + "        </style>\n"
                        + "        <script>\n"
                        + "            var map;\n"
                        + "            var coordenadax = '19.432388';\n"
                        + "            var coordenaday = '-99.133244';\n"
                        + "            var click = new google.maps.Marker({\n"
                        + "                icon: 'http://i.imgur.com/4gh1tVv.png'\n"
                        + "            });\n"
                        + "            function initMap() {\n"
                        + "                map = new google.maps.Map(document.getElementById('mapa'), {\n"
                        + "                    center: {lat: 19.432388, lng: -99.133244},\n"
                        + "                    zoom: 14,\n"
                        + "                    mapTypeId: google.maps.MapTypeId.ROADMAP\n"
                        + "\n"
                        + "                });\n"
                        + "                click.setMap(map);\n"
                        + "\n"
                        + "\n"
                        + "                // Try HTML5 geolocation.\n"
                        + "                if (navigator.geolocation) {\n"
                        + "                    navigator.geolocation.getCurrentPosition(function (position) {\n"
                        + "                        var pos = {\n"
                        + "                            lat: position.coords.latitude,\n"
                        + "                            lng: position.coords.longitude\n"
                        + "                        };\n"
                        + "\n"
                        + "                        map.setCenter(pos);\n"
                        + "                        coordenadax = pos.lat;\n"
                        + "                        coordenaday = pos.lng;\n"
                        + "                        var gps = new google.maps.Marker({\n"
                        + "                            icon: 'http://i.imgur.com/q6fRcjs.png'\n"
                        + "                        });\n"
                        + "\n"
                        + "                        gps.setMap(map);\n"
                        + "                        gps.setPosition(pos);\n"
                        + "                        google.maps.event.addListener(gps, 'rightclick', function (event) {\n"
                        + "                            showContextMenu(event.latLng, mapdivmenu);\n"
                        + "                            coordenadax = event.latLng.lat();\n"
                        + "                            coordenaday = event.latLng.lng();\n"
                        + "                        });\n"
                        + "\n"
                        + "                    }, function () {\n"
                        + "                    });\n"
                        + "                } else {\n"
                        + "                }\n"
                        + "\n"
                        + "                google.maps.event.addListener(map, 'click', function (event) {\n"
                        + "                    click.setPosition(event.latLng);\n"
                        + "                    $('.contextmenu').remove();\n"
                        + "                    document.getElementById('cx').value = event.latLng.lat();\n"
                        + "                    document.getElementById('cy').value = event.latLng.lng();\n"
                        + "                });\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "            }\n"
                        + "\n"
                        + "\n"
                        + "            function showContextMenu(currentPosition, contxt) {\n"
                        + "                var projection;\n"
                        + "                var contextmenuDir;\n"
                        + "                projection = map.getProjection();\n"
                        + "                $('.contextmenu').remove();\n"
                        + "                contextmenuDir = document.createElement('div');\n"
                        + "                contextmenuDir.className = 'contextmenu';\n"
                        + "                contextmenuDir.id = 'div-map';\n"
                        + "                contextmenuDir.innerHTML = contxt;\n"
                        + "                $(map.getDiv()).append(contextmenuDir);\n"
                        + "                var mapWidth = $('#mapa').width();\n"
                        + "                var mapHeight = $('#mapa').height();\n"
                        + "                var menuWidth = $('.contextmenu').width();\n"
                        + "                var menuHeight = $('.contextmenu').height();\n"
                        + "                var scale = Math.pow(2, map.getZoom());\n"
                        + "                var nw = new google.maps.LatLng(\n"
                        + "                        map.getBounds().getNorthEast().lat(),\n"
                        + "                        map.getBounds().getSouthWest().lng()\n"
                        + "                        );\n"
                        + "                var worldCoordinateNW = map.getProjection().fromLatLngToPoint(nw);\n"
                        + "                var worldCoordinate = map.getProjection().fromLatLngToPoint(currentPosition);\n"
                        + "                var currentPositionOffset = new google.maps.Point(\n"
                        + "                        Math.floor((worldCoordinate.x - worldCoordinateNW.x) * scale),\n"
                        + "                        Math.floor((worldCoordinate.y - worldCoordinateNW.y) * scale)\n"
                        + "                        );\n"
                        + "                var clickedPosition = currentPositionOffset;\n"
                        + "                var x = clickedPosition.x;\n"
                        + "                var y = clickedPosition.y;\n"
                        + "\n"
                        + "                if ((mapWidth - x) < menuWidth)\n"
                        + "                    x = x - menuWidth;\n"
                        + "                if ((mapHeight - y) < menuHeight)\n"
                        + "                    y = y - menuHeight;\n"
                        + "                $('.contextmenu').css('left', x);\n"
                        + "                $('.contextmenu').css('top', y);\n"
                        + "                contextmenuDir.style.visibility = 'visible';\n"
                        + "            }\n"
                        + "            google.maps.event.addDomListener(window, 'load', initMap);\n"
                        + "        </script>\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "        <div class=\"all-div\">\n"
                        + "            \n"
                        + "        <nav class=\"navbar navbar-default\">\n"
                        + "            <div class=\"container-fluid\">\n"
                        + "                <div class=\"navbar-header\">\n"
                        + "                    <a class=\"navbar-brand\" href=\"menuPrincipal.jsp\">Órden del Día</a>\n"
                        + "                </div>\n"
                        + "                <div>\n"
                        + "                    <ul class=\"nav navbar-nav navbar-right\">\n"
                        + "                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Amahury<span class=\"caret\"></span></a>\n"
                        + "                            <ul class=\"dropdown-menu\">\n"
                        + "                                <li><a href=\"CierraSesion\">Cerrar Sesión</a></li>\n"
                        + "                                <li><a href=\"AltaRestaurante\">AltaRestaurante</a></li>\n"
                        + "                                <li><a href=\"PreCambioUsuario.jsp\">Cambiar Datos</a></li>\n"
                        + "                                <li><a href=\"PreBajaUsuario.jsp\">Dar de baja</a></li>\n"
                        + "                            </ul>\n"
                        + "                        </li>\n"
                        + "                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Buscar<span class=\"caret\"></span></a>\n"
                        + "                            <ul class=\"dropdown-menu\">\n"
                        + "                                <li><a href=\"#\">Buscar Platillo</a></li>\n"
                        + "                                <li><a href=\"MapaRestaurantes\">Buscar Restaurante</a></li>\n"
                        + "                            </ul>\n"
                        + "                        </li>\n"
                        + "                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" id=\"notif\">Ordenes pendientes : *cargando*<span class=\"caret\"></span></a>\n"
                        + "                            <ul class=\"dropdown-menu\" id=\"lista\">\n"
                        + "\n"
                        + "                            </ul>\n"
                        + "                        </li>\n"
                        + "                    </ul>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </nav>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "        <!-- Cabecera -->\n"
                        + "        <a name=\"about\"></a>\n"
                        + "        <div class=\"intro-header\">\n"
                        + "            <div class=\"container\">\n"
                        + "\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-lg-12\">\n"
                        + "                        <div class=\"intro-message\">\n"
                        + "                            <h1>A la Órden del Día</h1>\n"
                        + "                            <h3>La nueva manera de pedir comida a domicilio</h3>\n"
                        + "                            <hr class=\"intro-divider\">\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "        <a  name=\"services\"></a>\n"
                        + "        <div class=\"content-section-a\">\n"
                        + "\n"
                        + "            <div class=\"container\">\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-lg-5 col-sm-6\">\n"
                        + "                        <hr class=\"section-heading-spacer\">\n"
                        + "                        <div class=\"clearfix\"></div>\n"
                        + "                        <h2 class=\"section-heading\">Una nueva manera de ordenar comida y hacer reservaciones</h2>\n"
                        + "                        <p class=\"lead\">Con \"A la Órden del Día\" podrás pedir comida a tu domicilio de manera sencilla. </p>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col-lg-5 col-lg-offset-2 col-sm-6\">\n"
                        + "                        <img class=\"img-responsive\" src=\"css/ordenar.jpg\" alt=\"\">\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "\n"
                        + "        <div class=\"content-section-b\">\n"
                        + "\n"
                        + "            <div class=\"container\">\n"
                        + "\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6\">\n"
                        + "                        <hr class=\"section-heading-spacer\">\n"
                        + "                        <div class=\"clearfix\"></div>\n"
                        + "                        <h2 class=\"section-heading\">Descubre</h2>\n"
                        + "                        <p class=\"lead\">Encuentra un nuevo lugar favorito para comer cerca de ti y prueba algo distinto cada día.</p>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col-lg-5 col-sm-pull-6  col-sm-6\">\n"
                        + "                        <img class=\"img-responsive\" src=\"css/descubre.jpg\" alt=\"\">\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "        <div class=\"content-section-a\">\n"
                        + "\n"
                        + "            <div class=\"container\">\n"
                        + "\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-lg-5 col-sm-6\">\n"
                        + "                        <hr class=\"section-heading-spacer\">\n"
                        + "                        <div class=\"clearfix\"></div>\n"
                        + "                        <h2 class=\"section-heading\">Administra tu negocio</h2>\n"
                        + "                        <p class=\"lead\">Nuestro software ofrece las herramientas necesarias para administrar tu negocio, ya sea grande o chico.</p>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col-lg-5 col-lg-offset-2 col-sm-6\">\n"
                        + "                        <img class=\"img-responsive\" src=\"css/administra.jpg\" alt=\"\">\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "\n"
                        + "\n"
                        + "        </div>\n"
                        + "<div class=\"content-section-b\">\n"
                        + "\n"
                        + "            <div class=\"container\">\n"
                        + "\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-lg-5 col-sm-6\">\n"
                        + "                        <hr class=\"section-heading-spacer\">\n"
                        + "                        <div class=\"clearfix\"></div>\n"
                        + "                        <h2 class=\"section-heading\">Soporte Técnico</h2>\n"
                        + "                        <p class=\"lead\">¿El sistema no ha funcionado? <a href=\"soporte.jsp\">Solucionalo Aquí</a></p>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col-lg-5 col-lg-offset-2 col-sm-6\">\n"
                        + "                        <img class=\"img-responsive\" src=\"css/soporte.jpg\" alt=\"\">\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "            <br><br>\n"
                        + "\n"
                        + "        <a  name=\"contact\"></a>\n"
                        + "        <div class=\"banner\">\n"
                        + "\n"
                        + "            <div class=\"container\">\n"
                        + "\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-lg-6\">\n"
                        + "                        <h2>Comienza ahora:</h2>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col-lg-6\">\n"
                        + "                        <ul class=\"list-inline banner-social-buttons\">\n"
                        + "                            <li>\n"
                        + "                                <a href=\"ConsultaRestaurante.jsp\" class=\"btn btn-success btn-lg\"><i class=\"fa fa-search fa-fw\"></i> <span class=\"network-name\">Buscar Restaurante</span></a>\n"
                        + "                            </li>\n"
                        + "                            <li>\n"
                        + "                                <a href=\"BusquedaRestauranteConsultaPlatillo.jsp\" class=\"btn btn-success btn-lg\"><i class=\"fa fa-spoon fa-fw\"></i> <span class=\"network-name\">Buscar Platillo</span></a>\n"
                        + "                            </li>\n"
                        + "                        </ul>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "        <footer>\n"
                        + "            <div class=\"container\">\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-lg-12\">\n"
                        + "                        <p class=\"copyright text-muted small\">Copyright &copy;  GreenNote 2015. All Rights Reserved</p>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </footer>\n"
                        + "        </div>\n"
                        + "    </body>\n"
                        + "</html>\n"
                        + "");

            } else {
                out.print("<script>alert('Usuario o contraseña incorrectos');location.replace('iniciarSesion.html');</script>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
