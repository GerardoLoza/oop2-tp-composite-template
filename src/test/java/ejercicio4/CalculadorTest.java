package ejercicio4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class CalculadorTest {

    private LogTransactionTest logTest;

    private static final double PRECIO_PRODUCTO = 100.0;
    private static final double DELTA = 0.01;

    @BeforeEach
    void setUp() {
        logTest = new LogTransactionTest();
    }

    @Test
    void jubiladoConPromocion() {
        int mesActual = LocalDate.now().getMonthValue();
        CalculadorJubilado calculador = new CalculadorJubilado(logTest, mesActual);

        double resultado = calculador.calcularPrecio(PRECIO_PRODUCTO);

        assertEquals(100.0, resultado, DELTA);
        assertEquals(CalculadorJubilado.class.getName(), logTest.getLastLoggedClass());
    }

    @Test
    void jubiladoSinPromocion() {
        int mesDistinto = (LocalDate.now().getMonthValue() % 12) + 1; // Mes diferente al actual
        CalculadorJubilado calculador = new CalculadorJubilado(logTest, mesDistinto);

        double resultado = calculador.calcularPrecio(PRECIO_PRODUCTO);

        assertEquals(110.0, resultado, DELTA);
        assertEquals(CalculadorJubilado.class.getName(), logTest.getLastLoggedClass());
    }

    @Test
    void noJubiladoEnMesDePromocion() {
        int mesActual = LocalDate.now().getMonthValue();
        CalculadorNoJubilado calculador = new CalculadorNoJubilado(logTest, mesActual);

        double resultado = calculador.calcularPrecio(PRECIO_PRODUCTO);

        assertEquals(115.0, resultado, DELTA);
        assertEquals(CalculadorNoJubilado.class.getName(), logTest.getLastLoggedClass());
    }

    @Test
    void noJubiladoFueraDePromocion() {
        int mesDistinto = (LocalDate.now().getMonthValue() % 12) + 1; // Mes diferente al actual
        CalculadorNoJubilado calculador = new CalculadorNoJubilado(logTest, mesDistinto);

        double resultado = calculador.calcularPrecio(PRECIO_PRODUCTO);

        assertEquals(121.0, resultado, DELTA);
        assertEquals(CalculadorNoJubilado.class.getName(), logTest.getLastLoggedClass());
    }
}

