package controlador;

import modelo.Camion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCamion {
    // Métodos para insertar, leer, actualizar y eliminar...

    // Método para insertar un camion
    public void agregarCamion(Camion camion) {
        String sql = "INSERT INTO camion (patente, conductor, ubicacion_gps, estado, fecha_mantenimiento) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conexion = ConexionDB.conectar();
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, camion.getPatente());
            statement.setString(2, camion.getConductor());
            statement.setString(3, camion.getUbicacionGps());
            statement.setBoolean(4, camion.isEstado());
            statement.setDate(5, camion.getFechaMantenimiento());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar camión: " + e.getMessage());
        }
    }

    // Método para leer los camiones
    public ArrayList<Camion> leerCamiones() {
        ArrayList<Camion> camiones = new ArrayList<>();
        String sql = "SELECT * FROM camion";
        try {
            Connection conexion = ConexionDB.conectar();
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Camion camion = new Camion(
                        resultado.getInt("id_camion"),
                        resultado.getString("patente"),
                        resultado.getString("conductor"),
                        resultado.getString("ubicacion_gps"),
                        resultado.getBoolean("estado"),
                        resultado.getDate("fecha_mantenimiento"));
                camiones.add(camion);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer camiones: " + e.getMessage());
        }
        return camiones;
    }

}
