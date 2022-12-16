package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
            }
        });
    }

    private void display(){
        int year = Integer.parseInt(tfYear.getText());

        boolean isLeapYear = (year % 400 == 0) ? true : (year % 100 == 0) ? false : (year % 4 == 0) ? true : false;

        JOptionPane.showMessageDialog(this, isLeapYear ? "Leap Year" : "Not a leap Year");

    }

    public static void main(String[] args){
        LeapYearGUI gui = new LeapYearGUI();
    }


}
