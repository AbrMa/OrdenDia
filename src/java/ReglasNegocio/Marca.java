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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "Marca", urlPatterns = {"/Marca"})
public class Marca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final long serialVersionUID = 1L;
     
    private static final String SENDER_ID = " AIzaSyC6UcIwqHLLGf4c75BR0DhKEiFQATw2ydU"; //Aqui va la chiquita
    
    private static String DROID_BIONIC =""; //Aqui va la grandota
         
    // This array will hold all the registration ids used to broadcast a message.
    // for this demo, it will only have the DROID_BIONIC id that was captured 
    // when we ran the Android client app through Eclipse.
    private List<String> androidTargets;
    
    String collapseKey = "Pedido";
    String userMessage = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            PrintWriter out = response.getWriter();
            BD.cDatos sql = new cDatos();
            ResultSet rs ;            
            try{
                sql.conectar();
                rs = sql.consulta("call notiMovil("+id+");");
                rs.next();
                DROID_BIONIC = rs.getString("ClaveMovil");
                userMessage = "Su platillo "+rs.getString("platillo")+" se esta preparando";
                sql.consulta("call marca("+id+")");                
                androidTargets = new ArrayList<String>();
                androidTargets.add(DROID_BIONIC);
                sql.cierraConexion();
                                
                    Sender sender = new Sender(SENDER_ID);
                 
                    Message message = new Message.Builder()                 
                    .collapseKey(collapseKey)
                    .timeToLive(30)
                    .delayWhileIdle(true)
                    .addData("mensaje", userMessage)
                    .build();
                                                 
                    MulticastResult result = sender.send(message, androidTargets, 1);
                                                            
            } catch(Exception ex){
                out.println(ex.toString());
            }
        } catch(Exception exxx){
            String cosa = exxx.toString();
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
