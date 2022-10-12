package chat;

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
 * @author Angel
 */
@WebServlet(name = "recargar", urlPatterns = {"/recargar"})
public class recargar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession();
            String html = "";
            ResultSet r;
            int idPer;
            int idPer2;
            try {
                idPer = Integer.parseInt(sesion.getAttribute("id").toString());
                idPer2 = Integer.parseInt(sesion.getAttribute("idPer2").toString());
                try {
                    BD.cDatos obj = new BD.cDatos();
                    obj.conectar();
                    r = obj.consulta("call sp_traeMensaje(" + idPer + "," + idPer2 + ");");
                    while (r.next()) {
                        if (r.getInt("idEnvia") == idPer) {
                            html += "<div class='msg grisC'><p class='textoChat'>" + r.getString("msj") + "<p/></div>";
                        }else{
                            html += "<div class='msg'><p class='textoChat'>" + r.getString("msj") + "</p></div>";
                        }
                    }
                } catch (SQLException f) {
                    html += "No se pudo enviar tu mensaje";
                }
            } catch (Exception e) {
                out.println("Error");                
            }
            out.println(html);
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
