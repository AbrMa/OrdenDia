/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lugar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luigi
 */
@WebServlet(name = "AltaRestaurante2", urlPatterns = {"/AltaRestaurante2"})
public class AltaRestaurante2 extends HttpServlet {

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
            try {
                String correo = "prueba@gmail.com";
                String nombre = (String) request.getParameter("nombre");
                String telefono = (String) request.getParameter("telefono");
                String hr_ab = (String) request.getParameter("hr_ab");
                String hr_cer = (String) request.getParameter("hr_cer");
                String coox = (String) request.getParameter("coox");
                String cooy = (String) request.getParameter("cooy");
                BD.cDatos sql = new BD.cDatos();
                sql.conectar();
                ResultSet r = sql.consulta("call ordenDia.AltaRestaurante('" + correo + "',\n"
                        + "'" + nombre + "', '" + coox + "', '" + cooy + "', '', '" + hr_ab + "', '" + hr_cer + "',\n"
                        + "'" + telefono + "');");
                while (r.next()) {
                    if (r.getString("idStatus").equals("1")) {

                        out.print("<script>alert('" + r.getString("mensaje") + "');location.replace('MapaRestaurantes');</script>");
                    } else {
                        out.print("<script>alert('" + r.getString("mensaje") + "');location.replace('AltaRestaurante');</script>");

                    }
                }
            } catch (Exception ex) {
                response.sendRedirect("MapaRestaurantes");
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
