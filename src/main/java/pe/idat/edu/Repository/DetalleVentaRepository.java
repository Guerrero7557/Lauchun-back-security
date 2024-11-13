package pe.idat.edu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.idat.edu.Entity.DetalleVentaEntity;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Long>{   
    @Query(value ="{call buscardetalleventa(:xidventa)}",nativeQuery=true)
    List<DetalleVentaEntity>findIdVenta(@Param("xidventa") Long xidventa); 
}
