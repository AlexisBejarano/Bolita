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
import mx.itson.bolita.entidades.Modelo;
import mx.itson.bolita.interfaz.ObjetoInterfaz;

/**
 *
 * @author medin
 */
public class ModeloDAO implements ObjetoInterfaz{

    private final Connection _connection;

    public ModeloDAO(Connection _connection) {
        this._connection = _connection;
    }
    
    @Override
    public boolean agregar(Object _object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int _object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        List<Modelo> _listaModelo = new ArrayList<>();
         
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT ")
                .append("nombre, ")
                .append("color, ")
                .append("talla, ")
                .append("stock ")
            .append("FROM foco.modelo");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                Modelo modelo = new Modelo();
                
                modelo.setNombre(_respuesta.getString("nombre"));
                modelo.setColor(_respuesta.getString("color"));
                modelo.setTalla(_respuesta.getDouble("talla"));
                //modelo.setStrok(_respuesta.getObject("stock"));
                //modelo.setId(_respuesta.getInt("idModelo"));
                //modelo.setMarca(_respuesta.getString("marca"));
                
                _listaModelo.add(modelo);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Bolita: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaModelo;
    }
}
