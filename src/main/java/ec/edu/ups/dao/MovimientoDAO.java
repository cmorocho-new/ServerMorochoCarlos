package ec.edu.ups.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MovimientoDAO {

    @PersistenceContext
    private EntityManager em;

}
