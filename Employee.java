import java.util.*;

public class Employee  {
    private String employeeFName;
    private String employeeLName;
    private int employeeID;
    private int employeeRating;
    private ArrayList<String> ratings = new ArrayList<>();

    /**grab all information from the certain employee and make that in a single list instance
     *
     */
    public Employee(String employeeFName, String employeeLName, int employeeID) {
        this(employeeFName, employeeLName, employeeID, 0); 
    } 
    
    public Employee(String employeeFName, String employeeLName, int employeeID, int starRating)  {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
        this.employeeRating = starRating; 
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
    public int getRating() {
        return employeeRating; 
    } 
    public void setStarRating(int rating) {
        this.employeeRating = rating; 
    } 
    public void addRating(String rating) {
        ratings.add(rating);
    }

}
