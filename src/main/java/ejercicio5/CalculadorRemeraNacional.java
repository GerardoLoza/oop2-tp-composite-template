package ejercicio5;

public class CalculadorRemeraNacional extends CalculadorPrecioRemera {

    private static final double COSTO_TRANSPORTE_PORCENTAJE = 1.5;
    private static final double BONIFICACION_PORCENTAJE = 20.0;
    private static final double GANANCIA_COMERCIO_PORCENTAJE = 15.0;

    @Override
    protected double aplicarRecargos(double precio) {
        // Aplicar 1.5% de costo de transporte
        double costoTransporte = aplicarPorcentaje(precio, COSTO_TRANSPORTE_PORCENTAJE);
        return precio + costoTransporte;
    }

    @Override
    protected double aplicarBonificaciones(double precio) {
        // Aplicar 20% de bonificación (descuento)
        double bonificacion = aplicarPorcentaje(precio, BONIFICACION_PORCENTAJE);
        return precio - bonificacion;
    }

    @Override
    protected double aplicarGananciaComercio(double precio) {
        // Aplicar 15% de ganancia del comercio
        double ganancia = aplicarPorcentaje(precio, GANANCIA_COMERCIO_PORCENTAJE);
        return precio + ganancia;
    }
}
