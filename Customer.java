import java.util.*;
import java.io.*;
public class Customer {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    public void WriteReview(int employeeNum) throws IOException {
        Scanner reviewInput = new Scanner(System.in);
        try (FileWriter fw = new FileWriter("Reviews.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            new FileWriter("Reviews.txt", false).close();
            System.out.print("Enter your review: ");
            String customerReview = reviewInput.nextLine();
            out.println(customerReview + "| Rating for Employee ID: " + employees.get(employeeNum - 1).getEmployeeID());
            employees.get(employeeNum-1).addRating(customerReview);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }


    }
    public void pause(double waitTime) {
        try {
            Thread.sleep((int)(waitTime * 1000.0D));
        } catch (InterruptedException ignored) {
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

                System.out.println(firstName + " " + lastName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public static void main(String[] args) {

    }
}
