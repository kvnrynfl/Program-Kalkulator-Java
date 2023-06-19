package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class KalkulatorLuasPersegiPanjang implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel panjangLabel, lebarLabel, resultLabel;
    JTextField panjangTF, lebarTF, resultTF;
    JButton calculateButton;
    Font font = new Font("Arial", Font.BOLD, 18);

    public KalkulatorLuasPersegiPanjang() {
        frame = new JFrame("Kalkulator Luas Persegi Panjang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 310);
        frame.setLayout(null);

        panjangLabel = new JLabel("Panjang : ");
        panjangLabel.setFont(font);

        lebarLabel = new JLabel("Lebar : ");
        lebarLabel.setFont(font);

        resultLabel = new JLabel("Hasil : ");
        resultLabel.setFont(font);

        panjangTF = new JTextField();
        panjangTF.setFont(font);
        panjangTF.setEditable(true);

        lebarTF = new JTextField();
        lebarTF.setFont(font);
        lebarTF.setEditable(true);

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
        panel.add(panjangLabel);
        panel.add(panjangTF);
        panel.add(lebarLabel);
        panel.add(lebarTF);
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
            double panjang = Double.parseDouble(panjangTF.getText());
            double lebar = Double.parseDouble(lebarTF.getText());
            double result = panjang * lebar;

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            resultTF.setText(decimalFormat.format(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
