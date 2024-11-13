package pe.idat.edu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.idat.edu.Entity.DetalleCompraEntity;


public interface DetalleCompraRepository extends JpaRepository<DetalleCompraEntity, Long>{ 
    @Query(value ="{call buscardetallecompra(:xidcompra)}",nativeQuery=true)
    List<DetalleCompraEntity>findIdCompra(@Param("xidcompra") Long xidcompra);
}
