package ejercicio5;

public abstract class CalculadorPrecioRemera {

    public final double calcularPrecioVenta(double precioUnitario) {
        double precio = precioUnitario;

        precio = aplicarRecargos(precio);
        precio = aplicarBonificaciones(precio);
        precio = aplicarGananciaComercio(precio);

        return precio;
    }

    protected abstract double aplicarRecargos(double precio);
    protected abstract double aplicarBonificaciones(double precio);
    protected abstract double aplicarGananciaComercio(double precio);

    protected double aplicarPorcentaje(double precio, double porcentaje) {
        return precio * (porcentaje / 100.0);
    }
}

