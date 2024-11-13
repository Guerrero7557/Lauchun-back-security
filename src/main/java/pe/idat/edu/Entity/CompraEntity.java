package pe.idat.edu.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
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
@Entity(name="CompraEntity")
@Table(name="compra")
public class CompraEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="idcompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcompra;
    
    @ManyToOne
     @JoinColumn(name="idproveedor", nullable = false)
    private ProveedorEntity idproveedor;
    
    @Column(name="fechacompra")
    private String fechacompra;
    
    @Column(name="estado")
    private boolean estado;     
}
