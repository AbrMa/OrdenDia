package chat;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class inicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
            out.println("  <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                    + "        <script src=\"js/bootstrap.min.js\"></script>\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n"
                    + "         <link rel=\"shortcut icon\" href=\"css/tenedor.png\" />\n"
                    + "        ");
            out.println("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
            out.println("<script type='text/javascript' src='js/chat_1.js'></script>");
            out.println("<title>Sala</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-default\">\n"
                    + "            <div class=\"container-fluid\">\n"
                    + "                <div class=\"navbar-header\">\n"
                    + "                    <a class=\"navbar-brand\" >Órden del Día</a>\n"
                    + "                </div>\n"
                    + "                <div>\n"
                    + "                    <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "                        <li><a href=\"menu.jsp\">Regresar</a></li>\n"
                    + "                    </ul>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </nav>");
            out.println("<div class='contenedor'>");

            try {
                out.print("<div class='inicioP '>Hola <i class='icon-user'></i><p class='izquierda' onclick='location.href=\"sala\"'><i class='icon-keyboard-backspace'></i>Volver</p></div>");
                out.println("<input type='text' value='' placeholder='Ingresa tu Usuario' id='usuario' style='display: block'>");
                out.println("<div class='cuadroCompleto rojo'><p class='tituloResumen'>Foro de Chat</p></div>");
                out.println("<div class='desplegado' id='areaTexto'></div><br>");
                out.println("<input type='text' class='inputMensaje' id='mensaje' style='display:none'><input id='enviar' class=\"btn btn-default' type='button' onclick=\"mandarMensaje()\" value='Conectar'>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {

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
    }
}
