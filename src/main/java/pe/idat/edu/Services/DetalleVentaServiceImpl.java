package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.DetalleVentaEntity;
import pe.idat.edu.Repository.DetalleVentaRepository;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService{

    @Autowired
    private DetalleVentaRepository detVenta;

    @Override
    public List<DetalleVentaEntity> findAll() {
        return detVenta.findAll();
    }
    
    
    @Override
    public List<DetalleVentaEntity> findIdVenta(Long xidventa) {
        return detVenta.findIdVenta(xidventa);
    }

    @Override
    public Optional<DetalleVentaEntity> findById(Long id) {
        return detVenta.findById(id);
    }

    @Override
    public DetalleVentaEntity add(DetalleVentaEntity detven) {
        return detVenta.save(detven);
    }

    @Override
    public DetalleVentaEntity update(DetalleVentaEntity detven) {
        DetalleVentaEntity objdetalleventa = detVenta.getById(detven.getIddetalle());
        BeanUtils.copyProperties(detven, objdetalleventa);
        return detVenta.save(objdetalleventa);
    }

    /*
    @Override
    public DetalleVentaEntity delete(DetalleVentaEntity detven) {
        DetalleVentaEntity objdetalleventa = detVenta.getById(detven.getIddetalle());
        objdetalleventa.setEstado(false);
        return detVenta.save(objdetalleventa);
    }*/


}