/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReglasNegocio;

import BD.cDatos;
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
 * @author Alumno
 */
@WebServlet(name = "notificaciones", urlPatterns = {"/notificaciones"})
public class notificaciones extends HttpServlet {  

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
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        int id = Integer.parseInt(request.getParameter("id"));
        try (PrintWriter out = response.getWriter()) {
            if(tipo == 1){
                BD.cDatos sql = new BD.cDatos();
                ResultSet rs;
                int cont = 0;
                try{
                    sql.conectar();
                    rs = sql.consulta("call notif("+id+");");
                    rs.next();
                    cont = rs.getInt("cont");
                    out.println(cont);
                    sql.cierraConexion();
                } catch(Exception ex){
                    out.println(ex.toString());
                }               
            } else {
                BD.cDatos sql = new BD.cDatos();
                ResultSet rs;
                int cont = 0;
                try{
                    sql.conectar();
                    rs = sql.consulta("call notif2("+id+",5);");
                    while(rs.next()){
                        out.println("<li>"+rs.getString("ordeno")+" - "+rs.getString("platillo")+", cantidad : "+rs.getInt("cantidad")+"<input type=button value='Listo' onclick='marca("+rs.getInt("id")+");'></li>");
                    }                    
                    out.println("<a href = 'ConsultaOrden.jsp'>Ver todas</a>");
                    sql.cierraConexion();
                } catch(Exception ex){
                    out.println(ex.toString());
                }               
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
