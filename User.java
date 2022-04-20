import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class User {
    private static final String ADMIN_USERNAME = "p131759";
    private static final String ADMIN_PASSWORD = "UMW.42972";
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
        printWriter.println("0");
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
            ArrayList<Employee> employees = Employee.getEmployeesFromFile("EmployeeList");
            for(Employee e : employees) {
                System.out.printf("%s %s\n\tID: %d\n\trating: %d\n\n", 
                                  e.getEmployeeFName(), e.getEmployeeLName(), 
                                  e.getEmployeeID(), e.getRating()); 
                pause(0.25D);
            } 
            pause(0.66D);
        }  catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(-1); 
        }
    }


    public static void rateEmployee() throws IOException {
        int i = 1;
        Scanner input = new Scanner(System.in);
        
        ArrayList<Employee> employees = Employee.getEmployeesFromFile("EmployeeList"); 
        for(Employee e : employees) 
            System.out.printf("[%d] %s %s\n", i++, e.getEmployeeFName(), e.getEmployeeLName()); 
        
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
        Employee.writeToFile("EmployeeList", employees); 
    }

    public static void readEmployeeReviews(int ID) throws FileNotFoundException {
        ArrayList<Employee> employees = Employee.getEmployeesFromFile("EmployeeList"); 
        for(Employee e : employees) {
            if(e.getEmployeeID() == ID) {
                System.out.printf("Customer reviews for employee #%d:\n", ID); 
                for(String review : e.getReviews()) {
                    System.out.println(review); 
                    System.out.println(); 
                } 
            }
        } 
        
        System.out.printf("The provided ID (%d) was not found.\n", ID); 
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
      public static void employeeMenu() throws FileNotFoundException {
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
