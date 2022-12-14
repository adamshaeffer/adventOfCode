import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day6 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 6: " + day6("lib/input.txt"));
    }
    
    public static int day6(String fileIn) throws IOException {
        int i=0;
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        boolean unique = true;
        String signal = scnr.next();
        String stream = "";
        char a = ' ';
        scnr.close();
        file.close();
        for(i=0; i<signal.length(); i++) {
            a = signal.charAt(i);
            unique = true;
            stream += a;
            if(stream.length() > 14) {
                stream = stream.substring(1);
            }
            for(int j=0; j<stream.length()-1; j++) {
                for(int k=j+1; k<stream.length(); k++) {
                    if(stream.charAt(j) == stream.charAt(k)) {
                        unique = false;
                        // h.print(stream.charAt(j) + " " + stream.charAt(k));
                    }
                }
            }
            // h.print(stream);
            if(unique && stream.length() == 14) {
                break;
            }
        }
        return i+1;
    }
}
