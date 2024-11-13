package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.CategoriaEntity;
import pe.idat.edu.Repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository CatRep;

    @Override
    public List<CategoriaEntity> findAll() {
        return CatRep.findAll();
    }

    @Override
    public List<CategoriaEntity> findAllCustom() {
        return CatRep.findAllCustom();
    }

    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        return CatRep.findById(id);
    }

    @Override
    public CategoriaEntity add(CategoriaEntity c) {
        return CatRep.save(c);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity c) {
        CategoriaEntity objcategoria = CatRep.getById(c.getIdcategoria());
        BeanUtils.copyProperties(c, objcategoria);
        return CatRep.save(objcategoria);
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity c) {
        CategoriaEntity objcategoria = CatRep.getById(c.getIdcategoria());
        objcategoria.setEstado(false);
        return CatRep.save(objcategoria);
    }
}
