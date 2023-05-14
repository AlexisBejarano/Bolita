/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.bolita.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.bolita.entidades.Proveedor;
import mx.itson.bolita.interfaz.ObjetoInterfaz;

/**
 *
 * @author medin
 */
public class ProveedorDAO implements ObjetoInterfaz {
    
     private final Connection _connection;

    public ProveedorDAO(Connection _connection) {
        this._connection = _connection;
    }
    
    
    
     public boolean modificar(Object _object) {
        
        Proveedor _cliente = (Proveedor) _object;
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("UPDATE foco.proveedor ")
            .append("SET ")
                .append("nombre = ?, ")
                .append("idarticulos = ? ")
            .append("WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
             _statement.setInt(1, _cliente.getId());
            _statement.setString(2, _cliente.getNombre());
            _statement.setObject(3, _cliente.getArticulos());
           
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("Bolita: Ha ocurrido un error al momento de modificar el cliente a la base de datos, error: " + ex.getMessage());
        }
        
        return _respuesta;
     }

    public Object buscarPor(String _campo, String _dato) {
        
        List<Proveedor> _listaClientes = new ArrayList<Proveedor>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("UPDATE foco.proveedor ")
            .append("SET ")
                .append("nombre = ?, ")
                .append("idarticulo= ? ")
            .append("WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _dato);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                Proveedor _cliente = new Proveedor();
                
                _cliente.setId(_respuesta.getInt("id"));
                _cliente.setNombre(_respuesta.getString("nombre"));
//                _cliente.setArticulos(_respuesta.getString("idarticulo"));
                
                _listaClientes.add(_cliente);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaClientes;
        
    }

   @Override
    public boolean eliminar(int _object) {
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("DELETE FROM foco.proveedor WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _object);
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("bolita: Ha ocurrido un error al momento de eliminar el cliente a la base de datos, error: " + ex.getMessage());
        }
        
        return _respuesta;
        
    }

    @Override
    public Object buscarPor(int _dato) {
         List<Proveedor> _listaClientes = new ArrayList<Proveedor>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("UPDATE foco.proveedor ")
            .append("SET ")
                .append("nombre = ?, ")
                .append("idarticulo= ? ")
            .append("WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            //_statement.setString(1, _dato);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                Proveedor _cliente = new Proveedor();
                
                _cliente.setId(_respuesta.getInt("id"));
                _cliente.setNombre(_respuesta.getString("nombre"));
//                _cliente.setArticulos(_respuesta.getObject("idarticulo"));
                
                _listaClientes.add(_cliente);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaClientes;
        
    }

    @Override
    public Object buscarTodo() {
       List<Proveedor> _listaClientes = new ArrayList<Proveedor>();
         
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("UPDATE foco.proveedor ")
            .append("SET ")
                .append("nombre = ?, ")
                .append("idarticulo= ? ")
            .append("WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                Proveedor _cliente = new Proveedor();
                
                _cliente.setId(_respuesta.getInt("id"));
                _cliente.setNombre(_respuesta.getString("nombre"));
               // _cliente.setArticulos(_respuesta.getString("idarticulos"));
                
                _listaClientes.add(_cliente);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaClientes;
    }
}