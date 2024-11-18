package conversor;
import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JFrame {
    public VentanaMenu() {
        setTitle("Convertidor de Unidades - Menú");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel titulo = new JLabel("Seleccione el tipo de conversión:");
        JButton btnTemperatura = new JButton("Temperatura");
        JButton btnLongitud = new JButton("Longitud");

        // Agregar acciones a los botones
        btnTemperatura.addActionListener(e -> {
            new VentanaTemperatura().setVisible(true);
        });
        
        btnLongitud.addActionListener(e -> {
            new VentanaLongitud().setVisible(true);
        });
        
        // Agregar componentes
        add(titulo);
        add(btnTemperatura);
        add(btnLongitud);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }
}
