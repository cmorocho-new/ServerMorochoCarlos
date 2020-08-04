package ec.edu.ups.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ex_detalles_productos")
public class DetalleProductoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cantidad", length = 10, nullable = false)
    private int cantidad;

    @Column(name = "saldo", length = 10, nullable = false)
    private int saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", referencedColumnName = "id", nullable = false)
    private ProductoDTO productoDTO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movimiento_id", referencedColumnName = "id", nullable = false)
    private MovimientoDTO movimientoDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
    }

    public MovimientoDTO getMovimientoDTO() {
        return movimientoDTO;
    }

    public void setMovimientoDTO(MovimientoDTO movimientoDTO) {
        this.movimientoDTO = movimientoDTO;
    }
}
