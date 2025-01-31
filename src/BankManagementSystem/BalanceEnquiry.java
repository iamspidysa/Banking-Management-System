package BankManagementSystem;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel l2;  // declaring globally
    JButton b1;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1750, 910, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(-5, 0, 1750, 910);
        add(back);

        JLabel l1 = new JLabel("Your Current Balance in Rs");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(500, 180, 400, 35);
        back.add(l1);

        l2 = new JLabel();
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(550, 220, 400, 35);
        back.add(l2);

        b1 = new JButton("BACK");
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.setBounds(810, 450, 150, 35);
        b1.addActionListener(this);
        back.add(b1);

        int balance = 0;
        try {
            Conn c = new Conn();
            String query = "select * from bank where pin = '" + pin + "'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        l2.setText(balance + "");


        setLayout(null);
        setSize(1750, 1080);
        setLocation(-5, 0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                setVisible(false);
                new TransactionMain(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
