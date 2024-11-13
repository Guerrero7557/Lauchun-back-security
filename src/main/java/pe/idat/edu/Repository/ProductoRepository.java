package pe.idat.edu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.idat.edu.Entity.ProductoEntity;


public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    @Query("select p from ProductoEntity p where p.estado = 'Disponible'")
    List<ProductoEntity>findAllCustom();  
    
    @Query(value ="{call buscarporcategoria(:xidcategoria)}",nativeQuery=true)
    List<ProductoEntity>finCategoriaProd(@Param("xidcategoria") Long xidcategoria); 
}
