/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoBD.acceso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class Modelo {
    Producto producto;    
    ArrayList<Producto> lista;
    public Boolean IngresarPelota(String nombre, String categoria, int precio, int stock,String marca){
        try {
            String sql = "insert into producto (codigo, nombre,categoria,precio,stock,marca) " +
                            "values (seq_producto.nextval,?,?,?,?,?)";
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,categoria);
            preparedStatement.setInt(3,precio);
            preparedStatement.setInt(4,stock);
            preparedStatement.setString(5,marca);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList<Producto> Listar(){
        
        try {
            String sql="select codigo, nombre,marca,categoria,precio,stock from producto";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            lista = new ArrayList();
            while (resultSet.next()){
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setCategoria(resultSet.getString("Categoria"));
                producto.setPrecio(resultSet.getInt("precio"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setMarca(resultSet.getString("Marca"));
                lista.add(producto);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }
        
    }
    public ArrayList<Producto> Buscar(int varCodigo){
        
        try {
            String sql="select codigo, nombre,marca,categoria,precio,stock from producto where codigo=?";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.setInt(1,varCodigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            lista = new ArrayList();
            while (resultSet.next()){
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setCategoria(resultSet.getString("Categoria"));
                producto.setPrecio(resultSet.getInt("precio"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setMarca(resultSet.getString("Marca"));
                lista.add(producto);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }
        
    }
    public Boolean ModificarProducto (int codigo,String nombre,String marca, String categoria, int precio, int stock){
          try {
            int a = 0;
            //String sql = "update un_alumno set rut=?, dv=?,nombre=?,apellido=? where id_alumno=?";
            StringBuffer linea = new StringBuffer();
            linea.append("update producto set ");
            if (!nombre.isEmpty()){
                linea.append("nombre='"+ nombre+"'");
                a++;
                System.out.println("modifico nombre");
            }if (!categoria.isEmpty()){
                if (a>0){
                linea.append(", ");
                a++;
                }
                linea.append("categoria= '"+categoria+"'");
                System.out.println("modifico categoria");
            }if (!marca.isEmpty()){
                if (a>0){
                linea.append(", ");
                a++;
                }
                linea.append("marca= '"+marca+"'");
                System.out.println("modifico marca");
            }if (precio>0){
                if (a>0){
                linea.append(", ");
                a++;
                }
            linea.append("precio="+precio);
                System.out.println("modifico precio");
            }if (stock>0){
                if (a>0){
                linea.append(", ");
                a++;
                }
            linea.append("stock="+stock);
                System.out.println("modifico stock");
            }
            linea.append(" where codigo="+codigo);                
            System.out.println(linea.toString());
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(linea.toString());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Boolean Borrar(int varCodigo){
        try {
            String sql0="delete producto where codigo=?";
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(sql0);
            preparedStatement.setInt(1,varCodigo);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
