import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class P15Day6 {
    static Function he = new Function();
    public static void main(String[] args) throws IOException {
        he.print("2015 Day 6: " + day6("../lib/input.txt"));
    }

    public static int day6(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
        int[][] map = new int[1000][1000];
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            int[] a = new int[2];
            int[] b = new int[2];
            int inst = 0;
            if(in.charAt(1) == 'o') { // toggle
                in = in.substring(7);
                a[0] = Integer.parseInt(in.substring(0,in.indexOf(',')));
                a[1] = Integer.parseInt(in.substring(in.indexOf(',')+1,in.indexOf(' ')));
                in = in.substring(in.indexOf('g')+3);
                b[0] = Integer.parseInt(in.substring(0,in.indexOf(',')));
                b[1] = Integer.parseInt(in.substring(in.indexOf(',')+1));
                // he.print(a);
                // he.print(b);
                inst = 1;
            } else {
                if(in.charAt(6) == 'n') { // turn on
                    in = in.substring(8);
                    a[0] = Integer.parseInt(in.substring(0,in.indexOf(',')));
                    a[1] = Integer.parseInt(in.substring(in.indexOf(',')+1,in.indexOf(' ')));
                    in = in.substring(in.indexOf('g')+3);
                    b[0] = Integer.parseInt(in.substring(0,in.indexOf(',')));
                    b[1] = Integer.parseInt(in.substring(in.indexOf(',')+1));
                    // he.print(a);
                    // he.print(b);
                    inst = 2;
                } else { // turn off
                    in = in.substring(9);
                    a[0] = Integer.parseInt(in.substring(0,in.indexOf(',')));
                    a[1] = Integer.parseInt(in.substring(in.indexOf(',')+1,in.indexOf(' ')));
                    in = in.substring(in.indexOf('g')+3);
                    b[0] = Integer.parseInt(in.substring(0,in.indexOf(',')));
                    b[1] = Integer.parseInt(in.substring(in.indexOf(',')+1));
                    // he.print(a);
                    // he.print(b);
                    inst = 3;
                }
            }
            for(int i=a[1]; i<b[1]+1; i++) {
                for(int j=a[0]; j<b[0]+1; j++) {
                    switch(inst) {
                    case 1: // toggle
                        map[i][j] += 2;
                        break;
                    case 2: // turn on
                        map[i][j] += 1;
                        break;
                    case 3: // turn off
                        if(map[i][j] > 0) map[i][j] -= 1;
                        break;
                    }
                }
            }
        }
        int count = 0;
        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                count += map[i][j];
            }
        }
        // he.print(map);
        return count;
    }
}
