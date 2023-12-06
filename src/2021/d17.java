import java.io.*;
import java.util.*;
public class d17 {
    static BufferedReader br;
    static StringTokenizer in;
    
    static int x1, x2, y1, y2;
    // this code might not work for your inputs, but it did for mine
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/17.in"));
        String[] xx = readLine().split(": ")[1].split(", ");
        String[] tmp = xx[0].substring(2).split("\\.\\.");
        x1 = Integer.parseInt(tmp[0]);
        x2 = Integer.parseInt(tmp[1]);
        tmp = xx[1].substring(2).split("\\.\\.");
        y1 = Integer.parseInt(tmp[0]);
        y2 = Integer.parseInt(tmp[1]);
        
        System.out.println(y1 * (y1 + 1) / 2);
        
        int ans2 = 0;
        for (int i = 0; i <= x2; i++) {
            for (int j = y1; j < y1 * (y1 + 1) / 2; j++) {
                ans2 += test(i, j);
            }
        }
        System.out.println(ans2);
    }
    
    static int test(int vx, int vy) {
        int x = 0, y = 0;
        while (y >= y1) {
            x += vx;
            y += vy;
            vx = Math.max(vx - 1, 0);
            vy--;
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                return 1;
            }
        }
        return 0;
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
}