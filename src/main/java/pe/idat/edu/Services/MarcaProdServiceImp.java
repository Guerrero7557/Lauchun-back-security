package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.MarcaProdEntity;
import pe.idat.edu.Repository.MarcaProdRepository;

@Service
public class MarcaProdServiceImp implements MarcaProdService{

    @Autowired
    private MarcaProdRepository marcarep;
    
    @Override
    public List<MarcaProdEntity> findAll() {
        return marcarep.findAll();
    }

    @Override
    public List<MarcaProdEntity> findAllCustom() {
        return marcarep.findAllCustom();
    }

    @Override
    public Optional<MarcaProdEntity> findById(Long id) {
        return marcarep.findById(id);
    }

    @Override
    public MarcaProdEntity add(MarcaProdEntity c) {
        return marcarep.save(c);
    }

    @Override
    public MarcaProdEntity update(MarcaProdEntity c) {
        MarcaProdEntity objmarca = marcarep.getById(c.getIdmarca());
        BeanUtils.copyProperties(c, objmarca);
        return marcarep.save(objmarca);
    }

    @Override
    public MarcaProdEntity delete(MarcaProdEntity c) {
        MarcaProdEntity objmarca = marcarep.getById(c.getIdmarca());
        objmarca.setEstado(false);
        return marcarep.save(objmarca);
    }
    
}
