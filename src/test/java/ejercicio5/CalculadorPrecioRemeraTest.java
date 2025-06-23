package ejercicio5;

import ejercicio5.CalculadorRemeraImportada;
import ejercicio5.CalculadorRemeraNacional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadorPrecioRemeraTest {

    private CalculadorRemeraImportada calculadorImportada;
    private CalculadorRemeraNacional calculadorNacional;

    private static final double PRECIO_BASE = 100.0;
    private static final double DELTA = 0.01;

    @BeforeEach
    void setUp() {
        calculadorImportada = new CalculadorRemeraImportada();
        calculadorNacional = new CalculadorRemeraNacional();
    }

    @Test
    void testCalculadorRemeraImportada() {
        double precioCalculado = calculadorImportada.calcularPrecioVenta(PRECIO_BASE);
        // Precio base: $100
        // + 3% recargo: $100 + $3 = $103
        // + 5% impuesto aduanero sobre $103: $103 + $5.15 = $108.15
        // + 25% ganancia comercio sobre $108.15: $108.15 + $27.04 = $135.19
        assertEquals(135.19, precioCalculado, DELTA);
    }

    @Test
    void testCalculadorRemeraNacional() {
        double precioCalculado = calculadorNacional.calcularPrecioVenta(PRECIO_BASE);
        // Precio base: $100
        // + 1.5% costo transporte: $100 + $1.5 = $101.5
        // - 20% bonificación sobre $101.5: $101.5 - $20.3 = $81.2
        // + 15% ganancia comercio sobre $81.2: $81.2 + $12.18 = $93.38
        assertEquals(93.38, precioCalculado, DELTA);
    }
}
