
package pe.idat.edu.Repository;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.idat.edu.Entity.CarritoEntity;

public interface CarritoRepository extends JpaRepository<CarritoEntity, Long>{ 
    
    @Query(value ="{call buscardetalleporusuario(:xidusuario)}",nativeQuery=true)
    List<CarritoEntity>findIdUsuario(@Param("xidusuario") Long xidusuario);
    
    
    
    
    @Query(value ="{call eliminarregistroscarrito(:xidusuario)}", nativeQuery = true)
    void deleteCarrito(@Param("xidusuario")Long xidusuario);
    
    /*
    @Query(value ="{delete from CarritoEntity c where c.idusuario=(:xidusuario)}", nativeQuery = true)
    void deleteCarrito(@Param("xidusuario")Long xidusuario);
    */
}
