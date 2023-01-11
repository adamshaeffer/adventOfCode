import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class P15Day5 {
    static Function he = new Function();
    public static void main(String[] args) throws IOException {
        he.print("2015 Day 5: " + day5("../lib/trial.txt"));
    }

    public static int day5(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
        int count = 0;
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            // int vow = 0;
            // boolean dub = false;
            // boolean ill = true;
            boolean rep = false;
            boolean san = false;
            // for(int i=0; i<in.length(); i++) {
            for(int i=0; i<in.length()-1; i++) {
                char c = in.charAt(i);
                if(i<in.length()-2 && c == in.charAt(i+2)) san = true;
                String sub = "" + c + in.charAt(i+1);
                for(int j=i+2; j<in.length()-1; j++) {
                    if(sub.equals(""+in.charAt(j)+in.charAt(j+1))) rep = true;
                }
                // if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vow++;
                // if(i < in.length()-1) {
                    // if(in.charAt(i+1)==c) dub = true;
                    // String sub = "" + c + in.charAt(i+1);
                    // if(sub.equals("ab") || sub.equals("cd") || sub.equals("pq") || sub.equals("xy")) ill = false;
                // }
            }
            if(san && rep) {
                count++;
                 he.print(in);
            }
            // if(vow >= 3 && dub && ill) {
                // count++;
                // he.print(in);
            // }
        }
        return count;
    }
}
