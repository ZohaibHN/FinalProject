import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class represents all the features that the Admin will be able to do
 * @author Adam Broskie, Zohaib Hassan, Joel Amanuel
 */
public class User {
    private static final String ADMIN_USERNAME = "p131759";
    private static final String ADMIN_PASSWORD = "UMW.42972";
    private int employeeRating;

    /**
     * getter for the admin username
     * @return the username
     */
    public static String getAdminUsername() {
        return ADMIN_USERNAME;
    }
    /**
     * getter for the admin password
     * @return the password
     */
    public static String getAdminPassword() {
        return ADMIN_PASSWORD;
    }

    /**
     * pause method so everything doesn't pop up all at once.
     * @param waitTime
     */
    public static void pause(double waitTime) {
        try {
            Thread.sleep((int)(waitTime * 1000.0D));
        } catch (InterruptedException ignored) {
        }

    }

    /**
     * method that creates employees.  Writes changes to the EmployeeList file
     * @throws IOException
     */
    public static void createEmployee() throws IOException {
        FileWriter fileWriter = new FileWriter("EmployeeList", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter employee information pressing enter after every aspect:\n");
        String inputFName = scnr.nextLine();
        String inputLName = scnr.nextLine();
        int inputID = Integer.parseInt(scnr.nextLine());
        int inputRating = Integer.parseInt( scnr.nextLine());

        printWriter.append(inputFName + "\n");
        printWriter.append(inputLName + "\n");
        printWriter.append(String.valueOf(inputID) + "\n");
        printWriter.append(String.valueOf(inputRating) + "\n");
        printWriter.append("0\n");
        printWriter.close();
        System.out.println("Employee has been created");

        System.out.print(".");
        pause(1D);
        System.out.print(".");
        pause(1D);
        System.out.println(".");
        pause(1D);

    }

    /**
     * Method to list the currently "hired" employees
     * Reads from EmployeeList, with some time interval between each employee to help with visual aid
     */
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

    /**
     * method to give a selected employee a 0-5 star rating.
     * Prints the Employee list, with a number beside each one
     * so the Admin can easily select which employee they wish
     * to give a rating for.
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void rateEmployee() throws IOException, NumberFormatException {
        int i = 1;
        Scanner input = new Scanner(System.in);
        
        ArrayList<Employee> employees = Employee.getEmployeesFromFile("EmployeeList"); 
        for(Employee e : employees) 
            System.out.printf("[%d] %s %s\n", i++, e.getEmployeeFName(), e.getEmployeeLName()); 
        
        System.out.println("Which employee would you like to select?");
        int numSelection = 0;
        try {
            numSelection = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException L) {
            System.out.println();
        }
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

    /**
     * Reads the employee reviews which the customer writes.
     * Each review is linked with the employee's uniqueID number,
     * and the ID is used when grabbing the review.
     * @param ID
     */
    public static void readEmployeeReviews(int ID) {
        ArrayList<Employee> employees;
        try {
            employees = Employee.getEmployeesFromFile("EmployeeList"); 
        } catch(IOException e) {
            e.printStackTrace(); 
            return; 
        } 

        for(Employee e : employees) {
            if(e.getEmployeeID() == ID && e.getReviews().size() > 0) {
                System.out.printf("Customer reviews for employee #%d:\n", ID);

                for(String review : e.getReviews()) {
                    System.out.println(review);
                    System.out.println();
                    break;
                }

            }

            else if (e.getEmployeeID() == ID  && e.getReviews().size() == 0) {
                System.out.printf("No reviews for ID (%d).\n", ID);
                break;
            }

        }
        pause(2D);
    }

    /**
     * Method for the Admin's options once they log in.
     * With each number, a different method is called.
     * @throws IOException
     * @throws InputMismatchException
     * @throws NumberFormatException
     */
      public static void adminMenu() throws IOException, InputMismatchException, NumberFormatException {
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
                      int employeeNum = 0;
                      try {
                          employeeNum = Integer.parseInt(input.nextLine());
                      } catch (InputMismatchException g) {
                          System.out.print("Enter a valid number, please.");
                      } catch (NumberFormatException n) {
                          System.out.print("Enter a valid number.\n");
                          break;
                      }
                          readEmployeeReviews(e.get(employeeNum -1).getEmployeeID());


                      break;
                  case 4: rateEmployee(); //rateEmployees(); break;
                  case 5: System.exit(-1); break;

              }
          }
      }

    /**
     * method for the Employee menu.
     * Less amount of options compared to that of the Admin,
     * since they should only be able to view their reviews.
     */
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
