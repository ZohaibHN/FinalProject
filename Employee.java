import java.util.*;
import java.io.*;
public class Employee  {
    private String employeeFName;
    private String employeeLName;
    private String employeeID;
    private int employeeRating = 0;
    private ArrayList<String> ratings;
    FileReader employeeIn = new FileReader("EmployeeList");
    Scanner sin = new Scanner(employeeIn);
    /**grab all info from the certain employee and make that in a single list instance
     *
     */
    public Employee(String employeeFName, String employeeLName, String employeeID) throws FileNotFoundException {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
    }
    public Employee(Scanner employeeScanner) throws FileNotFoundException {
        while (sin.hasNext()) {
            if (sin.hasNext()) {
                this.employeeFName = employeeScanner.nextLine();
            } else if(sin.hasNext()) {
                this.employeeLName = employeeScanner.nextLine();
            } else if(sin.hasNext()) {
                this.employeeID = employeeScanner.nextLine();
            } else if (sin.hasNextInt()) {
                this.employeeRating = Integer.parseInt(employeeScanner.nextLine());
            }

        }
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