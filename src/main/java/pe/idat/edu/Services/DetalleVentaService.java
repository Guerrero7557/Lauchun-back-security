package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.DetalleVentaEntity;

public interface DetalleVentaService {
    //funcion que te permita mostrar todos los datos    
    List<DetalleVentaEntity> findAll();   
    
    //funcion para buscar por id de venta
    List<DetalleVentaEntity> findIdVenta(Long xidventa); 
    
    //funcion para buscar por codigo
    Optional<DetalleVentaEntity> findById(Long id);
    
    //funcion para registrar datos
    DetalleVentaEntity add(DetalleVentaEntity detven);
    
    //funcion para actualizar datos
    DetalleVentaEntity update(DetalleVentaEntity detven);
    /*
    //funcion para eliminar datos
    DetalleVentaEntity delete(DetalleVentaEntity detven);*/
}
