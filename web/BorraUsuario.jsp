<%-- 
    Document   : BorraUsuario
    Created on : 16-nov-2015, 18:35:38
    Author     : Alejandro
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            String pass = request.getParameter("pass");           
            String correo = request.getParameter("correo");
             if(pass !=null &&  correo!=null)
            {
                BD.cDatos sql = new BD.cDatos();
                try
                {
                    sql.conectar();
                    ResultSet rsUsr = sql.consulta("call st_bajasUsuario('"+correo+"','"+pass+"');");
                      
                    while(rsUsr.next())
                    {
                        HttpSession op = request.getSession();
                        op.invalidate();
                        out.println("<script>alert('Registro Borrado.')</script>");
                       // out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                        response.sendRedirect("OrdenDia");
                    }
                }
               catch (SQLException error) {
                out.print(error.toString());
            }
                        
            }
            else
            {
                out.println("<script>alert('Por favor llene todos los campos')</script>");
                //out.print("<META HTTP-EQUIV='REFRESH' CONTENT='.0000001;URL=http://localhost:8080/OrdenDia/'/>");
                    response.sendRedirect("OrdenDia");
                            }
    %>

