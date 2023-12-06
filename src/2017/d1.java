import java.io.*;
import java.util.*;
public class d1 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2017/1.in"));
        String s = br.readLine(), s2 = s;
        s += s.substring(0, 1);
        int ans = 0, ans2 = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                ans += s.charAt(i) - '0';
            }
        }
        System.out.println(ans);
        for (int i = 0; i < s2.length() / 2; i++) {
            if (s2.charAt(i) == s2.charAt(i + s2.length() / 2)) {
                ans2 += s2.charAt(i) - '0';
            }
        }
        System.out.println(ans2 * 2);
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