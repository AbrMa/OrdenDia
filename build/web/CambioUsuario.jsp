<%-- 
    Document   : CambioUsuario
    Created on : 16-nov-2015, 17:49:37
    Author     : Alejandro
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        String usuario = request.getParameter("nombre");
            String pass = request.getParameter("pass");           
             String direc= request.getParameter("direccion");
            String correo = request.getParameter("correo");
             if(usuario!=null && pass !=null &&  direc!=null  && correo!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call st_cambioUsuario('"+usuario+"','"+direc+"','"+correo+"','"+pass+"');");
                      
                    while(rsUsr.next())
                    {
                        
                         HttpSession op = request.getSession();
                           op.putValue("Direc", direc);
                           op.putValue("nombre", usuario);
                        out.println("<script>alert('Registro Cambiado.')</script>");
                      //  out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
                         response.sendRedirect("menu.jsp");
                    }
                }
               catch (SQLException error) {
                out.print(error.toString());
            }
                        
            }
            else
            {
                out.println("<script>alert('Por favor llene todos los campos')</script>");
               // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/menu.jsp'/>");
                 response.sendRedirect("menu.jsp");
            }
    %>

