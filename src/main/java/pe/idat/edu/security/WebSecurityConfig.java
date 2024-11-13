package pe.idat.edu.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import pe.idat.edu.Controller.ProductoController;

@Configuration
@AllArgsConstructor
@CrossOrigin(origins= {"http://localhost/4200"})
public class WebSecurityConfig {
    
     private final UserDetailsService userDetailsService;//Definimos un Objeto
    private final JWTAuthorizationFilter jwtAuthorizationFilter;//Definimos un Objeto 
    
    @Bean 
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
        
       
       JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
       jwtAuthenticationFilter.setAuthenticationManager(authManager);
       jwtAuthenticationFilter.setFilterProcessesUrl("/login");
       
        return http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .regexMatchers(HttpMethod.GET, "/producto/custom")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)//filtro de autenticacion
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)//filtro de autorizacion
                .build(); 
        
    }
    
     
    /*
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles()
                .build());
        return manager;                
    }
    
*/
    
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }  
    
    /*
    public static void main(String[] args) {
        System.out.println("pass "+ new BCryptPasswordEncoder().encode("hola123"));
    }
*/
    
}
