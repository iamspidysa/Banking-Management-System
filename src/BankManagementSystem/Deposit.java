package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField t1;
    JButton b1,b2;
    Deposit(String pin){
        super("Deposit Window");
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1750,910, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(-5,0,1750,910);
        add(back);

        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(550,180,400,35);
        // 6. Why back.add(l1) ? -- Because If directly add l1 then it will set Label behind the image. To bring it on the front we use this.
        back.add(l1);

        // Amount to be deposited
        t1 = new JTextField();
        /*  6.2  -------------  If you want to make TextField Transparent use below code. -------------------- */
//        t1.setOpaque(true);
//        t1.setBackground(new Color(0, 0, 0, 0)); // Transparent background
//        t1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0)); // Optional border
        t1.setBackground(new Color(65,125,128));
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        t1.setBounds(550,230,320,25);
        back.add(t1);

        // Deposit Button
        b1 = new JButton("DEPOSIT");
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setBounds(810,400,150,35);
        b1.addActionListener(this);
        back.add(b1);

        // Back Button
        b2 = new JButton("BACK");
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setBounds(810,452,150,35);
        b2.addActionListener(this);
        back.add(b2);


        setLayout(null);
        setSize(1750,1080);
        setLocation(-5,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String amount = t1.getText();
            // 6.3 - Give output like : Tue Jul 12 18:35:37 IST 2016
            Date date = new Date();
            if(e.getSource()==b1){
                // 6.4 - Inline parsing amount into Double and checking if amount is less than 999 then it will not be deposited.
                if(amount.equals("") || ( Double.parseDouble(amount) < 1000)){
                    JOptionPane.showMessageDialog(null,"Enter amount to be deposited and Must be Rs. 1000 or More");
                }else{
                    Conn c = new Conn();
                    // 'deposit' - why in single quote only - coz it will be stored as text in DB of type "type".
                    c.statement.executeUpdate("insert into bank values ('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposit Successfully");
                    setVisible(false);
                    new TransactionMain(pin);
                }
            }else if(e.getSource()==b2){
                setVisible(false);
                new TransactionMain(pin);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
