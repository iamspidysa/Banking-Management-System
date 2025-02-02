package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    ChangePin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1750,910, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(-5,0,1750,910);
        add(back);

        JLabel l1 = new JLabel("CHANGE YOU PIN");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(550,180,400,45);
        back.add(l1);

        // ENTER NEW PIN Password
        JLabel l2 = new JLabel("NEW PIN : ");
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(550,240,400,35);
        back.add(l2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        p1.setBounds(760,240,200,35);
        back.add(p1);

        // RE-ENTER Password
        JLabel l3 = new JLabel("RE-ENTER NEW PIN : ");
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(550,300,400,35);
        back.add(l3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        p2.setBounds(760,300,200,35);
        back.add(p2);

        // CHANGE PIN BUTTON
        b1 = new JButton("CHANGE");
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
        setSize(1750, 1080);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            /*
            // ----------- Dont Know why this code works but , Logically I cant understand the workflow and how still correct.
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                resetField();
                return;
            }

            if( e.getSource()==b1 ){
                if(pin1.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if(pin2.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }

                Conn c = new Conn();
                String query = "Update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String query2 = "Update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String query3 = "Update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(query);
                c.statement.executeUpdate(query2);
                c.statement.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN CHANGED");
                setVisible(false);
                new Login();


            }else if(e.getSource()==b2){
                setVisible(false);
                new TransactionMain(pin);
            }

            */
            if(e.getSource() == b1){
                String pin1 = p1.getText();
                String pin2 = p2.getText();
                // Check for Empty string in field and exit the flow of the code.
                if(pin1.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                // Check for Empty string in field and exit the flow of the code.

                if(pin2.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                // Check Both field equality and runs a function which clear the field.
                if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    resetField();
                    return;
                }

                // If everything is perfect then it updates the pin in 3 tables if there is pin.
                Conn c = new Conn();
                String query = "Update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String query2 = "Update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String query3 = "Update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(query);
                c.statement.executeUpdate(query2);
                c.statement.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN CHANGED");
                setVisible(false);
                new Login();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void resetField(){
        p1.setText("");
        p2.setText("");
    }
    public static void main(String[] args) {
        new ChangePin("");
    }

}
