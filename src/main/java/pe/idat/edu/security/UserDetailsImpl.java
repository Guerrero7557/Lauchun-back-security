package pe.idat.edu.security;

import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.idat.edu.Entity.UsuarioEntity;

//Clase que implementa la clase UserDetails 
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{
    
    
    
    private final UsuarioEntity usuario; // inicializamos l aclase usuario con la que vamos a trabajar

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();//retornamos una lista vacia
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();//retornamos contraseña
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();//retornamos username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public String getNombre(){
        return usuario.getNombre();
    }
    
}
