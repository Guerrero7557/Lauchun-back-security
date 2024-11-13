/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.idat.edu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.idat.edu.Entity.TipoPagoEntity;

/**
 *
 * @author flores
 */
public interface TipoPagoRepository  extends JpaRepository<TipoPagoEntity, Long>{
      @Query("select tp from TipoPagoEntity tp where tp.estado = true")
    List<TipoPagoEntity>findAllCustom();  
    
}
