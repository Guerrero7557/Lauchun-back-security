package pe.idat.edu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.idat.edu.Entity.VentaEntity;


public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
    @Query("select v from VentaEntity v where v.estado = true")
    List<VentaEntity>findAllCustom();
}
