import java.util.*;
import java.io.*;
public class Customer {
    public static void main(String args[]) throws IOException {
        try(FileWriter fw = new FileWriter("Reviews.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("Very nice attitude and helpful!");
            out.println("Always put on a smile.  Never seems like they are in a bad mood!");
            out.println("Seemed a little upset when I asked for help.");
            out.println("Had the vibe that they didn't want to be at work.");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }
}
