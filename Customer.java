import java.util.*;
import java.io.*;
public class Customer {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    public void WriteReview() throws IOException {
        Scanner reviewInput = new Scanner(System.in);
        try (FileWriter fw = new FileWriter("Reviews.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            new FileWriter("Reviews.txt", false).close();
            out.println("Very nice attitude and helpful!");
            out.println("Always put on a smile.  Never seems like they are in a bad mood!");
            out.println("Seemed a little upset when I asked for help.");
            out.println("Had the vibe that they didn't want to be at work.");
            System.out.println("Enter your review:");
            String customerReview = reviewInput.nextLine();
            out.println(customerReview);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }


    }
    public void listEmployees() {
        try {
            Scanner input = new Scanner(new File("EmployeeList"));
            while (input.hasNextLine()) {
                String firstName = input.nextLine();
                String lastName = input.nextLine();
                int employeeID = Integer.parseInt(input.nextLine());
                Employee newEmployee = new Employee(firstName, lastName, employeeID);
                employees.add(newEmployee);
                input.nextLine();
                input.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public static void main(String[] args) {

    }
}
