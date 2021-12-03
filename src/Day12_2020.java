import java.util.*;
import java.io.*;

public class Day12_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        Pair[] inst = new Pair[773];
        for (int i = 0; i < 773; i++) {
            String tmp = readLine();
            inst[i] = new Pair(tmp.charAt(0), Integer.parseInt(tmp.substring(1)));
        }
        
        int facing = 1;
        int x = 0, y = 0;
        
        for (int i = 0; i < 773; i++) {
            switch (inst[i].inst) {
                case 'R':
                    facing = (facing + inst[i].d / 90) % 4;
                    break;
                case 'L':
                    facing = (facing - inst[i].d / 90) % 4;
                    if (facing < 0) facing += 4;
                    break;
                case 'F':
                    if (facing == 0) y += inst[i].d;
                    else if (facing == 1) x += inst[i].d;
                    else if (facing == 2) y -= inst[i].d;
                    else x -= inst[i].d;
                    break;
                case 'N':
                    y += inst[i].d;
                    break;
                case 'S':
                    y -= inst[i].d;
                    break;
                case 'E':
                    x += inst[i].d;
                    break;
                case 'W':
                    x -= inst[i].d;
                    break;
            }
        }
        
        System.out.println(Math.abs(x) + Math.abs(y));
        
        x = 0;
        y = 0;
        int wX = 10, wY = 1;
        
        for (int i = 0; i < 773; i++) {
            switch (inst[i].inst) {
                case 'R': {
                    int tmp = inst[i].d / 90;
                    if (tmp == 0) break;
                    else if (tmp == 1) {
                        int tm2 = wY;
                        wY = -wX;
                        wX = tm2;
                    } else if (tmp == 2) {
                        wX *= -1;
                        wY *= -1;
                    } else {
                        int tm2 = wY;
                        wY = wX;
                        wX = -tm2;
                    }
                    break;
                }
                case 'L':
                    int tmp = inst[i].d / 90;
                    if (tmp == 0) break;
                    else if (tmp == 3) {
                        int tm2 = wY;
                        wY = -wX;
                        wX = tm2;
                    } else if (tmp == 2) {
                        wX *= -1;
                        wY *= -1;
                    } else {
                        int tm2 = wY;
                        wY = wX;
                        wX = -tm2;
                    }
                    break;
                case 'F':
                    x += inst[i].d * wX;
                    y += inst[i].d * wY;
                    break;
                case 'N':
                    wY += inst[i].d;
                    break;
                case 'S':
                    wY -= inst[i].d;
                    break;
                case 'E':
                    wX += inst[i].d;
                    break;
                case 'W':
                    wX -= inst[i].d;
                    break;
            }
        }
        System.out.println(Math.abs(x) + Math.abs(y));
    }

    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens())
            in = new StringTokenizer(br.readLine());
        return in.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine();
    }
    
    static class Pair {
        int d;
        char inst;
        Pair (char inst, int d) { this.d = d; this.inst = inst; }
    }
}