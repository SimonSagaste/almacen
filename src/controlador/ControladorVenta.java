/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoBD.acceso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloVenta;
import modelo.Producto;
import modelo.Transaccion;
import modelo.Venta;

/**
 *
 * @author simon
 */
public class ControladorVenta {
    ModeloVenta consulta;
    ArrayList<Producto> lista;
    
    public Boolean AgregarVenta(int id_transaccion,int codigo_producto, int cantidad){
        consulta = new ModeloVenta();
        return consulta.IngresarVenta(id_transaccion, codigo_producto, cantidad);
    }
    public ArrayList<Producto> ListarVenta(int codigo){
        consulta = new ModeloVenta();
        return consulta.ListarVenta(codigo);
    }
    public int AgregarTransaccion(){
        consulta = new ModeloVenta();
        return consulta.IngresarTransaccion();
    }
    public ArrayList<Transaccion> ListarTransaccion(){
        consulta = new ModeloVenta();
        return consulta.ListarTransaccion();
    }
}
