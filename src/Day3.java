import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day3 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 3: " + day3("lib/input.txt"));
    }

    public static int day3(String fileIn) throws IOException {
        int sum = 0;
        int prio = 0;
        int count = 0;
        char repeat = ' ';
        String knapsack = "";
        // String knap;
        // String sack;
        String[] group = new String[3];
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        while(scnr.hasNextLine()) {
            repeat = ' ';
            prio = 0;
            count++;
            knapsack = scnr.nextLine();
            // knap = knapsack.substring(0,knapsack.length()/2);
            // sack = knapsack.substring(knapsack.length()/2);
            group[count%3] = knapsack;
            if(count%3 == 0) {
                    for(int j=0; j<group[0].length(); j++) {
                        if(group[1].indexOf(group[0].charAt(j)) != -1) {
                            if(group[2].indexOf(group[0].charAt(j)) != -1) {
                                repeat = group[0].charAt(j);
                                break;
                            }
                        }
                    }
            }
            // h.print(knap + " " + sack);
            // for(int i=0; i<knap.length(); i++) {
            //     if(sack.indexOf(knap.charAt(i)) != -1) {
            //         repeat = knap.charAt(i);
            //         h.print(repeat + "");
            //         break;
            //     }
            // }
            if(repeat > 64 && repeat < 91) {
                prio = repeat-38;
            } else if(repeat > 96 && repeat < 123) {
                prio = repeat-96;
            }
            // h.print(prio);
            sum += prio;
        }
        scnr.close();
        return sum;
    }
}
