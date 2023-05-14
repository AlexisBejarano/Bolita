/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.bolita.interfaz;

/**
 *
 * @author medin
 */
public interface ObjetoInterfaz {
    
    boolean eliminar(int _object);
    boolean modificar(Object _object);
    Object buscarPor(int _dato);
    Object buscarTodo();
    
}
