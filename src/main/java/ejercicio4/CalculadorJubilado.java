package ejercicio4;

public class CalculadorJubilado extends CalculadorBase {

    public CalculadorJubilado(LogTransaction log, int mesEnPromocion) {
        super(log, mesEnPromocion);
    }

    @Override
    protected double calcularImpuestos(double precioProducto) {
        // Para jubilados: solo pagan IVA si NO están en mes de promoción
        if (!estoEnMesDePromocion()) {
            return precioProducto * 0.1; // 10% de IVA
        }
        return 0.0; // Sin IVA en mes de promoción
    }
}

