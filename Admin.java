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
        String inputID = scnr.nextLine();

        Employee newEmployee = new Employee(inputFName, inputLName, inputID);
        System.out.println("Employee has been created");

    }

    public void setRating() {

    }

}
