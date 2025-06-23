package ejercicio3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class SeguroTest {

    private PaqueteSeguro paqueteFamiliar;
    private PaqueteSeguro paqueteCompleto;
    private SeguroHogar seguroHogar;
    private SeguroAutomovil seguroAuto;
    private SeguroVida seguroVida;
    private SeguroMedico seguroMedico;

    @BeforeEach
    void setUp() {
        // Crear seguros individuales para las pruebas
        seguroHogar = new SeguroHogar("Seguro Hogar Premium", "Cobertura completa para el hogar",
                new BigDecimal("1000.00"), "POL-HOG-001",
                "Av. Principal 123", new BigDecimal("200000.00"));

        seguroAuto = new SeguroAutomovil("Seguro Auto Completo", "Cobertura total para vehículo",
                new BigDecimal("800.00"), "POL-AUTO-001",
                "Toyota", "Corolla", 2022, "ABC-123");

        seguroVida = new SeguroVida("Seguro de Vida Familiar", "Protección para la familia",
                new BigDecimal("500.00"), "POL-VIDA-001",
                new BigDecimal("100000.00"), "María García", 35);

        seguroMedico = new SeguroMedico("Seguro Médico Integral", "Cobertura médica completa",
                new BigDecimal("1200.00"), "POL-MED-001",
                "Plan Premium", true, true, new BigDecimal("500.00"));
    }

    @Test
    void testPaqueteFamiliarConDiferentesTiposSeguros() {
        paqueteFamiliar = new PaqueteSeguro("Paquete Familiar Premium",
                "Protección completa para toda la familia", "PKG-FAM-001");

        paqueteFamiliar.agregar(seguroHogar);    // $1000
        paqueteFamiliar.agregar(seguroAuto);     // $800
        paqueteFamiliar.agregar(seguroVida);     // $500
        paqueteFamiliar.agregar(seguroMedico);   // $1200

        BigDecimal costoSinDescuento = new BigDecimal("3500.00"); // 1000 + 800 + 500 + 1200
        int cantidadSeguros = 4;
        BigDecimal descuentoEsperado = new BigDecimal("0.20"); // 4 seguros × 5% = 20%
        BigDecimal costoEsperado = costoSinDescuento.multiply(BigDecimal.ONE.subtract(descuentoEsperado))
                .setScale(2, RoundingMode.HALF_UP); // $2800.00

        assertEquals(cantidadSeguros, paqueteFamiliar.obtenerCantidadSeguros());
        assertEquals(costoEsperado, paqueteFamiliar.calcularCosto());
        assertEquals(4, paqueteFamiliar.getCantidadComponentes());
    }
}
