package ni.edu.uam.facturacion.modelo;
import javax.persistence.*;
import lombok.*;
import ni.edu.uam.facturacion.calculadores.CalculadorSiguienteNumeroParaAnyo;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import java.time.LocalDate;
import java.util.Collection;

@Entity @Getter @Setter
public class Factura {

    @Id
    @GeneratedValue(generator = "system.uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String oid;

    @DefaultValueCalculator(CurrentYearCalculator.class)
    @Column(length = 4)
    int anyo;

    @Column(length = 6)
    @DefaultValueCalculator(value = CalculadorSiguienteNumeroParaAnyo.class,
            properties = @PropertyValue(name = "anyo"))
    int numero;

    @DefaultValueCalculator(CurrentDateCalculator.class)
    @Required
    LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Cliente cliente;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;

    @Stereotype("MEMO")
    String observaciones;

}
