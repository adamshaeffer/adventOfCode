import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day7 {
    static Function h = new Function();
    public static void main(String[] args) throws IOException {
        h.print("Day 7: " + day7("lib/input.txt"));
    }
    
    public static int day7(String fileIn) throws IOException {
        int sum = 0;
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        String in = scnr.nextLine();
        File tempF;
        Dir source = new Dir("/",null);
        Dir tempD = source;
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            if(in.charAt(0) == '$') {
                String cmd = in.substring(in.indexOf(' ')+1);
                if(cmd.equals("ls")) {
                } else {
                    String target = cmd.substring(cmd.indexOf(' ')+1);
                    if(target.equals("/")) {
                        tempD = source;
                    } else if(target.equals("..")) {
                        tempD = tempD.getParent();
                    } else {
                        tempD = tempD.getDir(target);
                    }
                }
            } else if(in.charAt(0) == 'd') {
                String name = in.substring(in.indexOf(' ')+1);
                tempD.addDir(new Dir(name, tempD));
            } else if(49 <= in.charAt(0) && in.charAt(0) <= 57) {
                int size = Integer.parseInt(in.substring(0,in.indexOf(' ')));
                String name = in.substring(in.indexOf(' ')+1);
                tempF = new File(name, size);
                tempD.addFile(tempF);
            }
        }
        // source.print();
        // h.print(source.totalSize());
        int mkSpace = 30000000-(70000000-source.totalSize());
        sum = source.smallAtLeast(mkSpace);
        scnr.close();
        file.close();
        return sum;
    }
}
