import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Day2 {
    public static void main(String[] args) throws IOException {
        Function h = new Function();
        h.print("Day 2: " + day2("lib/input.txt"));
    }

    public static int day2(String fileIn) throws IOException {
        int score = 0;
        String line = "";
        char opp;
        char me;
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        while(scnr.hasNextLine()) {
            line = scnr.nextLine();
            opp = line.charAt(0);
            me = line.charAt(2);
            if(me == 'X') { // I throw rock
                score += 0;
                if(opp == 'A') { // Opponent rock
                    score += 3;
                } else if(opp == 'B') {
                    score += 1;
                } else if(opp == 'C') { // Opponent scissors
                    score += 2;
                }
            }
            else if(me == 'Y') { // I throw paper
                score += 3;
                if(opp == 'A') {
                    score += 1;
                } else if(opp == 'B') {
                    score += 2;
                } else if(opp == 'C') {
                    score += 3;
                }
            }
            if(me == 'Z') { // I throw scissors
                score+=6;
                if(opp == 'A') {
                    score += 2;
                } else if(opp == 'B') {
                    score += 3;
                } else if(opp == 'C') {
                    score += 1;
                }
            }
        }
        scnr.close();
        file.close();
        return score;
    }
}
