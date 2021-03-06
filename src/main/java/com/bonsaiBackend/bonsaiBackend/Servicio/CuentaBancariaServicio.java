package com.bonsaiBackend.bonsaiBackend.Servicio;
import com.bonsaiBackend.bonsaiBackend.DTO.ProductoDTO;
import com.bonsaiBackend.bonsaiBackend.DTO.Response;
import com.bonsaiBackend.bonsaiBackend.DTO.cuentaBancariaDTO;
import com.bonsaiBackend.bonsaiBackend.Modelo.*;


import com.bonsaiBackend.bonsaiBackend.Repositorio.BancoRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.CategoriaRepositorio;


import com.bonsaiBackend.bonsaiBackend.Repositorio.CuentaBancariaRepositorio;
import com.bonsaiBackend.bonsaiBackend.Repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CuentaBancariaServicio {


    @Autowired
    CuentaBancariaRepositorio cuentaBancariaRepositorio;
    @Autowired
    BancoRepositorio bancoRepositorio;
    @Autowired
    ProveedorRepositorio proveedorRepositorio;


    public Response listar() throws Exception {
        Response response = new Response();
        List<CuentaBancaria> cuentasBancarias = cuentaBancariaRepositorio.findAll();
        if (cuentasBancarias  == null) {
            throw new Exception();
        }
        response.setCode(200);
        response.setMsg("Lista de Cuentas Bancarias");
        response.setData(cuentasBancarias);
        return response;
    }
/*
    public Response guardarCuentaBancaria(cuentaBancariaDTO cuentaBancariaDTO) throws Exception {
        Response response = new Response();



        CuentaBancaria cuentaBancaria = new CuentaBancaria(cuentaBancariaDTO.getCbu(),
                cuentaBancariaDTO.getTipoCuenta(),cuentaBancariaDTO.isEstado(),
               cuentaBancariaDTO.getIdBanco().getId_banco(),cuentaBancariaDTO.getIdProveedor().getId_proveedor());
        System.out.println("acaBoy");
        CuentaBancaria cuentaBancariaToSave = cuentaBancariaRepositorio.save(cuentaBancaria);

        if (cuentaBancariaToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Cuenta Bancaria Guardado Exitosamente");
        response.setData(cuentaBancariaToSave);
        return response;
    }
*/
    public Response guardarCuentaBancaria(cuentaBancariaDTO cuentaBancariaDTO) throws Exception {
        Response response = new Response();
        CuentaBancaria cuentaBancaria = mapDTOtoEntity(cuentaBancariaDTO);
        CuentaBancaria cuentaBancariaToSave = cuentaBancariaRepositorio.save(cuentaBancaria);

        if (cuentaBancariaToSave == null)
            throw new Exception();
        response.setCode(200);
        response.setMsg("Cuenta Bancaria Guardado Exitosamente");
        response.setData(cuentaBancariaToSave);
        return response;
    }

    private CuentaBancaria mapDTOtoEntity(cuentaBancariaDTO cuentaBancariaDTO) {
            CuentaBancaria cuentaBancaria = new CuentaBancaria();

            cuentaBancaria.setCbu(cuentaBancariaDTO.getCbu());
            cuentaBancaria.setTipoCuenta(cuentaBancariaDTO.getTipoCuenta());

            cuentaBancaria.setEstado(true);

            Banco banco = this.bancoRepositorio.findById(cuentaBancariaDTO.getIdBanco()).get();
            Proveedor proveedor = this.proveedorRepositorio.findById(cuentaBancariaDTO.getIdProveedor()).get();
            cuentaBancaria.setBancoID(banco);
            cuentaBancaria.setProveedorID(proveedor);


            return cuentaBancaria;

    }

    public Response buscarPorId(int id){
        Response response= new Response();
        Optional<CuentaBancaria> cuentaBancaria = cuentaBancariaRepositorio.findById(id);
        response.setData(cuentaBancaria);
        return response;
    }
    public Response editar(CuentaBancaria cuentaBancaria){
        Response response = new Response();
        CuentaBancaria cuentaBancariaGuardado = cuentaBancariaRepositorio.save(cuentaBancaria);
        response.setData(cuentaBancariaGuardado);
        return response;
    }

    /*public Response actualizarCategoria (Categoria categoria) throws Exception {
        Response response = new Response();
        Categoria categoriaToUpdate = categoriaRepositorio.fndById_categoria(categoria.getId_categoria());

        if (categoriaToUpdate == null) {
            throw new Exception();
        }

        categoriaToUpdate.setDescripcion(categoria.getDescripcion());
        categoriaToUpdate.setEtiqueta(categoria.getEtiqueta());

        response.setCode(200);
        response.setMsg("Banco actualizado con exito");
        response.setData(categoriaRepositorio.save(categoriaToUpdate));
        return response;
    }*/
    public Response ListarHabilitados(){
        Response response = new Response();
        List<CuentaBancaria> cuentaBancarias = cuentaBancariaRepositorio.findAllByEstadoTrue();
        response.setCode(200);
        response.setMsg("Lista de Cuentas Bancarias");
        response.setData(cuentaBancarias);
        return response;
    }
}
