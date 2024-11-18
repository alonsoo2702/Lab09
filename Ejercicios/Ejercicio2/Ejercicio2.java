package ej2;

import javax.swing.*;
import java.awt.*;

public class Ejercicio2 extends JFrame {
    private JTextField txtNombre, txtIdentidad;
    private JComboBox<String> cbDia, cbMes, cbAnio;
    private JRadioButton rbPiso1, rbPiso2;
    private ButtonGroup bgPisos;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaCalidad;
    private JButton btnProcesar, btnLimpiar;
    private JCheckBox chkAudifonos, chkFrasada;

    public Ejercicio2() {
        setTitle("Compra de Pasajes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 550);
        setLayout(new GridLayout(0, 2, 10, 10));

        // Campos de texto
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("DNI:"));
        txtIdentidad = new JTextField();
        add(txtIdentidad);

        // Panel de fecha
        add(new JLabel("Fecha de Viaje:"));
        JPanel fechaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Día (1-31)
        String[] dias = new String[31];
        for(int i = 1; i <= 31; i++) dias[i-1] = String.format("%02d", i);
        cbDia = new JComboBox<>(dias);
        
        // Mes (1-12)
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", 
                         "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        cbMes = new JComboBox<>(meses);
        
        // Año (2024-2025)
        String[] anios = {"2024", "2025"};
        cbAnio = new JComboBox<>(anios);

        fechaPanel.add(cbDia);
        fechaPanel.add(cbMes);
        fechaPanel.add(cbAnio);
        add(fechaPanel);

        // Pisos
        add(new JLabel("Seleccione Piso:"));
        JPanel pisoPanel = new JPanel();
        rbPiso1 = new JRadioButton("1er Piso");
        rbPiso2 = new JRadioButton("2do Piso");
        bgPisos = new ButtonGroup();
        bgPisos.add(rbPiso1);
        bgPisos.add(rbPiso2);
        pisoPanel.add(rbPiso1);
        pisoPanel.add(rbPiso2);
        add(pisoPanel);

        // Origen y destino
        add(new JLabel("Origen:"));
        cbOrigen = new JComboBox<>(new String[]{"Lima", "Arequipa", "Trujillo"});
        add(cbOrigen);

        add(new JLabel("Destino:"));
        cbDestino = new JComboBox<>(new String[]{"Cusco", "Piura", "Chiclayo"});
        add(cbDestino);

        // Servicios opcionales
        add(new JLabel("Servicios Opcionales:"));
        JPanel serviciosPanel = new JPanel();
        chkAudifonos = new JCheckBox("Audífonos");
        chkFrasada = new JCheckBox("Frasada");
        serviciosPanel.add(chkAudifonos);
        serviciosPanel.add(chkFrasada);
        add(serviciosPanel);

        // Calidad de servicio
        add(new JLabel("Calidad de Servicio:"));
        listaCalidad = new JList<>(new String[]{"Económico", "Regular", "VIP"});
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaCalidad));

        // Botones
        btnProcesar = new JButton("Procesar");
        btnLimpiar = new JButton("Limpiar");
        add(btnProcesar);
        add(btnLimpiar);

        // Eventos
        btnProcesar.addActionListener(e -> mostrarResumen());
        btnLimpiar.addActionListener(e -> limpiarFormulario());

        setLocationRelativeTo(null);
    }

    private void mostrarResumen() {
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fechaViaje = cbDia.getSelectedItem() + "/" + 
                           (cbMes.getSelectedIndex() + 1) + "/" + 
                           cbAnio.getSelectedItem();

        String servicios = "";
        if (chkAudifonos.isSelected()) servicios += "- Audífonos\n";
        if (chkFrasada.isSelected()) servicios += "- Frasada\n";
        if (servicios.isEmpty()) servicios = "Ninguno\n";

        String resumen = "Resumen de Compra:\n\n" +
                        "Nombre: " + txtNombre.getText() + "\n" +
                        "Identidad: " + txtIdentidad.getText() + "\n" +
                        "Fecha de Viaje: " + fechaViaje + "\n" +
                        "Piso: " + (rbPiso1.isSelected() ? "1er Piso" : "2do Piso") + "\n" +
                        "Origen: " + cbOrigen.getSelectedItem() + "\n" +
                        "Destino: " + cbDestino.getSelectedItem() + "\n" +
                        "Calidad: " + listaCalidad.getSelectedValue() + "\n" +
                        "Servicios Opcionales:\n" + servicios;

        JOptionPane.showMessageDialog(this, resumen, "Resumen de Compra", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtIdentidad.setText("");
        cbDia.setSelectedIndex(0);
        cbMes.setSelectedIndex(0);
        cbAnio.setSelectedIndex(0);
        bgPisos.clearSelection();
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        listaCalidad.clearSelection();
        chkAudifonos.setSelected(false);
        chkFrasada.setSelected(false);
    }

    private boolean validarCampos() {
        return !txtNombre.getText().isEmpty() &&
               !txtIdentidad.getText().isEmpty() &&
               (rbPiso1.isSelected() || rbPiso2.isSelected()) &&
               listaCalidad.getSelectedValue() != null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2().setVisible(true);
        });
    }
}
