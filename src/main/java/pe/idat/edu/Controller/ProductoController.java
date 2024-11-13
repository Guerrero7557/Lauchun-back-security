package pe.idat.edu.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.idat.edu.Entity.ProductoEntity;
import pe.idat.edu.Services.ProductoService;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins= {"http://localhost/4200"})
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    public List<ProductoEntity> findAll(){
        return productoService.findAll();
    }
    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom(){
        return productoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable Long id){
        return productoService.findById(id);
    }
    
    //buscar por categoria
    
    @GetMapping("/buscarxcateg/{xidcategoria}")
    public List<ProductoEntity> finCategoriaProd(@PathVariable Long xidcategoria){
        return productoService.finCategoriaProd(xidcategoria);
    }

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity p){
        return productoService.add(p);
    }

    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable long id, @RequestBody ProductoEntity p) {
        p.setIdproducto(id);
        return productoService.update(p);
    }

    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable long id) {
        ProductoEntity ObjetoProducto= new ProductoEntity();
        ObjetoProducto.setEstado("Agotado");
        return productoService.delete(ProductoEntity.builder().idproducto(id).build());
    }
    
}
