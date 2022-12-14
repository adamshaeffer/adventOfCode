import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day12 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 12: " + day12("lib/input.txt"));
    }

    public static int day12(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        char[][] map = new char[0][0];
        String in = "";
        while(scnr.hasNextLine()) {
            char[] temp = new char[0];
            in = scnr.nextLine();
            for(int i=0; i<in.length(); i++) {
                temp = h.add(temp,in.charAt(i));
            }
            map = h.add(map,temp);
        }
        int[] curr = new int[2];
        int[] end = new int[2];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] == 'S') {
                    curr[0] = i;
                    curr[1] = j;
                    map[i][j] = 'a';
                }
                if(map[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                    map[i][j] = 'z';
                }
            }
        }
        scnr.close();
        file.close();
        int ret = move(curr[1], curr[0],end,map);
        // h.print(map);
        return ret;
    }

    public static int move(int x, int y, int[] e, char[][] mapO) {
        if(x == e[1] && y == e[0]) {
            // h.print(mapO);
            return 0;
        }
        char[][] map = new char[mapO.length][mapO[0].length];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                map[i][j] = mapO[i][j];
            }
        }
        char curr = map[y][x];
        map[y][x] = '.';
        int lat = map.length-1, log = map[0].length-1;
        int min = 5000;
        int temp = min;
        if(x < log) {
            x++;
            if(map[y][x] <= curr+1 && map[y][x] != '.') {
                temp = move(x,y,e,map);
                if(temp < min) {
                    min = temp;
                }
            }
            x--;
        }
        if(y > 0) {
            y--;
            if(map[y][x] <= curr+1 && map[y][x] != '.') {
                temp = move(x,y,e,map);
                if(temp < min) {
                    min = temp;
                }
            }
            y++;
        }
        if(y < lat) {
            y++;
            if(map[y][x] <= curr+1 && map[y][x] != '.') {
                temp = move(x,y,e,map);
                if(temp < min) {
                    min = temp;
                }
            }
            y--;
        }
        if(x > 116) {
            x--;
            if(map[y][x] <= curr+1 && map[y][x] != '.') {
                temp = move(x,y,e,map);
                if(temp < min) {
                    min = temp;
                }
            }
            x++;
        }
        return min+1;
    }
}
