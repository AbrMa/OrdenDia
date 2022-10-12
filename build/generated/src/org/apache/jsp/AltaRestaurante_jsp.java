package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.ResultSet;

public final class AltaRestaurante_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Órden del Día</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script type = \"text/javascript\" src=\"js/validaciones.js\">\n");
      out.write("        </script>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("        <script src='http://maps.googleapis.com/maps/api/js'></script>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"css/tenedor.png\" />\n");
      out.write("        <!--Con Internet\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("        -->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String user = (String) session.getAttribute("varUsuario");
            String pass = (String) session.getAttribute("Pass");
            String id = (String) session.getAttribute("id");
            String nom = (String) session.getAttribute("nombre");
            String tel = (String) session.getAttribute("Telefono");
            String tip = (String) session.getAttribute("Tipo");
            String dir = (String) session.getAttribute("Direc");
            if (user != null && pass != null && id != null && nom != null && tel != null && tip != null && dir != null) {
        
      out.write("\n");
      out.write("        <!--Menú de Navegación-->\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"menuPrincipal.jsp\">Órden del Día</a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">");
out.print(user);
      out.write("<span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"CierraSesion\">Cerrar Sesión</a></li>\n");
      out.write("                                <li><a href=\"UserNameServlet\">Chat</a></li>\n");
      out.write("                                <li><a href=\"PreCambioUsuario.jsp\">Cambiar Datos</a></li>\n");
      out.write("                                <li><a href=\"PreBajaUsuario.jsp\">Dar de baja</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Buscar<span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"#\">Buscar Platillo</a></li>\n");
      out.write("                                <li><a href=\"#\">Buscar Restaurante</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" id=\"notif\">Ordenes pendientes : *cargando*<span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\" id=\"lista\">\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!--Formulario-->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <center><h3>Realizar Pedido</h3></center>\n");
      out.write("            <hr>\n");
      out.write("        </div>  \n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-1\"></div>\n");
      out.write("            <div class=\"col-sm-5\">\n");
      out.write("                <div class=\"clearfix\"></div>\n");
      out.write("                <h2 class=\"section-heading\">Alta</h2>\n");
      out.write("                <p class=\"lead\">A solo un paso de alegrar a tu estomago .</p>\n");
      out.write("\n");
      out.write("                <img class=\"img-responsive\" src=\"css/deli.jpg\" alt=\"\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-5\">\n");
      out.write("                <br>\n");
      out.write("                <div class=\"panel panel-success\">\n");
      out.write("                    <div class=\"panel-heading\">Platillo</div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <form class=\"form-horizontal\" role=\"form\" name=\"Alta\" method=\"Post\" Action=\"AltaPedido\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <label class=\"control-label col-sm-2\" for=\"phone\">Platillo</label>\n");
      out.write("                                <div class=\"col-sm-10\">\n");
      out.write("                                    <select class=\"form-control\" NAME=\"Platillo\" required>                    \n");
      out.write("                                        ");

                                            BD.cDatos sql = new BD.cDatos();
                                            try {
                                                sql.conectar();
                                                String rest = request.getParameter("restaurante");
                                                ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo2('" + rest + "');");

                                                while (rsUsr.next()) {
                                                    String plat = rsUsr.getString("idPlatillo");
                                                    String nomf = rsUsr.getString("Nombre");
                                                    out.print("<option value=" + plat + ">" + nomf + "</option>\n");
                                                }
                                            } catch (SQLException error) {
                                                out.print(error.toString());
                                            }

                                        
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <label class=\"control-label col-sm-2\" for=\"dishDescription\">Cantidad</label>\n");
      out.write("                                        <div class=\"col-sm-10\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"cantidad\" name=\"cantidad\" placeholder=\"1\" onkeypress=\"return solonumeros1(event)\"  required>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"panel-body\">        \n");
      out.write("                                    <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-success\">Ordenar</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-1\"></div>\n");
      out.write("        </div>\n");
      out.write("        ");
            
            String rest = request.getParameter("restaurante");
            
            
            out.print("<div class='container'><center><h3>Platillos</h3></center><hr></div>"
                    + "<div class='container'>");
            try {
                sql.conectar();
                ResultSet rsUsr = sql.consulta("call sp_ConsultaPlatillo2('" + rest + "');");
                int contador = 0;
                while (rsUsr.next()) {
                    String plat = rsUsr.getString("idPlatillo");
                    String nomf = rsUsr.getString("Nombre");
                    String descrip = rsUsr.getString("Descripcion");
                    String prec = rsUsr.getString("Precio");

                    if (contador == 0) {
                        out.print("<div class='row'>");
                    }
                    out.print("<div class='col-sm-3'>"
                            + "<a class='thumbnail' href='#'>"
                            + "<img class='img-responsive imagenSucha' src='" + request.getContextPath() + "/" + rsUsr.getString("foto") + "'>"
                            + "<center><p><b>" + nomf + "</b></p>"
                            + "<p>" + descrip + "</p><p>$ " + prec + "</p></center>"
                            + "</a>"
                            + "</div>");

                    contador++;
                    if (contador == 4) {
                        out.print("</div>");
                        contador = 0;

                    }

                }
                out.print("</div>");
            } catch (SQLException error) {
                out.print(error.toString());
            }

        
      out.write("\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <p class=\"copyright text-muted small\">Copyright &copy;  GreenNote 2015. All Rights Reserved</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        ");
} else {

            //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
            response.sendRedirect("menuUsuarioCliente.jsp");
        
      out.write("\n");
      out.write("        ");
            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
