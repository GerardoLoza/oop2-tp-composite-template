package ejercicio3;

import java.math.BigDecimal;

public class SeguroVida extends SeguroIndividual {
    private BigDecimal montoCobertura;
    private String beneficiario;
    private int edadAsegurado;

    public SeguroVida(String nombre, String descripcion, BigDecimal costoBase,
                      String numeroPoliza, BigDecimal montoCobertura, String beneficiario, int edadAsegurado) {
        super(nombre, descripcion, costoBase, numeroPoliza);
        this.montoCobertura = montoCobertura;
        this.beneficiario = beneficiario;
        this.edadAsegurado = edadAsegurado;
    }

    // Getters y Setters específicos
    public BigDecimal getMontoCobertura() { return montoCobertura; }
    public void setMontoCobertura(BigDecimal montoCobertura) { this.montoCobertura = montoCobertura; }
    public String getBeneficiario() { return beneficiario; }
    public void setBeneficiario(String beneficiario) { this.beneficiario = beneficiario; }
    public int getEdadAsegurado() { return edadAsegurado; }
    public void setEdadAsegurado(int edadAsegurado) { this.edadAsegurado = edadAsegurado; }
}