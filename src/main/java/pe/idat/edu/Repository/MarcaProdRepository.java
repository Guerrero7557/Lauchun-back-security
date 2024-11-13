package pe.idat.edu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.idat.edu.Entity.MarcaProdEntity;


public interface MarcaProdRepository extends JpaRepository<MarcaProdEntity, Long>{
    @Query("select m from MarcaProdEntity m where m.estado=true")
    List<MarcaProdEntity>findAllCustom();
}

