package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ComponenteSeguro {
    protected String nombre;
    protected String descripcion;

    public ComponenteSeguro(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract BigDecimal calcularCosto();

    public abstract int obtenerCantidadSeguros();

    public void agregar(ComponenteSeguro componente) {
        throw new UnsupportedOperationException("Operación no soportada para este tipo de componente");
    }

    public void remover(ComponenteSeguro componente) {
        throw new UnsupportedOperationException("Operación no soportada para este tipo de componente");
    }

    public ComponenteSeguro obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Operación no soportada para este tipo de componente");
    }

    public List<ComponenteSeguro> obtenerHijos() {
        throw new UnsupportedOperationException("Operación no soportada para este tipo de componente");
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}
