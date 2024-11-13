package pe.idat.edu.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="VentaEntity")
@Table(name="venta")
public class VentaEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="idventa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idventa;
    
    @ManyToOne
     @JoinColumn(name="idusuario", nullable = false)
    private UsuarioEntity idusuario;
    
    @ManyToOne
    @JoinColumn(name="idtipopago", nullable = false)
    private TipoPagoEntity idtipopago;
    
    @Column(name="fechaventa")
    private String fechaventa;
    
    @Column(name="montototalv")
    private double montototalv;
    
    @Column(name="estado")
    private boolean estado;    
    
}
