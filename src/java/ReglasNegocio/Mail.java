
package ReglasNegocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Silvester
 */
@WebServlet(name = "Mail", urlPatterns = {"/Mail"})
public class Mail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        doPost(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            BD.cDatos sql = new BD.cDatos();
            sql.conectar();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = new Date();
            String Fecha = dateFormat.format(date); //2014/08/06 15:59:48
            String correohaciacomun = request.getParameter("mail");
            ResultSet rs = sql.consulta("call sp_ValidaCorreo ('" + correohaciacomun + "')");
            if (rs.next()) {

                //System.out.println(validado);
                final String username = "erick_starwars@hotmail.com";
                final String password = "resident";

                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                //props.put("mail.smtp.host", "smtp.zoho.com");
                //props.put("mail.smtp.host", "smtp.live.com");
                props.put("mail.smtp.host", "smtp-mail.outlook.com");
                props.put("mail.smtp.port", "587");

                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("erick_starwars@hotmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(correohaciacomun));
                String myIp=Inet4Address.getLocalHost().getHostAddress();
                message.setSubject("Recuperacion de Contraseña OrdenDia");
                message.setText("Para continuar con el proceso de renovación de su contraseña de click en el siguiente enlace:"
                        + "\n\nhttp://"+myIp+":8080/OrdenDia/CorreoCambioContraseña.jsp?m="+rs.getString("pass")+rs.getString("Correo")+""
                        + "\n\n" + Fecha);

                Transport.send(message);
                out.print("Acceder al link");
            } else {
                out.print("no");
            }
        } catch (MessagingException e) {
            out.print("Msgex\n" + e);
        } catch (java.lang.NullPointerException e) {
            out.print("nulo");
        } catch (SQLException e) {
            out.print("SQLex");
        }

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
