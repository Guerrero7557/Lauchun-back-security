package pe.idat.edu.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder           
@AllArgsConstructor 
@NoArgsConstructor  
@Data        
@Entity(name = "ProductoEntity")
@Table(name = "producto")

public class ProductoEntity implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "idproducto")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idproducto;
    
    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false)
    private CategoriaEntity idcategoria;     
    
    @ManyToOne
    @JoinColumn(name = "idmarca", nullable = false)
    private MarcaProdEntity idmarca;   
    
    @Column(name = "nombproducto")
    private String nombproducto;
    
    @Column(name =  "precio")
    private double precio;
    
    @Column(name = "stock")
    private int stock;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private String estado;        
    
    @Column(name = "imagen")
    private String imagen;
   
}
