package ejercicio2;

class Tarea extends ItemTrabajo {
    private int tiempoEstimado; // en horas

    public Tarea(String nombre, String descripcion, int tiempoEstimado) {
        super(nombre, descripcion);
        this.tiempoEstimado = tiempoEstimado;
    }

    @Override
    public int calcularTiempo() {
        return tiempoEstimado;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}
