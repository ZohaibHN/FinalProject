import java.util.*;
import java.io.*;

/**
 * This class creates the employees from the EmployeeList file
 * @author Adam Broskie, Zohaib Hassan, Joel Amanuel
 */
public class Employee  {
    private String employeeFName;
    private String employeeLName;
    private int employeeID;
    private int employeeRating;
    private ArrayList<String> ratings = new ArrayList<>();

    /**
     * constructor for an employee
     * @param employeeFName first name
     * @param employeeLName last name
     * @param employeeID ID
     */
    public Employee(String employeeFName, String employeeLName, int employeeID) {
        this(employeeFName, employeeLName, employeeID, 0); 
    }

    /**
     * constructor for employee
     * @param employeeFName first name
     * @param employeeLName last name
     * @param employeeID ID
     * @param starRating 0-5 star rating
     */
    public Employee(String employeeFName, String employeeLName, int employeeID, int starRating)  {
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeID = employeeID;
        this.employeeRating = starRating; 
    }

    /**
     * getter for first name
     * @return first name
     */
    public String getEmployeeFName() {
        return employeeFName;
    }

    /**
     * getter for last name
     * @return last name
     */
    public String getEmployeeLName() {
        return employeeLName;
    }

    /**
     * getter for employee ID
     * @return ID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * getter for the 0-5 star rating
     * @return star rating
     */
    public int getRating() {
        return employeeRating; 
    }

    /**
     * sets the star rating
     * @param rating
     */
    public void setStarRating(int rating) {
        this.employeeRating = rating; 
    }

    /**
     * adds a star rating
     * @param rating
     */
    public void addRating(String rating) {
        ratings.add(rating);
    }

    /**
     * grabs the customer's reviews
     * @return
     */
    public ArrayList<String> getReviews() {
        return ratings; 
    }

    /**
     * grabs the employees from the EmployeeList file
     * @param file
     * @return ArrayList
     * @throws FileNotFoundException
     */
    public static ArrayList<Employee> getEmployeesFromFile(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file)); 
        ArrayList<Employee> e = new ArrayList<Employee>(); 
        
        while(sc.hasNext()) {
            String fn = sc.nextLine(); 
            String ln = sc.nextLine(); 
            int id = Integer.parseInt(sc.nextLine()); 
            int rating = Integer.parseInt(sc.nextLine()); 
            Employee temp = new Employee(fn, ln, id, rating); 
            
            int numRevs = Integer.parseInt(sc.nextLine()); 
            for(int i = 0; i < numRevs; i++) 
                temp.addRating(sc.nextLine()); 

            e.add(temp); 
        }
        
        return e; 
    }

    /**
     * method to write changes to the EmployeeList file
     * @param file
     * @param employees
     * @throws IOException
     */
    public static void writeToFile(String file, ArrayList<Employee> employees) throws IOException {
        FileWriter fw = new FileWriter(file); 
        PrintWriter pw = new PrintWriter(new BufferedWriter(fw)); 
        
        for(Employee e : employees) {
            pw.println(e.getEmployeeFName()); 
            pw.println(e.getEmployeeLName()); 
            pw.println(e.getEmployeeID()); 
            pw.println(e.getRating()); 
            
            ArrayList<String> revs = e.getReviews(); 
            pw.println(revs.size()); 
            for(String s : revs) 
                pw.println(s); 
        } 

        pw.flush(); 
        pw.close(); 
    } 
}
