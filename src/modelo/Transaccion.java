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
public class Transaccion {
    private int idTransaccion,monto_total,id_venta;
    private String fecha;

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Transaccion() {
    }

    public Transaccion(int idTransaccion, int monto_total, int id_venta, String fecha) {
        this.idTransaccion = idTransaccion;
        this.monto_total = monto_total;
        this.id_venta = id_venta;
        this.fecha = fecha;
    }
}
