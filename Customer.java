import java.util.*;
import java.io.*;
public class Customer {
    private String name;

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

    public void pause(double waitTime) {
        try {
            Thread.sleep((int) (waitTime * 1000.0D));
        } catch (InterruptedException ignored) {
        }

    }

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
