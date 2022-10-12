/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ReglasNegocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Amahury
 */
@WebServlet(name = "AltaRestaurante", urlPatterns = {"/AltaRestaurante"})
@MultipartConfig
public class AltaRestaurante extends HttpServlet {

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
            String nombre = request.getParameter("Restaurante");
            String direc = request.getParameter("direccion");
            String descrip = request.getParameter("descripcionRestaurante");
            Part arch = request.getPart("imagen");
                 String Inombre = arch.getSubmittedFileName();
            
            String id = request.getParameter("id");
            String workingDir = getServletContext().getRealPath("/");
            
            
            
//             @WebMethod(operationName = "uploadImg2")
//    public void upload(@WebParam(name = "ImgBytes") byte[] imageBytes, @WebParam(name = "Id") String UsrId, @WebParam(name = "UserPass") String passwd) throws SQLException, FileNotFoundException, IOException {
//        if(Login(UsrId,passwd)){
//        con.conectar();
//        ResultSet rsimg = con.consulta("call newpassimage('2','" + convierteMailaUsrid(UsrId) + "','" + "imgperfil.png" + "','0')");
//        if (rsimg.next()) {
//            Files.write(new File(workingDir+convierteMailaUsrid(UsrId)+"/imgperfil.png").toPath(), imageBytes);
//            
//        }
//        con.cierraConexion();
//        }
//    }
            
    
    
            if(nombre!=null && direc!=null && descrip!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call sp_AltaRestaurante('"+id+"','"+nombre+"','"+descrip+"','"+direc+"','"+Inombre.trim()+"');");
                      
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
                        out.println("<script>alert('Restaurante dado de alta exitosamente.');location.href='menuFranquicia.jsp';</script>");
                       // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menuPrincipal.jsp'/>");
                       // response.sendRedirect("menuPrincipal.jsp");
                    }
                }
               catch (SQLException error) {
                out.print(error.toString());
            }
                        
            }
            else
            {
                out.println("<script>alert('Por favor llene nigga nigga campos');location.href='menuFranquicia.jsp'</script>");
                //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/registrarRestaurante.jsp'/>");
                //response.sendRedirect("registrarRestaurante.jsp");
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