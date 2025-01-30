package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    String pin;
    JTextField t1;
    JButton b1, b2;

    Withdrawal(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1750, 910, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(-5, 0, 1750, 910);
        add(back);

        JLabel l1 = new JLabel("MAXIMIUM WITHDRAW AMOUNT Rs. 10,000");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(540, 180, 400, 35);
        // 6. Why back.add(l1) ? -- Because If directly add l1 then it will set Label behind the image. To bring it on the front we use this.
        back.add(l1);

        JLabel l2 = new JLabel("PLEASE ENTER THE AMOUNT");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(590, 220, 400, 35);
        // 6. Why back.add(l1) ? -- Because If directly add l1 then it will set Label behind the image. To bring it on the front we use this.
        back.add(l2);

        // Amount to be deposited
        t1 = new JTextField();
        /*  6.2  -------------  If you want to make TextField Transparent use below code. -------------------- */
//        t1.setOpaque(true);
//        t1.setBackground(new Color(0, 0, 0, 0)); // Transparent background
//        t1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0)); // Optional border
        t1.setBackground(new Color(65, 125, 128));
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(550, 270, 320, 25);
        back.add(t1);

        // Deposit Button
        b1 = new JButton("WITHDRAW");
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.setBounds(810, 400, 150, 35);
        b1.addActionListener(this);
        back.add(b1);

        // Back Button
        b2 = new JButton("BACK");
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.setBounds(810, 452, 150, 35);
        b2.addActionListener(this);
        back.add(b2);


        setLayout(null);
        setSize(1750, 1080);
        setLocation(-5, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String amount = t1.getText();
            Date date = new Date();
            if (e.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
                } else {
                    Conn c = new Conn();
                    String query = "select * from bank where pin = '" + pin + "'";
                    ResultSet rs = c.statement.executeQuery(query);
                    int balance = 0;
                    while (rs.next()) {
                        /* Resultset rs returns a table, and rs.next() move the move the cursor down the list.
                         *  Each call to rs.next() advances the cursor to the next row in the result set.
                         * The method rs.getString("type") retrieves the value of the "type" column
                         * from the current row as a String.
                         * If the value in the "type" column equals "Deposit", the condition evaluates to true,
                         * NOTE : "Deposit" is case-sensitive , it should be similar in DB too"
                         * and the corresponding block of code will be executed.
                         */
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    // For insufficient Balance
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    // Updating value into DB - if withdrew
                    c.statement.executeUpdate("Insert into bank values('" + pin + "','" + date + "','withdraw','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited successfully");
                    setVisible(false);
                    new TransactionMain(pin);
                }
            } else if (e.getSource() == b2) {
                setVisible(false);
                new TransactionMain(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
