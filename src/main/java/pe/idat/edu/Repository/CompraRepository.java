package pe.idat.edu.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.idat.edu.Entity.CompraEntity;


public interface CompraRepository extends JpaRepository<CompraEntity, Long>{
     @Query("select co from CompraEntity co where co.estado=true")
    List<CompraEntity>findAllCustom();  
    
}
