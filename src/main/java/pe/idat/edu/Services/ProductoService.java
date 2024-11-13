package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import pe.idat.edu.Entity.ProductoEntity;

public interface ProductoService {
    
    List<ProductoEntity> findAll();
    
    
    List<ProductoEntity> findAllCustom();
    
    //buscar por categoria
    List<ProductoEntity> finCategoriaProd(Long xidcategoria);
    
    
    Optional<ProductoEntity> findById(Long id);
    
    
    ProductoEntity add (ProductoEntity p);
    
    
    ProductoEntity update (ProductoEntity p);
    
    
    ProductoEntity delete (ProductoEntity p);

    
        
}
