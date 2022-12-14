import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day14 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 14: " + day14("lib/trial.txt"));
    }

    public static int day14(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        scnr.close();
        file.close();
        return 0;
    }
}
