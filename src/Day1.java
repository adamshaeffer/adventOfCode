import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day1 {
    public static void main(String[] args) throws IOException {
        Function h = new Function();
        h.print("Day 1: " + day1("lib/input.txt"));
    }

    public static int day1(String fileIn) throws IOException {
        int sum = 0;
        int max = sum;
        int silv = sum;
        int bron = sum;
        // int lin = 0;
        String line = "";
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        while(scnr.hasNextLine()) {
            line = scnr.nextLine();
            if(line.equals("")) {
                if(sum > max) {
                    bron = silv;
                    silv = max;
                    max = sum;
                } else if(sum > silv) {
                    bron = silv;
                    silv = sum;
                } else if(sum > bron) {
                    bron = sum;
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
            // lin++;
        }
        scnr.close();
        file.close();
        return max+silv+bron;
    }
}
