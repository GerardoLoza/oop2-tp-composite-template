package ejercicio1.modelo;

public class EmpleadoRegular extends Empleado {

    public EmpleadoRegular(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularSalarioTotal() {
        return salario;
    }

    @Override
    public void agregarSubordinado(Empleado empleado) {
        throw new UnsupportedOperationException("Los empleados regulares no pueden tener subordinados");
    }

    @Override
    public void removerSubordinado(Empleado empleado) {
        throw new UnsupportedOperationException("Los empleados regulares no pueden tener subordinados");
    }

    // Sobrescribir getChild para lanzar excepción en Leaf
    @Override
    public Empleado getChild(int index) {
        throw new UnsupportedOperationException("Los empleados regulares no tienen subordinados");
    }

    @Override
    public int getChildCount() {
        return 0;
    }
}

