package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    int formno;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    Signup3(int formno){
        super();
        this.formno = formno;
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i11 = i10.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image = new JLabel(i12);
        image.setBounds(150, 5, 100, 100);
        add(image);

        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway", Font.BOLD,22));
        l2.setBounds(280,70,400,40);
        add(l2);

        JLabel l3 = new JLabel("Account Type : ");
        l3.setFont(new Font("Raleway", Font.BOLD,18));
        l3.setBounds(100,140,200,30);
        add(l3);

        // Radio Button - Account Types
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(new Color(215,252,252));
        r1.setBounds(100,180,150,30);
        r1.setFocusPainted(false);
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(new Color(215,252,252));
        r2.setBounds(350,180,300,30);
        r2.setFocusPainted(false);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBackground(new Color(215,252,252));
        r3.setBounds(100,220,250,30);
        r3.setFocusPainted(false);
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBackground(new Color(215,252,252));
        r4.setBounds(350,220,300,30);
        r4.setFocusPainted(false);
        add(r4);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card Number : ");
        l4.setFont(new Font("Raleway", Font.BOLD,18));
        l4.setBounds(100,300,200,30);
        add(l4);

        JLabel l5 = new JLabel("( Your 16-digit Card Number )");
        l5.setFont(new Font("Raleway", Font.BOLD,12));
        l5.setBounds(100,330,200,20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway", Font.BOLD,18));
        l6.setBounds(330,300,250,30);
        add(l6);

        JLabel l7 = new JLabel("( It would appear on atm card/cheque book and statement )");
        l7.setFont(new Font("Raleway", Font.BOLD,12));
        l7.setBounds(330,330,500,20);
        add(l7);

        JLabel l8 = new JLabel("PIN : ");
        l8.setFont(new Font("Raleway", Font.BOLD,18));
        l8.setBounds(100,370,200,30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(330,370,200,20);
        add(l9);

        JLabel l10 = new JLabel("( 4-digit pin )");
        l10.setFont(new Font("Raleway", Font.BOLD,12));
        l10.setBounds(100,400,200,20);
        add(l10);

        JLabel l11 = new JLabel("Services Required : ");
        l11.setFont(new Font("Raleway", Font.BOLD,18));
        l11.setBounds(100,450,200,30);
        add(l11);

        // CheckBox -
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(new Color(215,252,252));
        c1.setBounds(100,500,200,30);
        c1.setFocusPainted(false);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(new Color(215,252,252));
        c2.setBounds(350,500,200,30);
        c2.setFocusPainted(false);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(new Color(215,252,252));
        c3.setBounds(100,550,200,30);
        c3.setFocusPainted(false);
        add(c3);
        c4 = new JCheckBox("E-Mail Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(new Color(215,252,252));
        c4.setBounds(350,550,200,30);
        c4.setFocusPainted(false);
        add(c4);
        c5 = new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(new Color(215,252,252));
        c5.setBounds(100,600,200,30);
        c5.setFocusPainted(false);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(new Color(215,252,252));
        c6.setBounds(350,600,200,30);
        c6.setFocusPainted(false);
        add(c6);

        // 5.1 Agreement - passing true because we want agreement to be checked after opening form.
        c7 = new JCheckBox("I here by declares that teh above entered details correct to the best of my knowledge",true);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(new Color(215,252,252));
        c7.setBounds(100,660,600,20);
        c7.setFocusPainted(false);
        add(c7);

        // Form Number Label
        JLabel l12 = new JLabel("Form No");
        l12.setFont(new Font("Raleway",Font.BOLD,16));
        l12.setBounds(700,10,100,30);
        add(l12);
        JLabel l13 = new JLabel(formno+"");
        l13.setFont(new Font("Raleway",Font.BOLD,16));
        l13.setBounds(710,30,100,30);
        add(l13);

        // Submit Button
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(230,710,100,40);
        submit.addActionListener(this);
        add(submit);
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setBounds(520,710,100,40);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(new Color(215,252,252));
        setLayout(null);
        setVisible(true);
        setSize(850,800);
        setLocation(400,20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accountType = "";
        if(r1.isSelected()){
            accountType = "Saving Account";
        }else if(r2.isSelected()){
            accountType = "Fixed Deposit Account";
        }else if(r3.isSelected()){
            accountType = "Current Account";
        }else if(r4.isSelected()){
            accountType = "Recurring Deposit Account";
        }
        // Generating Random Card Number for last 8 digit and fist 8 digit will be fixed.
        // Random Class is more often used , coz it gives more flexibility and great properties
        Random rand = new Random();
        long first7 = (rand.nextLong() % 90000000L) + 1769984300000000L;
        String cardNo = Math.abs(first7)+""; // converted to string

        // Generating PIN
        int first3 = (rand.nextInt() % 9000) + 1000;
        String pin = Math.abs(first3)+"";

        String services = "";
        if(c1.isSelected()){
            services = services + "ATM Card ";
        }
        if(c2.isSelected()){
            services = services + "Internet Banking ";
        }
        if(c3.isSelected()){
            services = services + "Mobile Banking ";
        }
        if(c4.isSelected()){
            services = services + "E-Mail Alerts ";
        }
        if(c5.isSelected()){
            services = services + "Check Book ";
        }
        if(c6.isSelected()){
            services = services + "E-Statement ";
        }

        // Try/Catch0
        try{
            if(e.getSource()==submit){
                // If Account Type or Agreement is not selected then a op up will appear.
                if(accountType.equals("") || !c7.isSelected()){
                    JOptionPane.showMessageDialog(null,"Fill all the details");
                }else{
                    Conn c1 = new Conn();
                    String query = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardNo+"','"+pin+"','"+services+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardNo+"','"+pin+"')";
                    c1.statement.executeUpdate(query);
                    c1.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardNo+"\nPin : "+pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            }else if(e.getSource()==cancel){
                System.exit(0);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
            new Signup3(1234);
    }

}
