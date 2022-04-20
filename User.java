import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class User {
    private static final String ADMIN_USERNAME = "p131759";
    private static final String ADMIN_PASSWORD = "UMW.42972";
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private int employeeRating;

    public static String getAdminUsername() {
        return ADMIN_USERNAME;
    }

    public static String getAdminPassword() {
        return ADMIN_PASSWORD;
    }
    public static void pause(double waitTime) {
        try {
            Thread.sleep((int)(waitTime * 1000.0D));
        } catch (InterruptedException ignored) {
        }

    }
    //creates a new employee
    public static void createEmployee() throws IOException {
        FileWriter fileWriter = new FileWriter("EmployeeList", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter employee information:\n");
        String inputFName = scnr.nextLine();
        String inputLName = scnr.nextLine();
        int inputID = scnr.nextInt();
        int inputRating = scnr.nextInt();

        printWriter.println(inputFName);
        printWriter.println(inputLName);
        printWriter.println(inputID);
        printWriter.println(inputRating);
        printWriter.println("");
        printWriter.close();
        System.out.println("Employee has been created");

        System.out.print(".");
        pause(1D);
        System.out.print(".");
        pause(1D);
        System.out.println(".");
        pause(1D);

    }
    public static void listEmployees() {
        try {
            Scanner input = new Scanner(new File("EmployeeList"));
            while (input.hasNext()) {
                String firstName = input.nextLine();
                String lastName = input.nextLine();
                int employeeID = Integer.parseInt(input.nextLine());
                input.nextLine();
                input.nextLine();
                Employee newEmployee = new Employee(firstName,lastName,employeeID);
                System.out.println(firstName + " " + lastName);
                pause(0.25D);
            }
            //System.out.println();
            pause(0.66D);
        }  catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }


    public static void rateEmployee() throws FileNotFoundException {
        int i = 1;
        Scanner employeeNum = new Scanner(new File("EmployeeList"));
        Scanner input = new Scanner(System.in);
        
        ArrayList<Employee> employees = new ArrayList<Employee>(); 
        while (employeeNum.hasNext()) {
            String firstName = employeeNum.nextLine();
            String lastName = employeeNum.nextLine();
            int employeeID = Integer.parseInt(employeeNum.nextLine());
            int rating = Integer.parseInt(employeeNum.nextLine()); 
            employeeNum.nextLine();
            
            employees.add(new Employee(firstName, lastName, employeeID, rating)); 
            System.out.println("[" + i + "] " + firstName + ", " + lastName);
            i++;
        }
        
        employeeNum.close(); 
        
        System.out.println("Which employee would you like to select?");
        int numSelection = input.nextInt();
        
        while(numSelection < 1 || numSelection > employees.size()) {
            System.out.println("That's not a valid employee."); 
            System.out.println("Which employee would you like to select?");
            numSelection = input.nextInt();
        }
        
        System.out.println("What rating would you like to give them? [0-5]"); 
        int rating = input.nextInt(); 
        while(rating < 0 || rating > 5) {
            System.out.println("That's not a valid star rating."); 
            System.out.println("What rating would you like to give them? [0-5]"); 
            rating = input.nextInt(); 
        }
        
        employees.get(numSelection - 1).setStarRating(rating); 
        
        // writing out the data back to the original file. 
        try {
            FileWriter fw = new FileWriter("EmployeeList"); 
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw)); 
            
            for(Employee e : employees) {
                pw.println(e.getEmployeeFName()); 
                pw.println(e.getEmployeeLName()); 
                pw.println(e.getEmployeeID()); 
                pw.println(e.getRating()); 
                pw.println(); 
            } 
            
            pw.close(); 
        } catch(IOException e) {
            e.printStackTrace(); 
            System.exit(-1); 
        } 
    }

    public static void readEmployeeReviews(int ID) {
        try {
            Scanner reader = new Scanner(new File("Reviews.txt"));
            while(reader.hasNext()) {
                try {
                    int fileID = Integer.parseInt(reader.nextLine());
                    String review = reader.nextLine();

                    if (fileID == ID) {
                        System.out.println(review);
                    }
                    reader.nextLine();
                } catch (Exception f) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        System.out.print("Bottom of page\n");
    }

      public static void adminMenu() throws IOException {
          while (true) {
              Scanner input = new Scanner(System.in);
              System.out.println("What would you like to do?");
              pause(0.5D);
              System.out.print(".");
              pause(0.5D);
              System.out.print(".");
              pause(0.5D);
              System.out.println();
              System.out.println("1. Create new employee.");
              System.out.println("2. List employees.");
              System.out.println("3. View Employee Reviews");
              System.out.println("4. Rate Employees");
              System.out.println("5. Exit");
              int adminNum = input.nextInt();
              switch (adminNum) {
                  case 1 -> createEmployee();
                  case 2 -> listEmployees();
                  case 3 -> readEmployeeReviews(0);
                  case 4 -> rateEmployee(); //rateEmployees();
                  case 5 -> System.exit(-1);
              }
          }
      }
      public static void employeeMenu() {
        Scanner input = new Scanner(System.in);
            System.out.println("1. View Employee Reviews");
            System.out.println("2. Exit");
            System.out.print("What would you like to do?: ");
            int userInput = input.nextInt();
            switch(userInput) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int employeeID = input.nextInt();
                    readEmployeeReviews(employeeID);
                    break;
                case 2:
                    System.exit(-1);
                    break;
            }


      }
}
