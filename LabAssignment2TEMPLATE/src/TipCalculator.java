import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TipCalculator extends JFrame implements ActionListener {
    JTextField priceID;
    JTextField tipsID;
    JTextField peopleID;
    
    
    JLabel prices;
    JLabel Tips;
    JLabel People;
    JLabel indiPay;
    JButton buttons;
    TipCalculator() {
        this.setSize(230,320);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        prices = new JLabel("price");
        this.add(prices);
        this.setVisible(true);
        priceID = new JTextField(15);
        this.add(priceID);
        Tips = new JLabel("tip(%)");
        this.add(Tips);
        this.setVisible(true);
        tipsID = new JTextField(15);
        this.add(tipsID);
        People = new JLabel("People");
        this.add(People);
        this.setVisible(true);
        peopleID = new JTextField(12);
        this.add(peopleID);
        buttons = new JButton("Calculate");
        buttons.addActionListener(this);
        this.add(buttons);
        indiPay = new JLabel("Each person should pay: ");
        this.add(indiPay);
        indiPay.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TipCalculator();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double cost = 0.0;
        try {
            double price = Double.parseDouble(priceID.getText());
            double tip = (Double.parseDouble(tipsID.getText()) / 100) + 1;
            double people = Double.parseDouble(peopleID.getText());
            cost = Math.round(((price * tip) / people) * 100.0) / 100.0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only enter valid numbers!");
        }
        indiPay.setText("Each person should pay: £" + "\n"
                + String.format("%.2f", cost));
    }
}


