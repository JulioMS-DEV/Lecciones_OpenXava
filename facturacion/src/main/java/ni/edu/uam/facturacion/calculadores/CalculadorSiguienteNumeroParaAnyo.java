package ni.edu.uam.facturacion.calculadores;

import javax.persistence.*;
import lombok.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

public class CalculadorSiguienteNumeroParaAnyo implements ICalculator{

    @Getter
    @Setter
    int anyo;
    @Override
    public Object calculate() throws Exception {
        Query query = XPersistence.getManager().createQuery("select max(f.numero) from Factura f where f.anyo = :anyo");
        query.setParameter("anyo", anyo);
        Integer ultimoNumero = (Integer)query.getSingleResult();
        return ultimoNumero == null? 1: ultimoNumero + 1;
    }
}
