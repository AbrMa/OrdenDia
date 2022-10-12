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

/**
 *
 * @author luigi
 */
@WebServlet(name = "AltaRestaurante", urlPatterns = {"/AltaRestaurante"})
public class AltaRestaurante extends HttpServlet {

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
            out.println("<!DOCTYPE html>\n"
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
                    + "            <form action=\"AltaRestaurante2\" method=\"post\">\n"
                    + "            <h1>Agregar un nuevo restaurante</h1>\n"
                    + "            <br>\n"
                    + "            <center>\n"
                    + "                <table class=\"table-registro\">\n"
                    + "                    <tr><td class=\"td-label\">Nombre:</td><td class=\"td-input\"><input maxlength=\"120\" required name=\"nombre\" class=\"input-all\"></td></tr>\n"
                    + "                    <tr><td class=\"td-label\">Lugar:</td><td class=\"td-input\"><div id=\"mapa\" class=\"mapa-div\"></div></td></tr>\n"
                    + "                    <tr><td class=\"td-label\">Horario de abrir:</td><td class=\"td-input\"><input type=\"time\" required name=\"hr_ab\" class=\"input-all\"></td></tr>\n"
                    + "                    <tr><td class=\"td-label\">Horario de cerrar:</td><td class=\"td-input\"><input type=\"time\" required name=\"hr_cer\" class=\"input-all\"></td></tr>\n"
                    + "                    <tr><td class=\"td-label\">Telefono:</td><td class=\"td-input\"><input required type=\"number\" name=\"telefono\" class=\"input-all\"></td></tr>\n"
                    + "                    <tr><td class=\"td-label\"></td><td class=\"td-input\"><input type=\"submit\" value=\"Guardar\" class=\"input-all\"></td></tr>\n"
                    + "                </table>\n"
                    + "            </center>\n"
                    + "            <input id=\"cx\" name=\"coox\" hidden>\n"
                    + "            <input id=\"cy\" name=\"cooy\" hidden>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
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
