package pe.idat.edu.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.idat.edu.Entity.CarritoEntity;
import pe.idat.edu.Services.CarritoService;

@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins= {"http://localhost/4200"})
public class CarritoController {
    
    @Autowired
    private CarritoService DetCarServ;
    
    @GetMapping
    public List<CarritoEntity>findAll(){
        return DetCarServ.findAll();
    }    
    
    @GetMapping("/buscarporusuario/{xidusuario}")
    public List<CarritoEntity>findIdUsuario(@PathVariable Long xidusuario){
        return DetCarServ.findIdUsuario(xidusuario);
    }
            
    @GetMapping("/{id}")
    public Optional<CarritoEntity>findById(@PathVariable Long id ){
        return DetCarServ.findById(id);
    }
    
    @PostMapping
    public CarritoEntity add(@RequestBody CarritoEntity detcar){
        return DetCarServ.add(detcar);
    }
    
    @PutMapping("/{id}")
    public CarritoEntity update(@PathVariable long id, @RequestBody CarritoEntity detcar){
        detcar.setIdcarrito(id);
        return DetCarServ.update(detcar);
    }
    /*
    @DeleteMapping("/{id}")
    public DetCarritoEntity delete(@PathVariable long id){
        DetCarritoEntity objcabcarrito = new DetCarritoEntity();
        objcabcarrito.setEstado(false);
        return DetCarServ.delete(DetCarritoEntity.builder().idcabcarrito(id).build());
    }*/
    
    @DeleteMapping("/{xidcarrito}")
    public ResponseEntity<?> deleteregistroCarrito(@PathVariable long xidcarrito) {
        DetCarServ.deleteregistroCarrito(xidcarrito);
        return new ResponseEntity("Registro eliminado", HttpStatus.OK);
    } 
    
    
    @DeleteMapping("/borrarxusuario/{xidusuario}")
    public ResponseEntity<?> deleteCarrito(@PathVariable("xidusuario") long xidusuario) {
        DetCarServ.deleteCarrito(xidusuario);
        return new ResponseEntity("Carrito limpio", HttpStatus.OK);
    } 
   
}
