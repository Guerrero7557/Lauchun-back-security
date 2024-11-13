package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.DetalleCompraEntity;

public interface DetalleCompraService {
    //funcion que te permita mostrar todos los datos    
    List<DetalleCompraEntity> findAll();
       
    
    //funcion para buscar por id de compra
    List<DetalleCompraEntity>findIdCompra(Long xidcompra);
    
    //funcion para buscar por codigo
    Optional<DetalleCompraEntity> findById(Long id);
    
    //funcion para registrar datos
    DetalleCompraEntity add(DetalleCompraEntity detcom);
    
    //funcion para actualizar datos
    DetalleCompraEntity update(DetalleCompraEntity detcom);
    
    /*
    //funcion para eliminar datos
    DetalleCompraEntity delete(DetalleCompraEntity c);*/
}
