package conversor;
import javax.swing.*;
import java.awt.*;

public class VentanaTemperatura extends JFrame {
    public VentanaTemperatura() {
        setTitle("Convertidor de Temperatura");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Panel superior
        JPanel panelNorte = new JPanel();
        panelNorte.add(new JLabel("Convertidor de Temperatura"));
        add(panelNorte, BorderLayout.NORTH);

        // Panel central
        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JTextField inputTemp = new JTextField(10);
        JLabel resultado = new JLabel("Resultado: ");
        JButton convertir = new JButton("Convertir");
        
        String[] opciones = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
        JComboBox<String> tipoConversion = new JComboBox<>(opciones);

        convertir.addActionListener(e -> {
            try {
                double temp = Double.parseDouble(inputTemp.getText());
                if (tipoConversion.getSelectedIndex() == 0) {
                    // C a F
                    double far = (temp * 9/5) + 32;
                    resultado.setText(String.format("Resultado: %.2f °F", far));
                } else {
                    // F a C
                    double cel = (temp - 32) * 5/9;
                    resultado.setText(String.format("Resultado: %.2f °C", cel));
                }
            } catch (NumberFormatException ex) {
                resultado.setText("Error: Ingrese un número válido");
            }
        });

        // Agregar componentes al panel central
        panelCentral.add(new JLabel("Ingrese temperatura: "), gbc);
        panelCentral.add(inputTemp, gbc);
        panelCentral.add(tipoConversion, gbc);
        panelCentral.add(convertir, gbc);
        panelCentral.add(resultado, gbc);
        
        add(panelCentral, BorderLayout.CENTER);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }
}
