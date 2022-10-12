
package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Osvaldo
 */
@WebServlet(name = "correo", urlPatterns = {"/correo"})
public class correo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Correo</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Correo: " + enviarCorreo("osvaldo.valdivia1@gmail.com","huhouvbopdimgdhm","osvaldo.valdivia1@hotmail.com","Mensaje Prueba") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public String enviarCorreo(String usuario,String contraseña,String destino,String asunto,String mens){
        try{
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", usuario);
            p.setProperty("mail.smtp.auth", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            
            Session s = Session.getDefaultInstance(p,null);
            BodyPart texto= new MimeBodyPart();
            texto.setText("Tu codigo es: "+mens);
            
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(usuario));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mensaje.setSubject(asunto);
            mensaje.setContent(m);
            Transport t = s.getTransport("smtp");
            t.connect(usuario,contraseña);
            t.sendMessage(mensaje,mensaje.getAllRecipients());
            t.close();
            return "True";
            
        }catch(Exception e){
            return e.toString();
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
