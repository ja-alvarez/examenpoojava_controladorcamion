package vista;

import controlador.ControladorCamion;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ventana extends JFrame {
    // Componentes AWT
    private TextField txtPatente, txtConductor, txtUbicacion, txtFechaMantenimiento;
    private Checkbox chkActivo;
    private Button btnAgregar, btnActualizar, btnEliminar, btnLeer;
    private ControladorCamion controlador;
    private JTable table;
    private DefaultTableModel tableModel;

    public Ventana() {
        configuracion();
    }

    private void configuracion() {
        controlador = new ControladorCamion();
        setTitle("Gestión de Flota 4.0");
        setSize(600, 600);
        setLayout(null); // Posicionamiento absoluto
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fondo de la ventana
        getContentPane().setBackground(Color.decode("#FFFFE0")); // Fondo de toda la ventana

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBounds(20, 20, 550, 550);
        panelPrincipal.setBackground(Color.decode("#FFFFE0")); // Fondo del panel principal
        add(panelPrincipal);

        // Sección de Datos del Camión con TitledBorder
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
                "Datos Camión", TitledBorder.LEFT, TitledBorder.TOP));
        panelDatos.setBounds(10, 10, 520, 200);
        panelDatos.setBackground(Color.decode("#FFFFE0")); // Fondo del panel de datos
        panelPrincipal.add(panelDatos);

        // Componentes AWT en panelDatos
        Label lblPatente = new Label("Patente:");
        lblPatente.setBounds(20, 30, 100, 25);
        panelDatos.add(lblPatente);

        txtPatente = new TextField();
        txtPatente.setBounds(130, 30, 200, 25);
        panelDatos.add(txtPatente);

        Label lblConductor = new Label("Conductor:");
        lblConductor.setBounds(20, 60, 100, 25);
        panelDatos.add(lblConductor);

        txtConductor = new TextField();
        txtConductor.setBounds(130, 60, 200, 25);
        panelDatos.add(txtConductor);

        Label lblUbicacion = new Label("Ubicación GPS:");
        lblUbicacion.setBounds(20, 90, 100, 25);
        panelDatos.add(lblUbicacion);

        txtUbicacion = new TextField();
        txtUbicacion.setBounds(130, 90, 200, 25);
        panelDatos.add(txtUbicacion);

        Label lblFecha = new Label("F. Mantenimiento:");
        lblFecha.setBounds(20, 120, 100, 25);
        panelDatos.add(lblFecha);

        txtFechaMantenimiento = new TextField();
        txtFechaMantenimiento.setBounds(130, 120, 200, 25);
        panelDatos.add(txtFechaMantenimiento);

        chkActivo = new Checkbox("Activo");
        chkActivo.setBounds(350, 30, 100, 25);
        panelDatos.add(chkActivo);

        // Sección de Operaciones CRUD con TitledBorder
        JPanel panelOperaciones = new JPanel();
        panelOperaciones.setLayout(null);
        panelOperaciones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
                "Operaciones", TitledBorder.LEFT, TitledBorder.TOP));
        panelOperaciones.setBounds(10, 220, 520, 80);
        panelOperaciones.setBackground(Color.decode("#FFFFE0")); // Fondo del panel de operaciones
        panelPrincipal.add(panelOperaciones);

        // Botones CRUD
        btnAgregar = new Button("Agregar");
        btnAgregar.setBounds(20, 30, 100, 30);
        panelOperaciones.add(btnAgregar);

        btnActualizar = new Button("Actualizar");
        btnActualizar.setBounds(130, 30, 100, 30);
        panelOperaciones.add(btnActualizar);

        btnEliminar = new Button("Eliminar");
        btnEliminar.setBounds(240, 30, 100, 30);
        panelOperaciones.add(btnEliminar);

        btnLeer = new Button("Leer");
        btnLeer.setBounds(350, 30, 100, 30);
        panelOperaciones.add(btnLeer);

        // Sección de la Base de Datos con TitledBorder
        JPanel panelBaseDatos = new JPanel();
        panelBaseDatos.setLayout(new BorderLayout());
        panelBaseDatos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
                "Base de Datos", TitledBorder.LEFT, TitledBorder.TOP));
        panelBaseDatos.setBounds(10, 310, 520, 200);
        panelBaseDatos.setBackground(Color.decode("#FFFFE0")); // Fondo del panel de base de datos
        panelPrincipal.add(panelBaseDatos);

        // Configuración de la JTable
        tableModel = new DefaultTableModel(
                new String[] { "ID", "Patente", "Conductor", "Ubicación", "Estado", "F. Mantemiento" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panelBaseDatos.add(scrollPane);


        // Cargar datos iniciales
        cargarDatos();
    }

    private void agregarCamion() {
        // Lógica de agregar aquí
    }

    private void actualizarCamion() {
        // Lógica de actualización aquí
    }

    private void eliminarCamion() {
        // Lógica de eliminación aquí
    }

    private void cargarDatos() {
        // Obtener los datos de la base de datos y llenar la tabla
    }
}
