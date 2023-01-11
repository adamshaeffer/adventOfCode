import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class P15Day8 {
    static Function he = new Function();
    public static void main(String[] args) throws IOException {
        he.print("2015 Day 8: " + day8("../lib/input.txt"));
    }

    public static int day8(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
        int code = 0, val = 0;
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            int n = in.length();
            code += n; n += 2;
            for(int i=0; i<in.length(); i++) {
                char c = in.charAt(i);
                if(c == '\\' || c == '"') {
                    n++;
                }
            }
            val += n;
            // int t = in.length()-2, p = in.indexOf('\\');
            // while(p != -1) {
                // char c = in.charAt(p+1);
                // if(c == '\\') {
                    // t -= 1;
                // } else if(c == '"') {
                    // t -= 1;
                // } else if(c == 'x') {
                    // t -= 3;
                // }
                // in = in.substring(p+2);
                // p = in.indexOf('\\');
            // }
            // val += t;
        }
        // return code-val;
        return val-code;
    }
}
