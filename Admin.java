import java.util.*;
import java.io.*;
public class Admin {
    private static final String ADMIN_USERNAME = "p131759";
    private static final String ADMIN_PASSWORD = "UMW.42972";
    private int employeeRating;

    public void createEmployee() throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter employee information:\n");
        String inputFName = scnr.nextLine();
        String inputLName = scnr.nextLine();
        int inputID = scnr.nextInt();

        Employee newEmployee = new Employee(inputFName, inputLName, inputID);
        System.out.println("Employee has been created");

    }

    public void setRating() {

    }
    public void menuOptions() {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1. Create new employee.");
        System.out.println("2. List employees.");
        System.out.println("3. View Employee Reviews");
        System.out.println("4. Rate Employees");
        System.out.println("5. Exit");
        int adminNum = input.nextInt();
    }

}
