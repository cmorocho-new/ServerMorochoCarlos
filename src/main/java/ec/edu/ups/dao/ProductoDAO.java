package ec.edu.ups.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductoDAO {

    @PersistenceContext
    private EntityManager em;

    public void guardarProducto(ProductoDAO productoDAO) throws Exception{
        em.persist(productoDAO);
    }

}
