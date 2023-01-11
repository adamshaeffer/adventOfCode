import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class P15Day9 {
    static Function he = new Function();
    public static void main(String[] args) throws IOException {
        he.print("2015 Day 9: " + day9("../lib/input.txt"));
    }

    public static int day9(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
    }
}
