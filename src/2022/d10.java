import java.io.*;
import java.util.*;
public class d10 {
    static BufferedReader br;
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2022/10.in"));
        int ans1 = 0, i = 1, x = 1;
        char[][] grid = new char[6][40];
        for (int j = 0; j < 6; j++) Arrays.fill(grid[j], ' ');
        while (br.ready()) {
            if (x >= (i-1+40)%40-1 && x <= (i-1+40)%40+1) {
                grid[(i-1)/40][(i-1+40)%40] = '#';
            }
            if (i < 230 && i % 40 == 20) {
                ans1 += x * i;
            }
            String inst = next();
            if (inst.equals("noop")) {
                i++;
                continue;
            } else {
                int amt = readInt();
                i++;
                if (x >= (i-1+40)%40-1 && x <= (i-1+40)%40+1) {
                    grid[(i-1)/40][(i-1+40)%40] = '#';
                }
                if (i < 230 && i % 40 == 20) {
                    ans1 += x * i;
                }
                i++;
                x += amt;
            }
        }
        System.out.println(ans1);
        for (int j = 0; j < 6; j++) System.out.println(grid[j]);
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
