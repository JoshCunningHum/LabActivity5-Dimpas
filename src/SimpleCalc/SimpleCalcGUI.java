package SimpleCalc;

import javax.swing.*;
import java.util.regex.Pattern;

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

        btnCompute.addActionListener(e -> compute());
    }

    private void compute(){
        double num1 = 0, num2;

        try {

            num1 = Double.parseDouble(tfNumber1.getText());
            num2 = Double.parseDouble(tfNumber2.getText());

            int op = cbOperations.getSelectedIndex();

            if(num2 == 0 && op == 3) throw new ArithmeticException("Divide by zero");

            double result = switch (op) {
                case 0 -> num1 + num2;
                case 1 -> num1 - num2;
                case 2 -> num1 * num2;
                case 3 -> num1 / num2;
                default -> 0;
            };

            lblResult.setText(String.format("%.0f", result));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Please input a number");

            if(num1 == 0) tfNumber1.setText("");
            if(Pattern.matches(".*\\D+.*", tfNumber2.getText())) tfNumber2.setText("");
        }catch (ArithmeticException e){
            JOptionPane.showMessageDialog(this, "Can't divide by zero!");
            tfNumber2.setText("");
        }catch (Exception ignored){

        }
    }
    public static void main(String[] args){
        JFrame UI = new SimpleCalcGUI();

    }
}
