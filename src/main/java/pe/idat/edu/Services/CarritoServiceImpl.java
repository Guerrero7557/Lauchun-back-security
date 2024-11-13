package pe.idat.edu.Services;

import static java.lang.System.console;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.CarritoEntity;
import pe.idat.edu.Repository.CarritoRepository;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired
    private CarritoRepository detCarrito;

    @Override
    public List<CarritoEntity> findAll() {
        return detCarrito.findAll();
    }
    
    @Override
    public List<CarritoEntity> findIdUsuario(Long xidusuario) {
        return detCarrito.findIdUsuario(xidusuario);
    }

    @Override
    public Optional<CarritoEntity> findById(Long id) {
        return detCarrito.findById(id);
    }

    @Override
    public CarritoEntity add(CarritoEntity detcar) {
        return detCarrito.save(detcar);
    }

    @Override
    public CarritoEntity update(CarritoEntity detcar) {
        CarritoEntity objdetcarrito = detCarrito.getById(detcar.getIdcarrito());
        BeanUtils.copyProperties(detcar, objdetcarrito);
        return detCarrito.save(objdetcarrito);
    }
    
    /*
    @Override
    public DetCarritoEntity delete(DetCarritoEntity detcar) {
        DetCarritoEntity objdetcarrito = detCarrito.getById(detcar.getIddetcarrito());
        objdetcarrito.setEstado(false);
        return detCarrito.save(objdetcarrito);
    }*/

    @Override
    public void deleteregistroCarrito(Long xidcarrito) {
        detCarrito.deleteById(xidcarrito);
    }
    
    

    @Override
    public void deleteCarrito(Long xidusuario) {
        try {
            detCarrito.deleteCarrito(xidusuario);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        
    }

    
    
}
