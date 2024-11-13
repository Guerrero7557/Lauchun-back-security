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
import pe.idat.edu.Entity.MarcaProdEntity;
import pe.idat.edu.Services.MarcaProdService;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins= {"http://localhost/4200"})
public class MarcaProdController {
    
    @Autowired
    private MarcaProdService marcarep;
    
    @GetMapping
    public List<MarcaProdEntity> findAll(){
        return marcarep.findAll();
    }
    
    @GetMapping("/custom")
    public List<MarcaProdEntity>findAllCustom(){
        return marcarep.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<MarcaProdEntity> findById(@PathVariable Long id){
        return marcarep.findById(id);
    }
    
    @PostMapping
    public MarcaProdEntity add (@RequestBody MarcaProdEntity m){
        return marcarep.add(m);
    }
    
    @PutMapping("{id}")
    public MarcaProdEntity update(@PathVariable long id, @RequestBody MarcaProdEntity m){
        m.setIdmarca(id);
        return marcarep.update(m);
    }
    
    @DeleteMapping("/{id}")
    public MarcaProdEntity delete(@PathVariable long id){
        MarcaProdEntity objmarca = new MarcaProdEntity();
        objmarca.setEstado(false);
        return marcarep.delete(MarcaProdEntity.builder().idmarca(id).build());
    }
    
}
