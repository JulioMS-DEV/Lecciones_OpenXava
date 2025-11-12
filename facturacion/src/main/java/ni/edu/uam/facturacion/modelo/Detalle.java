package ni.edu.uam.facturacion.modelo;
import javax.persistence.*;
import lombok.*;

@Embeddable @Getter @Setter
public class Detalle {
    int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Producto producto;
}
