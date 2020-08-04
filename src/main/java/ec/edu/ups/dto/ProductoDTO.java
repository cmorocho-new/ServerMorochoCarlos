package ec.edu.ups.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ex_productos")
public class ProductoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo", length = 20, unique = true)
    private String codigo;

    @Column(name = "nombre", length = 200)
    private String nombre;

    @Column(name = "stock", length = 10)
    private int stock;

    public ProductoDTO(){

    }

    public ProductoDTO(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
