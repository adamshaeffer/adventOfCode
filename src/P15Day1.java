import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class P15Day1 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("2015 Day 1: " + day1("../lib/trial.txt"));
    }

    public static int day1(String fileIn) throws IOException {
        int count = 0;
        int base = 0;
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String instr = scnr.nextLine();
        scnr.close();
        file.close();
        for(int i=0; i<instr.length(); i++) {
            if(instr.charAt(i) == '(')
                count++;
            if(instr.charAt(i) == ')')
                count--;
            if(count == -1 && base == 0)
                base = i+1;
        }
        return base;
    }
}
