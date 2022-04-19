import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;


public class Main {
    JFrame frame;
    JLabel userLabel;
    JTextField textField;
    JLabel passLabel;
    JTextField passField;
    JButton button, customerButton;


    public Main() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userLabel = new JLabel();
        userLabel.setText("Username");
        textField = new JTextField(10);

        passLabel = new JLabel();
        passLabel.setText("Password");
        passField = new JPasswordField(10);

        button = new JButton("Login");
        button.addActionListener(new LoginButton());
        button.addActionListener(e -> {
            frame.dispose();
        });
        customerButton = new JButton("Customer");
        customerButton.addActionListener(new CustomerButton());
        customerButton.addActionListener(e ->  {
            frame.dispose();
        });
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(userLabel);
        panel.add(textField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(button);
        panel.add(customerButton);

        frame.add(panel, BorderLayout.CENTER);


        frame.setSize(400, 200);
        frame.setVisible(true);



    }
    public JFrame getFrame() {
        return frame;
    }


    class CustomerButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Scanner input = new Scanner(System.in);
            System.out.print("Enter Name: ");
            String customerName = input.nextLine();
            //Customer newCustomer = new Customer(customerName);
            //newCustomer.Menu(); //test code to make sure a method is called
        }
    }
    class LoginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = textField.getText();
            String passWord = passField.getText();
            if (userName.equals("p131759") && passWord.equals("UMW.42972")) {
                JOptionPane.showMessageDialog(null, "Correct"); //test to make sure button is working
            }
        }
    }
    public static void main(String args[]) {
        Main window = new Main();
        window.getFrame().setSize(400, 150);
        window.getFrame().setVisible(true);


    }
}