package ec.edu.ups.dao;

import ec.edu.ups.dto.MovimientoDTO;
import ec.edu.ups.trasient.InfoMovimientoTrasient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MovimientoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Guarda los datos de un movmiento
     * @param movimientoDTO
     * @return
     * @throws Exception
     */
    public void guardarMovimiento(MovimientoDTO movimientoDTO) throws Exception {
        em.persist(movimientoDTO);
    }

    /**
     * obtiene los movimientos de un producto
     * @param idPorducto
     * @return
     * @throws Exception
     */
    public List<InfoMovimientoTrasient> obtenerMovimientosProducto(long idPorducto) throws Exception {
        return em.createQuery("SELECT NEW ec.edu.ups.trasient.InfoMovimientoTrasient( " +
                "d.movimientoDTO.tipoMovimientoDTO.codigo, d.movimientoDTO.tipoMovimientoDTO.nombre, " +
                "d.movimientoDTO.fecha, d.movimientoDTO.numero, d.cantidad, d.saldo) " +
                "FROM DetalleProductoDTO d " +
                "WHERE d.productoDTO.id = :idPorducto", InfoMovimientoTrasient.class)
                .setParameter("idPorducto", idPorducto)
                .getResultList();
    }
}
