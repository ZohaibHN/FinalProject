import java.util.*;
import java.io.*;
public class Employee {
    private String employeeFName;
    private String employeeLName;
    private String employeeID;
    private int employeeRating = 0;
    private ArrayList<String> ratings;
    /**grab all info from the certain employee and make that in a single list instance
     *
     */
    public Employee(String employeeFName, String employeeLName, String employeeID) {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
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
