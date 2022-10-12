/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReglasNegocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "BusquedaCambioUsuario", urlPatterns = {"/BusquedaCambioUsuario"})
public class BusquedaCambioUsuario extends HttpServlet {

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
            String correo = request.getParameter("correo");
            String pass = request.getParameter("pass");
            if (correo != null && pass != null) {
                BD.cDatos sql = new BD.cDatos();
                try {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call st_consultasUsuario('" + correo + "','" + pass + "');");

                    while (rsUsr.next()) {
                        String Nombre=rsUsr.getString("Nombre");
                        String Direccion=rsUsr.getString("Direccion");
                        String Correo=rsUsr.getString("Correo");
                        String Pass=rsUsr.getString("Pass");
                        String Telefono=rsUsr.getString("Telefono");
                        String Descripcion=rsUsr.getString("Descripción");
                        out.println("<html lang=\"en\">\n"
                                + "    <head>\n"
                                + "        <title>Órden del Día</title>\n"
                                + "        <meta charset=\"utf-8\">\n"
                                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                                + "        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n"
                                + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n"
                                + "        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n"
                                + "    </head>\n"
                                + "    <body>\n"
                                + "        <!--Menú de Navegación-->\n"
                                + "        <nav class=\"navbar navbar-default\">\n"
                                + "            <div class=\"container-fluid\">\n"
                                + "                <div class=\"navbar-header\">\n"
                                + "                    <a class=\"navbar-brand\" href=\"menuPrincipal.jsp\">Órden del Día</a>\n"
                                + "                </div>\n"
                                + "                <div>\n"
                                + "                    <ul class=\"nav navbar-nav navbar-right\">\n"
                                + "                        <li><a href=\"menu.jsp.\">Regresar</a></li>\n"
                                + "                    </ul>\n"
                                + "                </div>\n"
                                + "            </div>\n"
                                + "        </nav>\n"
                                + "        <!--Formulario-->\n"
                                + "        <div class=\"container\">\n"
                                + "         \n"
                                + "            <center><h3>Cambio</h3></center>\n"
                                + "            <hr>\n"
                                + "        </div>\n"
                                + "        <div class=\"container\">\n"
                                + "            <form class=\"form-horizontal\" role=\"form\" name=\"CambioUsuario\" method=\"Post\" Action=\"CambioUsuario.jsp\">\n"
                                + "                <div class=\"form-group\">\n"
                                + "                    <label class=\"control-label col-sm-2\" for=\"name\">Nombre</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"text\" class=\"form-control\" id=\"name\" name=\"nombre\" value="+Nombre+" required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">\n"
                                + "                    <label class=\"control-label col-sm-2\" for=\"address\">Dirección</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"text\" class=\"form-control\" id=\"address\" value="+Direccion+" name=\"direccion\" placeholder=\"Mar Mediterrano Popotla no 984\" required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">\n"
                                + "                    <label class=\"control-label col-sm-2\" for=\"email\">Correo</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"email\" class=\"form-control\" id=\"email\" value="+Correo+" name=\"correo\" placeholder=\"ejemplo@gmail.com\" required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">\n"
                                + "                    <label class=\"control-label col-sm-2\" for=\"pwd\">Contraseña:</label>\n"
                                + "                    <div class=\"col-sm-10\">          \n"
                                + "                        <input type=\"password\" class=\"form-control\" value="+Pass+" id=\"contrasena\" name=\"pass\" placeholder=\"Ingresa tu Contraseña\" required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">\n"
                                + "                    <label class=\"control-label col-sm-2\" for=\"phone\">Teléfono</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"text\" class=\"form-control\" id=\"phone\"  disabled value="+Telefono+" name=\"telefono\" placeholder=\"8794568728\" required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">\n"
                                + "                    <label class=\"control-label col-sm-2\" for=\"phone\">Tipo de Teléfono</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <select class=\"form-control\" value=Cambiar"+Descripcion+" NAME=\"tipo\" required>\n"
                                + "                            <optionvalue=Cambiar"+Descripcion+">Selecciona Una Opción</option>\n"
                                + "                            <option value=\"1\" >Casa</option>\n"
                                + "                            <option value=\"2\">Célular</option>\n"
                                + "                            <option value=\"3\">Oficina</option>\n"
                                + "                        </select>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">        \n"
                                + "                    <div class=\"col-sm-offset-2 col-sm-10\">\n"
                                + "                        <button type=\"submit\" class=\"btn btn-default\">Cambiar</button>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "            </form>\n"
                                + "        </div>\n"
                                + "    </body>\n"
                                + "</html>");
                    }
                } catch (SQLException error) {
                    out.print(error.toString());
                }

            } else {
                out.println("<script>alert('Por favor llene todos los campos')</script>");
               // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                response.sendRedirect("OrdenDia");
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
