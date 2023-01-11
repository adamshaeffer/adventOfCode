import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day13 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 13: " + day13("../lib/trial.txt"));
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
                h.print(count);
                sum += count;
            }
        }
        scnr.close();
        file.close();
        return sum;
    }

    public static boolean compareLists(String l, String r) {
        char ll, rr;
        int elemL = 0, elemR = 0;
        h.print(l + " vs " + r);
        for(int i=1, j=1; i<l.length()-1 && j<r.length()-1; i++) {
            ll = l.charAt(i);
            rr = r.charAt(j);
            if(ll == '[' && rr == '[') {
                String inL = "", inR = "";
                int brack = 1;
                while(ll != ']' && brack != 0) {
                    i++; ll = l.charAt(i);
                    if(ll == '[')
                        brack++;
                    if(ll == ']' && brack > 0)
                        brack--;
                    if(ll != ']')
                        inL += ll;
                }
                brack = 1;
                while(rr != ']') {
                    j++; rr = r.charAt(j);
                    if(rr == '[')
                        brack++;
                    if(rr == ']' && brack > 0)
                        brack--;
                    if(rr != ']')
                        inR += rr;
                }
                boolean inside = compareInList(inL,inR);
                if(!inside) {
                    h.print("Inner list error" + inL + " vs " + inR);
                    return false;
                }
                elemL++; elemR++;
                j++; continue;
            } else if(ll == '[' && rr != '[') {
                if(rr == ']') {
                    return false;
                }
                String inL = "", inR = "";
                while(ll != ']') {
                    i++; ll = l.charAt(i);
                    if(ll != ']')
                        inL += ll;
                }
                inR += rr;
                boolean inside = compareInList(inL,inR);
                if(!inside) {
                    h.print("Inner list error" + inL + " vs " + inR);
                    return false;
                }
                elemL++; elemR++;
                j++; continue;
            } else if(ll != '[' && rr == '[') {
                if(ll == ']') {
                    j++;
                    continue;
                }
                String inL = "", inR = "";
                while(rr != ']') {
                    j++; rr = r.charAt(j);
                    if(rr != ']')
                        inR += rr;
                }
                inL += ll;
                boolean inside = compareInList(inL,inR);
                if(!inside) {
                    h.print("Inner list error" + inL + " vs " + inR);
                    return false;
                }
                elemL++; elemR++;
                j++; continue;
            }
            if(ll == ',' && rr == ',') {
            } else if(ll > rr) {
                h.print(ll + " > " + rr);
                return false;
            }
            if(ll == '[' || ll == ',' || ll == ']') {
            } else {
                elemL++;
            }
            if(rr == '[' || rr == ',' || rr == ']') {
            } else {
                elemR++;
            }
            j++;
        }
        if(elemL > elemR) {
            h.print("Element error");
            return false;
        }
        return true;
    }

    public static boolean compareInList(String l, String r) {
        h.print("- " + l + " vs " + r);
        int i=0, j=0;
        while(i < l.length() && j < r.length()) {
            char ll = l.charAt(i), rr = r.charAt(j);
            if(ll > rr) {
                return false;
            }
            i++; j++;
        }
        return true;
    }

}
