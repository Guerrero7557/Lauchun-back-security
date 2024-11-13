package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.CategoriaEntity;

public interface CategoriaService {
    //funcion que te permita mostrar todos los datos    
    List<CategoriaEntity> findAll();
    
    //funcion para mostrar todods los datos habilitados
    List<CategoriaEntity> findAllCustom();
    
    //funcion para buscar por codigo
    Optional<CategoriaEntity> findById(Long id);
    
    //funcion para registrar datos
    CategoriaEntity add(CategoriaEntity c);
    
    //funcion para actualizar datos
    CategoriaEntity update(CategoriaEntity c);
    
    //funcion para eliminar datos
    CategoriaEntity delete(CategoriaEntity c);
}
