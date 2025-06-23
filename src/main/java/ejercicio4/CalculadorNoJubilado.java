package ejercicio4;

public class CalculadorNoJubilado extends CalculadorBase {

    public CalculadorNoJubilado(LogTransaction log, int mesEnPromocion) {
        super(log, mesEnPromocion);
    }

    @Override
    protected double calcularImpuestos(double precioProducto) {
        // Para no jubilados: IVA reducido en mes de promoción, completo fuera de promoción
        if (estoEnMesDePromocion()) {
            return precioProducto * 0.15; // 15% de IVA en promoción
        } else {
            return precioProducto * 0.21; // 21% de IVA normal
        }
    }
}

