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
        int inputID = Integer.parseInt(scnr.nextLine());
        int inputRating = Integer.parseInt( scnr.nextLine());

        printWriter.append(inputFName);
        printWriter.append(inputLName);
        printWriter.append(String.valueOf(inputID));
        printWriter.append(String.valueOf(inputRating));
        printWriter.append("0");
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
        int numSelection = Integer.parseInt(input.nextLine());
        
        while(numSelection < 1 || numSelection > employees.size()) {
            System.out.println("That's not a valid employee."); 
            System.out.println("Which employee would you like to select?");
            numSelection = Integer.parseInt(input.nextLine());
        }
        
        System.out.println("What rating would you like to give them? [0-5]"); 
        int rating = Integer.parseInt(input.nextLine()); 
        while(rating < 0 || rating > 5) {
            System.out.println("That's not a valid star rating."); 
            System.out.println("What rating would you like to give them? [0-5]"); 
            rating = Integer.parseInt(input.nextLine()); 
        }
        
        employees.get(numSelection - 1).setStarRating(rating); 
        
        // writing out the data back to the original file. 
        Employee.writeToFile("EmployeeList", employees); 
    }

    public static void readEmployeeReviews(int ID) {
        ArrayList<Employee> employees = null; 
        try {
            employees = Employee.getEmployeesFromFile("EmployeeList"); 
        } catch(IOException e) {
            e.printStackTrace(); 
            return; 
        } 

        for(Employee e : employees) {
            if(e.getEmployeeID() == ID) {
                System.out.printf("Customer reviews for employee #%d:\n", ID); 
                for(String review : e.getReviews()) {
                    System.out.println(review); 
                    System.out.println();

                }
                break;
            } else {
                System.out.printf("No reviews for ID (%d).\n", ID);
                break;
            }
        }
        

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
              int adminNum = Integer.parseInt(input.nextLine());
              switch (adminNum) {
                  case 1: createEmployee(); break;
                  case 2: listEmployees(); break;
                  case 3: 
                      ArrayList<Employee> e = null; 
                      try {
                          e = Employee.getEmployeesFromFile("EmployeeList"); 
                      } catch(IOException ex) {
                          ex.printStackTrace(); 
                          System.exit(-1); 
                      } 
                      
                      for(int i = 0; i < e.size(); i++) {
                          System.out.printf("[%d] %s %s\n", i + 1, 
                                            e.get(i).getEmployeeFName(), 
                                            e.get(i).getEmployeeLName()); 
                      }
                      System.out.println("Which employee's reviews do you want to read? "); 
                      int employeeNum = Integer.parseInt(input.nextLine()); 
                      readEmployeeReviews(e.get(employeeNum - 1).getEmployeeID()); 
                      break;
                  case 4: rateEmployee(); //rateEmployees(); break;
                  case 5: System.exit(-1); break;
              }
          }
      }
      public static void employeeMenu() {
        Scanner input = new Scanner(System.in);
            System.out.println("1. View Employee Reviews");
            System.out.println("2. Exit");
            System.out.print("What would you like to do?: ");
            int userInput = Integer.parseInt(input.nextLine());
            switch(userInput) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int employeeID = Integer.parseInt(input.nextLine());
                    readEmployeeReviews(employeeID);
                    break;
                case 2:
                    System.exit(-1);
                    break;
            }


      }
}
