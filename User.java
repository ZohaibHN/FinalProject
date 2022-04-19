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

    public static void createEmployee() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter employee information:\n");
        String inputFName = scnr.nextLine();
        String inputLName = scnr.nextLine();
        int inputID = scnr.nextInt();

        System.out.println("Employee has been created");

    }
    public static void listEmployees() {
        try {
            Scanner input = new Scanner(new File("EmployeeList"));
            while (input.hasNextLine()) {
                String firstName = input.nextLine();
                String lastName = input.nextLine();
                int employeeID = Integer.parseInt(input.nextLine());
                input.nextLine();
                input.nextLine();
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(employeeID);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
    public static void updateEmployeeList() {
        try {
            Scanner input = new Scanner(new File("EmployeeList"));
            while (input.hasNextLine()) {
                String firstName = input.nextLine();
                String lastName = input.nextLine();
                int employeeID = Integer.parseInt(input.nextLine());
                Employee newEmployee = new Employee(firstName, lastName, employeeID);
                employeeList.add(newEmployee);
                input.nextLine();
                input.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
    public static void listEmployeeNames() {
        Scanner employeeNum = new Scanner(System.in);
        System.out.println("Which employee would you like to select?");
        for(Employee employee : employeeList) {
            System.out.println(employee.getEmployeeLName() + ", " + employee.getEmployeeFName());
        }
        int adminInput = employeeNum.nextInt();
    }
    public static void employeeReview(int ID) {
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
                    System.out.println("Bottom of page");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public void setRating() {

    }
    //public void menuOptions()
      public static void adminMenu() {
          while (true) {
              Scanner input = new Scanner(System.in);
              System.out.println("What would you like to do?");
              System.out.println();
              System.out.println("1. Create new employee.");
              System.out.println("2. List employees.");
              System.out.println("3. Update Employee List");
              System.out.println("4. View Employee Reviews");
              System.out.println("5. Rate Employees");
              System.out.println("6. Exit");
              int adminNum = input.nextInt();
              switch (adminNum) {
                  case 1:
                      createEmployee();
                      break;
                  case 2:
                      listEmployees();
                      break;
                  case 3:
                      updateEmployeeList();
                      break;
                  case 4:
                    listEmployeeNames();
                      break;
                  case 5:
                    listEmployeeNames();
                      break;
                  case 6:
                      System.exit(-1);
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
                    employeeReview(employeeID);
                    break;
                case 2:
                    System.exit(-1);
                    break;
            }


      }
}
