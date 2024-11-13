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
@Entity(name="CarritoEntity")
@Table(name="carrito")
public class CarritoEntity implements Serializable{
    
    private final static long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idcarrito")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcarrito;     
    
    @ManyToOne
    @JoinColumn(name="idusuario", nullable = false)
    private UsuarioEntity idusuario;
    
    @ManyToOne
    @JoinColumn(name="idproducto", nullable = false)
    private ProductoEntity idproducto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "montoprod")
    private double montoprod;
    
}
