import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day8 {
    static Function r = new Function();
    public static void main(String[] args) throws IOException {
        r.print("Day 8: " + day8("lib/input.txt"));
    }

    public static int day8(String fileIn) throws IOException {
        int count = 0;
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
        int[][] forest = new int[0][0];
        int w = 0; int h = 0;
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            w = in.length();
            h++;
            int[] row = new int[w];
            for(int i=0; i<w; i++) {
                row[i] = Character.getNumericValue(in.charAt(i));
            }
            int[][] temp = new int[h][w];
            for(int i=0; i<h-1; i++) {
                temp[i] = forest[i];
            }
            temp[h-1] = row;
            forest = temp;
        }
        // int t;
        // boolean vn, vs, vw, ve;
        // for(int i=0; i<h; i++) {
        //     for(int j=0; j<w; j++) {
        //         vn = true; vs = true; vw = true; ve = true;
        //         t = forest[i][j];
        //         for(int k=0; k<i && vn; k++) {
        //             if(forest[k][j] >= t)
        //                 vn = false;
        //         }
        //         if(vn) { count++; continue; }
        //         for(int k=0; k<j && vw; k++) {
        //             if(forest[i][k] >= t)
        //                 vw = false;
        //         }
        //         if(vw) { count++; continue; }
        //         for(int k=h-1; k>i && vs; k--) {
        //             if(forest[k][j] >= t)
        //                 vs = false;
        //         }
        //         if(vs) { count++; continue; }
        //         for(int k=w-1; k>j && ve; k--) {
        //             if(forest[i][k] >= t)
        //                 ve = false;
        //         }
        //         if(ve) { count++; continue; }
        //     }
        // }
        int t, vn=0, ve=0, vs=0, vw=0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                vn=0; ve=0; vs=0; vw=0;
                t = forest[i][j];
                for(int k=i-1; k>=0; k--) {
                    vn++;
                    if(forest[k][j] >= t)
                        break;
                }
                for(int k=i+1; k<h; k++) {
                    vs++;
                    if(forest[k][j] >= t)
                        break;
                }
                for(int k=j-1; k>=0; k--) {
                    vw++;
                    if(forest[i][k] >= t)
                        break;
                }
                for(int k=j+1; k<w; k++) {
                    ve++;
                    if(forest[i][k] >= t)
                        break;
                }
                if(count < vn*ve*vs*vw)
                    count = vn*ve*vs*vw;
            }
        }
        scnr.close();
        file.close();
        return count;
    }
}