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
@WebServlet(name = "AltaUsuario", urlPatterns = {"/AltaUsuario"})
public class AltaUsuario extends HttpServlet {

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
            
              String usuario = request.getParameter("nombre");
            String pass = request.getParameter("pass");
             String tel = request.getParameter("telefono");
             String direc= request.getParameter("direccion");
            String correo = request.getParameter("correo");
            String tipo = request.getParameter("tipo");
     
            if(usuario!=null && pass !=null && tel!=null && direc!=null && tipo!=null && correo!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_AltaUsuario('"+usuario+"','"+direc+"','"+correo+"','"+pass+"','"+tel+"','"+tipo+"');");
                      
                    while(rsUsr.next())
                    {

                        out.println("<script>alert('Registro dado de alta exitosamente.')</script>");
                        //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                        response.sendRedirect("OrdenDia");
                    }
                }
               catch (SQLException error) {
                out.print(error.toString());
            }
                        
            }
            else
            {
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
