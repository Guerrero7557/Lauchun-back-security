package pe.idat.edu.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins= {"http://localhost/4200"})
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
    

    //sobrescribimos el metodo de autenticacion
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        
        Authcredentials authCredentials = new Authcredentials(); // creamos un objeto que nos permitirá obtener las credenciales
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), Authcredentials.class);// convertimos a Json
        } catch (IOException ex) {
            Logger.getLogger(JWTAuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken( //instanciamso y le damos datos
                authCredentials.getEmail(), //obtenemos los datos de inicio de secion
                authCredentials.getPassword(),
                Collections.emptyList());
        
        return  getAuthenticationManager().authenticate(usernamePAT);
                   
    }

    
    //metodo para validar el la autenticacion
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        
       UserDetailsImpl userDetails =(UserDetailsImpl) authResult.getPrincipal();
       String token = TokenUtils.createToken(userDetails.getNombre(),userDetails.getUsername());//creamos el token con los datos del UserDetails
             
       response.addHeader("Authorization","Bearer " + token);  
       
       
       //enviamos los argumentos en en encabezado de la respuesta 
       response.getWriter().flush(); //confirmamos los cambios.
        
        super.successfulAuthentication(request, response, chain, authResult); 
    }
    
    
    
}
