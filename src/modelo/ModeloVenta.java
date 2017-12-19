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
public class ModeloVenta {
    private Producto producto;
    private ArrayList<Producto> productos;
    private ArrayList<Transaccion> lista;
    private Venta venta;
    private Transaccion transaccion;
    private int x=0;
    
    public int IngresarTransaccion(){
        try {
            String sql = "insert into transaccion (id_transaccion) " +
                    "values (seq_id_trans.nextval)";
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.execute();
            String sq2 = "select seq_id_trans.currval as valor from dual";
            preparedStatement = acceso.obtenerInstancia().prepareStatement(sq2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            x = resultSet.getInt("valor");
            }
            return x;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return x;
        }
    }
    public Boolean IngresarVenta(int id_transaccion,int codigo_producto,int cantidad){
        try {
            String sq0 = "select stock from producto where codigo=?";
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(sq0);
            preparedStatement.setInt(1,codigo_producto);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            x = resultSet.getInt("stock");
            }
            String sq2 = "insert into venta (id_transaccion,codigo_producto,cantidad,monto) " +
                            "values (?,?,?,(select precio from producto where codigo=?)*?)";
            preparedStatement = acceso.obtenerInstancia().prepareStatement(sq2);
            preparedStatement.setInt(1,id_transaccion);
            preparedStatement.setInt(2,codigo_producto);
            if (x>=cantidad){
            preparedStatement.setInt(3,cantidad);
            preparedStatement.setInt(4,codigo_producto);
            preparedStatement.setInt(5,cantidad);
            preparedStatement.execute();
            String sq3 = "update transaccion set monto_total = (select sum(v.monto) from venta v where id_transaccion=?)where id_transaccion=?";
            preparedStatement = acceso.obtenerInstancia().prepareStatement(sq3);
            preparedStatement.setInt(1,id_transaccion);
            preparedStatement.setInt(2,id_transaccion);
            preparedStatement.execute();
            return true;
            }
            else {
                System.out.println("Stock insuficiente");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList<Transaccion> ListarTransaccion(){
        
        try {
            String sql="select id_transaccion,fecha,monto_total from transaccion";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            lista = new ArrayList();
            while (resultSet.next()){
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultSet.getInt("id_transaccion"));
                transaccion.setFecha(resultSet.getString("fecha"));
                transaccion.setMonto_total(resultSet.getInt("monto_total"));
                lista.add(transaccion);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }   
    }
    public ArrayList<Producto> ListarVenta(int id_transaccion){
        
        try {
            String sql="select p.codigo,p.nombre,p.marca,p.precio,v.cantidad,p.stock from producto p inner join venta v on"
                    + " p.codigo=v.codigo_producto and v.id_transaccion=?";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.setInt(1,id_transaccion);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            productos = new ArrayList();
            while (resultSet.next()){
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setPrecio(resultSet.getInt("precio"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setMarca(resultSet.getString("Marca"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }   
    }
}
