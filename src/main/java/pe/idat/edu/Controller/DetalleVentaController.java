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
import pe.idat.edu.Entity.DetalleVentaEntity;
import pe.idat.edu.Entity.ProductoEntity;
import pe.idat.edu.Entity.VentaEntity;

import pe.idat.edu.Services.DetalleVentaService;
import pe.idat.edu.Services.ProductoService;
import pe.idat.edu.Services.VentaService;

@RestController
@RequestMapping("/detalleventa")
@CrossOrigin(origins= {"http://localhost/4200"})
public class DetalleVentaController {
    
    @Autowired
    private DetalleVentaService DetVenServ;
    
    @Autowired
    private ProductoService prodSer;
    
    @Autowired
    private VentaService VenServ;
    
    @GetMapping
    public List<DetalleVentaEntity>findAll(){
        return DetVenServ.findAll();
    }
        
    
    @GetMapping("/buscarporventa/{xidventa}")
    public List<DetalleVentaEntity> findIdVenta(@PathVariable Long xidventa){
        return DetVenServ.findIdVenta(xidventa);
    }
    
    @GetMapping("/{id}")
    public Optional<DetalleVentaEntity>findById(@PathVariable Long id ){
        return DetVenServ.findById(id);
    }
    
    @PostMapping
    public DetalleVentaEntity add(@RequestBody DetalleVentaEntity detven){
        
        try {
                ProductoEntity producto = new ProductoEntity();
                  Optional<ProductoEntity> productoOptional = prodSer.findById(detven.getIdproducto().getIdproducto());
                  producto = productoOptional.get();
                  if(producto.getStock()>detven.getCantidad()){
                    int stock =  producto.getStock()-detven.getCantidad() ;
                    producto.setStock(stock);
                    prodSer.update(producto);
                  }else{
                      producto.setEstado("Agotado");
                      prodSer.update(producto);
                  }
                  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return DetVenServ.add(detven);
    }
    
    @PutMapping("/{id}")
    public DetalleVentaEntity update(@PathVariable long id, @RequestBody DetalleVentaEntity detven){
        detven.setIddetalle(id);
        return DetVenServ.update(detven);
    }
    /*
    @DeleteMapping("/{id}")
    public DetalleVentaEntity delete(@PathVariable long id){
        DetalleVentaEntity objdetalleventa = new DetalleVentaEntity();
        objdetalleventa.setEstado(false);
        return DetVenServ.delete(DetalleVentaEntity.builder().iddetalle(id).build());
    }*/
}
