package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    String pin;
    JButton b1, b2, b3, b4, b5, b6, b7;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1750, 910, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(-5, 0, 1750, 910);
        add(back);

        // Label Information
        JLabel l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setFont(new Font("System", Font.BOLD, 24));
        l1.setForeground(Color.WHITE);
        l1.setBounds(510, 180, 700, 35);
        back.add(l1);

        /* All Menus in Fast Cash */
        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(461, 297, 160, 35);
        b1.setFocusPainted(false);
        b1.addActionListener(this);
        back.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(800, 297, 160, 35);
        b2.setFocusPainted(false);
        b2.addActionListener(this);
        back.add(b2);

        // If we write Rs. 1000 as Rs. 1,000 , we will get NumberFormatException because there's a comma on rupee.
        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(461, 349, 160, 35);
        b3.setFocusPainted(false);
        b3.addActionListener(this);
        back.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(800, 349, 160, 35);
        b4.setFocusPainted(false);
        b4.addActionListener(this);
        back.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(461, 401, 160, 35);
        b5.setFocusPainted(false);
        b5.addActionListener(this);
        back.add(b5);

        b6 = new JButton("Rs. 10000");
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
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b7){
                setVisible(false);
                new TransactionMain(pin);
            }

            else{
                String amount = ((JButton)e.getSource()).getText().substring(4);
                Conn c = new Conn();
                Date date = new Date();
                String query = "select * from bank where pin = '"+pin+"'";
                ResultSet rs =  c.statement.executeQuery(query);
                long balance = 0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Long.parseLong(rs.getString("amount"));
                    }else{
                        balance -= Long.parseLong(rs.getString("amount"));
                    }
                }String num = "17";
                if(e.getSource() != b7 && balance < Long.parseLong(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','withdraw','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        setVisible(false);
        new TransactionMain(pin);
    }

    public static void main(String[] args) {
        new FastCash("");
    }

}
