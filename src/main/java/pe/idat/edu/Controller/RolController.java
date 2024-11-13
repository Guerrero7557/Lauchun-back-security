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
import pe.idat.edu.Entity.RolEntity;
import pe.idat.edu.Services.RolService;


@RestController
@RequestMapping("/rol")
@CrossOrigin(origins= {"http://localhost/4200"})
public class RolController {
    
    @Autowired    
    private RolService rolRepository;
    
    @GetMapping
    public List<RolEntity> findAll(){
        return rolRepository.findAll();
    }
    
    @GetMapping("/custom")
    public List<RolEntity>findAllCustom(){
        return rolRepository.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<RolEntity> findById(@PathVariable Long id){
        return rolRepository.findById(id);
    }
    
    @PostMapping
    public RolEntity add (@RequestBody RolEntity r){
        return rolRepository.add(r);
    }
    
    @PutMapping("{id}")
    public RolEntity update(@PathVariable long id, @RequestBody RolEntity r){
        r.setIdrol(id);
        return rolRepository.update(r);
    }
    
    @DeleteMapping("/{id}")
    public RolEntity delete(@PathVariable long id){
       RolEntity objerol= new RolEntity();
        objerol.setEstado(false);
        return rolRepository.delete(RolEntity.builder().idrol(id).build());
    }
    
}

