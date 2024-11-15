package pe.idat.edu.email;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.idat.edu.Entity.DetalleVentaEntity;

@Builder           
@AllArgsConstructor 
@NoArgsConstructor  
@Data 
public class Boleta {
    private String para;
    private String nombreCliente;  
    private String dni;
    private String direccion; 
    private String email;     
    private String numeroBoleta;
    private String fecha; 
    private List<DetalleVentaEntity> detalles;
    private double total;   
}
