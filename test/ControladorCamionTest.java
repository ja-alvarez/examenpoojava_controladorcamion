import static org.junit.Assert.assertEquals;
import org.junit.Test;
import controlador.ControladorCamion;
import modelo.Camion;
import java.sql.Date;

public class ControladorCamionTest {
    // PRUEBAS CREAR
    // Prueba agregar un camion activo a la base de datos
    @Test
    public void testAgregarCamionActivo() {
        ControladorCamion controlador = new ControladorCamion();
        Camion camion = new Camion(
                0,
                "TEST001",
                "Conductor Test",
                "Temuco",
                true,
                Date.valueOf("2026-09-06"));
        controlador.agregarCamion(camion);
        boolean encontrado = false;
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST001")) {
                encontrado = true;
            }
        }
        assertEquals(true, encontrado);

        // Limpiar registro de prueba
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST001")) {
                controlador.eliminarCamion(c.getId());
            }
        }
    }

    // Prueba agregar un camion inactivo a la base de datos
    @Test
    public void testAgregarCamionInactivo() {
        ControladorCamion controlador = new ControladorCamion();
        Camion camion = new Camion(
                0,
                "TEST002",
                "Conductor Test 2",
                "Padre Las Casas",
                false,
                Date.valueOf("2026-09-06"));
        controlador.agregarCamion(camion);
        boolean encontrado = false;
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST002")) {
                encontrado = true;
            }
        }
        assertEquals(true, encontrado);

        // Limpiar registro de prueba
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST002")) {
                controlador.eliminarCamion(c.getId());
            }
        }
    }

    // PRUEBAS LEER
    // Prueba que existen camiones registrados
    @Test
    public void testLeerCamiones() {
        ControladorCamion controlador = new ControladorCamion();
        boolean tieneCamiones = controlador.leerCamiones().size() > 0;
        assertEquals(true, tieneCamiones);
    }

    // Prueba encontrar un camion agregado
    @Test
    public void testLeerCamionAgregado() {
        ControladorCamion controlador = new ControladorCamion();
        Camion camion = new Camion(
                0,
                "TEST_LEER",
                "Conductor Test",
                "Temuco",
                true,
                Date.valueOf("2026-09-06"));
        controlador.agregarCamion(camion);
        boolean encontrado = false;
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_LEER")) {
                encontrado = true;
            }
        }
        assertEquals(true, encontrado);

        // Limpiar registro de prueba
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_LEER")) {
                controlador.eliminarCamion(c.getId());
            }
        }
    }

    // PRUEBAS ACTUALIZAR
    // Prueba actualizar los datos de un camion
    @Test
    public void testActualizarCamion() {
        ControladorCamion controlador = new ControladorCamion();
        Camion camion = new Camion(
                0,
                "TEST_UPDATE1",
                "Conductor Original",
                "Temuco",
                true,
                Date.valueOf("2026-09-06"));
        controlador.agregarCamion(camion);
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_UPDATE1")) {
                c.setConductor("Conductor Actualizado");
                controlador.actualizarCamion(c);
            }
        }
        boolean actualizado = false;
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_UPDATE1")
                    && c.getConductor().equals("Conductor Actualizado")) {
                actualizado = true;
            }
        }
        assertEquals(true, actualizado);

        // Limpiar registro de prueba
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_UPDATE1")) {
                controlador.eliminarCamion(c.getId());
            }
        }
    }

    // Prueba actualizar estado de un camion
    @Test
    public void testActualizarEstadoCamion() {
        ControladorCamion controlador = new ControladorCamion();
        Camion camion = new Camion(
                0,
                "TEST_UPDATE2",
                "Conductor Test",
                "Temuco",
                false,
                Date.valueOf("2026-09-06"));
        controlador.agregarCamion(camion);
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_UPDATE2")) {
                c.setEstado(true);
                controlador.actualizarCamion(c);
            }
        }
        boolean actualizado = false;
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_UPDATE2") && c.isEstado()) {
                actualizado = true;
            }
        }
        assertEquals(true, actualizado);

        // Limpiar registro de prueba
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_UPDATE2")) {
                controlador.eliminarCamion(c.getId());
            }
        }
    }

    // PRUEBAS ELIMINAR
    // Prueba eliminar un camion
    @Test
    public void testEliminarCamion() {
        ControladorCamion controlador = new ControladorCamion();
        Camion camion = new Camion(
                0,
                "TEST_DELETE1",
                "Conductor Test",
                "Temuco",
                true,
                Date.valueOf("2026-09-06"));
        controlador.agregarCamion(camion);
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_DELETE1")) {
                controlador.eliminarCamion(c.getId());
            }
        }
        boolean encontrado = false;
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_DELETE1")) {
                encontrado = true;
            }
        }
        assertEquals(false, encontrado);
    }

    // Prueba eliminar un segundo camion
    @Test
    public void testEliminarSegundoCamion() {
        ControladorCamion controlador = new ControladorCamion();
        Camion camion = new Camion(
                0,
                "TEST_DELETE2",
                "Conductor Test 2",
                "Padre Las Casas",
                false,
                Date.valueOf("2026-09-06"));
        controlador.agregarCamion(camion);
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_DELETE2")) {
                controlador.eliminarCamion(c.getId());
            }
        }
        boolean encontrado = false;
        for (Camion c : controlador.leerCamiones()) {
            if (c.getPatente().equals("TEST_DELETE2")) {
                encontrado = true;
            }
        }
        assertEquals(false, encontrado);
    }
}