import java.io.*;
import java.util.*;
public class Day1_2018 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day1_2018.in"));
        int s = 0;
        int[] inputs = new int[1025];
        for (int i = 0; i < 1025; i++) {
            inputs[i] = readInt();
            s += inputs[i];
        }
        System.out.println(s);
        Set<Integer> set = new HashSet<>();
        s = 0;
        while (true) {
            for (int e : inputs) {
                s += e;
                if (set.contains(s)) {
                    System.out.println(s);
                    return;
                }
                set.add(s);
            }
        }
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