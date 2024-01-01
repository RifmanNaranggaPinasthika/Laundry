import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaundryApp {

    private JFrame frame;
    private JTextField beratTextField;
    private JComboBox<String> layananComboBox;
    private JLabel totalLabel;

    private double hargaPerKg = 5000; // Harga per kilogram pakaian

    public LaundryApp() {
        frame = new JFrame("Aplikasi Pelayanan Laundry Online");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel beratLabel = new JLabel("Berat Pakaian (kg):");
        beratLabel.setBounds(20, 20, 120, 20);
        frame.add(beratLabel);

        beratTextField = new JTextField();
        beratTextField.setBounds(150, 20, 120, 20);
        frame.add(beratTextField);

        JLabel layananLabel = new JLabel("Jenis Layanan:");
        layananLabel.setBounds(20, 60, 120, 20);
        frame.add(layananLabel);

        String[] layanan = {"Reguler", "Express"};
        layananComboBox = new JComboBox<>(layanan);
        layananComboBox.setBounds(150, 60, 120, 20);
        frame.add(layananComboBox);

        JButton hitungButton = new JButton("Hitung Total");
        hitungButton.setBounds(90, 100, 120, 30);
        frame.add(hitungButton);

        totalLabel = new JLabel("Total Harga: ");
        totalLabel.setBounds(20, 150, 200, 20);
        frame.add(totalLabel);

        hitungButton.addActionListener(new ButtonClickListener());

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double berat = Double.parseDouble(beratTextField.getText());
                int index = layananComboBox.getSelectedIndex();
                double total;

                if (index == 0) { // Layanan Reguler
                    total = berat * hargaPerKg;
                } else { // Layanan Express
                    total = berat * hargaPerKg * 1.5; // Biaya 1.5 kali lipat
                }

                totalLabel.setText("Total Harga: Rp" + total);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan berat pakaian yang valid.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LaundryApp());
    }
}
