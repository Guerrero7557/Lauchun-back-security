package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.RolEntity;
import pe.idat.edu.Repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository rolRepository;
        
    @Override
    public List<RolEntity> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public List<RolEntity> findAllCustom() {
       return rolRepository.findAllCustom();
    }

    @Override
    public Optional<RolEntity> findById(Long id) {
      return rolRepository.findById(id);
    }

    @Override
    public RolEntity add(RolEntity r) {
       return rolRepository.save(r);
    }


    @Override
    public RolEntity delete(RolEntity r) {
      RolEntity  objerol= rolRepository.getById(r.getIdrol());
        objerol.setEstado(false);
        return rolRepository.save(objerol);
}

    @Override
    public RolEntity update(RolEntity r) {
        RolEntity  objerol = rolRepository.getById(r.getIdrol());
        BeanUtils.copyProperties(r, objerol);
        return rolRepository.save(objerol);
    }
    
}
