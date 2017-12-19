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
import modelo.Modelo;
import modelo.Producto;

/**
 *
 * @author simon
 */
public class ControladorProducto {
    Modelo consulta;
    ArrayList<Producto> lista;
    
    public Boolean Agregar(String nombre,String marca, String categoria, int precio, int stock){
        consulta = new Modelo();
        return consulta.IngresarPelota(nombre, categoria, precio, stock, marca);
    }
    /*public Boolean Modificar(int rut, String nombre, String apellido, String dv, int id_alumno){
        consulta = new Modelo();
        return consulta.ModificarAlumno(rut, nombre, apellido, dv, id_alumno);
    }*/
    public ArrayList<Producto> Buscar ( int varCodigo){
        consulta = new Modelo();
        return consulta.Buscar(varCodigo);
    }
    public Boolean Eliminar(int VarCodigo){
        consulta = new Modelo();
        return consulta.Borrar(VarCodigo);
    }
    public ArrayList<Producto> Listar(){
        consulta = new Modelo();
        return consulta.Listar();
    }
    public Boolean Modificar(int codigo,String nombre, String categoria, int precio, int stock,String marca){
        consulta = new Modelo();
        return consulta.ModificarProducto(codigo, nombre,marca, categoria, precio, stock);
    }
}
