import java.util.*;
import java.io.*;
public class Employee {
    private String employeeFName;
    private String employeeLName;
    private String employeeID;
    private int employeeRating;
    private ArrayList<String> ratings;
    public Employee(String employeeFName, String employeeLName, String employeeID, int employeeRating) {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
        this.employeeRating = employeeRating;
    }
    public Employee(Scanner employeeScanner) {
        this.employeeFName = employeeScanner.nextLine();
        this.employeeLName = employeeScanner.nextLine();
        this.employeeID = employeeScanner.nextLine();
        this.employeeRating = Integer.parseInt(employeeScanner.nextLine());
    }

    public String getEmployeeFName() {
        return employeeFName;
    }
    public String getEmployeeLName() {
        return employeeLName;
    }
    public String getEmployeeID() {
        return employeeID;
    }
}
