package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.CompraEntity;
import pe.idat.edu.Repository.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraRepository ComRep;

    @Override
    public List<CompraEntity> findAll() {
        return ComRep.findAll();
    }

    @Override
    public List<CompraEntity> findAllCustom() {
        return ComRep.findAllCustom();
    }

    @Override
    public Optional<CompraEntity> findById(Long id) {
        return ComRep.findById(id);
    }

    @Override
    public CompraEntity add(CompraEntity co) {
        return ComRep.save(co);
    }

    @Override
    public CompraEntity update(CompraEntity co) {
        CompraEntity objcompra = ComRep.getById(co.getIdcompra());
        BeanUtils.copyProperties(co, objcompra);
        return ComRep.save(objcompra);
    }

    @Override
    public CompraEntity delete(CompraEntity co) {
        CompraEntity objcompra = ComRep.getById(co.getIdcompra());
        objcompra.setEstado(false);
        return ComRep.save(objcompra);
    }
}
