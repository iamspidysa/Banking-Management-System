package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 3.7.2 - extends JFrame to make another form
public class Signup2 extends JFrame implements ActionListener {
    // 3.7.3 - Creating
    int formno; //
    // 4.2 Creating ComboBox;
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6;
    JTextField textPAN,textAadhar;
    JRadioButton r1,r2,r3,r4;
    JButton next;
        // 3.7 - Creating Parameterized Constructor because We will pass FORM NO as parameter in another Class Form , and to maintain same form no in another form too.
        Signup2(int formno){
            super("APPLICATION FORM");
            this.formno = formno; // 3.7.4 rand does have value from previous class , so we are storing value in this file variable.
            // And everything is similar to previous one , so only new things will be pointed.
            ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
            Image i11 = i10.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i12 = new ImageIcon(i11);
            JLabel image = new JLabel(i12);
            image.setBounds(150, 5, 100, 100);
            add(image);

            JLabel l1 = new JLabel("Page 2");
            l1.setFont(new Font("Raleway",Font.BOLD,22));
            l1.setBounds(300,30,600,40);
            add(l1);
            JLabel l2 = new JLabel("Additional Information");
            l2.setFont(new Font("Raleway",Font.BOLD,22));
            l2.setBounds(300,60,600,40);
            add(l2);

            // Religion
            JLabel l3 = new JLabel("Religion :");
            l3.setFont(new Font("Raleway",Font.BOLD,18));
            l3.setBounds(100,120,100,30);
            add(l3);
            // 4. - Creating array of religion because we will wrap in combobox.
            String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
            comboBox = new JComboBox(religion);
            comboBox.setBackground(new Color(252,208,76));
            comboBox.setFont(new Font("Raleway",Font.BOLD,14));
            comboBox.setBounds(350,120,320,30);
            add(comboBox);

            // Category
            JLabel l4 = new JLabel("Category :");
            l4.setFont(new Font("Raleway",Font.BOLD,18));
            l4.setBounds(100,170,100,30);
            add(l4);
            String category[] = {"General","OBC","SC","ST","Other"};
            comboBox2 = new JComboBox(category);
            comboBox2.setBackground(new Color(252,208,76));
            comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
            comboBox2.setBounds(350,170,320,30);
            add(comboBox2);

            // Income
            JLabel l5 = new JLabel("Income :");
            l5.setFont(new Font("Raleway",Font.BOLD,18));
            l5.setBounds(100,220,100,30);
            add(l5);
            String income[] = {"NULL","<1,50,00","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
            comboBox3 = new JComboBox(income);
            comboBox3.setBackground(new Color(252,208,76));
            comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
            comboBox3.setBounds(350,220,320,30);
            add(comboBox3);

            // Education
            JLabel l6 = new JLabel("Educational :");
            l6.setFont(new Font("Raleway",Font.BOLD,18));
            l6.setBounds(100,270,120,30);
            add(l6);
            String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
            comboBox4 = new JComboBox(education);
            comboBox4.setBackground(new Color(252,208,76));
            comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
            comboBox4.setBounds(350,270,320,30);
            add(comboBox4);

            // Occupation
            JLabel l7 = new JLabel("Occupation :");
            l7.setFont(new Font("Raleway",Font.BOLD,18));
            l7.setBounds(100,340,120,30);
            add(l7);
            String occupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
            comboBox5 = new JComboBox(occupation);
            comboBox5.setBackground(new Color(252,208,76));
            comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
            comboBox5.setBounds(350,340,320,30);
            add(comboBox5);

            //Pan Number
            JLabel l8 = new JLabel("PAN Number :");
            l8.setFont(new Font("Raleway",Font.BOLD,18));
            l8.setBounds(100,390,150,30);
            add(l8);
            textPAN = new JTextField();
            textPAN.setFont(new Font("Raleway",Font.BOLD,18));
            textPAN.setBounds(350,390,320,30);
            add(textPAN);

            // Aadhar Number
            JLabel l9 = new JLabel("Aadhar Number :");
            l9.setFont(new Font("Raleway",Font.BOLD,18));
            l9.setBounds(100,440,170,30);
            add(l9);
            textAadhar = new JTextField();
            textAadhar.setFont(new Font("Raleway",Font.BOLD,18));
            textAadhar.setBounds(350,440,320,30);
            add(textAadhar);

            // Senior Citizen
            JLabel l10 = new JLabel("Senior Citizen :");
            l10.setFont(new Font("Raleway",Font.BOLD,18));
            l10.setBounds(100,490,170,30);
            add(l10);
            r1 = new JRadioButton("Yes");
            r1.setBackground(new Color(252,208,76));
            r1.setFont(new Font("Raleway",Font.BOLD,14));
            r1.setBounds(350,490,100,30);
            r1.setFocusPainted(false);
            add(r1);
            r2 = new JRadioButton("No");
            r2.setBackground(new Color(252,208,76));
            r2.setFont(new Font("Raleway",Font.BOLD,14));
            r2.setBounds(460,490,100,30);
            r2.setFocusPainted(false);
            add(r2);
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(r1);
            buttonGroup.add(r2);

            // Existing Account
            JLabel l11 = new JLabel("Existing Account :");
            l11.setFont(new Font("Raleway",Font.BOLD,18));
            l11.setBounds(100,540,170,30);
            add(l11);
            r3 = new JRadioButton("Yes");
            r3.setBackground(new Color(252,208,76));
            r3.setFont(new Font("Raleway",Font.BOLD,14));
            r3.setBounds(350,540,100,30);
            r3.setFocusPainted(false);
            add(r3);
            r4 = new JRadioButton("No");
            r4.setBackground(new Color(252,208,76));
            r4.setFont(new Font("Raleway",Font.BOLD,14));
            r4.setBounds(460,540,100,30);
            r4.setFocusPainted(false);
            add(r4);
            ButtonGroup buttonGroup2 = new ButtonGroup();
            buttonGroup2.add(r3);
            buttonGroup2.add(r4);

            // Form Number
            JLabel l12 = new JLabel("Form No");
            l12.setFont(new Font("Raleway",Font.BOLD,16));
            l12.setBounds(700,10,100,30);
            add(l12);
            JLabel l13 = new JLabel(formno+"");
            l13.setFont(new Font("Raleway",Font.BOLD,16));
            l13.setBounds(710,30,100,30);
            add(l13);

            // Button next
            next = new JButton("Next");
            next.setFont(new Font("Raleway",Font.BOLD,14));
            next.setBackground(Color.WHITE);
            next.setForeground(Color.BLACK);
            next.setBounds(570,640,100,30);
            // 4.3 - Adding listener to button.
            next.addActionListener(this);  // Adding Listener Event on button, you must implement ActionListener to class.
            add(next);



            setLayout(null);
            setSize(850,750);
            setLocation(450,80);
            getContentPane().setBackground(new Color(252,208,76));
            setVisible(true);


        }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 4.3.1 - fetching data from each input fields.
        // ------------------- To fetch data from comboBox we use - getSelectedItem -------------
        String religion = (String)comboBox.getSelectedItem();
        String category = (String)comboBox2.getSelectedItem();
        String income = (String)comboBox3.getSelectedItem();
        String education = (String)comboBox4.getSelectedItem();
        String occupation = (String)comboBox5.getSelectedItem();

        String pan = textPAN.getText();
        String aadhar = textAadhar.getText();

        String sCitizen = "";
        if(r1.isSelected()){
            sCitizen = "yes";
        }else if(r2.isSelected()){
            sCitizen = "no";
        }
        String existingAcc = "";
        if(r3.isSelected()){
            existingAcc = "yes";
        }else if(r4.isSelected()){
            existingAcc = "no";
        }

        try{
            // Checking 2 field , we can select more.
            if(pan.equals("") || aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Fill the mandatory field");
            }else{
                // Creating Connection Object form Conn class.
                Conn c1 = new Conn();
                String query = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+sCitizen+"','"+existingAcc+"')";
                c1.statement.executeUpdate(query);
                new Signup3(formno);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
            new Signup2(1234);

    }

}
