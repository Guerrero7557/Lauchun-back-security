package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.UsuarioEntity;

public interface UsuarioService {
    //funcion que te permita mostrar todos los datos    
    List<UsuarioEntity> findAll();
    
    //funcion para mostrar todods los datos habilitados
    List<UsuarioEntity> findAllCustom();
    
    //funcion para buscar por codigo
    Optional<UsuarioEntity> findById(Long id);
    
    //funcion para buscar por codigo
    Optional<UsuarioEntity> findOnebyEmail(String xemail);
    
    //funcion para registrar datos
    UsuarioEntity add(UsuarioEntity u);
    
    //funcion para actualizar datos
    UsuarioEntity update(UsuarioEntity u);
    
    //funcion para eliminar datos
    UsuarioEntity delete(UsuarioEntity u);
}
