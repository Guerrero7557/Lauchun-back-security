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
@Entity(name="UsuarioEntity")
@Table(name="usuario")
public class UsuarioEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idusuario;
    
    @ManyToOne
    @JoinColumn(name="idrol",nullable= false )
    private RolEntity idrol;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidos")
    private String apellidos;
    
    @Column(name="sexo")
    private String sexo;
    
    @Column(name="email")
    private String email;
    
    @Column(name="dni")
    private String dni;
    
    @Column(name="direccion")
    private String direccion;
    
    @Column(name="usuario")
    private String usuario;
    
    @Column(name="password")
    private String password;
    
    @Column(name="estado")
    private boolean estado;
    
}
