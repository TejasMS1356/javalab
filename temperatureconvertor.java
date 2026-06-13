import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterGUI extends JFrame implements ActionListener {

    JTextField inputField, resultField;
    JButton cToF, fToC;

    public TemperatureConverterGUI() {

        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.cyan);

        inputField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        cToF = new JButton("C to F");
        fToC = new JButton("F to C");

        cToF.addActionListener(this);
        fToC.addActionListener(this);

        add(new JLabel("Input:"));
        add(inputField);
        add(new JLabel("Result:"));
        add(resultField);
        add(cToF);
        add(fToC);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double temp = Double.parseDouble(inputField.getText());
            double result = 0;

            if (e.getSource() == cToF)
                result = (temp * 9 / 5) + 32;
            else if (e.getSource() == fToC)
                result = (temp - 32) * 5 / 9;

            resultField.setText(String.format("%.2f", result));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid number!");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverterGUI();
    }
}
