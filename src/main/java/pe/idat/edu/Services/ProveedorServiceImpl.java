package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.ProveedorEntity;
import pe.idat.edu.Repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;
    
    @Override
    public List<ProveedorEntity> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public List<ProveedorEntity> findAllCustom() {
    return proveedorRepository.findAllCustom();
    }

    @Override
    public Optional<ProveedorEntity> findById(Long id) {
    return proveedorRepository.findById(id);
    }

    @Override
    public ProveedorEntity add(ProveedorEntity pr) {
       return proveedorRepository.save(pr);
    }

    @Override
    public ProveedorEntity update(ProveedorEntity pr) {
         ProveedorEntity objetoProveedor = proveedorRepository.getById(pr.getIdproveedor());
        BeanUtils.copyProperties(pr, objetoProveedor);
        return proveedorRepository.save(objetoProveedor);    
    }

    @Override
    public ProveedorEntity delete(ProveedorEntity pr) {
         ProveedorEntity objetoProveedor = proveedorRepository.getById(pr.getIdproveedor());
        objetoProveedor.setEstado(false);
        return proveedorRepository.save(objetoProveedor);      
    } 
    
}
