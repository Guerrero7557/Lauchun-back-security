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
import pe.idat.edu.Entity.ProveedorEntity;
import pe.idat.edu.Services.ProveedorService;

/**
 *
 * @author flores
 */
@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins= {"http://localhost/4200"})
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorRepository;
    
    @GetMapping
    public List<ProveedorEntity> findAll(){
        return proveedorRepository.findAll();
    }
    
    @GetMapping("/custom")
    public List<ProveedorEntity>findAllCustom(){
        return proveedorRepository.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<ProveedorEntity> findById(@PathVariable Long id){
        return proveedorRepository.findById(id);
    }
    
    @PostMapping
    public ProveedorEntity add (@RequestBody ProveedorEntity pr){
        return proveedorRepository.add(pr);
    }
    
    @PutMapping("{id}")
    public ProveedorEntity update(@PathVariable long id, @RequestBody ProveedorEntity pr){
        pr.setIdproveedor(id);
        return proveedorRepository.update(pr);
    }
    
    @DeleteMapping("/{id}")
    public ProveedorEntity delete(@PathVariable long id){
        ProveedorEntity objetoProveedor = new ProveedorEntity();
        objetoProveedor.setEstado(false);
        return proveedorRepository.delete(ProveedorEntity.builder().idproveedor(id).build());
    }
    
}


