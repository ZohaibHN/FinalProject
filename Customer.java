import java.util.*;
import java.io.*;
public class Customer {
    public static void main(String args[]) throws IOException {
        try(FileWriter fw = new FileWriter("Reviews.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("the text");
            //more code
            out.println("more text");
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }
}
