package ejercicio1.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    protected String nombre;
    protected double salario;
    protected List<Empleado> subordinados;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
        this.subordinados = new ArrayList<>();
    }

    public void agregarSubordinado(Empleado empleado) {
        subordinados.add(empleado);
    }

    public void removerSubordinado(Empleado empleado) {
        subordinados.remove(empleado);
    }

    public abstract double calcularSalarioTotal();

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public Empleado getChild(int index) {
        if (index >= 0 && index < subordinados.size()) {
            return subordinados.get(index);
        }
        return null;
    }

    public int getChildCount() {
        return subordinados.size();
    }
}
