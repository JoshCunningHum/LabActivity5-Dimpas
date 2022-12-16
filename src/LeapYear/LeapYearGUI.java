package LeapYear;

import javax.swing.*;

public class LeapYearGUI extends JFrame{
    private JPanel main;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI(){
        this.setContentPane(main);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("Leap Year Checker");

        btnCheckYear.addActionListener(e -> display());
    }

    private void display(){
        try {
            int year = Integer.parseInt(tfYear.getText());
            boolean isLeapYear = year % 400 == 0 || (year % 100 != 0 && (year % 4 == 0));

            JOptionPane.showMessageDialog(this, isLeapYear ? "Leap Year" : "Not a leap Year");
        } catch (NumberFormatException e){
            // For wrong input
            JOptionPane.showMessageDialog(this, "Please input a number");
            tfYear.setText("");
        } catch (Exception ignored){

        }
    }

    public static void main(String[] args){
        LeapYearGUI gui = new LeapYearGUI();
    }


}
