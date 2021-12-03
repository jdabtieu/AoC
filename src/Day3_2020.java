import java.util.*;
import java.io.*;

public class Day3_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static ArrayList<String> lines = new ArrayList();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 323; i++) lines.add(readLine());
        
        System.out.println(f(3, 1));
        System.out.println(f(3, 1) * f(1, 1) * f(5, 1) * f(7, 1) * f(1, 2));
    }
    
    static long f(int r, int d) {
        int x = r;
        long count = 0;
        for (int i = d; i < 323; i += d, x = (x + r) % 31) {
            if (lines.get(i).charAt(x) == '#') count++;
        }
        return count;
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