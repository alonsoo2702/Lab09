package conversor;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaMenu menu = new VentanaMenu();
            menu.setVisible(true);
        });
    }
}
