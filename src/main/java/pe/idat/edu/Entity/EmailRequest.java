package pe.idat.edu.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder           
@AllArgsConstructor 
@NoArgsConstructor  
@Data 
public class EmailRequest {
     private String to;
    private String subject;
    private String content;
}
