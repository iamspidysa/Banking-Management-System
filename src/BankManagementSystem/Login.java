package BankManagementSystem;
// 3.1 Swing package added coz of JFrame

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//3. Extends JFrame to create a frame.
// 7. Now Implementing ActionListener to perform Event on Buttons.
public class Login extends JFrame implements ActionListener {
    // 6. Global Variable
    JLabel label1, label2, label3;
    JTextField textField2;  //For Card no
    JPasswordField passwordField2; //For PIN
    JButton button1, button2, button3;    // For Login ,

    // 1. Constructor
    Login() {
        // 5. We can use setTitle() too
        super("Banking Management System");
        /* ClassLoader: This is a built-in Java class that is used for loading resources (like images, files, properties files, etc.) from the classpath
         *  getSystemResource("icon/bank.png"): This method is used to load a resource (in this case, an image) that is specified by a file path.
         * ImageIcon: This is a Swing class used to represent and display images within a Swing component (like a JLabel, JButton, etc.).
         * new ImageIcon(...): The ImageIcon constructor takes the URL (that was returned by ClassLoader.getSystemResource(...)) and loads the image from that URL.
         * i1.getImage(): This extracts the actual image from the ImageIcon object i1.
         * getScaledInstance(100, 100, Image.SCALE_DEFAULT): This resizes the image to a new size. The image will be resized to 100x100 pixels. The Image.SCALE_DEFAULT parameter indicates that the resizing will be done using the default scaling algorithm.
         * Step 3 : i2 is just a plain Image object (a lower-level representation of the image), and Swing components like JLabel require an ImageIcon to display an image.
         * JLabel : This is a Swing component that is used to display text, images, or both. Here, a JLabel is created to display the image.
         * setBounds() : This line sets the position and size of the label containing the image in the window.
         * add(image): This adds the JLabel (which contains the image) to the container (typically a JFrame)
         * */
        // 5.1 Bank Icon
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i12 = i11.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image1 = new JLabel(i13);
        image1.setBounds(350, 10, 100, 100);
        add(image1);

        // 5.1 Debit/Credit card ICON
        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image i22 = i21.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        JLabel image2 = new JLabel(i23);
        image2.setBounds(630, 350, 100, 100);
        add(image2);

        // 6.1 Adding Label Welcome ATM
        label1 = new JLabel("Welcome to ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        // 6.2 Adding Label Card No.
        label2 = new JLabel("Card No: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        // 6.4 Adding TextField Card Number
        textField2 = new JTextField(15);
        textField2.setBounds(325, 190, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 18));
        add(textField2);

        // 6.3 Adding Label PIN
        label3 = new JLabel("PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("AvantGarde", Font.BOLD, 28));
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        // 6.5 Adding Password Field
        passwordField2 = new JPasswordField(15);
        passwordField2.setBounds(325, 250, 230, 30);
        passwordField2.setFont(new Font("Arial", Font.BOLD, 18));
        add(passwordField2);

        // 6.6 Adding Button
        button1 = new JButton("SIGN IN");
        button1.setBounds(300, 300, 100, 30);
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        /* this is the current instance of the Login class, which is handling button events.
        It is used to identify the current object that implements the ActionListener interface and should respond to the event. */
        button1.addActionListener(this);    // 7.2
        add(button1);
        // 6.7 Adding Button
        button2 = new JButton("Clear");
        button2.setBounds(450, 300, 100, 30);
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.addActionListener(this);    // 7.3
        add(button2);
        // 6.8 Adding Button
        button3 = new JButton("SIGN UP");
        button3.setBounds(375, 350, 100, 40);
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.addActionListener(this);    // 7.4
        add(button3);

        // 5.3 For JFrame Background
        ImageIcon i31 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image i32 = i31.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i32);
        JLabel image3 = new JLabel(i33);
        image3.setBounds(0, 0, 850, 480);
        add(image3);


        // 4. By default, visibility is set to FALSE and by Default Frame is set to Border Layout coz we need layout to our accordingly
        setLayout(null);
        setSize(850, 480);  // Size of the frame
        setLocation(450, 200); // 4.1 Location of the JFrame
        setVisible(true);
    }

    // 7.1 Must Override because it is a method of Interface.
    @Override
    public void actionPerformed(ActionEvent l) {
        // 7.5 After Getting object from button , we are performing action based on button clicked.
        try {
            if (l.getSource() == button1) {

            } else if (l.getSource() == button2) {  // getSource() gives you the object that triggered the event (like a button or a text field).
                textField2.setText("");
                passwordField2.setText("");
            } else if (l.getSource() == button3) {   // SignUp Button
                new Signup();
                setVisible(false);
            }
        } catch (Exception e) {
            // prints out information about where the exception occurred in the program, including the method calls that led to the exception, the class names, and the line numbers in the source code.
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //2. Anonymous Object
        new Login();
    }
}
