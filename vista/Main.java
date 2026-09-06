package vista;
import controlador.ConexionDB; //borrar

public class Main {
    public static void main(String[] args) {

        ConexionDB.conectar();

        javax.swing.SwingUtilities.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }
}
