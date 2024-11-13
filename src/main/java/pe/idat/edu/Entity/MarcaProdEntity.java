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
@Entity(name = "MarcaProdEntity")
@Table(name = "marcaprod")
public class MarcaProdEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "idmarca")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idmarca;
    
    
    @Column(name = "nombmarca")
    private String nombmarca;
    
    @Column(name = "estado")
    private boolean estado;
    
       
}
