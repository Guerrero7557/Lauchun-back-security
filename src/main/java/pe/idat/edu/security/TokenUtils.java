package pe.idat.edu.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;


public class TokenUtils {
    
    //creamos una variable que será la llave secreta para firmar el token
    private final static String ACCESS_TOKEN_SECRET = "4HaRstggfEEtgDTGsgERTGr54gHJjgFGkjG54";
    
    //variable que usaremos par definir el tiempo que va a durar el token
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
    
    //Clase para construir el token que se enviara hacia el cliente y los parametros que contendra
    public static String createToken(String nombre, String email){
        //convertimos la variable de tiempo ya creada y lo convertimos a milisegundos
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        //variable de tipo date que sera el tiempo que durará nuestro token
        Date expirationDate = new Date(System.currentTimeMillis()+ expirationTime);
        
        //Creamos un mapa que funciona como una mochila de datos adicional 
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre",nombre);
        
        return Jwts.builder()//construimos el token
                .setSubject(email)//a quien va dirigido este token
                .setExpiration(expirationDate)//tiempo de expiracion
                .addClaims(extra)//añadimos la data adicional de la mochila
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))//firmamos el token
                .compact(); 
        
    }
    
    //Metodo que me permite autenticar el token
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
        //Claims es un objeto de jwt que me permite reclamar datos del tipo jwt y/o que estén encriptados
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())//definimos la llave con la que sera validada el token
                .build()
                .parseClaimsJws(token)//convertimos el token para poder validarlo
                .getBody();//obtenemos el cuerpo
        
        String email = claims.getSubject();// extraemos el email 
        
        //retornamos una instancia enviandole algunos datos
        return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    
    } 

    
    
}
