import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day4 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 4: " + day4("lib/input.txt"));
    }

    public static int day4(String fileIn) throws IOException {
        int count = 0;
        int[] a = new int[2];
        int[] b = new int[2];
        String pair;
        String pa;
        String ir;
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        while(scnr.hasNextLine()) {
            pair = scnr.nextLine();
            pa = pair.substring(0,pair.indexOf(','));
            ir = pair.substring(pair.indexOf(',')+1);
            a[0] = Integer.parseInt(pa.substring(0,pa.indexOf('-')));
            a[1] = Integer.parseInt(pa.substring(pa.indexOf('-')+1));
            b[0] = Integer.parseInt(ir.substring(0,ir.indexOf('-')));
            b[1] = Integer.parseInt(ir.substring(ir.indexOf('-')+1));
            // h.print(a[0] + "-" + a[1] + " " + b[0] + "-" + b[1]);
            if(a[1] >= b[0] && a[0] <= b[1]) {
                count++;
                // h.print("Contains!");
            } else if(b[1] >= a[0] && b[0] <= a[1]) {
                count++;
                // h.print("Contains!");
            }
        }
        scnr.close();
        file.close();
        return count;
    }
}
