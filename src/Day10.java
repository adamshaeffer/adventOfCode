import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day10 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 10: " + day10("lib/input.txt"));
    }

    public static int day10(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
        int signal = 1;
        int cycle = -1;
        String[] screen = new String[6];
        for(int i=0; i<6; i++) {
            screen[i] = "";
        }
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            cycle++;
            if(signal-1 == cycle%40 || signal == cycle%40 || signal+1 == cycle%40) {
                screen[cycle/40] += "#";
            } else {
                screen[cycle/40] += ".";
            }
            if(in.charAt(0) == 'a') {
                cycle++;
            }
            if(in.charAt(0) == 'a') {
                if(signal-1 == cycle%40 || signal == cycle%40 || signal+1 == cycle%40) {
                    screen[cycle/40] += "#";
                } else {
                    screen[cycle/40] += ".";
                }
            }
            if(in.charAt(0) == 'a') {
                signal += Integer.parseInt(in.substring(5));
            }
        }
        h.print(screen);
        scnr.close();
        file.close();
        return 0;
    }
}
