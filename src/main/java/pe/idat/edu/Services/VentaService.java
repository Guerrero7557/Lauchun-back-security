/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.VentaEntity;

/**
 *
 * @author flores
 */
public interface VentaService {
    ///funcion que te permita mostrar todos los datos    
    List<VentaEntity> findAll();
    
    ///funcion para mostrar todods los datos habilitados
    List<VentaEntity> findAllCustom();
    
    ///funcion para buscar por codigo
    Optional<VentaEntity> findById(Long id);
    
    ///funcion para registrar datos
    VentaEntity add(VentaEntity v);
    
    ///funcion para actualizar datos
    VentaEntity update(VentaEntity v);
    
    ///funcion para eliminar datos
    VentaEntity delete(VentaEntity v);
    
}

