import java.util.*;
import java.io.*;
public class Employee  {
    private String employeeFName;
    private String employeeLName;
    private int employeeID;
    private int employeeRating;
    private ArrayList<String> ratings;
    FileReader employeeIn = new FileReader("EmployeeList");
    Scanner sin = new Scanner(employeeIn);
    /**grab all info from the certain employee and make that in a single list instance
     *
     */
    public Employee(String employeeFName, String employeeLName, int employeeID) throws FileNotFoundException {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
        this.employeeRating = 0;
    }
    public Employee(Scanner employeeScanner) throws FileNotFoundException {
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
