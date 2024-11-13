/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import pe.idat.edu.Entity.TipoPagoEntity;
import pe.idat.edu.Services.TipoPagoService;

/**
 *
 * @author flores
 */
@RestController
@RequestMapping("/tipopago")
@CrossOrigin(origins= {"http://localhost/4200"})
public class TipoPagoController {
     @Autowired
    
    private TipoPagoService tipopagoRepository;
    
    @GetMapping
    public List<TipoPagoEntity> findAll(){
        return tipopagoRepository.findAll();
    }
    
    @GetMapping("/custom")
    public List<TipoPagoEntity>findAllCustom(){
        return tipopagoRepository.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<TipoPagoEntity> findById(@PathVariable Long id){
        return tipopagoRepository.findById(id);
    }
    
    @PostMapping
    public TipoPagoEntity add (@RequestBody TipoPagoEntity tp){
        return tipopagoRepository.add(tp);
    }
    
    @PutMapping("{id}")
    public TipoPagoEntity update(@PathVariable long id, @RequestBody TipoPagoEntity tp){
        tp.setIdtipopago(id);
        return tipopagoRepository.update(tp);
    }
    
    @DeleteMapping("/{id}")
    public TipoPagoEntity delete(@PathVariable long id){
      TipoPagoEntity objetipopago= new TipoPagoEntity();
        objetipopago.setEstado(false);
        return tipopagoRepository.delete(TipoPagoEntity.builder().idtipopago(id).build());
    }
    
}
