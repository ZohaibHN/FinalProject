import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Adam Broskie, Zohaib Hassan, Joel Amanuel
 * This program represents what a boss/manager of a workplace will
 * do when they do a performance review.
 *
 */
public class Main {
    JFrame frame;
    JLabel userLabel;
    JTextField textField;
    JLabel passLabel;
    JTextField passField;
    JButton button, customerButton;
    User user = new User();

    /**
     * this method creates a JFrame where we can log in.
     */
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

    /**
     * a getter for the JFrame
     * @return the JFrame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * JButton for the customer, allows us to interact with the JFrame
     * and use the customer's features
     */
    class CustomerButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) throws InputMismatchException {

            Scanner input = new Scanner(System.in);


            System.out.print("Enter Name: ");
            String customerName = input.nextLine();

            System.out.print("Greetings, " + customerName + ".  Please select an employee you wish to review");

            Customer c1 = new Customer();

            try {
                c1.pause(1D);
                System.out.print(" .");
                c1.pause(1D);
                System.out.print(".");
                c1.pause(1D);
                System.out.println(".");
                c1.pause(0.25D);
                c1.listEmployees();
                try {
                    int selectEmployee = input.nextInt();
                    c1.WriteReview(selectEmployee);
                } catch (InputMismatchException L) {
                    System.out.print("Please enter a valid number for the employee you wish to choose.");
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            //newCustomer.Menu(); //test code to make sure a method is called
        }
    }

    /**
     * Login button for Admin/Employee
     * Will verify if the credentials are correct, otherwise a popup will appear saying
     * they are incorrect.
     */
    class LoginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = textField.getText();
            String passWord = passField.getText();

            if (userName.equals(user.getAdminUsername()) && passWord.equals(user.getAdminPassword())) {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Access Granted: Welcome Admin");//test to make sure button is working
                try {
                    user.adminMenu();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            } else if ((userName.equals("employee") || userName.equals("Employee")) && passWord.equals("123456")) {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Access Granted: Welcome Employee");
                user.employeeMenu();
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect username/password.");//incorrect username/password
                textField.setText("");
                passField.setText("");
            }
        }
    }

    /**
     * main method which draws JFrame
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        Main window = new Main();
        window.getFrame().setSize(400, 150);
        window.getFrame().setVisible(true);


    }
}