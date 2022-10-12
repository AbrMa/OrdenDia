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
@WebServlet(name = "procesa", urlPatterns = {"/procesa"})
public class procesa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("usuario");
            String texto;
            String html = "";
            ResultSet r;
            int idPer;
            int idPer2;
            try {
                idPer = Integer.parseInt(sesion.getAttribute("id").toString());
                idPer2 = Integer.parseInt(sesion.getAttribute("idPer2").toString());
                texto = request.getParameter("texto");
                try {
                    BD.cDatos obj = new BD.cDatos();
                    obj.conectar();
                    obj.consulta("call sp_registraMensaje(" + idPer + "," + idPer2 + ",'" + texto + "');");
                    obj.cierraConexion();
                } catch (SQLException f) {
                    out.println("No se pudo enviar tu mensaje");
                }
            } catch (Exception e) {
                out.println("No se pudo enviar tu mensaje");
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
