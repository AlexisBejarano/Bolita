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
import mx.itson.bolita.entidades.Articulos;
import mx.itson.bolita.interfaz.ObjetoInterfaz;

/**
 *
 * @author medin
 */
public class ArticuloDAO implements ObjetoInterfaz{
    
    private final Connection _connection;

    public ArticuloDAO(Connection _connection) {
        this._connection = _connection;
    }

    @Override
    public boolean eliminar(int _object) {
         boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("DELETE FROM foco.articulos WHERE id = ?;");
        
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
    public boolean modificar(Object _object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarPor(int _dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarTodo() {
        List<Articulos> _listaArticulos = new ArrayList<>();
         
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT ")
                .append("nombre, ")
                .append("precio, ")
                .append("idmodelo ")
            .append("FROM foco.articulos");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                Articulos _cliente = new Articulos();
                
                //_cliente.setId(_respuesta.getInt("idmodelo"));
                _cliente.setNombre(_respuesta.getString("nombre"));
                _cliente.setPrecio(_respuesta.getDouble("precio"));
               // _cliente.setModelo(_respuesta.getObject("idmodelo"));
                
                _listaArticulos.add(_cliente);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaArticulos;
    }
}
