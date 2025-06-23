package ejercicio1.modelo;

public class Supervisor extends Empleado {

    public Supervisor(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularSalarioTotal() {
        double total = salario;
        for (Empleado subordinado : subordinados) {
            total += subordinado.calcularSalarioTotal();
        }
        return total;
    }
}

