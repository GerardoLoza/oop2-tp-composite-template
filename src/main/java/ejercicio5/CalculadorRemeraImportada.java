package ejercicio5;

public class CalculadorRemeraImportada extends CalculadorPrecioRemera {

    private static final double RECARGO_PORCENTAJE = 3.0;
    private static final double IMPUESTO_ADUANERO_PORCENTAJE = 5.0;
    private static final double GANANCIA_COMERCIO_PORCENTAJE = 25.0;

    @Override
    protected double aplicarRecargos(double precio) {
        // Aplicar 3% de recargo
        double recargo = aplicarPorcentaje(precio, RECARGO_PORCENTAJE);
        precio += recargo;

        // Aplicar 5% de impuesto aduanero
        double impuestoAduanero = aplicarPorcentaje(precio, IMPUESTO_ADUANERO_PORCENTAJE);
        precio += impuestoAduanero;

        return precio;
    }

    @Override
    protected double aplicarBonificaciones(double precio) {
        // Las remeras importadas no tienen bonificaciones
        return precio;
    }

    @Override
    protected double aplicarGananciaComercio(double precio) {
        // Aplicar 25% de ganancia del comercio
        double ganancia = aplicarPorcentaje(precio, GANANCIA_COMERCIO_PORCENTAJE);
        return precio + ganancia;
    }
}

