import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day16 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 16: " + day16("lib/trial.txt"));
    }

    public static int day16(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        scnr.close();
        file.close();
        return 0;
    }
}
