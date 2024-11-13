/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.ProveedorEntity;

/**
 *
 * @author flores
 */
public interface ProveedorService {
    ///funcion que te permita mostrar todos los datos    
    List<ProveedorEntity> findAll();
    
    ///funcion para mostrar todods los datos habilitados
    List<ProveedorEntity> findAllCustom();
    
    ///funcion para buscar por codigo
    Optional<ProveedorEntity> findById(Long id);
    
    ///funcion para registrar datos
    ProveedorEntity add(ProveedorEntity pr);
    
    ///funcion para actualizar datos
   ProveedorEntity update(ProveedorEntity pr);
    
    ///funcion para eliminar datos
    ProveedorEntity delete(ProveedorEntity pr);
}
