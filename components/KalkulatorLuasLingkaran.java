package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class KalkulatorLuasLingkaran implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel jarijariLabel, tinggiLabel, resultLabel;
    JTextField jarijariTF, tinggiTF, resultTF;
    JButton calculateButton;
    Font font = new Font("Arial", Font.BOLD, 18);

    public KalkulatorLuasLingkaran() {
        frame = new JFrame("Kalkulator Luas Lingkaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 310);
        frame.setLayout(null);

        jarijariLabel = new JLabel("Jari-Jari : ");
        jarijariLabel.setFont(font);

        resultLabel = new JLabel("Hasil : ");
        resultLabel.setFont(font);

        jarijariTF = new JTextField();
        jarijariTF.setFont(font);
        jarijariTF.setEditable(true);

        resultTF = new JTextField();
        resultTF.setFont(font);
        resultTF.setEditable(false);

        calculateButton = new JButton("Hitung");
        calculateButton.setBounds(50, 205, 300, 40);
        calculateButton.addActionListener(this);
        calculateButton.setFont(font);
        calculateButton.setFocusable(false);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 15));
        panel.setBounds(50, 55, 300, 150);
        panel.add(jarijariLabel);
        panel.add(jarijariTF);
        panel.add(resultLabel);
        panel.add(resultTF);

        frame.add(panel);
        frame.add(calculateButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            hitungLuas();
        }
    }

    public void hitungLuas() {
        try {
            double jarijari = Double.parseDouble(jarijariTF.getText());
            double result = 3.14 * jarijari * jarijari;

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            resultTF.setText(decimalFormat.format(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
