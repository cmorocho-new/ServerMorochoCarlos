package ec.edu.ups.dao;

import ec.edu.ups.dto.TipoMovimientoDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoMovimientoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Obtiene la info basica del tipo movimeinto
     * @param codigo
     * @return
     * @throws Exception
     */
    public TipoMovimientoDTO obtenerTipoMovimeinto(String codigo) throws Exception {
        return em.createQuery("SELECT NEW ec.edu.ups.dto.TipoMovimientoDTO(tm.id, tm.numeroSiguiente) " +
                "FROM TipoMovimientoDTO tm " +
                "WHERE tm.codigo = :codigo", TipoMovimientoDTO.class)
                .setParameter("codigo", codigo)
                .getSingleResult();
    }

    /**
     * Actualiza el nuemro siguiente
     * @param idTipoMovimeinto
     */
    public void actualziarNumeroSiguiente(long idTipoMovimeinto) throws Exception{
        em.createQuery("UPDATE TipoMovimientoDTO tm SET tm.numeroSiguiente = tm.numeroSiguiente + 1 " +
                "WHERE tm.id = :idTipoMovimeinto")
                .setParameter("idTipoMovimeinto", idTipoMovimeinto)
                .executeUpdate();
    }

}
