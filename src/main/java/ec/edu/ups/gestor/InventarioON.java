package ec.edu.ups.gestor;

import ec.edu.ups.dao.ProductoDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class InventarioON {

    @Inject
    private ProductoDAO productoDAO;

    public void guardarProducto(ProductoDAO productoDAO) throws Exception {
        productoDAO.guardarProducto(productoDAO);
    }

    public void generarMovimientoEgreso() {

    }

}
