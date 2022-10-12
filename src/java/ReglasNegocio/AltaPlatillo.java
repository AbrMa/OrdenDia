/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ReglasNegocio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Carmen
 */
@WebServlet(name = "AltaPlatillo", urlPatterns = {"/AltaPlatillo"})
@MultipartConfig
public class AltaPlatillo extends HttpServlet {

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
            
             String nombre = request.getParameter("platillo");
             String descrip = request.getParameter("descripcionPlatillo");
             String precio = request.getParameter("precio");
             String restaurante = request.getParameter("restaurante");
             String workingDir = getServletContext().getRealPath("/");
             Part arch = request.getPart("imagen");
                 String Inombre = arch.getSubmittedFileName();
             
            if(nombre!=null && descrip !=null && precio!=null && restaurante!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_AltaPlatillo('"+nombre+"','"+descrip+"','"+precio+"','"+restaurante+"','"+Inombre+"');");
                      
                    while(rsUsr.next())
                    {
                              try (InputStream is = arch.getInputStream()) {
                            
                            File f = new File(workingDir+Inombre.trim());
                            System.out.println(workingDir+Inombre.trim());

                            try (FileOutputStream ous = new FileOutputStream(f)) {
                                int dato = is.read();
                                while (dato != -1) {
                                    ous.write(dato);
                                    dato = is.read();
                                }
                                is.close();
                                ous.close();
                            }
                            
                        }
                        out.println("<script>alert('Platillo Registrado.');location.href='menuRestaurante.jsp';</script>");
                   // response.sendRedirect("menuRestaurante.jsp");
                    }
                }
               catch (SQLException error) {
                out.print(error.toString());
            }
                        
            }
            else
            {
                out.println("<script>alert('Por favor llene todos los campos')menuRestaurante.jsp</script>");
                 //response.sendRedirect("menuRestaurante.jsp");
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
