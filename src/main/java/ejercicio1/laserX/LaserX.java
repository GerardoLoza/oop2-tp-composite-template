package ejercicio1.laserX;

import ejercicio1.modelo.Empleado;

public class LaserX {
    private Empleado director;

    public LaserX(Empleado director) {
        this.director = director;
    }

    public void mostrarCostoSalarial() {
        System.out.println(director.calcularSalarioTotal());
    }
}
