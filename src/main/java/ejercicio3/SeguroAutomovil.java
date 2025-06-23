package ejercicio3;

import java.math.BigDecimal;

public class SeguroAutomovil extends SeguroIndividual {
    private String marca;
    private String modelo;
    private int anio;
    private String patente;

    public SeguroAutomovil(String nombre, String descripcion, BigDecimal costoBase,
                           String numeroPoliza, String marca, String modelo, int anio, String patente) {
        super(nombre, descripcion, costoBase, numeroPoliza);
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
}