/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.VentaEntity;
import pe.idat.edu.Repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {
    
    @Autowired
    private VentaRepository ventarepository;
    
    @Override
    public List<VentaEntity> findAll(){
        return ventarepository.findAll();
    }

    @Override
    public List<VentaEntity> findAllCustom() {
    return ventarepository.findAllCustom();    }

    @Override
    public Optional<VentaEntity> findById(Long id) {
     return ventarepository.findById(id);
    }

    @Override
    public VentaEntity add(VentaEntity v) {
    return ventarepository.save(v);
    }

    @Override
    public VentaEntity update(VentaEntity v) {
          VentaEntity  objeventa = ventarepository.getById(v.getIdventa());
        BeanUtils.copyProperties(v, objeventa);
        return ventarepository.save(objeventa);
    }

    @Override
    public VentaEntity delete(VentaEntity v) {
      VentaEntity  objeventa= ventarepository.getById(v.getIdventa());
        objeventa.setEstado(false);
        return ventarepository.save(objeventa);
}
    
}
