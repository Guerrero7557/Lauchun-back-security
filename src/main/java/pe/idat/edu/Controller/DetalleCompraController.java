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
import pe.idat.edu.Entity.DetalleCompraEntity;
import pe.idat.edu.Services.DetalleCompraService;

@RestController
@RequestMapping("/detallecompra")
@CrossOrigin(origins= {"http://localhost/4200"})
public class DetalleCompraController {
    
    @Autowired
    private DetalleCompraService DetComServ;
    
    @GetMapping
    public List<DetalleCompraEntity>findAll(){
        return DetComServ.findAll();
    }    
    
    @GetMapping("/{id}")
    public Optional<DetalleCompraEntity>findById(@PathVariable Long id ){
        return DetComServ.findById(id);
    }
    
    @GetMapping("/buscarporcompra/{xidcompra}")
    public List<DetalleCompraEntity> findIdVenta(@PathVariable Long xidcompra){
        return DetComServ.findIdCompra(xidcompra);
    }
    
    @PostMapping
    public DetalleCompraEntity add(@RequestBody DetalleCompraEntity detcom){
        return DetComServ.add(detcom);
    }
    
    @PutMapping("/{id}")
    public DetalleCompraEntity update(@PathVariable long id, @RequestBody DetalleCompraEntity detcom){
        detcom.setIddetallecom(id);
        return DetComServ.update(detcom);
    }
    
    /*
    @DeleteMapping("/{id}")
    public DetalleCompraEntity delete(@PathVariable long id){
        DetalleCompraEntity objdetallecompra = new DetalleCompraEntity();
        objdetallecompra.setEstado(false);
        return DetComServ.delete(DetalleCompraEntity.builder().iddetallecom(id).build());
    }*/
}
