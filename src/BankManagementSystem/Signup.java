package BankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1. Extend JFrame for Signup Interface
// 2.18 Implementing ActionListener to set working for button
public class Signup extends JFrame implements ActionListener {
    // 2.4
    int rand = (int)Math.abs(Math.random()*8999+1001);
    JTextField textName,fatherName,email,address,marriedStatus,city,pincode,state;
    JButton next;
    /* We have to Add a jar file use JDateChooser.
    * jcalendar.jar file into Libraries, Then
    * import com.toedter.calendar.JDateChooser;  You can then use it.
    *  */
    // 2.9.1
    JDateChooser dateChooser;
    JRadioButton male,female,married,unmarried,otherMS; // 2.10.2
    //    1.2   Constructor
    Signup() {
        super("APPLICATION FORM"); // 2.2 Frame Title
        // 2.1 Bank Icon
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i11 = i10.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image = new JLabel(i12);
        image.setBounds(25, 10, 100, 100);
        add(image);

        // 2.3 Adding Label Application No and Random digit will be generated for each form from 2.4
        JLabel label1 = new JLabel("APPLICATION FORM NO."+rand);
        label1.setBounds(190,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);
        // 2.5 Adding Label - Page No.
        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330,70,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        add(label2);
        // 2.6 Adding Label - Personal Details
        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290,90,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);
        // 2.7.2 Adding Label - Name
        JLabel label4 = new JLabel("Name :");
        label4.setBounds(100,190,100,30);
        label4.setFont(new Font("Raleway",Font.BOLD,20));
        add(label4);
        // 2.7.3 Adding TextField - Name
        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);
        // 2.8.2 Adding Label - Father Name
        JLabel label5 = new JLabel("Father's Name :");
        label5.setBounds(100,240,200,30);
        label5.setFont(new Font("Raleway",Font.BOLD,20));
        add(label5);
        // 2.8.3 Adding TextField - Father Name
        fatherName = new JTextField();
        fatherName.setFont(new Font("Raleway",Font.BOLD,14));
        fatherName.setBounds(300,240,400,30);
        add(fatherName);
        // 2.9.2 - Adding DOB Label
        JLabel labelDOB = new JLabel("Date of Birth :");
        labelDOB.setBounds(100,340,200,30);
        labelDOB.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelDOB);
        // 2.9.3 - Adding calendar for DOB
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);
        // 2.10.1 - Label Gender
        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(100,290,200,30);
        labelGender.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelGender);
        // 2.10.2 - Radio Button Male
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway",Font.BOLD,14));
        male.setBounds(300,290,60,30);
        male.setBackground(new Color(222, 255, 228));
        male.setFocusPainted(false); // setFocusPainted(false): This method disables the drawing of the focus border (the outline) around the radio button when it is focused.
        add(male);
        // 2.10.3 - Radio Button FeMale
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway",Font.BOLD,14));
        female.setBounds(450,290,90,30);
        female.setBackground(new Color(222, 255, 228));
        female.setFocusPainted(false);
        add(female);
        // 2.10.4 Grouping Button so that either gender can be selected.
        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(male);
        btnGrp.add(female);
        // 2.11.2 - Label Email
        JLabel labelEmail = new JLabel("Email Address");
        labelEmail.setBounds(100,390,200,30);
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelEmail);
        // 2.11.3 TextField - Email
        email = new JTextField();
        email.setFont(new Font("Raleway",Font.BOLD,14));
        email.setBounds(300,390,400,30);
        add(email);
        // 2.12.2 - Label Address
        JLabel labelAddrs = new JLabel("Address");
        labelAddrs.setBounds(100,440,200,30);
        labelAddrs.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelAddrs);
        // 2.12.3 TextField - Address
        address = new JTextField();
        address.setFont(new Font("Raleway",Font.BOLD,14));
        address.setBounds(300,440,400,30);
        add(address);
        // 2.13.2 - Label - Married Status
        JLabel marriedS = new JLabel("Married Status :");
        marriedS.setBounds(100,490,200,30);
        marriedS.setFont(new Font("Raleway",Font.BOLD,20));
        add(marriedS);
        // 2.13.3 RadioButton - Married
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway",Font.BOLD,14));
        married.setBounds(300,490,150,30);
        married.setBackground(new Color(222, 255, 228));
        married.setFocusPainted(false);
        add(married);
        // 2.13.4 RadioButton - UnMarried
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway",Font.BOLD,14));
        unmarried.setBounds(450,490,150,30);
        unmarried.setBackground(new Color(222, 255, 228));
        unmarried.setFocusPainted(false);
        add(unmarried);
        // 2.13.4 RadioButton - Others
        otherMS = new JRadioButton("Others");
        otherMS.setFont(new Font("Raleway",Font.BOLD,14));
        otherMS.setBounds(600,490,150,30);
        otherMS.setBackground(new Color(222, 255, 228));
        otherMS.setFocusPainted(false);
        add(otherMS);
        // 2.13.6 - Button Group - Married/Unmarried/Others
        ButtonGroup btnGrp2 = new ButtonGroup();
        btnGrp2.add(married);
        btnGrp2.add(unmarried);
        btnGrp2.add(otherMS);
        // 2.14.2 - Label City
        JLabel labelCity = new JLabel("City :");
        labelCity.setBounds(100,540,200,30);
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelCity);
        // 2.14.3 TextField - City
        city = new JTextField();
        city.setFont(new Font("Raleway",Font.BOLD,14));
        city.setBounds(300,540,400,30);
        add(city);
        // 2.15.2 - Label Pin code
        JLabel labelPC = new JLabel("PIN Code :");
        labelPC.setBounds(100,590,200,30);
        labelPC.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelPC);
        // 2.15.3 TextField - Pincode
        pincode = new JTextField();
        pincode.setFont(new Font("Raleway",Font.BOLD,14));
        pincode.setBounds(300,590,400,30);
        add(pincode);
        // 2.16.2 - Label State
        JLabel labelState = new JLabel("State :");
        labelState.setBounds(100,640,200,30);
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelState);
        // 2.16.3 TextField - State
        state = new JTextField();
        state.setFont(new Font("Raleway",Font.BOLD,14));
        state.setBounds(300,640,400,30);
        add(state);
        // 2.17 - Button - to proceed to next page.
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,700,80,30);
        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);
        /*
        getContentPane(): Retrieves the content pane of the JFrame, where all your components are placed.
        setBackground(): Changes the background color of the content pane.
        new Color(222, 255, 228): Creates a new color based on RGB values (light greenish shade).
        */
        // 2.
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    // 2.18.2
    @Override
    public void actionPerformed(ActionEvent e) {
        // 3.5 - We will getText from each field to store it on DB.
        int formno = rand;
        String name = textName.getText();
        String fname = fatherName.getText();
        // 3.5.2 - DOB can't get Directly because we used jcalenedar.
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        // 3.5.3 - Gender is a radio button , so we cannot use gerText(), we will use isSelected().
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }else if(female.isSelected()){
            gender = "female";
        }
        String email = this.email.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "married";
        }else if(unmarried.isSelected()){
            marital = "unmarried";
        }else if(otherMS.isSelected()){
            marital = "other";
        }
        String address = this.address.getText();
        String city = this.city.getText();
        String pincode = this.pincode.getText();
        String state = this.state.getText();

        // 3.6 - To store Data in db
        try {
            /* Here We are hard coding each field,
             we can create a function which checks each field without hard coding each input boxes.
             Which can bring better maintainability code.
              */
            // 3.6.2 - Checking if fields are empty then fill the detail then proceed.
            if(false){
                JOptionPane.showMessageDialog(null,"Fill all the Details");
            }else{
                // 3.6.3 - Calling our connection class.
                Conn con1 = new Conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                // 3.6.4 - Now we Execute query.
                con1.statement.executeUpdate(query);
                // 3.7 - After executing query , we need to jump to another class, to Fill another details. also passing "Random" as parameter
                new Signup2(formno);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //    1.1   Main method
    public static void main(String[] args) {
        // 1.3 Anonymous Object
        new Signup();
    }
}
