package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.MarcaProdEntity;


public interface MarcaProdService {
    
    //funcion que te permita mostrar todos los datos    
    List<MarcaProdEntity> findAll();
    
    //funcion para mostrar todods los datos habilitados
    List<MarcaProdEntity> findAllCustom();
    
    //funcion para buscar por codigo
    Optional<MarcaProdEntity> findById(Long id);
    
    //funcion para registrar datos
    MarcaProdEntity add(MarcaProdEntity c);
    
    //funcion para actualizar datos
    MarcaProdEntity update(MarcaProdEntity c);
    
    //funcion para eliminar datos
    MarcaProdEntity delete(MarcaProdEntity c);
    
}
