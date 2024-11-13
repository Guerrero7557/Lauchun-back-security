/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.TipoPagoEntity;

/**
 *
 * @author flores
 */
public interface TipoPagoService {
       
    List<TipoPagoEntity> findAll();
    
    List<TipoPagoEntity>findAllCustom();
    
    Optional<TipoPagoEntity>findById(Long id);
    
    TipoPagoEntity add(TipoPagoEntity tp);
    
    TipoPagoEntity update (TipoPagoEntity tp);
    
    TipoPagoEntity delete (TipoPagoEntity tp);
    
}
