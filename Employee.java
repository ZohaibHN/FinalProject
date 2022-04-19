import java.util.*;
import java.io.*;
public class Employee {
    private String employeeFName;
    private String employeeLName;
    private String employeeID;
    private ArrayList<String> ratings;
    public Employee(String employeeFName, String employeeLName, String employeeID) {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
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
