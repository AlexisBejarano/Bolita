/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.bolita.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author medin
 */
public class Conexion {
   private Connection _connection = null;

    public Conexion() {
        

        String _url = "jdbc:mysql://127.0.0.1:3306/foco?allowPublicKeyRetrieval=true&useSSL=false";

        String _user = "root";

        String _password="Poke6470";
       
        try{
            
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this._connection = DriverManager.getConnection(_url, _user, _password);
            
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }
    
    public Connection getConnection(){
        return this._connection;
    }
    
    public void closeConnection(){
        
            try { 
                this._connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
    
}
