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
            while (input.hasNextLine()) {
                String firstName = input.nextLine();
                String lastName = input.nextLine();
                int employeeID = Integer.parseInt(input.nextLine());
                input.nextLine();
                input.nextLine();
                Employee newEmployee = new Employee(firstName, lastName, employeeID);

                System.out.println(firstName + " " + lastName);
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
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public static void listEmployeeNames() {
        Scanner employeeNum = new Scanner(System.in);
        System.out.println("Which employee would you like to select?");
        int i = 0;
            for (Employee employee : employeeList) {

                System.out.println("[" + i + "] " + employee.getEmployeeLName() + ", " + employee.getEmployeeFName());
                i++;
            }

            int adminInput = employeeNum.nextInt();

            System.out.println(adminInput + ": " + employeeList.get(adminInput));

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
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        System.out.print("Bottom of page");
    }

    public void setRating() {

    }
    //public void menuOptions()
      public static void adminMenu() throws IOException {
          while (true) {
              Scanner input = new Scanner(System.in);
              System.out.println("What would you like to do?");
              pause(1D);
              System.out.print(".");
              pause(1D);
              System.out.print(".");
              System.out.println();
              System.out.println("1. Create new employee.");
              System.out.println("2. List employees.");
              System.out.println("3. Update Employee List");
              System.out.println("4. View Employee Reviews");
              System.out.println("5. Rate Employees");
              System.out.println("6. Exit");
              int adminNum = input.nextInt();
              switch (adminNum) {
                  case 1 -> createEmployee();
                  case 2 -> listEmployees();
                  case 3 -> updateEmployeeList();
                  case 4 -> listEmployeeNames();
                  case 5 -> listEmployeeNames(); //rateEmployees();
                  case 6 -> System.exit(-1);
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
