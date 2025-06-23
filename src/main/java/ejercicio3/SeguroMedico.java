package ejercicio3;

import java.math.BigDecimal;

public class SeguroMedico extends SeguroIndividual {
    private String planMedico;
    private boolean incluyeOdontologia;
    private boolean incluyeVision;
    private BigDecimal deducible;

    public SeguroMedico(String nombre, String descripcion, BigDecimal costoBase,
                        String numeroPoliza, String planMedico, boolean incluyeOdontologia,
                        boolean incluyeVision, BigDecimal deducible) {
        super(nombre, descripcion, costoBase, numeroPoliza);
        this.planMedico = planMedico;
        this.incluyeOdontologia = incluyeOdontologia;
        this.incluyeVision = incluyeVision;
        this.deducible = deducible;
    }

    // Getters y Setters específicos
    public String getPlanMedico() { return planMedico; }
    public void setPlanMedico(String planMedico) { this.planMedico = planMedico; }
    public boolean isIncluyeOdontologia() { return incluyeOdontologia; }
    public void setIncluyeOdontologia(boolean incluyeOdontologia) { this.incluyeOdontologia = incluyeOdontologia; }
    public boolean isIncluyeVision() { return incluyeVision; }
    public void setIncluyeVision(boolean incluyeVision) { this.incluyeVision = incluyeVision; }
    public BigDecimal getDeducible() { return deducible; }
    public void setDeducible(BigDecimal deducible) { this.deducible = deducible; }
}
