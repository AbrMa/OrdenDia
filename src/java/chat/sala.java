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
@WebServlet(name = "sala", urlPatterns = {"/sala"})
public class sala extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("idPer2", 0);
            String usuario = (String) sesion.getAttribute("usuario");
            int id;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
           out.println("  <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                    + "        <script src=\"js/bootstrap.min.js\"></script>\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n"
                    + "         <link rel=\"shortcut icon\" href=\"css/tenedor.png\" />\n"
                    + "        ");
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
            out.println("<div class='contenedor form-group'>");
         
            if (sesion.getAttribute("id") != null) {
                out.print("<div class='inicioP'>Hola " + usuario + "<i class='icon-user'></i></div>");
                out.println("<div class='contenedorTexto2'>");
                out.println("<div class='cuadroCompleto rojo'><p class='tituloResumen'>Usuarios Conectados</p></div>");
                try {
                    id = Integer.parseInt(sesion.getAttribute("id").toString());
                    out.println(consultaUsuario(id));
                } catch (Exception e) {
                    out.println("<div class='cuadroE' id='cuadro'>");
                    out.println("<p class='nombre1'>Lo sentimos, algo salió mal<br>:(</p>");
                    out.println("</div>");
                }                
                out.println("</div>");
            } else {
                out.println("<script>location.href='index.html'</script>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String consultaUsuario(int idP) {
        String cadena = "";
        ResultSet r;
        int nivel;
        boolean ok = false;
        try {
            BD.cDatos sql = new BD.cDatos();
            sql.conectar();
            r = sql.consulta("call sp_traeConectados2("+idP+");");
            while (r.next()) {
                ok = true;
                nivel = r.getInt("nivel");
                cadena += "<div class='elementoChat'><p class='user'>" + r.getString("usuario") + "</p><p class='level'>" + nivel + "</p><p class='ok'>.</p></div>";
            }
            if (!ok) {
                cadena += "<div class='cuadroE' id='cuadro'><p class='nombre1'>Lo sentimos, por el momento no hay usuarios disponibles<br>:(</p></div>";
            }else{
                cadena += "<input type='button' class='boton1' style='width: 35%' value='Acceder al Foro' onclick=\"location.href='inicio'\">";
            }

        } catch (SQLException e) {
            cadena += "<div class='cuadroE' id='cuadro'><p class='nombre1'>Lo sentimos, por el momento no hay usuarios disponibles<br>:(</p></div>";
        }
        return cadena;
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
