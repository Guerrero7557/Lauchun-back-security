package pe.idat.edu.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

@CrossOrigin(origins= {"http://localhost/4200"})
//filtro para autorizacion de los endpoints segun el token generado
@Component //notacion para que la clase sea tratada como objeto gestionado por sprint y permitir la inyeccion de dependencias asi como la gestion de permisos para acceder a algunos enpoints
public class JWTAuthorizationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        
        String bearerToken = request.getHeader("Authorization");// una ves validado el usuario el token que ese genere tendra acceso a las interfaces de su rol
        
        //validamos algunos estandares de los usuarios
        if(bearerToken != null && bearerToken.startsWith("Bearer")){
            String token = bearerToken.replace("Bearer ", "");//extraemos el token
            UsernamePasswordAuthenticationToken usernamePAT = TokenUtils.getAuthentication(token);//extraemos el token con token Utils
            SecurityContextHolder.getContext().setAuthentication(usernamePAT);//Establecemos la autenticacion
        }
        filterChain.doFilter(request, response);
    }
    
}
