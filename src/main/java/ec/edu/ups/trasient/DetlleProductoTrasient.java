package ec.edu.ups.trasient;

public class DetlleProductoTrasient {

    private long idProducto;
    private int cantidad;
    private int stock;

    public DetlleProductoTrasient() {

    }
    public DetlleProductoTrasient(long idProducto, int cantidad, int stock) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
