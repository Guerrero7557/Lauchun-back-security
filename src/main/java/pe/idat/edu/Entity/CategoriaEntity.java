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
@Entity(name = "CategoriaEntity")
@Table(name = "categoria")
public class CategoriaEntity implements Serializable{
    private final static long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcategoria;
    
    @Column(name = "nombrecategoria")
    private String nombrecategoria;
    
    @Column(name = "estado")
    private boolean estado;
}
