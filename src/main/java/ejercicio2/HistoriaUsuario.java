package ejercicio2;

import java.util.ArrayList;
import java.util.List;

class HistoriaUsuario extends ItemTrabajo {
    private List<ItemTrabajo> items;
    private int prioridad;

    public HistoriaUsuario(String nombre, String descripcion, int prioridad) {
        super(nombre, descripcion);
        this.items = new ArrayList<>();
        this.prioridad = prioridad;
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

    public int getPrioridad() { return prioridad; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }
    public List<ItemTrabajo> getItems() { return new ArrayList<>(items); }
    public int getCantidadItems() { return items.size(); }
}