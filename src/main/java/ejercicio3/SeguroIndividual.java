package ejercicio3;

import java.math.BigDecimal;

public abstract class SeguroIndividual extends ComponenteSeguro {
    protected BigDecimal costoBase;
    protected String numeroPoliza;
    protected String fechaVencimiento;

    public SeguroIndividual(String nombre, String descripcion, BigDecimal costoBase, String numeroPoliza) {
        super(nombre, descripcion);
        this.costoBase = costoBase;
        this.numeroPoliza = numeroPoliza;
    }

    @Override
    public BigDecimal calcularCosto() {
        return costoBase;
    }

    @Override
    public int obtenerCantidadSeguros() {
        return 1; // Un seguro individual cuenta como 1
    }

    // Getters y Setters
    public BigDecimal getCostoBase() { return costoBase; }
    public void setCostoBase(BigDecimal costoBase) { this.costoBase = costoBase; }
    public String getNumeroPoliza() { return numeroPoliza; }
    public void setNumeroPoliza(String numeroPoliza) { this.numeroPoliza = numeroPoliza; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
}

