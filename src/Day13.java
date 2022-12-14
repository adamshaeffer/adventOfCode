import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day13 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 13: " + day13("lib/input.txt"));
        // 976 is too low
    }

    public static int day13(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        int count = 0;
        int sum = 0;
        String left = "";
        String right = "";
        while(scnr.hasNextLine()) {
            left = scnr.nextLine();
            right = scnr.nextLine();
            if(scnr.hasNextLine()) {
                scnr.nextLine();
            }
            count++;
            boolean first = compareLists(left,right);
            if(first) {
                // h.print(count);
                sum += count;
            }
        }
        scnr.close();
        file.close();
        return sum;
    }

    public static boolean compareLists(String l, String r) {
        char ll, rr;
        boolean inside = false;
        // h.print(l + " vs " + r);
        for(int i=0, j=0; i<l.length() && j<r.length(); i++) {
            ll = l.charAt(i);
            rr = r.charAt(j);
            if((ll == '[' || ll == ',' || ll == ']') && (rr == '[' || rr == ',' || rr == ']')) {
            } else if(ll == '[' && rr != '[') {
                inside = true;
                i++;
                ll = l.charAt(i);
            } else if(rr == '[' && ll != '[') {
                inside = true;
                j++;
                rr = r.charAt(j);
            }
            if((ll == '[' || ll == ',' || ll == ']') && (rr == '[' || rr == ',' || rr == ']')) {
            } else if(ll == ']' && (rr != '[' || rr != ',' || rr != ']')) {
            } else if(rr == ']' && (ll != '[' || ll != ',' || ll != ']')) {
            } else if(ll > rr) {
                // h.print(ll + " > " + rr);
                return false;
            }
            j++;
        }
        if(l.length() > r.length() && !inside) {
            // h.print("Length error");
            return false;
        }
        return true;
    }

}
