import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class P15Day3 {
    static Function he = new Function();
    public static void main(String[] args) throws IOException {
        he.print("2015 Day 3: " + day3("../lib/trial.txt"));
    }

    public static int day3(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String[] in = new String[0];
        int x=0,y=0,x1=0,y1=0,count=0;
        int minX=0,maxX=0,minY=0,maxY=0;
        char c = '<';
        while(scnr.hasNextLine()) {
            in = he.add(in,scnr.nextLine());
            for(int i=0; i<in[count].length(); i++) {
                c = in[count].charAt(i);
                if(i%2 == 0) {
                    if(c == '<') x--;
                    if(c == '>') x++;
                    if(c == '^') y--;
                    if(c == 'v') y++;
                } else {
                    if(c == '<') x1--;
                    if(c == '>') x1++;
                    if(c == '^') y1--;
                    if(c == 'v') y1++;
                }
                if(x < minX) minX = x;
                if(x > maxX) maxX = x;
                if(y < minY) minY = y;
                if(y > maxY) maxY = y;
                if(x1 < minX) minX = x1;
                if(x1 > maxX) maxX = x1;
                if(y1 < minY) minY = y1;
                if(y1 > maxY) maxY = y1;
            }
            count++;
        }
        int h=maxY-minY, w=maxX-minX;
        h++; w++;
        int ox=0-minX, oy=0-minY;
        he.print(minX+ " " + maxX+" " + minY + " " + maxY);
        he.print(h+ " " + w+" " + ox + " " + oy);
        int[][] map = new int[h][w];
        x=ox; y=oy;
        x1=ox; y1=oy;
        map[y][x]++;
        // he.print(map);
        for(int i=0; i<count; i++) {
            // he.print(in[i]);
            for(int j=0; j<in[i].length(); j++) {
                c = in[i].charAt(j);
                if(j%2 == 0) {
                    if(c == '<') x--;
                    if(c == '>') x++;
                    if(c == '^') y--;
                    if(c == 'v') y++;
                    map[y][x]++;
                } else {
                    if(c == '<') x1--;
                    if(c == '>') x1++;
                    if(c == '^') y1--;
                    if(c == 'v') y1++;
                    map[y1][x1]++;
                }
                // he.print(map);
            }
        }
        he.print(map);
        count=0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[i][j] > 0) count++;
            }
        }
        return count;
    }
}
