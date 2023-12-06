import java.io.*;
import java.util.*;
public class d7 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/7.in"));
        int[] d = Arrays.stream(readLine().split(",")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1000; i++) {
            final int f = i;
            int newAns = Arrays.stream(d).map(e -> Math.abs(f - e)).sum();
            if (newAns < ans) ans = newAns;
            else break;
        }
        System.out.println(ans);
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1000; i++) {
            final int f = i;
            int newAns = Arrays.stream(d).map(e -> {
                int x = Math.abs(f - e);
                return x * (x + 1) / 2;
            }).sum();
            if (newAns < ans) ans = newAns;
            else break;
        }
        System.out.println(ans);
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