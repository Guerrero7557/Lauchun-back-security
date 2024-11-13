/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.RolEntity;

/**
 *
 * @author flores
 */
public interface RolService {
    List<RolEntity> findAll();
    
    List<RolEntity>findAllCustom();
    
    Optional<RolEntity>findById(Long id);
    
    RolEntity add(RolEntity r);
    
    RolEntity update (RolEntity r);
    
    RolEntity delete (RolEntity r);
    
}
