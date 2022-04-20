import java.util.*;
import java.io.*; 

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
    public ArrayList<String> getReviews() {
        return ratings; 
    } 
    
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
    } 
}
