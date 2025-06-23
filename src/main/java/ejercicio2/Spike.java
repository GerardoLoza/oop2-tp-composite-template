package ejercicio2;

class Spike extends ItemTrabajo {
    private int tiempoAnalisis; // en horas

    public Spike(String nombre, String descripcion, int tiempoAnalisis) {
        super(nombre, descripcion);
        this.tiempoAnalisis = tiempoAnalisis;
    }

    @Override
    public int calcularTiempo() {
        return tiempoAnalisis;
    }

    public int getTiempoAnalisis() {
        return tiempoAnalisis;
    }

    public void setTiempoAnalisis(int tiempoAnalisis) {
        this.tiempoAnalisis = tiempoAnalisis;
    }
}
