package ejercicio2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ProyectoScrumTest {

    private ProyectoScrum proyecto;
    private HistoriaUsuario historia1;
    private HistoriaUsuario historia2;

    @BeforeEach
    void setUp() {
        // Setup común para los tests
        proyecto = new ProyectoScrum("Sistema de E-commerce",
                "Desarrollo de plataforma de comercio electrónico");
    }

    @Test
    void calcularTiempoTest1() {
        historia1 = new HistoriaUsuario("Login de Usuario",
                "Como usuario quiero poder iniciar sesión", 1);

        historia1.agregar(new Tarea("Diseñar formulario de login", "Crear interfaz de usuario", 4));
        historia1.agregar(new Tarea("Implementar autenticación", "Lógica de validación", 8));
        historia1.agregar(new Tarea("Testing de login", "Pruebas unitarias e integración", 4));

        historia2 = new HistoriaUsuario("Carrito de Compras",
                "Como usuario quiero agregar productos al carrito", 2);

        historia2.agregar(new Tarea("Diseñar carrito", "Interfaz del carrito", 6));
        historia2.agregar(new Tarea("Lógica de carrito", "Agregar/remover productos", 10));
        historia2.agregar(new Spike("Análisis de persistencia", "Investigar opciones de almacenamiento", 3));

        Spike spikeArquitectura = new Spike("Análisis de Arquitectura",
                "Definir arquitectura general del sistema", 8);

        proyecto.agregar(historia1);
        proyecto.agregar(historia2);
        proyecto.agregar(spikeArquitectura);

        int tiempoEsperadoHistoria1 = 4 + 8 + 4; // 16 horas
        int tiempoEsperadoHistoria2 = 6 + 10 + 3; // 19 horas
        int tiempoEsperadoTotal = tiempoEsperadoHistoria1 + tiempoEsperadoHistoria2 + 8; // 43 horas

        assertEquals(tiempoEsperadoHistoria1, historia1.calcularTiempo());
        assertEquals(tiempoEsperadoHistoria2, historia2.calcularTiempo());
        assertEquals(tiempoEsperadoTotal, proyecto.calcularTiempo());
    }

    @Test
    void calcularTiempoTest2() {
        ProyectoScrum proyectoPrincipal = new ProyectoScrum("Sistema de Gestión",
                "Sistema integral de gestión empresarial");

        HistoriaUsuario moduloVentas = new HistoriaUsuario("Módulo de Ventas",
                "Funcionalidades de gestión de ventas", 1);

        moduloVentas.agregar(new Tarea("Registro de ventas", "Formulario de registro", 6));
        moduloVentas.agregar(new Tarea("Reportes de ventas", "Generar reportes", 8));
        moduloVentas.agregar(new Spike("Análisis de KPIs", "Definir métricas de ventas", 4));

        HistoriaUsuario moduloInventario = new HistoriaUsuario("Módulo de Inventario",
                "Control de stock y productos", 2);

        moduloInventario.agregar(new Tarea("Gestión de productos", "CRUD de productos", 12));
        moduloInventario.agregar(new Tarea("Control de stock", "Seguimiento de inventario", 10));
        moduloInventario.agregar(new Tarea("Alertas de stock", "Notificaciones automáticas", 5));

        Spike spikeIntegracion = new Spike("Integración con ERP",
                "Análisis de integración con sistemas existentes", 16);
        Spike spikeSeguridad = new Spike("Análisis de Seguridad",
                "Definir políticas de seguridad", 12);

        proyectoPrincipal.agregar(moduloVentas);
        proyectoPrincipal.agregar(moduloInventario);
        proyectoPrincipal.agregar(spikeIntegracion);
        proyectoPrincipal.agregar(spikeSeguridad);

        int tiempoModuloVentas = 6 + 8 + 4; // 18 horas
        int tiempoModuloInventario = 12 + 10 + 5; // 27 horas
        int tiempoSpikes = 16 + 12; // 28 horas
        int tiempoTotal = tiempoModuloVentas + tiempoModuloInventario + tiempoSpikes; // 73 horas

        assertEquals(tiempoModuloVentas, moduloVentas.calcularTiempo());
        assertEquals(tiempoModuloInventario, moduloInventario.calcularTiempo());
        assertEquals(tiempoTotal, proyectoPrincipal.calcularTiempo());
    }
}