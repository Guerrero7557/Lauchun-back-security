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
import pe.idat.edu.Entity.CategoriaEntity;
import pe.idat.edu.Services.CategoriaService;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins= {"http://localhost/4200"})
public class CategoriaController {
    
    @Autowired
    private CategoriaService CatSer;
    
    @GetMapping
    public List<CategoriaEntity>findAll(){
        return CatSer.findAll();
    }
    
    @GetMapping("/custom")
    public List<CategoriaEntity>findAllCustom(){
        return CatSer.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<CategoriaEntity>findById(@PathVariable Long id ){
        return CatSer.findById(id);
    }
    
    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c){
        return CatSer.add(c);
    }
    
    @PutMapping("/{id}")
    public CategoriaEntity update(@PathVariable long id, @RequestBody CategoriaEntity c){
        c.setIdcategoria(id);
        return CatSer.update(c);
    }
    
    @DeleteMapping("/{id}")
    public CategoriaEntity delete(@PathVariable long id){
        CategoriaEntity objcategoria = new CategoriaEntity();
        objcategoria.setEstado(false);
        return CatSer.delete(CategoriaEntity.builder().idcategoria(id).build());
    }
}
