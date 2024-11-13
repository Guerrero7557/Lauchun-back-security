package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.DetalleCompraEntity;
import pe.idat.edu.Repository.DetalleCompraRepository;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService{

    @Autowired
    private DetalleCompraRepository detCompra;

    @Override
    public List<DetalleCompraEntity> findAll() {
        return detCompra.findAll();
    }    
    
    @Override
    public List<DetalleCompraEntity> findIdCompra(Long xidcompra) {
        return detCompra.findIdCompra(xidcompra);
    }

    @Override
    public Optional<DetalleCompraEntity> findById(Long id) {
        return detCompra.findById(id);
    }

    @Override
    public DetalleCompraEntity add(DetalleCompraEntity detcom) {
        return detCompra.save(detcom);
    }

    @Override
    public DetalleCompraEntity update(DetalleCompraEntity detcom) {
        DetalleCompraEntity objdetallecompra = detCompra.getById(detcom.getIddetallecom());
        BeanUtils.copyProperties(detcom, objdetallecompra);
        return detCompra.save(objdetallecompra);
    }
    
    /*
    @Override
    public DetalleCompraEntity delete(DetalleCompraEntity c) {
        DetalleCompraEntity objdetallecompra = detCompra.getById(c.getIddetallecom());
        objdetallecompra.setEstado(false);
        return detCompra.save(objdetallecompra);
    }*/
 
}
