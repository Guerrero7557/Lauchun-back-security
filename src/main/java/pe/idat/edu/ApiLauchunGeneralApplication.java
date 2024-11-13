package pe.idat.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiLauchunGeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLauchunGeneralApplication.class, args);
	}
        
        @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {   
                            
                            registry.addMapping("/login").allowedOrigins("*")
                                    .allowedMethods("*")
                                    .exposedHeaders("*");
                            
				registry.addMapping("/**")
                                        .allowedOrigins("*");
			}
		};
	}
        

}
