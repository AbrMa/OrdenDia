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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "AltaPedido", urlPatterns = {"/AltaPedido"})
public class AltaPedido extends HttpServlet {

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
            String plat = request.getParameter("Platillo");
             int cant = Integer.parseInt(request.getParameter("cantidad"));

            if (plat != null) {
                BD.cDatos sql = new BD.cDatos();
                try {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo3('" + plat + "');");

                    while (rsUsr.next()) {
                           HttpSession op = request.getSession();
                        String Rest = rsUsr.getString("idRestaurante");
                        String Nombre = rsUsr.getString("Nombre");
                       int Precio = rsUsr.getInt("Precio");
                        String id = (String) op.getAttribute("id");
                        int total;
                        total = Precio * cant;
                        out.println("<html lang=\"en\">\n"
                                + "    <head>\n"
                                + "        <title>Órden del Día</title>\n"
                                + "        <meta charset=\"utf-8\">\n"
                                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                                + " <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                                + "        <script src=\"js/bootstrap.min.js\"></script>\n"
                                + "        <link rel=\"shortcut icon\" href=\"css/tenedor.png\" />\n"
                                + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>"
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
                                + "                        <li><a href=\"menu.jsp\">Regresar</a></li>\n"
                                + "                    </ul>\n"
                                + "                </div>\n"
                                + "            </div>\n"
                                + "        </nav>\n"
                                + "        <!--Formulario-->\n"
                                + "        <div class=\"container\">\n"
                                + "            <center><h3>Pedido</h3></center>\n"
                                + "<h3>¿Está completamente seguro de Ordenar esto?</h3>\n"
                                + "            <hr>\n"
                                + "        </div>  \n"
                                + "        <div class=\"container\">\n"
                                + "            <form class=\"form-horizontal\" role=\"form\" method=\"post\" name=\"AltaPedido\" action=\"RegistrarPedido.jsp\">\n"
                                + "                <div class=\"form-group\">\n"
                                + "                        <label class=\"control-label col-sm-2\" for=\"franchise\">Nombre Platillo</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"text\" class=\"form-control\" id=\"franchise\" name=\"platillo\" value='" + Nombre + "' readonly required>\n"
                                 + "                        <input type=\"text\" hidden id=\"franchise\" name=\"idRest\" value='" + Rest + "' readonly required>\n"                               
                                 + "                        <input type=\"text\" hidden id=\"franchise\" name=\"Usr\" value='" + id + "' readonly required>\n"         
                                + "                        <input type=\"text\" hidden id=\"franchise\" name=\"idplat\" value='" + plat + "' readonly required>\n"         
                                   + "                        <input type=\"text\" hidden id=\"franchise\" name=\"cant\" value='" +cant + "' readonly required>\n" 
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">\n"
                                + "                        <label class=\"control-label col-sm-2\" for=\"franchiseDescription\">Costo Pedido</label>\n"
                                + "                    <div class=\"col-sm-10\">\n"
                                + "                        <input type=\"text\" class=\"form-control\" id=\"franchiseDescription\" name=\"precio\" readonly value='" + total  + "' required>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "                <div class=\"form-group\">        \n"
                                + "                    <div class=\"col-sm-offset-2 col-sm-10\">\n"
                                + "<button type=\"submit\" class=\"btn btn-danger\">Si</button>\n"
                                + "<button type=\"button\" href=\"menu.jsp\" class=\"btn btn-info\">No</button>\n"
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
                out.println("<script>alert('Por favor llene nigga nigga campos')</script>");
              //  out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/registrarPedido.jsp'/>");
                response.sendRedirect("registrarPedido.jsp");
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
