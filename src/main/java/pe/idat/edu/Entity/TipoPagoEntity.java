package pe.idat.edu.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder           
@AllArgsConstructor 
@NoArgsConstructor  
@Data        
@Entity(name = "TipoPagoEntity")
@Table(name = "tipopago")
public class TipoPagoEntity implements Serializable{
    
    private final static long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idtipopago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtipopago;     
        
    @Column(name = "nombtipopago")
    private String nombtipopago;
    
    @Column(name = "estado")
    private boolean estado;
    
}
