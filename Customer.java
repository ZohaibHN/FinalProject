import java.util.*;
import java.io.*;
public class Customer {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    public void WriteReview(int employeeNum) throws IOException {
        while (true) {
        Scanner reviewInput = new Scanner(System.in);
        try (FileWriter fw = new FileWriter("Reviews.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            //new FileWriter("Reviews.txt", false).close();
            System.out.println("Enter your review:");
            String customerReview = reviewInput.nextLine();
            out.println(employees.get(employeeNum-1).getEmployeeID());
            out.println(customerReview);
            out.close();
            System.out.println("Thank you for your review");
            System.out.println("Have a good day!");
            System.out.print("Exiting");
            pause(0.5D);
            System.out.print(".");
            pause(0.125D);
            System.out.print(".");
            pause(0.125D);
            System.out.print(".");
            pause(0.125D);
            System.out.print(".");
            pause(0.125D);
            System.out.print(".");
            pause(0.125D);
            System.out.print(".");
            System.exit(-1);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }
    }
    public void pause(double waitTime) {
        try {
            Thread.sleep((int)(waitTime * 1000.0D));
        } catch (InterruptedException ignored) {
        }

    }
    public void listEmployees() throws FileNotFoundException {
        int i = 1;
        Scanner employeeNum = new Scanner(new File("EmployeeList"));
        Scanner input = new Scanner(System.in);
        while (employeeNum.hasNext()) {
            String firstName = employeeNum.nextLine();
            String lastName = employeeNum.nextLine();
            int employeeID = Integer.parseInt(employeeNum.nextLine());
            Employee newEmployee = new Employee(firstName, lastName, employeeID);
            employeeNum.nextLine();
            employeeNum.nextLine();
            System.out.println("[" + i + "] " + firstName + ", " + lastName);
            i++;
        }
        System.out.println("Enter in the number which corresponds with the appropriate employee.");


        /**try {
            Scanner input = new Scanner(new File("EmployeeList"));
            while (input.hasNext()) {
                String firstName = input.nextLine();
                String lastName = input.nextLine();
                int employeeID = Integer.parseInt(input.nextLine());
                input.nextLine();
                input.nextLine();
                Employee newEmployee = new Employee(firstName, lastName, employeeID);
                employees.add(newEmployee);

                System.out.println(firstName + " " + lastName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }**/
    }
}
