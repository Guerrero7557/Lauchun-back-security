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
@Entity(name="DetalleCompraEntity")
@Table(name="detallecompra")
public class DetalleCompraEntity implements Serializable{
    
   private final static long serialVersionUID = 1L;
    
    @Id
    @Column(name = "iddetallecom")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iddetallecom;     
    
    @ManyToOne
    @JoinColumn(name="idcompra", nullable = false)
    private CompraEntity idcompra;
    
    @ManyToOne
    @JoinColumn(name="idproducto", nullable = false)
    private ProductoEntity idproducto;
    
    @Column(name = "costo")
    private double costo;
    
    @Column(name = "cantidad")
    private int cantidad;  
    
}
