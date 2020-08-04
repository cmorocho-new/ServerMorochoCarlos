package ec.edu.ups.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ex_movimientos")
public class MovimientoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero", length = 10, unique = true, nullable = false)
    private long numero;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_movimeinto_id", referencedColumnName = "id", nullable = false)
    private TipoMovimientoDTO tipoMovimientoDTO;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movimientoDTO")
    private List<DetalleProductoDTO> detalleProductoDTOS;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoMovimientoDTO getTipoMovimientoDTO() {
        return tipoMovimientoDTO;
    }

    public void setTipoMovimientoDTO(TipoMovimientoDTO tipoMovimientoDTO) {
        this.tipoMovimientoDTO = tipoMovimientoDTO;
    }

    public List<DetalleProductoDTO> getDetalleProductoDTOS() {
        return detalleProductoDTOS;
    }

    public void setDetalleProductoDTOS(List<DetalleProductoDTO> detalleProductoDTOS) {
        this.detalleProductoDTOS = detalleProductoDTOS;
    }
}
