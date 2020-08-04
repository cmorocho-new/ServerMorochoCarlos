package ec.edu.ups.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ex_tipos_movimientos")
public class TipoMovimientoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo", length = 20, nullable = false, unique = true)
    private String codigo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "numero", length = 10, nullable = false)
    private long numeroSiguiente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumeroSiguiente() {
        return numeroSiguiente;
    }

    public void setNumeroSiguiente(long numeroSiguiente) {
        this.numeroSiguiente = numeroSiguiente;
    }
}
