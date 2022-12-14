import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day5 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 5: " + day5("lib/input.txt"));
    }

    public static String day5(String fileIn) throws IOException {
        String tops = "";
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String[] crates = new String[0];
        String in = "";
        int[][] instr = new int[0][3];
        int stackNum = 0;
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            if(in.length() == 0) {

            } else if(in.charAt(0) == 'm') {
                int[][] temp = new int[instr.length+1][3];
                in = in.substring(5);
                temp[instr.length][0] = Integer.parseInt(in.substring(0,in.indexOf(' ')));
                in = in.substring(in.indexOf(' ')+1);
                in = in.substring(5);
                temp[instr.length][1] = Integer.parseInt(in.substring(0,1));
                in = in.substring(5);
                temp[instr.length][2] = Integer.parseInt(in);
                for(int i=0; i<instr.length; i++) {
                    temp[i] = instr[i];
                }
                instr = temp;
            } else if(in.indexOf('[') != -1) {
                String[] temp = new String[crates.length+1];
                temp[crates.length] = in;
                for(int i=0; i<crates.length; i++) {
                    temp[i] = crates[i];
                }
                crates = temp;
            } else {
                stackNum = in.charAt(in.length()-2)-48;
            }
        }
        Stack[] stacks = new Stack[stackNum];
        Stack temp = new Stack();
        char t;
        int u;
        for(int i=0; i<stackNum; i++) {
            stacks[i] = new Stack();
        }
        for(int i=crates.length-1; i>=0; i--) {
            for(int j=1; j<stackNum*4; j+=4) {
                t = crates[i].charAt(j);
                if(t != ' ')
                    stacks[(j-1)/4].push(t);
            }
        }
        for(int i=0; i<instr.length; i++) {
            for(int j=0; j<instr[i][0]; j++) {
                temp.push(stacks[instr[i][1]-1].pop());
            }
            u = temp.getSize();
            for(int j=0; j<u; j++) {
                stacks[instr[i][2]-1].push(temp.pop());
            }
        }
        for(int i=0; i<stacks.length; i++) {
            tops += stacks[i].pop();
        }
        scnr.close();
        file.close();
        return tops;
    }
}
