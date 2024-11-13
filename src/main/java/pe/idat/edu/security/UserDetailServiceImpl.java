package pe.idat.edu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.idat.edu.Entity.UsuarioEntity;
import pe.idat.edu.Repository.UsuarioRepository;



@Service //definimos como servicio implementamos la clase y el metodo que tiene
public class UserDetailServiceImpl implements UserDetailsService{
    
    @Autowired//injeccion
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioEntity  usuario = usuarioRepository 
                .findOnebyEmail(email)//llamamos al metodo del repositoy                
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email :" + email +" no existe")); //validamos si no existe que me retorne null
        return new UserDetailsImpl(usuario);
    }
    
}
