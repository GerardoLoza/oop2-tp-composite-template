package ejercicio2;

abstract class ItemTrabajo {
    protected String nombre;
    protected String descripcion;

    public ItemTrabajo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Método abstracto para calcular el tiempo
    public abstract int calcularTiempo();

    // Métodos para manejo de componentes (por defecto no hacen nada)
    public void agregar(ItemTrabajo item) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    public void remover(ItemTrabajo item) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    public ItemTrabajo obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}
