package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Random;

/**
 * @author Angel
 */
@ServerEndpoint("/servidor")
@WebServlet(name = "Servidor", urlPatterns = {"/Servidor"})
public class Servidor extends HttpServlet {

    public static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
    HttpSession sesion;
    String username;
    String color;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @OnOpen
    public void Abrir(Session sesion) {
        chatroomUsers.add(sesion);
    }

    @OnMessage
    public void Mensaje(String msj, Session ses) throws IOException {
        String user = (String) ses.getUserProperties().get("username");
        if (user == null) {
            ses.getUserProperties().put("username", msj);
            ses.getBasicRemote().sendText(construirJson("", "Estas conectado como: " + msj));
            this.username = msj;
        } else {

            Iterator<Session> iterador = chatroomUsers.iterator();
            while (iterador.hasNext()) {
                iterador.next().getBasicRemote().sendText(construirJson(user, msj));
            }
        }
    }

    @OnClose
    public void Cierra(Session sesion) {
        chatroomUsers.remove(sesion);
    }

    private String construirJson(String user, String mensaje) {
        JsonObject json;
        if (user.equals(username)) {
            json = Json.createObjectBuilder().add("Mensaje", "<div><p>" + user + ": " + mensaje + "</p></div>").build();
        } else {
            json = Json.createObjectBuilder().add("Mensaje", "<div><p>" + user + mensaje + "</p></div>").build();
        }
        StringWriter escritor = new StringWriter();
        try (JsonWriter jescritor = Json.createWriter(escritor)) {
            jescritor.write(json);
        }
        return escritor.toString();
    }

    /*
    public String generaColor() {
        Random rand = new Random();
        String cadena[] = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
        int r = (int) (rand.nextDouble() * 10.0);
        return cadena[r];
    }    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     */
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
