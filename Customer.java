import java.util.*;
import java.io.*;

/**
 * This class handles all the options that the Customer is able to do
 * @author Adam Broskie, Zohaib Hassan, Joel Amanuel
 */
public class Customer {
    private String name;

    /**
     * method to write a review for a chosen employee
     * calls getEmployeesFromFile method to grab the employees.
     * from the EmployeeList file
     * @param employeeIndex index for which employee chosen
     * @throws IOException
     */
    public void WriteReview(int employeeIndex) throws IOException {
        Scanner reviewInput = new Scanner(System.in);
        ArrayList<Employee> employees = Employee.getEmployeesFromFile("EmployeeList");
        Employee reviewed = employees.get(employeeIndex - 1);
        System.out.printf("Please enter your review for %s %s:", reviewed.getEmployeeFName(), reviewed.getEmployeeLName());
        reviewed.addRating(reviewInput.nextLine());

        Employee.writeToFile("EmployeeList", employees);
        System.out.println("Thank you for your review");
        System.out.println("Have a good day!");
        System.out.print("Exiting");
        pause(0.5D);
        System.out.print(".");
        pause(0.125D);
        System.out.print(".");
        pause(0.125D);
        System.out.print(".");
        pause(0.125D);
        System.out.print(".");
        pause(0.125D);
        System.out.print(".");
        pause(0.125D);
        System.out.print(".");
    }

    /**
     * pause method so everything doesn't pop up all at once
     * @param waitTime wait time
     */
    public void pause(double waitTime) {
        try {
            Thread.sleep((int) (waitTime * 1000.0D));
        } catch (InterruptedException ignored) {
        }

    }

    /**
     * lists all employees available
     * @throws FileNotFoundException
     * @throws InputMismatchException
     */
    public void listEmployees() throws FileNotFoundException, InputMismatchException {
        ArrayList<Employee> employees = Employee.getEmployeesFromFile("EmployeeList");
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            System.out.printf("[%d] %s %s\n", i + 1, e.getEmployeeFName(), e.getEmployeeLName());
        }
        try {
            System.out.println("Enter in the number which corresponds with the appropriate employee.");
        } catch (InputMismatchException e) {
            System.out.print("Please enter a valid number.");
        }
    }
}
