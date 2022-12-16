package FoodOrdering;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodOrderGUI extends JFrame{

    static HashMap<String, Integer> prices = new HashMap<>();

    // set food
    static {
        prices.put("Pizza", 100);
        prices.put("Burger", 80);
        prices.put("Fries", 65);
        prices.put("Soft Drinks", 55);
        prices.put("Tea", 50);
        prices.put("Sundae", 40);
    }

    private JPanel main;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private final List<JRadioButton> bgDiscounts = new ArrayList<>();

    private final List<JCheckBox> bgFood = new ArrayList<>();


    public FoodOrderGUI(){
        this.setContentPane(main);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("Food Ordering System");

        // set groups
        bgFood.add(cPizza);
        bgFood.add(cBurger);
        bgFood.add(cFries);
        bgFood.add(cSoftDrinks);
        bgFood.add(cTea);
        bgFood.add(cSundae);

        bgDiscounts.add(rbNone);
        bgDiscounts.add(rb5);
        bgDiscounts.add(rb10);
        bgDiscounts.add(rb15);

        btnOrder.addActionListener(e -> takeOrder());
    }

    public void takeOrder(){
        try {

            double totalOrder = 0;

            // loop through checkboxes
            for(JCheckBox food : bgFood) if(food.isSelected()) totalOrder += FoodOrderGUI.prices.get(food.getText());

            if(totalOrder == 0) throw new Exception("No Order Taken");

            double i = 0;

            // apply discount if any
            for(JRadioButton btn : bgDiscounts){
                if(btn.isSelected()){
                    JOptionPane.showMessageDialog(this, String.format("The total price is Php %.2f", totalOrder * ((100.0 - i) / 100.0)));
                    break;
                }
                i += 5;
            }
        }catch (Exception e){
            if ("No Order Taken".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(this, "Please select at least 1 order.");
            } else {
                JOptionPane.showMessageDialog(this, "Something went wrong, please try again.");
            }
        }
    }

    public static void main(String[] args){
        FoodOrderGUI gui = new FoodOrderGUI();
    }
}
