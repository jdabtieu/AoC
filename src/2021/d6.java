import java.io.*;
import java.util.*;

public class d6 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/6.in"));
        HashMap<Integer, Long> m = new HashMap<>();
        for (int i = 0; i < 9; i++) m.put(i, 0L);
        final HashMap<Integer, Long> tmp = m;
        Arrays.stream(readLine().split(","))
              .mapToInt(e -> Integer.parseInt(e))
              .forEach(e -> tmp.put(e, tmp.get(e) + 1));
        for (int days = 1; days <= 80; days++) {
            HashMap<Integer, Long> today = new HashMap<>();
            for (int i = 0; i < 8; i++) {
                today.put(i, m.get(i + 1));
            }
            long zcnt = m.get(0);
            today.put(8, zcnt);
            today.put(6, today.get(6) + zcnt);
            m = today;
        }
        long sum = 0;
        for (long e : m.values()) {
            sum += e;
        }
        System.out.println(sum);
        for (int days = 81; days <= 256; days++) {
            HashMap<Integer, Long> today = new HashMap<>();
            for (int i = 0; i < 8; i++) {
                today.put(i, m.get(i + 1));
            }
            long zcnt = m.get(0);
            today.put(8, zcnt);
            today.put(6, today.get(6) + zcnt);
            m = today;
        }
        sum = 0;
        for (long e : m.values()) {
            sum += e;
        }
        System.out.println(sum);
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