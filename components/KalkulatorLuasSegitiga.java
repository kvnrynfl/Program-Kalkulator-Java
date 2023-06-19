package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class KalkulatorLuasSegitiga implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel alasLabel, tinggiLabel, resultLabel;
    JTextField alasTF, tinggiTF, resultTF;
    JButton calculateButton;
    Font font = new Font("Arial", Font.BOLD, 18);

    public KalkulatorLuasSegitiga() {
        frame = new JFrame("Kalkulator Luas Segitiga");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 310);
        frame.setLayout(null);

        alasLabel = new JLabel("Alas : ");
        alasLabel.setFont(font);

        tinggiLabel = new JLabel("Tinggi : ");
        tinggiLabel.setFont(font);

        resultLabel = new JLabel("Hasil : ");
        resultLabel.setFont(font);

        alasTF = new JTextField();
        alasTF.setFont(font);
        alasTF.setEditable(true);

        tinggiTF = new JTextField();
        tinggiTF.setFont(font);
        tinggiTF.setEditable(true);

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
        panel.setBounds(50, 25, 300, 150);
        panel.add(alasLabel);
        panel.add(alasTF);
        panel.add(tinggiLabel);
        panel.add(tinggiTF);
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
            double alas = Double.parseDouble(alasTF.getText());
            double tinggi = Double.parseDouble(tinggiTF.getText());
            double result = 0.5 * alas * tinggi;

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            resultTF.setText(decimalFormat.format(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
