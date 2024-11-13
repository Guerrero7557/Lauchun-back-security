package pe.idat.edu.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.idat.edu.Entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    @Query("select u from UsuarioEntity u where u.estado=true")
    List<UsuarioEntity>findAllCustom();
    
    //METODO QUE ME VA A PERMITIR ENCONTRAR UN USUARIO POR SU EMAIL
    @Query(value ="{call buscaremail(:xemail)}",nativeQuery=true)    
    Optional<UsuarioEntity> findOnebyEmail(@Param("xemail") String xemail);
}
