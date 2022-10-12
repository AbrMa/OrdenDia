/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Clases.cPlatillo;
import Clases.cRestaurante;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USER
 */
@WebService(serviceName = "wsPersona")
public class wsPersona {
    BD.cDatos sql = new BD.cDatos();
    ArrayList<cRestaurante> restaurantes;
    //cRestaurante objR;
    ArrayList <cPlatillo> platillos;
    cPlatillo objP;
  
    @WebMethod(operationName = "Login")
    public int Login(@WebParam(name = "email") String email, @WebParam(name = "contra") String contra) {
        String cadenapsw="";
        int estatus = 0;
        try{
            sql.conectar();             
            ResultSet rs = sql.consulta("call sp_ValidaLogIn('"+email+"', '"+contra+"');");
            if(rs.next()){
                estatus=rs.getInt("Estatus");
            }
            
        }
        catch(Exception xxxD){
        }
        return estatus;
    }
    
    @WebMethod(operationName = "altaPedido")
    public String altaPedido(@WebParam(name = "platillo") String platillo, @WebParam(name = "restaurante") String restaurante, @WebParam(name = "correo") String correo, @WebParam(name = "precio") int precio, @WebParam(name = "cant") int cant) {
        String mensaje="";
        try{
            sql.conectar();
            
            ResultSet rs = sql.consulta("call sp_AltaPedidoAndroid('"+platillo+"', '"+restaurante+"','"+correo+"',"+precio+","+cant+");");
            if(rs.next()){
                mensaje=rs.getString("MSJ");
            }
        }
        catch(Exception xxxD){
        }
        return mensaje;
    }
    
    @WebMethod(operationName = "altaReservacion")
    public String altaReservacion(@WebParam(name = "restaurante") String restaurante, @WebParam(name = "usuario") String usuario, @WebParam(name = "horas") int horas, @WebParam(name = "minutos") int minutos,@WebParam(name = "fecha") String fecha) {
        String mensaje="";
        try{
            sql.conectar();
            
            ResultSet rs = sql.consulta("call sp_AltaReservacionAndroid('"+restaurante+"',"+horas+","+minutos+",'"+fecha+"','"+usuario+"');");
            if(rs.next()){
                mensaje=rs.getString("MSJ");
            }
        }
        catch(Exception xxxD){
        }
        return mensaje;
    }
    
    @WebMethod(operationName = "altaUsuario")
    public String altaUsuario(@WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion, @WebParam(name = "mail") String mail, @WebParam(name = "contra") String contra,@WebParam(name = "tel") String tel,@WebParam(name = "tipo") int tipo) {
        String mensaje="";
        try{
            sql.conectar();
            
            ResultSet rs = sql.consulta("call sp_AltaUsuario('"+nombre+"','"+direccion+"','"+mail+"','"+contra+"','"+tel+"',"+tipo+");");
            if(rs.next()){
                mensaje=rs.getString("MSJ");
            }
        }
        catch(Exception xxxD){
        }
        return mensaje;
    }
    
    @WebMethod(operationName = "consultaRestaurante")
    public String consultaRestaurante() {
        String restaurantes = "";   
        int cont = 0;
        try{
            sql.conectar();
            ResultSet rs = sql.consulta("call sp_ConsultaRestauranteFull();");
            while(rs.next()){
                if(cont > 0)
                    restaurantes += ";";                
                restaurantes += rs.getString("Nombre");                
                cont++;
            }
        }
        catch(Exception xxxD){                        
            restaurantes = "bien muerto";
        }
        return restaurantes;
    }
    
    @WebMethod(operationName = "consultaPlatillo")
    public String consultaPlatillo(@WebParam(name = "rest") String rest) {
        String platillos = "";        
        int cont = 0;
        try{
            sql.conectar();
            ResultSet rs = sql.consulta("call sp_ConsultaPlatillo2Android('"+rest+"');");
            while(rs.next()){
                if(cont > 0)
                    platillos += ";";                
                platillos += rs.getString("Nombre")+"*"+rs.getString("Precio");                
                cont++;
            }            
        }
        catch(Exception xxxD){
            platillos += xxxD.toString();            
        }
        return platillos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SubeClaveMovil")
    public String SubeClaveMovil(@WebParam(name = "IdPersona") String IdPersona, @WebParam(name = "Clave") String Clave) {
        BD.cDatos sql = new BD.cDatos();
        try{
            sql.conectar();
            sql.actualizar("update persona set ClaveMovil = '"+Clave+"' where idPersona = "+IdPersona+";");
            return "1";
        } catch(Exception ex){
            return ex.toString();
        }           
    }
}
