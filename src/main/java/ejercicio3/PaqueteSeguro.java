package ejercicio3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PaqueteSeguro extends ComponenteSeguro {
    private List<ComponenteSeguro> componentes;
    private static final BigDecimal DESCUENTO_POR_SEGURO = new BigDecimal("0.05"); // 5% por seguro
    private String codigoPaquete;

    public PaqueteSeguro(String nombre, String descripcion, String codigoPaquete) {
        super(nombre, descripcion);
        this.componentes = new ArrayList<>();
        this.codigoPaquete = codigoPaquete;
    }

    @Override
    public void agregar(ComponenteSeguro componente) {
        if (componente != null && !componentes.contains(componente)) {
            componentes.add(componente);
        }
    }

    @Override
    public void remover(ComponenteSeguro componente) {
        componentes.remove(componente);
    }

    @Override
    public ComponenteSeguro obtenerHijo(int indice) {
        if (indice >= 0 && indice < componentes.size()) {
            return componentes.get(indice);
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
    }

    @Override
    public List<ComponenteSeguro> obtenerHijos() {
        return new ArrayList<>(componentes);
    }

    @Override
    public int obtenerCantidadSeguros() {
        int cantidad = 0;
        for (ComponenteSeguro componente : componentes) {
            cantidad += componente.obtenerCantidadSeguros();
        }
        return cantidad;
    }

    @Override
    public BigDecimal calcularCosto() {
        if (componentes.isEmpty()) {
            return BigDecimal.ZERO;
        }

        // Calcular costo base sumando todos los componentes
        BigDecimal costoBase = BigDecimal.ZERO;
        for (ComponenteSeguro componente : componentes) {
            costoBase = costoBase.add(componente.calcularCosto());
        }

        // Aplicar descuento acumulativo del 5% por cada seguro en el paquete
        int cantidadSeguros = obtenerCantidadSeguros();
        BigDecimal descuentoTotal = DESCUENTO_POR_SEGURO.multiply(new BigDecimal(cantidadSeguros));

        // El descuento no puede ser mayor al 100%
        if (descuentoTotal.compareTo(BigDecimal.ONE) > 0) {
            descuentoTotal = BigDecimal.ONE;
        }

        BigDecimal factorDescuento = BigDecimal.ONE.subtract(descuentoTotal);
        BigDecimal costoFinal = costoBase.multiply(factorDescuento);

        return costoFinal.setScale(2, RoundingMode.HALF_UP);
    }

    // Getters
    public String getCodigoPaquete() { return codigoPaquete; }
    public void setCodigoPaquete(String codigoPaquete) { this.codigoPaquete = codigoPaquete; }
    public int getCantidadComponentes() { return componentes.size(); }
}
