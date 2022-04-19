import java.util.*;
import java.io.*;
public class Employee  {
    private String employeeFName;
    private String employeeLName;
    private int employeeID;
    private int employeeRating;
    private ArrayList<String> ratings;

    /**grab all information from the certain employee and make that in a single list instance
     *
     */
    public Employee(String employeeFName, String employeeLName, int employeeID)  {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
        this.employeeRating = 0;
    }
    public Employee(Scanner employeeScanner)  {
        this.employeeFName = employeeScanner.nextLine();
        this.employeeLName = employeeScanner.nextLine();
        this.employeeID = employeeScanner.nextInt();
        this.employeeRating = employeeScanner.nextInt();
        }



    public String getEmployeeFName() {
        return employeeFName;
    }
    public String getEmployeeLName() {
        return employeeLName;
    }
    public int getEmployeeID() {
        return employeeID;
    }

}
