package pe.idat.edu.Controller;

import java.util.ArrayList;
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
import pe.idat.edu.Entity.CompraEntity;
import pe.idat.edu.Entity.DetalleCompraEntity;
import pe.idat.edu.Entity.ProductoEntity;
import pe.idat.edu.Services.CompraService;
import pe.idat.edu.Services.ProductoService;
import pe.idat.edu.Services.DetalleCompraService;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins= {"http://localhost/4200"})
public class CompraController {
    
    @Autowired
    private CompraService ComSer;
    
    @Autowired
    private ProductoService prodSer;
    
    @Autowired
    private DetalleCompraService detSer;
    
    @GetMapping
    public List<CompraEntity>findAll(){
        return ComSer.findAll();
    }
    
    @GetMapping("/custom")
    public List<CompraEntity>findAllCustom(){
        return ComSer.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<CompraEntity>findById(@PathVariable Long id ){
        return ComSer.findById(id);
    }
    
    @PostMapping
    public CompraEntity add(@RequestBody CompraEntity co){        
        return ComSer.add(co);
        
    }
    
    @PutMapping("/{id}")
    public CompraEntity update(@PathVariable long id, @RequestBody CompraEntity co){
        co.setIdcompra(id);
        
        //intento por realizar la actualizacion del stock
        
        try {
            ArrayList<DetalleCompraEntity> detalles = new ArrayList<DetalleCompraEntity>();        
        if(co.isEstado()== true){
            detalles = (ArrayList<DetalleCompraEntity>) detSer.findIdCompra(co.getIdcompra());
            for (DetalleCompraEntity detalle : detalles) {
                ProductoEntity producto = new ProductoEntity();
                  Optional<ProductoEntity> productoOptional = prodSer.findById(detalle.getIdproducto().getIdproducto());
                  producto = productoOptional.get();
                  int stock = detalle.getCantidad()+ producto.getStock() ;
                  producto.setStock(stock);
                prodSer.update(producto);
            }           
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        return ComSer.update(co);
    }
    
    @DeleteMapping("/{id}")
    public CompraEntity delete(@PathVariable long id){
        CompraEntity objcompra = new CompraEntity();
        objcompra.setEstado(false);
        return ComSer.delete(CompraEntity.builder().idcompra(id).build());
    }
}