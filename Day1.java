import java.util.*;
import java.io.*;
public class Day1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    public static void main(String[] args) throws IOException {
        int total = 0, total2 = 0;
        for (int i = 0; i < 100; i++) {
            int tmp = readInt();
            total += tmp / 3;
            tmp = tmp / 3 - 2;
            while (tmp > 0) {
                total2 += tmp;
                tmp = tmp / 3 - 2;
            }
        }
        System.out.println(total - 200);
        System.out.println(total2);
        
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