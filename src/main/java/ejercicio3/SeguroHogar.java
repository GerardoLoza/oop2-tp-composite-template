package ejercicio3;

import java.math.BigDecimal;

public class SeguroHogar extends SeguroIndividual {
    private String direccionPropiedad;
    private BigDecimal valorPropiedad;
    private String tipoVivienda;

    public SeguroHogar(String nombre, String descripcion, BigDecimal costoBase,
                       String numeroPoliza, String direccionPropiedad, BigDecimal valorPropiedad) {
        super(nombre, descripcion, costoBase, numeroPoliza);
        this.direccionPropiedad = direccionPropiedad;
        this.valorPropiedad = valorPropiedad;
        this.tipoVivienda = "Casa";
    }

    public String getDireccionPropiedad() { return direccionPropiedad; }
    public void setDireccionPropiedad(String direccionPropiedad) { this.direccionPropiedad = direccionPropiedad; }
    public BigDecimal getValorPropiedad() { return valorPropiedad; }
    public void setValorPropiedad(BigDecimal valorPropiedad) { this.valorPropiedad = valorPropiedad; }
    public String getTipoVivienda() { return tipoVivienda; }
    public void setTipoVivienda(String tipoVivienda) { this.tipoVivienda = tipoVivienda; }
}
