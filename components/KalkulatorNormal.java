package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class KalkulatorNormal implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField displayTF;
    JButton[] numberButtons;
    JButton[] functionButtons;
    JButton tambahButton, kurangButton, kaliButton, bagiButton;
    JButton komaButton, samadenganButton, deleteButton, clearButton;
    Font font = new Font("Arial", Font.BOLD, 18);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public KalkulatorNormal() {
        frame = new JFrame("Kalkulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 520);
        frame.setLayout(null);

        displayTF = new JTextField();
        displayTF.setBounds(50, 25, 300, 50);
        displayTF.setFont(font);
        displayTF.setEditable(false);
        displayTF.setHorizontalAlignment(JTextField.RIGHT);

        tambahButton = new JButton("+");
        kurangButton = new JButton("-");
        kaliButton = new JButton("*");
        bagiButton = new JButton("/");
        komaButton = new JButton(".");
        samadenganButton = new JButton("=");
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(50, 410, 145, 50);
        clearButton = new JButton("Clear");
        clearButton.setBounds(205, 410, 145, 50);

        functionButtons = new JButton[] { 
            tambahButton, 
            kurangButton, 
            kaliButton, 
            bagiButton, 
            komaButton,
            samadenganButton, 
            deleteButton, 
            clearButton 
        };

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(tambahButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(kurangButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(kaliButton);
        panel.add(numberButtons[0]);
        panel.add(komaButton);
        panel.add(samadenganButton);
        panel.add(bagiButton);

        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(displayTF);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayTF.setText(displayTF.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == komaButton) {
            displayTF.setText(displayTF.getText().concat("."));
        }

        if (e.getSource() == tambahButton) {
            num1 = Double.parseDouble(displayTF.getText());
            operator = '+';
            displayTF.setText("");
        }

        if (e.getSource() == kurangButton) {
            num1 = Double.parseDouble(displayTF.getText());
            operator = '-';
            displayTF.setText("");
        }

        if (e.getSource() == kaliButton) {
            num1 = Double.parseDouble(displayTF.getText());
            operator = '*';
            displayTF.setText("");
        }

        if (e.getSource() == bagiButton) {
            num1 = Double.parseDouble(displayTF.getText());
            operator = '/';
            displayTF.setText("");
        }

        if (e.getSource() == samadenganButton) {
            num2 = Double.parseDouble(displayTF.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            displayTF.setText(decimalFormat.format(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) {
            displayTF.setText("");
        }

        if (e.getSource() == deleteButton) {
            String currentText = displayTF.getText();
            if (!currentText.isEmpty()) {
                displayTF.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

}
