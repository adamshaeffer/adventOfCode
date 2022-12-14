import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Day9 {
    static Function help = new Function();
    public static void main(String[] args) throws IOException {
        help.print("Day 9: " + day9("lib/input.txt"));
    }

    public static int day9(String fileIn) throws IOException {
        FileInputStream file = new FileInputStream(fileIn);
        Scanner scnr = new Scanner(file);
        int count = 0;
        int step = 0;
        int[] t1 = new int[2];
        int[] t2 = new int[2];
        int[] t3 = new int[2];
        int[] t4 = new int[2];
        int[] t5 = new int[2];
        int[] t6 = new int[2];
        int[] t7 = new int[2];
        int[] t8 = new int[2];
        int[] t = new int[2];
        int[] h = new int[2];
        int[][] tpos = new int[0][2];
        char dir = ' ';
        String in = "";
        while(scnr.hasNextLine()) {
            in = scnr.nextLine();
            dir = in.charAt(0);
            step = Integer.parseInt(in.substring(in.indexOf(' ')+1));
            for(int i=0; i<step; i++) {
                if(dir == 'R')
                    h[0]++;
                else if(dir == 'L')
                    h[0]--;
                else if(dir == 'U')
                    h[1]--;
                else if(dir == 'D')
                    h[1]++;
                
                int[] dif1 = {h[0]-t1[0], h[1]-t1[1]};
                if(dif1[0] > 1) {
                    t1[0]++;
                    if(dif1[1] > 0) {
                        t1[1]++;
                    } else if(dif1[1] < 0) {
                        t1[1]--; }
                } else if(dif1[0] < -1) {
                    t1[0]--;
                    if(dif1[1] > 0) {
                        t1[1]++;
                    } else if(dif1[1] < 0) {
                        t1[1]--; }
                } else if(dif1[1] > 1) {
                    t1[1]++;
                    if(dif1[0] > 0) {
                        t1[0]++;
                    } else if(dif1[0] < 0) {
                        t1[0]--; }
                } else if(dif1[1] < -1) {
                    t1[1]--;
                    if(dif1[0] > 0) {
                        t1[0]++;
                    } else if(dif1[0] < 0) {
                        t1[0]--; }}
                int[] dif2 = {t1[0]-t2[0], t1[1]-t2[1]};
                if(dif2[0] > 1) {
                    t2[0]++;
                    if(dif2[1] > 0) {
                        t2[1]++;
                    } else if(dif2[1] < 0) {
                        t2[1]--; }
                } else if(dif2[0] < -1) {
                    t2[0]--;
                    if(dif2[1] > 0) {
                        t2[1]++;
                    } else if(dif2[1] < 0) {
                        t2[1]--; }
                } else if(dif2[1] > 1) {
                    t2[1]++;
                    if(dif2[0] > 0) {
                        t2[0]++;
                    } else if(dif2[0] < 0) {
                        t2[0]--; }
                } else if(dif2[1] < -1) {
                    t2[1]--;
                    if(dif2[0] > 0) {
                        t2[0]++;
                    } else if(dif2[0] < 0) {
                        t2[0]--; }}
                int[] dif3 = {t2[0]-t3[0], t2[1]-t3[1]};
                if(dif3[0] > 1) {
                    t3[0]++;
                    if(dif3[1] > 0) {
                        t3[1]++;
                    } else if(dif3[1] < 0) {
                        t3[1]--; }
                } else if(dif3[0] < -1) {
                    t3[0]--;
                    if(dif3[1] > 0) {
                        t3[1]++;
                    } else if(dif3[1] < 0) {
                        t3[1]--; }
                } else if(dif3[1] > 1) {
                    t3[1]++;
                    if(dif3[0] > 0) {
                        t3[0]++;
                    } else if(dif3[0] < 0) {
                        t3[0]--; }
                } else if(dif3[1] < -1) {
                    t3[1]--;
                    if(dif3[0] > 0) {
                        t3[0]++;
                    } else if(dif3[0] < 0) {
                        t3[0]--; }}
                int[] dif4 = {t3[0]-t4[0], t3[1]-t4[1]};
                if(dif4[0] > 1) {
                    t4[0]++;
                    if(dif4[1] > 0) {
                        t4[1]++;
                    } else if(dif4[1] < 0) {
                        t4[1]--; }
                } else if(dif4[0] < -1) {
                    t4[0]--;
                    if(dif4[1] > 0) {
                        t4[1]++;
                    } else if(dif4[1] < 0) {
                        t4[1]--; }
                } else if(dif4[1] > 1) {
                    t4[1]++;
                    if(dif4[0] > 0) {
                        t4[0]++;
                    } else if(dif4[0] < 0) {
                        t4[0]--; }
                } else if(dif4[1] < -1) {
                    t4[1]--;
                    if(dif4[0] > 0) {
                        t4[0]++;
                    } else if(dif4[0] < 0) {
                        t4[0]--; }}
                int[] dif5 = {t4[0]-t5[0], t4[1]-t5[1]};
                if(dif5[0] > 1) {
                    t5[0]++;
                    if(dif5[1] > 0) {
                        t5[1]++;
                    } else if(dif5[1] < 0) {
                        t5[1]--; }
                } else if(dif5[0] < -1) {
                    t5[0]--;
                    if(dif5[1] > 0) {
                        t5[1]++;
                    } else if(dif5[1] < 0) {
                        t5[1]--; }
                } else if(dif5[1] > 1) {
                    t5[1]++;
                    if(dif5[0] > 0) {
                        t5[0]++;
                    } else if(dif5[0] < 0) {
                        t5[0]--; }
                } else if(dif5[1] < -1) {
                    t5[1]--;
                    if(dif5[0] > 0) {
                        t5[0]++;
                    } else if(dif5[0] < 0) {
                        t5[0]--; }}
                int[] dif6 = {t5[0]-t6[0], t5[1]-t6[1]};
                if(dif6[0] > 1) {
                    t6[0]++;
                    if(dif6[1] > 0) {
                        t6[1]++;
                    } else if(dif6[1] < 0) {
                        t6[1]--; }
                } else if(dif6[0] < -1) {
                    t6[0]--;
                    if(dif6[1] > 0) {
                        t6[1]++;
                    } else if(dif6[1] < 0) {
                        t6[1]--; }
                } else if(dif6[1] > 1) {
                    t6[1]++;
                    if(dif6[0] > 0) {
                        t6[0]++;
                    } else if(dif6[0] < 0) {
                        t6[0]--; }
                } else if(dif6[1] < -1) {
                    t6[1]--;
                    if(dif6[0] > 0) {
                        t6[0]++;
                    } else if(dif6[0] < 0) {
                        t6[0]--; }}
                int[] dif7 = {t6[0]-t7[0], t6[1]-t7[1]};
                if(dif7[0] > 1) {
                    t7[0]++;
                    if(dif7[1] > 0) {
                        t7[1]++;
                    } else if(dif7[1] < 0) {
                        t7[1]--; }
                } else if(dif7[0] < -1) {
                    t7[0]--;
                    if(dif7[1] > 0) {
                        t7[1]++;
                    } else if(dif7[1] < 0) {
                        t7[1]--; }
                } else if(dif7[1] > 1) {
                    t7[1]++;
                    if(dif7[0] > 0) {
                        t7[0]++;
                    } else if(dif7[0] < 0) {
                        t7[0]--; }
                } else if(dif7[1] < -1) {
                    t7[1]--;
                    if(dif7[0] > 0) {
                        t7[0]++;
                    } else if(dif7[0] < 0) {
                        t7[0]--; }}
                int[] dif8 = {t7[0]-t8[0], t7[1]-t8[1]};
                if(dif8[0] > 1) {
                    t8[0]++;
                    if(dif8[1] > 0) {
                        t8[1]++;
                    } else if(dif8[1] < 0) {
                        t8[1]--; }
                } else if(dif8[0] < -1) {
                    t8[0]--;
                    if(dif8[1] > 0) {
                        t8[1]++;
                    } else if(dif8[1] < 0) {
                        t8[1]--; }
                } else if(dif8[1] > 1) {
                    t8[1]++;
                    if(dif8[0] > 0) {
                        t8[0]++;
                    } else if(dif8[0] < 0) {
                        t8[0]--; }
                } else if(dif8[1] < -1) {
                    t8[1]--;
                    if(dif8[0] > 0) {
                        t8[0]++;
                    } else if(dif8[0] < 0) {
                        t8[0]--; }}
                int[] dif9 = {t8[0]-t[0], t8[1]-t[1]};
                if(dif9[0] > 1) {
                    t[0]++;
                    if(dif9[1] > 0) {
                        t[1]++;
                    } else if(dif9[1] < 0) {
                        t[1]--; }
                } else if(dif9[0] < -1) {
                    t[0]--;
                    if(dif9[1] > 0) {
                        t[1]++;
                    } else if(dif9[1] < 0) {
                        t[1]--; }
                } else if(dif9[1] > 1) {
                    t[1]++;
                    if(dif9[0] > 0) {
                        t[0]++;
                    } else if(dif9[0] < 0) {
                        t[0]--; }
                } else if(dif9[1] < -1) {
                    t[1]--;
                    if(dif9[0] > 0) {
                        t[0]++;
                    } else if(dif9[0] < 0) {
                        t[0]--; }}
                tpos = help.add(tpos, t);
                count++;
            }
        }
        for(int i=0; i<tpos.length; i++) {
            for(int j=i+1; j<tpos.length; j++) {
                if(tpos[i][0] == tpos[j][0] && tpos[i][1] == tpos[j][1]) {
                    count--;
                    tpos = help.remove(tpos,j);
                    j--;
                }
            }
        }
        scnr.close();
        file.close();
        return count;
    }
}
