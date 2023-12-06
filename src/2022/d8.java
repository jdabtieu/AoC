import java.io.*;
import java.util.*;
public class d8 {
    static BufferedReader br;
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2022/8.in"));
        char[][] g = new char[99][];
        boolean[][] ok = new boolean[99][99];
        for (int i = 0; i < 99; i++) g[i] = readLine().toCharArray();
        // ltr
        for (int i = 0; i < 99; i++) {
            char lo = 0;
            for (int j = 0; j < 99; j++) {
                if (g[i][j] > lo) {
                    lo = g[i][j];
                    ok[i][j] = true;
                }
            }
        }
        // rtl
        for (int i = 0; i < 99; i++) {
            char lo = 0;
            for (int j = 98; j >= 0; j--) {
                if (g[i][j] > lo) {
                    lo = g[i][j];
                    ok[i][j] = true;
                }
            }
        }
        // utd
        for (int i = 0; i < 99; i++) {
            char lo = 0;
            for (int j = 0; j < 99; j++) {
                if (g[j][i] > lo) {
                    lo = g[j][i];
                    ok[j][i] = true;
                }
            }
        }
        // dtu
        for (int i = 0; i < 99; i++) {
            char lo = 0;
            for (int j = 98; j >= 0; j--) {
                if (g[j][i] > lo) {
                    lo = g[j][i];
                    ok[j][i] = true;
                }
            }
        }
        int ans1 = 0;
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) ans1 += ok[i][j] ? 1 : 0;
        }
        System.out.println(ans1);
        
        long hiscore = 0;
        for (int a = 0; a < 99; a++) for (int b = 0; b < 99; b++) {
            long ans = 1;
            long cnt = 0;
            // ltr
            for (int j = b+1; j < 99; j++) {
                cnt++;
                if (g[a][j] >= g[a][b]) break;
            }
            ans *= cnt;
            cnt = 0;
            // rtl
            for (int j = b-1; j >= 0; j--) {
                cnt++;
                if (g[a][j] >= g[a][b]) break;
            }
            ans *= cnt;
            cnt = 0;
            // utd
            for (int j = a+1; j < 99; j++) {
                cnt++;
                if (g[j][b] >= g[a][b]) break;
            }
            ans *= cnt;
            cnt = 0;
            // dtu
            for (int j = a-1; j >= 0; j--) {
                cnt++;
                if (g[j][b] >= g[a][b]) break;
            }
            ans *= cnt;
            hiscore = Math.max(hiscore, ans);
        }
        System.out.println(hiscore);
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
