package ni.edu.uam.facturacion.modelo;

import lombok.Setter;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Getter @Setter
public class Categoria {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length=32)
    String id;

    @Column(length=50)
    String descripcion;

}
