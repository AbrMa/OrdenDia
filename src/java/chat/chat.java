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
 * @author Angel
 */
@WebServlet(name = "chat", urlPatterns = {"/chat"})
public class chat extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("usuario");
            String user2 = "";
            int idPer2;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
            out.println("<link type='text/css' rel='stylesheet' href='css/menu.css'>");
            out.println("<link type='text/css' rel='stylesheet' href='css/estilos.css'>");
            out.println("<link type='text/css' rel='stylesheet' href='css/tabla.css'>");
            out.println("<link type='text/css' rel='stylesheet' href='css/periodica.css'>");
            out.println("<link type='text/css' rel='stylesheet' href='css/formulario.css'>");
            out.println("<link type='text/css' rel='stylesheet' href='iconos/style.css'>");
            out.println("<link type='text/css' rel='stylesheet' href='css/resumen.css'>");
            out.println("<link type='text/css' rel='stylesheet' href='css/chat.css'>");
            out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\">");
            out.println("<script src='jquery-latest.js'></script>");
            out.println("<script src='js/chat.js'></script>");
            out.println("<script src='js/recargar_1.js'></script>");
            out.println("<title>Chat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='contenedor'>");
            out.println("<header onclick = \"location.href='jsps/Dentro.jsp'\">Prometio <br><i class=\"icon-polymer\"></i></header>");
            if (sesion.getAttribute("id") != null) {
                try {
                    String mensaje = "";
                    out.print("<div class='inicioP'>Hola " + usuario + "<i class='icon-user'></i><p class='izquierda' onclick='location.href=\"sala1\"'><i class='icon-keyboard-backspace'></i>Volver</p></div>");
                    idPer2 = Integer.parseInt((String) request.getParameter("sala"));
                    BD.cDatos sql = new BD.cDatos();
                    ResultSet r = null;
                    try {
                        sql.conectar();
                        r = sql.consulta("call sp_existe2('" + idPer2 + "');");
                        if(r.next()){
                            mensaje = r.getString("msj");
                            user2 = r.getString("usuarioU");
                        }
                    } catch (SQLException e) {
                        out.println("<script>location.href='sala1'</script>");
                    }
                    if (mensaje.equals("existe")) {
                        sesion.setAttribute("idPer2", idPer2);
                        out.println("<div class='cuadroCompleto rojo'><p class='tituloResumen'>Conversación con "+user2+"</p></div>");
                        out.println("<div class='desplegado' id='desplegado'></div>");
                        out.println("<input type='text' class='inputMensaje' placeholder='Mensaje' id='texto' autocomplete='off'>");
                        out.println("<input type='submit' class='botonEnviar' value='Enviar' id='enviar'>");
                    }else{
                        out.println("<script>location.href='sala1'</script>");
                    }

                } catch (Exception e) {
                    out.println("<script>location.href='sala1'</script>");
                    out.println("<div class='cuadroE' id='cuadro'>");
                    out.println("<p class='nombre1'>Lo sentimos, no existe el usuario<br>:(</p>");
                    out.println("</div>");
                }
            } else {
                out.println("<script>location.href='indatos/login.html'</script>");
                out.println("<div class='cuadroE' id='cuadro'>");
                out.println("<p class='nombre1'>Lo sentimos, debes estar registrado para usar esto<br>:(</p>");
                out.println("</div>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
