/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class Venta {
    private  ArrayList<Producto> productos;
    private int id,monto,codigoProducto,cantidad;
    private String fecha;

    public Venta(ArrayList<Producto> productos, int id, int monto, int codigoProducto, int cantidad, String fecha) {
        this.productos = productos;
        this.id = id;
        this.monto = monto;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Venta() {
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
