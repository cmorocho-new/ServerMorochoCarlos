package ec.edu.ups.trasient;

import java.io.Serializable;
import java.util.Date;

public class InfoMovimientoTrasient implements Serializable {

    private String codigo;
    private String nombre;
    private Date fecha;
    private long numero;
    private int cantidad;
    private int stockActual;

    public InfoMovimientoTrasient(){

    }
    public InfoMovimientoTrasient(String codigo, String nombre, Date fecha, long numero, int cantidad, int stockActual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.numero = numero;
        this.cantidad = cantidad;
        this.stockActual = stockActual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
}
