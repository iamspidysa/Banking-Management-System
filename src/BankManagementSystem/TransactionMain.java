package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionMain extends JFrame implements ActionListener {
    // Getting pin from Login class and storing in instance variable from constructor.
    String pin;
    JButton b1, b2, b3, b4, b5, b6, b7;

    TransactionMain(String pin) {
        this.pin = pin;
        // ATM Background Image.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1750, 910, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(-5, 0, 1750, 910);
        add(back);

        // Label Information
        JLabel l1 = new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 28));
        l1.setForeground(Color.WHITE);
        l1.setBounds(500, 180, 700, 35);
        back.add(l1);

        /* All Menus in Main Screen */
        // Deposit
        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(461, 297, 160, 35);
        b1.setFocusPainted(false);
        b1.addActionListener(this);
        back.add(b1);

        // Cash Withdraw
        b2 = new JButton("CASH WITHDRAWAL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(800, 297, 160, 35);
        b2.setFocusPainted(false);
        b2.addActionListener(this);
        back.add(b2);

        // Fast CASH
        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(461, 349, 160, 35);
        b3.setFocusPainted(false);
        b3.addActionListener(this);
        back.add(b3);

        // MINI STATEMENT
        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(800, 349, 160, 35);
        b4.setFocusPainted(false);
        b4.addActionListener(this);
        back.add(b4);

        // PIN CHANGE
        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(461, 401, 160, 35);
        b5.setFocusPainted(false);
        b5.addActionListener(this);
        back.add(b5);

        // BALANCE ENQUIRY
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(800, 401, 160, 35);
        b6.setFocusPainted(false);
        b6.addActionListener(this);
        back.add(b6);

        // EXIT
        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(800, 453, 160, 35);
        b7.setFocusPainted(false);
        b7.addActionListener(this);
        back.add(b7);

        setLayout(null);
        setSize(1750, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Deposit
            if (e.getSource() == b1) {
                new Deposit(pin);
                setVisible(false);
            }
            // Cash Withdraw
            else if (e.getSource() == b2) {
                new Withdrawal(pin);
                setVisible(false);
            }
            // Fast Cash
            else if (e.getSource() == b3) {
                new FastCash(pin);
                setVisible(false);
            }
            // Change PIN
            else if (e.getSource() == b5) {
                new ChangePin(pin);
                setVisible(false);
            }
            // Balance Enquiry
            else if (e.getSource()== b6) {
                setVisible(false);
                new BalanceEnquiry(pin);
            }
            // Exit Button
            else if (e.getSource() == b7) {
                System.exit(0);
            }

            // Deposit Button
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TransactionMain("");
    }
}
