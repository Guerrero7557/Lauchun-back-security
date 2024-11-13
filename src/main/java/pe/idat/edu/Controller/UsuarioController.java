package pe.idat.edu.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.idat.edu.Entity.UsuarioEntity;
import pe.idat.edu.Services.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins= {"http://localhost/4200"})
public class UsuarioController {
    
    @Autowired
    private UsuarioService UsuSer;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping
    public List<UsuarioEntity>findAll(){
        return UsuSer.findAll();
    }
    
    @GetMapping("/custom")
    public List<UsuarioEntity>findAllCustom(){
        return UsuSer.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<UsuarioEntity>findById(@PathVariable Long id ){
        
        return UsuSer.findById(id);
    }
    
    @GetMapping("/xemail/{xemail}")
    public Optional<UsuarioEntity>findOnebyEmail(@PathVariable String xemail ){        
        return UsuSer.findOnebyEmail(xemail);
    }
    
    @PostMapping
    public UsuarioEntity add(@RequestBody UsuarioEntity u){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return UsuSer.add(u);
    }
    
    @PutMapping("/{id}")
    public UsuarioEntity update(@PathVariable long id, @RequestBody UsuarioEntity u){
        u.setIdusuario(id);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return UsuSer.update(u);
    }
    
    @DeleteMapping("/{id}")
    public UsuarioEntity delete(@PathVariable long id){
        UsuarioEntity objusuario = new UsuarioEntity();
        objusuario.setEstado(false);
        return UsuSer.delete(UsuarioEntity.builder().idusuario(id).build());
    }
}