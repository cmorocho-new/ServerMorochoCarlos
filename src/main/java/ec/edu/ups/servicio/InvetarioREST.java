package ec.edu.ups.servicio;

import ec.edu.ups.dto.ProductoDTO;
import ec.edu.ups.gestor.InventarioON;
import ec.edu.ups.trasient.DetlleProductoTrasient;
import ec.edu.ups.trasient.InfoMovimientoTrasient;
import ec.edu.ups.trasient.ResultadoTrasient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/inventario")
public class InvetarioREST {

    @Inject
    private InventarioON inventarioON;

    @POST
    @Path("/guardar_producto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoTrasient guardarProducto(ProductoDTO prodcutoDTO) {
        try{
            inventarioON.guardarProducto(prodcutoDTO);
            return new ResultadoTrasient("200", "Producto Guardado");
        }catch (Exception ex){
            return new ResultadoTrasient("100", ex.getMessage());
        }
    }

    @POST
    @Path("/movimiento_egreso")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoTrasient generarMovimientoEgreso(List<DetlleProductoTrasient> listaDetalles) {
        try{
            inventarioON.generarMovimientoEgreso(listaDetalles);
            return new ResultadoTrasient("200", "Movimiento egereso realizado");
        }catch (Exception ex){
            return new ResultadoTrasient("100", ex.getMessage());
        }
    }

    @POST
    @Path("/movimiento_ingreso")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoTrasient generarMovimientoIngreso(List<DetlleProductoTrasient> listaDetalles) {
        try{
            inventarioON.generarMovimientoIngreso(listaDetalles);
            return new ResultadoTrasient("200", "Movimiento ingreso realizado");
        }catch (Exception ex){
            return new ResultadoTrasient("100", ex.getMessage());
        }
    }

    @GET
    @Path("/movimietos_producto/{idProducto}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InfoMovimientoTrasient> obtenerMovimientosProducto(@PathParam("idProducto") long idProducto) throws Exception{
        return inventarioON.obtenerMovimientosProducto(idProducto);
    }

    @GET
    @Path("/productos/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDTO> obtenerProductos() throws Exception{
        return inventarioON.obtenerProductos();
    }
}
