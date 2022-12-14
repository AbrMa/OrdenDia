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
@WebServlet(name = "BusquedaBajaPlatillo", urlPatterns = {"/BusquedaBajaPlatillo"})
public class BusquedaBajaPlatillo extends HttpServlet {

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
            String nom = request.getParameter("platillo");
            if (nom != null) {
                BD.cDatos sql = new BD.cDatos();
                try {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo3('" + nom + "');");

                    while (rsUsr.next()) {
                        String Nombre = rsUsr.getString("Nombre");
                        String Descrip = rsUsr.getString("descripcion");

                        out.println("<html lang=\"en\">\n"
                                + "    <head>\n"
                                + "        <title>??rden del D??a</title>\n"
                                + "        <meta charset=\"utf-8\">\n"
                                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                                + " <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                                + "        <script src=\"js/bootstrap.min.js\"></script>\n"
                                + "        <link rel=\"shortcut icon\" href=\"css/tenedor.png\" />\n"
                                + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>"
                                + "    </head>\n"
                                + "    <body>\n"
                                + "        <!--Men?? de Navegaci??n-->\n"
                                + "        <nav class=\"navbar navbar-default\">\n"
                                + "            <div class=\"container-fluid\">\n"
                                + "                <div class=\"navbar-header\">\n"
                                + "                    <a class=\"navbar-brand\" href=\"menuPrincipal.jsp\">??rden del D??a</a>\n"
                                + "                </div>\n"
                                + "                <div>\n"
                                + "                    <ul class=\"nav navbar-nav navbar-right\">\n"
                                + "                        <li><a href=\"menu.jsp\">Regresar</a></li>\n"
                                + "                    </ul>\n"
                                + "                </div>\n"
                                + "            </div>\n"
                                + "        </nav>\n"
                                + "        <!--Formulario-->\n"
                                + "        <div class=\"container\">\n"
                                + "            <center><h3>Eliminar Platillo</h3></center>\n"
                                + "<h3>??Est?? completamente seguro de Eliminar este Platillo?</h3>\n"
                                + "<h4>Este proceso es Irreversible</h4>\n"
                                + "            <hr>\n"
                                + "        </div>  \n"
                                + "        <div class=\"container\">\n"
                                + "            <form class=\"form-horizontal\" role=\"form\" method=\"post\" name=\"BajaPlatillo\" action=\"BorraPlatillo.jsp\">\n"
                                + "                <div class=\"form-group\">\n"
                                + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Nombre Platillo</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"nombre\" value='" + Nombre + "' readonly required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">\n"
                                + "                        <label class=\"control-label col-sm-2\" for=\"franchiseDescription\">Descripci??n Platillo</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"text\" class=\"form-control\" id=\"franchiseDescription\" name=\"descripcionPlatillo\" readonly value='" + Descrip + "' required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">        \n"
                                + "                    <div class=\"col-sm-offset-2 col-sm-10\">\n"
                                + "<button type=\"submit\" class=\"btn btn-danger\">Si</button>\n"
                                + "<button type=\"button\" onclick=\"location.href='menuRestaurante.jsp';\" class=\"btn btn-info\">No</button>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "            </form>\n"
                                + "        </div>\n"
                                + "\n"
                                + "    </body>\n"
                                + "</html>");
                    }
                } catch (SQLException error) {
                    out.print(error.toString());
                }

            } else {
                out.println("<script>alert('Por favor llene todos los campos')</script>");
                out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
                //response.sendRedirect("menu.jsp");
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
