/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.idat.edu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.idat.edu.Entity.ProveedorEntity;

/**
 *
 * @author flores
 */
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>{
    @Query("select pr from ProveedorEntity pr where pr.estado = true")
    List<ProveedorEntity>findAllCustom();
    
}
