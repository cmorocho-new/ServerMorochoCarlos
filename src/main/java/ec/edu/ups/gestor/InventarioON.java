package ec.edu.ups.gestor;

import ec.edu.ups.dao.MovimientoDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.TipoMovimientoDAO;
import ec.edu.ups.dto.DetalleProductoDTO;
import ec.edu.ups.dto.MovimientoDTO;
import ec.edu.ups.dto.ProductoDTO;
import ec.edu.ups.dto.TipoMovimientoDTO;
import ec.edu.ups.trasient.DetlleProductoTrasient;
import ec.edu.ups.trasient.InfoMovimientoTrasient;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class InventarioON {

    @Inject
    private ProductoDAO productoDAO;

    @Inject
    private TipoMovimientoDAO tipoMovimientoDAO;

    @Inject
    private MovimientoDAO movimientoDAO;

    /**
     * Guarda un prodcuto
     * @param productoDTO
     * @throws Exception
     */
    public void guardarProducto(ProductoDTO productoDTO) throws Exception {
        productoDAO.guardarProducto(productoDTO);
    }

    /**
     * Obtiene los productos registrados
     * @return
     * @throws Exception
     */
    public List<ProductoDTO> obtenerProductos() throws Exception {
        return productoDAO.obtenerProductos();
    }

    /**
     * Genera el movmiento tipo Egreso
     * @param detallesProductos
     * @throws Exception
     */
    public void generarMovimientoEgreso(List<DetlleProductoTrasient> detallesProductos) throws Exception {
        generarMovimiento(detallesProductos, "MOV-EGR", false);
    }

    /**
     * Genera el movmiento tipo Egreso
     * @param detallesProductos
     * @throws Exception
     */
    public void generarMovimientoIngreso(List<DetlleProductoTrasient> detallesProductos) throws Exception {
        generarMovimiento(detallesProductos, "MOV-ING", true);
    }

    /**
     * Genera un movimiento tipo EGRESO - INGRESO
     * @param detallesProductos
     */
    public void generarMovimiento(List<DetlleProductoTrasient> detallesProductos, String codigoMovimeitno, boolean ingreso) throws Exception {
        // Vrifica si hay detalles
        if (detallesProductos.size() == 0){
            throw new Exception("Debe tener almenos un detalle");
        }
        // Obtiene la info basica del tipo movimiento
        TipoMovimientoDTO tipoMovimientoDTO = tipoMovimientoDAO.obtenerTipoMovimeinto(codigoMovimeitno);
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setFecha(new Date());
        movimientoDTO.setTipoMovimientoDTO(tipoMovimientoDTO);
        movimientoDTO.setNumero(tipoMovimientoDTO.getNumeroSiguiente());
        movimientoDTO.setTipoMovimientoDTO(tipoMovimientoDTO);
        List<DetalleProductoDTO> detalles = new ArrayList<>();
        for (DetlleProductoTrasient d: detallesProductos) {
            long stock = productoDAO.obtenerStockProducto(d.getIdProducto());
            DetalleProductoDTO detalle = new DetalleProductoDTO();
            detalle.setMovimientoDTO(movimientoDTO);
            detalle.setCantidad(d.getCantidad());
            detalle.setProductoDTO(new ProductoDTO(d.getIdProducto()));
            if (ingreso){
                detalle.setSaldo(((int) stock) + d.getCantidad());
            }else{
                detalle.setSaldo(((int) stock) - d.getCantidad());
            }
            detalles.add(detalle);
            // actualiza  stock producto
            productoDAO.actaulizarStockProducto(d.getIdProducto(), detalle.getSaldo());
        }
        movimientoDTO.setDetalleProductoDTOS(detalles);
        // Manda a presiste el movmiento
        movimientoDAO.guardarMovimiento(movimientoDTO);
        // actualiza el numero siguinte
        tipoMovimientoDAO.actualziarNumeroSiguiente(tipoMovimientoDTO.getId());
    }

    /**
     * Genera un movimiento tipo INGRESO
     * @param idPorducto
     */
    public List<InfoMovimientoTrasient> obtenerMovimientosProducto(long idPorducto) throws Exception {
        return movimientoDAO.obtenerMovimientosProducto(idPorducto);
    }

}
