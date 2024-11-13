package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.CarritoEntity;

public interface CarritoService {
    //funcion que te permita mostrar todos los datos    
    List<CarritoEntity> findAll();    
    
    //funcion para buscar detalles por id de cabecera de carrito
    List<CarritoEntity>findIdUsuario(Long xidusuario);
    
    //funcion para buscar por codigo
    Optional<CarritoEntity> findById(Long id);     
    
    
    //funcion para registrar datos
    CarritoEntity add(CarritoEntity detcar);
    
    //funcion para actualizar datos
    CarritoEntity update(CarritoEntity detcar);    
    
    //funcion para eliminar datos unitario
    public void deleteregistroCarrito(Long xidcarrito);
    
    
    //funcion para eliminar datos unitario
    public void deleteCarrito(Long xidusuario);

}
