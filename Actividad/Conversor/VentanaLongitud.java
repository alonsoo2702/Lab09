package conversor;
import javax.swing.*;
import java.awt.*;

public class VentanaLongitud extends JFrame {
    private JTextField[] campos;
    private final String[] unidades = {"Metros", "Kilómetros", "Millas", "Pies"};
    
    public VentanaLongitud() {
        setTitle("Convertidor de Longitud");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setLayout(new GridLayout(unidades.length + 1, 2, 10, 5));
        
        campos = new JTextField[unidades.length];
        
        // Agregar etiquetas y campos
        for (int i = 0; i < unidades.length; i++) {
            add(new JLabel(unidades[i] + ":"));
            campos[i] = new JTextField();
            add(campos[i]);
            
            final int index = i;
            campos[i].addActionListener(e -> convertir(index));
        }
        
        // Agregar botón de limpiar
        JButton limpiar = new JButton("Limpiar");
        limpiar.addActionListener(e -> {
            for (JTextField campo : campos) {
                campo.setText("");
            }
        });
        add(limpiar);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }
    
    private void convertir(int sourceIndex) {
        try {
            double valor = Double.parseDouble(campos[sourceIndex].getText());
            
            // Convertir todo a metros primero
            double metros = 0;
            switch (sourceIndex) {
                case 0: // Metros
                    metros = valor;
                    break;
                case 1: // Kilómetros
                    metros = valor * 1000;
                    break;
                case 2: // Millas
                    metros = valor * 1609.34;
                    break;
                case 3: // Pies
                    metros = valor * 0.3048;
                    break;
            }
            
            // Convertir metros a todas las unidades
            campos[0].setText(String.format("%.2f", metros));
            campos[1].setText(String.format("%.2f", metros / 1000));
            campos[2].setText(String.format("%.2f", metros / 1609.34));
            campos[3].setText(String.format("%.2f", metros / 0.3048));
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un número válido", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
