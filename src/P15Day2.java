import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class P15Day2 {
    static Function he = new Function();
    public static void main(String[] args) throws IOException {
        he.print("2015 Day 2: " + day2("../lib/trial.txt"));
    }

    public static int day2(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = "";
        int sum = 0;
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            int l, w, h;
            l = Integer.parseInt(in.substring(0,in.indexOf('x')));
            in = in.substring(in.indexOf('x')+1);
            w = Integer.parseInt(in.substring(0,in.indexOf('x')));
            in = in.substring(in.indexOf('x')+1);
            h = Integer.parseInt(in);
            // int a = l*w, b = w*h, c = l*h;
            int a = l+w, b = w+h, c = l+h;
            int min = a;
            if(b<min) min = b;
            if(c<min) min = c;
            int area = 2*a + 2*b + 2*c + min;
            int vol = l*w*h + 2*min;
            // he.print(area); // 1606483
            // sum += area;
            // he.print(vol); // 3842356
            sum += vol;
        }
        return sum;
    }
}
