import java.util.*;
import java.io.*;
public class Admin {
    private String adminFirstName;
    private String adminLastName;
    private String adminAuthenticationNumber;
    private int employeeRating;
    public Admin(String adminAuthenticationNumber) {
        this.adminAuthenticationNumber = adminAuthenticationNumber;
    }
    public void save(PrintWriter savePWriter) {
        savePWriter.println(this.adminFirstName);
        savePWriter.println(this.adminLastName);
        savePWriter.println(this.adminAuthenticationNumber);
    }
    public void setRating() {

    }

}
