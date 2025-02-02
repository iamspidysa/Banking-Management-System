package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton btn1;

    MiniStatement(String pin) {
        this.pin = pin;


        JLabel l1 = new JLabel();
//        l1.setBounds(20,140,400,200);     // Commented both because using scrollpane instead of using label directly to show content.
//        add(l1);
        /* Added a scroll pane so that we can see every statement, If you want top 5 transaction we can add a condition in while with counter. */
        JScrollPane scrollPane = new JScrollPane(l1);
        scrollPane.setBackground(new Color(255, 204, 204));
        scrollPane.getViewport().setBackground(new Color(255, 204, 204));
        scrollPane.setBounds(13, 140, 360, 300);  // Set your fixed size here (width, height)
        add(scrollPane);  // Instead of adding l1 directly

        JLabel l2 = new JLabel("Bank Management System");
        l2.setFont(new Font("System", Font.BOLD, 15));
        l2.setBounds(150, 20, 400, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 460, 300, 20);
        add(l4);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from login where pin = '" + pin + "' ");
            while (rs.next()) {
                /* .substring(0, 4)
                This extracts the first 4 characters of the card_no string.
                For example, if card_no is "1234567890123456", this will return "1234".

                + "XXXXXXXX"
                This adds a static string "XXXXXXXX" to mask the middle part of the card number.

                + rs.getString("card_no").substring(12)
                This extracts the last 4 characters of the card_no string.
                For example, if card_no is "1234567890123456", this will return "3456".
                */
                l3.setText("Card Number: " + rs.getString("card_no").substring(0, 4) + "XXXXXXXX" + rs.getString("card_no").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            long balance = 0L;
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from bank where pin = '" + pin + "' ");
            while (rs.next()) {
                /* rs.getString("date")
                This retrieves the value of the date column from the current row of the ResultSet (rs).
                The ResultSet is the result of your SQL query (select * from bank where pin = '"+pin+"').
                And same for every column
                */

                // We dont have to close html tage at the end </html> it is causing error, we are not able to show all statements. IF IT WORKS DONT TOUCH IT xD
                l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    balance += Long.parseLong(rs.getString("amount"));
                } else {
                    balance -= Long.parseLong(rs.getString("amount"));
                }
            }

            l4.setText("Your Total Balance in Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        btn1 = new JButton("Exit");
        btn1.setBounds(20, 500, 100, 25);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFocusPainted(false);
        btn1.addActionListener(this);
        add(btn1);


        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

}
