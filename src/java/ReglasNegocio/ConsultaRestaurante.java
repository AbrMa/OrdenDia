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
 * @author Amahury
 */
@WebServlet(name = "ConsultaRestaurante", urlPatterns = {"/ConsultaRestaurante"})
public class ConsultaRestaurante extends HttpServlet {

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
              String nombre = request.getParameter("restaurante");
              
            if(nombre!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_ConsultaRestaurante('"+nombre+"');");
                      
                    
                   while (rsUsr.next()) {
                        String Nombre=rsUsr.getString("Nombre");
                        String Descrip=rsUsr.getString("descripcion");
                        
                       out.println("<html lang=\"en\">\n"
                               + "    <head>\n"
                               + "        <title>??rden del D??a</title>\n"
                               + "        <meta charset=\"utf-8\">\n"
                               + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                               + "        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n"
                               + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n"
                               + "        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n"
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
                               + "            <center><h3>Consulta Restaurante</h3></center>\n"
                               + "        </div>  \n"
                               + "        <div class=\"container\">\n"
                               + "          <div class=\"panel panel-info\">\n"
                               + "                <div class=\"panel-heading\">" + Nombre + "</div>\n"
                               + "                <div class=\"panel-body\">\n"
                               + "            <form class=\"form-horizontal\" role=\"form\" method=\"post\" name=\"BajaFranq\" action=\"BorraFranquicia.jsp\">\n"
                               + " <div class=\"panel-body\">  \n"
                               + "                <div class=\"form-group\">\n"
                               + "                        <label class=\"control-label col-sm-2\" for=\"restaurant\">Nombre Restaurante</label>\n"
                               + "                    <div class=\"col-sm-10\">\n"
                               + "                        <input type=\"text\" class=\"form-control\" id=\"restaurant\" name=\"restaurante\" value='" + Nombre + "' required>\n"
                               + "                    </div>\n"
                               + "                </div>\n"
                               + " </div>\n"
                               + " <div class=\"panel-body\">\n"
                               + "                <div class=\"form-group\">\n"
                               + "                        <label class=\"control-label col-sm-2\" for=\"franchiseDescription\">Descripci??n Restaurante</label>\n"
                               + "                    <div class=\"col-sm-10\">\n"
                               + "                        <input type=\"text\" class=\"form-control\" id=\"franchiseDescription\" name=\"descripcionFranquicia\" value='" + Descrip + "' required>\n"
                               + "                    </div>\n"
                               + "                </div>\n"
                               + "</div> \n"
                               + " <div class=\"panel-body\">\n"
                               + "                <div class=\"form-group\">\n"
                               + "                    <div class=\"col-sm-offset-2 col-sm-10\">\n"
                               + "<button type=\"button\" href=\"menu.jsp\" class=\"btn btn-info\">Menu</button>\n"
                               + "                    </div>\n"
                               + "                </div>\n"
                               + "</div> \n"
                               + "            </form>\n"
                               + "              </div>\n"
                               + "              </div>\n"
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
               // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
                response.sendRedirect("menu.jsp");
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
