package ec.edu.ups.dao;

import ec.edu.ups.dto.ProductoDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Guarda un producto
     * @param productoDTO
     * @throws Exception
     */
    public void guardarProducto(ProductoDTO productoDTO) throws Exception {
        em.persist(productoDTO);
    }

    /**
     * Obtiene los productos
     * @return
     * @throws Exception
     */
    public List<ProductoDTO> obtenerProductos() throws Exception {
        return em.createQuery("SELECT p FROM ProductoDTO p", ProductoDTO.class)
                .getResultList();
    }

    /**
     * Obtiene el stock actual
     * @return
     * @throws Exception
     */
    public int obtenerStockProducto(long idProducto) throws Exception {
        return em.createQuery("SELECT p.stock FROM ProductoDTO p WHERE p.id = :idProducto", Integer.class)
                .setParameter("idProducto", idProducto)
                .getSingleResult();
    }


    /**
     * Actualiza el stock del producto
     * @return
     * @throws Exception
     */
    public void actaulizarStockProducto(long idProducto, int stock) throws Exception {
        em.createQuery("UPDATE ProductoDTO p SET p.stock = :stock WHERE p.id = :idProducto")
                .setParameter("idProducto", idProducto)
                .setParameter("stock", stock)
                .executeUpdate();
    }

}
