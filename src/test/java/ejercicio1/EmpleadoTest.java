package ejercicio1;

import ejercicio1.modelo.Empleado;
import ejercicio1.modelo.EmpleadoRegular;
import ejercicio1.modelo.Supervisor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void calcularSalarioTotal() {
        Empleado director = new Supervisor("Director", 10000);
        Empleado gerente1 = new Supervisor("Gerente 1", 8000);
        Empleado gerente2 = new Supervisor("Gerente 2", 8000);

        Empleado mandoMedio1 = new Supervisor("Mando Medio 1", 6000);
        Empleado mandoMedio2 = new Supervisor("Mando Medio 2", 6000);

        Empleado lider1 = new Supervisor("Líder 1", 4000);
        Empleado lider2 = new Supervisor("Líder 2", 4000);

        Empleado empleado1 = new EmpleadoRegular("Empleado 1", 3000);
        Empleado empleado2 = new EmpleadoRegular("Empleado 2", 3000);
        Empleado empleado3 = new EmpleadoRegular("Empleado 3", 3000);
        Empleado empleado4 = new EmpleadoRegular("Empleado 4", 3000);

        director.agregarSubordinado(gerente1);
        director.agregarSubordinado(gerente2);

        gerente1.agregarSubordinado(mandoMedio1);
        gerente2.agregarSubordinado(mandoMedio2);

        mandoMedio1.agregarSubordinado(lider1);
        mandoMedio2.agregarSubordinado(lider2);

        lider1.agregarSubordinado(empleado1);
        lider1.agregarSubordinado(empleado2);
        lider2.agregarSubordinado(empleado3);
        lider2.agregarSubordinado(empleado4);

        // Verificar cálculo total
        double salarioTotal = director.calcularSalarioTotal();
        double esperado = 10000 + 8000 + 8000 + 6000 + 6000 + 4000 + 4000 + 3000 + 3000 + 3000 + 3000;

        assertEquals(esperado, salarioTotal, 0.01);
    }

    @Test
    public void sinSubordinados() {
        EmpleadoRegular empleado = new EmpleadoRegular("Juan", 3000);
        EmpleadoRegular otroEmpleado = new EmpleadoRegular("Pedro", 3000);

        assertThrows(UnsupportedOperationException.class, () -> {
            empleado.agregarSubordinado(otroEmpleado);
        });

        assertEquals(3000, empleado.calcularSalarioTotal(), 0.01);
    }
}

