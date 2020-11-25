package com.bonsaiBackend.bonsaiBackend.Servicio;

import com.bonsaiBackend.bonsaiBackend.DTO.ProductoDTO;
import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.Modelo.Categoria;
import com.bonsaiBackend.bonsaiBackend.Modelo.Marca;
import com.bonsaiBackend.bonsaiBackend.Modelo.Producto;
import com.bonsaiBackend.bonsaiBackend.Modelo.Proveedor;
import com.bonsaiBackend.bonsaiBackend.Repositorio.CategoriaRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.MarcaRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProductoRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProveedorRepositorio;
import com.bonsaiBackend.bonsaiBackend.Security.Modelo.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoServicio {
    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    CategoriaRepositorio categoriaRepositorio;
    @Autowired
    MarcaRepositorio marcaRepositorio;
    @Autowired
    ProveedorRepositorio proveedorRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<Producto> productos = productoRepositorio.findAll();
        if (productos == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Productos");
        response.setData(productos);
        return response;
    }

    public Response guardarProducto(ProductoDTO productoDTO) throws Exception {
        Response response = new Response();
        Producto producto =  mapDTOtoEntity(productoDTO);
        Producto productoToSave = productoRepositorio.save(producto);

        if (productoToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Producto Guardado Exitosamente");
        response.setData(productoToSave);
        return response;
    }
    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<Producto> producto = productoRepositorio.findById(id);
        response.setData(producto);
        return response;
    }
    public Response editar(Producto producto){
        Response response = new Response();
        Producto productoGuardado = productoRepositorio.save(producto);
        response.setData(productoRepositorio);
        return response;
    }

    public Response ListarHabilitados() {
        Response response = new Response();
        List<Producto> productos = productoRepositorio.findAllByEstadoTrue();
        response.setCode(200);
        response.setMsg("Lista de Categorias");
        response.setData(productos);
        return response;
    }
    public Producto mapDTOtoEntity(ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setCodigoBarra(productoDTO.getCodigoBarra());
        producto.setPresentacion(productoDTO.getPresentacion());
        producto.setProductoDescripcion(productoDTO.getProductoDescripcion());
        producto.setProductoInformacion(productoDTO.getProductoInformacion());
        producto.setStockMinimo(productoDTO.getStockMinimo());
        producto.setEstado(true);

        Categoria categoria = this.categoriaRepositorio.findById(productoDTO.getCategoriaID()).get();
        Marca marca = this.marcaRepositorio.findById(productoDTO.getMarcaID()).get();


        producto.setMarcaID(marca);
        producto.setCategoriaID(categoria);

        Set<Proveedor> proveedores = new HashSet<>();
        for (int producto1:productoDTO.getProveedoresID()) {

                proveedores.add(this.proveedorRepositorio.findById(producto1).get());
        }

        return producto;
    }
}
