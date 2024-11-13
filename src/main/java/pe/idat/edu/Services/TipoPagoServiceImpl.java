package pe.idat.edu.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.TipoPagoEntity;
import pe.idat.edu.Repository.TipoPagoRepository;

@Service
public class TipoPagoServiceImpl  implements TipoPagoService{

   @Autowired
      private TipoPagoRepository tipopagoRepository;
        
    @Override
    public List< TipoPagoEntity> findAll() {
        return tipopagoRepository.findAll();
    }

    @Override
    public List< TipoPagoEntity> findAllCustom() {
       return tipopagoRepository.findAllCustom();
    }

    @Override
    public Optional< TipoPagoEntity> findById(Long id) {
      return tipopagoRepository.findById(id);
    }

    @Override
    public  TipoPagoEntity add( TipoPagoEntity tp) {
       return tipopagoRepository.save(tp);
    }


    @Override
    public  TipoPagoEntity delete( TipoPagoEntity tp) {
       TipoPagoEntity  objetipopago= tipopagoRepository.getById(tp.getIdtipopago());
        objetipopago.setEstado(false);
        return tipopagoRepository.save(objetipopago);
}

    @Override
    public TipoPagoEntity update(TipoPagoEntity tp) {
        TipoPagoEntity  objetipopago = tipopagoRepository.getById(tp.getIdtipopago());
        BeanUtils.copyProperties(tp, objetipopago);
        return tipopagoRepository.save(objetipopago);
    }
}

