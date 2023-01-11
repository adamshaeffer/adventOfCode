import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day14 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 14: " + day14("../lib/input.txt"));
    }

    public static int day14(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
        String[] input = new String[0];
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            input = h.add(input,in);
        }
        int[][] paths = new int[input.length][0];
        for(int i=0; i<input.length; i++) {
            while(input[i].indexOf(',') != -1) {
                paths[i] = h.add(paths[i],Integer.parseInt(input[i].substring(0,input[i].indexOf(','))));
                input[i] = input[i].substring(input[i].indexOf(',')+1);
                if(input[i].indexOf('>') != -1) {
                    paths[i] = h.add(paths[i],Integer.parseInt(input[i].substring(0,input[i].indexOf(' '))));
                    input[i] = input[i].substring(input[i].indexOf('>')+2);
                } else {
                    paths[i] = h.add(paths[i],Integer.parseInt(input[i]));
                }
            }
        }
        int minX = 500, maxX = 500, minY = 500, maxY = 0;
        for(int i=0; i<paths.length; i++) {
            for(int j=0; j<paths[i].length; j++) {
                int t = paths[i][j];
                if(j%2 == 0) {
                    if(t<minX)
                        minX = t;
                    if(t>maxX)
                        maxX = t;
                } else {
                    if(t<minY)
                        minY = t;
                    if(t>maxY)
                        maxY = t;
                }
            }
        }
        minX--;
        int wid = (maxY+3)*2;
        int src = wid/2;
        for(int i=0; i<paths.length; i++) {
            for(int j=0; j<paths[i].length; j++) {
                if(j%2 == 0) {
                    int t = paths[i][j];
                    t -= 500;
                    t += src;
                    paths[i][j] = t;
                }
            }
        }
        char[][] map = new char[maxY+3][wid];
        for(int i=0; i<maxY+3; i++) {
            for(int j=0; j<wid; j++) {
                if(i == maxY+2) {
                    map[i][j] = '#';
                } else {
                    map[i][j] = '.';
                }
            }
        }
        map[0][src] = '+';
        for(int i=0; i<paths.length; i++) {
            for(int j=0; j+3<paths[i].length; j+=2) {
                int x = paths[i][j], x_ = paths[i][j+2];
                int y = paths[i][j+1], y_ = paths[i][j+3];
                map[y][x] = '#';
                while(x != x_) {
                    if(x < x_) {
                        x++;
                    } else {
                        x--;
                    }
                    map[y][x] = '#';
                }
                while(y != y_) {
                    if(y < y_) {
                        y++;
                    } else {
                        y--;
                    }
                    map[y][x] = '#';
                }
            }
        }
        int count = 0;
        h.print(map);
        // while(checkBot(map)) {
        while(map[0][src] == '+') {
            count++;
            map = sandFall(src,0,map);
        }
        h.print(map);
        scnr.close();
        file.close();
        return count;
    }

    public static boolean checkBot(char[][] map) {
        int i = map.length-2;
        for(int j=0; j<map[i].length; j++) {
            if(map[i][j] == 'o')
                return false;
        }
        return true;
    }

    public static char[][] sandFall(int x, int y, char[][] map) {
        while(y+1 < map.length) {
            if(map[y+1][x] != '.') {
                if(map[y+1][x-1] == '.') {
                    y++;
                    x--;
                } else if(map[y+1][x+1] == '.') {
                    y++;
                    x++;
                } else {
                    break;
                }
            } else {
                y++;
            }
        }
        map[y][x] = 'o';
        return map;
    }
}
