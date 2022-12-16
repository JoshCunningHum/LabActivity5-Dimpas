package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI extends JFrame{
    private JPanel main;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public SimpleCalcGUI(){
        this.setContentPane(main);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("Simple Calculator");

        lblResult.setEditable(false);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compute();
            }
        });
    }

    private void compute(){
        double num1 = Double.parseDouble(tfNumber1.getText());
        double num2 = Double.parseDouble(tfNumber2.getText());

        int op = cbOperations.getSelectedIndex();
        double result = switch (op) {
            case 0 -> num1 + num2;
            case 1 -> num1 - num2;
            case 2 -> num1 * num2;
            case 3 -> num1 / num2;
            default -> 0;
        };

        lblResult.setText(String.format("%.0f", result));
    }
    public static void main(String[] args){
        JFrame UI = new SimpleCalcGUI();

    }
}
