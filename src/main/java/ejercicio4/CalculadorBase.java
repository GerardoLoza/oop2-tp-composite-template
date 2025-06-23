package ejercicio4;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class CalculadorBase implements Calculador {
    protected LogTransaction log;
    protected int mesEnPromocion;

    public CalculadorBase(LogTransaction log, int mesEnPromocion) {
        this.log = log;
        this.mesEnPromocion = mesEnPromocion;
    }

    public final double calcularPrecio(double precioProducto) {
        double precioTotal = precioProducto;

        // Paso variable: calcular impuestos según el tipo de calculador
        precioTotal += calcularImpuestos(precioProducto);

        // Paso común: hacer logging
        realizarLogging();

        return precioTotal;
    }

    protected abstract double calcularImpuestos(double precioProducto);

    private void realizarLogging() {
        log.log(this.getClass().getName());
    }

    protected boolean estoEnMesDePromocion() {
        return of(mesEnPromocion).equals(now().getMonth());
    }
}

