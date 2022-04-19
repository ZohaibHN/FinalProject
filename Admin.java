import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
public class Admin {
    private static final String ADMIN_USERNAME = "p131759";
    private static final String ADMIN_PASSWORD = "UMW.42972";
    private int employeeRating;

    public static void createEmployee() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter employee information:\n");
        String inputFName = scnr.nextLine();
        String inputLName = scnr.nextLine();
        int inputID = scnr.nextInt();

        Employee newEmployee = new Employee(inputFName, inputLName, inputID);
        System.out.println("Employee has been created");

    }
    public static void listEmployees() {
        try {
            Scanner input = new Scanner(new File("EmployeeList"));
            while (input.hasNextLine()) {
                String firstName = input.nextLine();
                String lastName = input.nextLine();
                int employeeID = Integer.parseInt(input.nextLine());
                input.nextLine();
                input.nextLine();
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(employeeID);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public void setRating() {

    }
    //public void menuOptions()
      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1. Create new employee.");
        System.out.println("2. List employees.");
        System.out.println("3. View Employee Reviews");
        System.out.println("4. Rate Employees");
        System.out.println("5. Exit");
        int adminNum = input.nextInt();
        switch (adminNum) {
            case 1:
                createEmployee();
                break;
            case 2:
                listEmployees();
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                System.exit(-1);
        }
    }
    public static String getAdminUsername() {
        return ADMIN_USERNAME;
    }

    public static String getAdminPassword() {
        return ADMIN_PASSWORD;
    }
}
