package ejercicio2;

import java.util.ArrayList;
import java.util.List;

class ProyectoScrum extends ItemTrabajo {
    private List<ItemTrabajo> items;
    private String fechaInicio;
    private String fechaFin;

    public ProyectoScrum(String nombre, String descripcion) {
        super(nombre, descripcion);
        this.items = new ArrayList<>();
    }

    @Override
    public void agregar(ItemTrabajo item) {
        items.add(item);
    }

    @Override
    public void remover(ItemTrabajo item) {
        items.remove(item);
    }

    @Override
    public ItemTrabajo obtenerHijo(int indice) {
        if (indice >= 0 && indice < items.size()) {
            return items.get(indice);
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    @Override
    public int calcularTiempo() {
        int tiempoTotal = 0;
        for (ItemTrabajo item : items) {
            tiempoTotal += item.calcularTiempo();
        }
        return tiempoTotal;
    }

    public List<ItemTrabajo> getItems() { return new ArrayList<>(items); }
    public int getCantidadItems() { return items.size(); }
    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }
}