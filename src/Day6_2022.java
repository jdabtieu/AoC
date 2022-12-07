import java.io.*;
import java.util.*;
public class Day6_2022 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../in/Day6_2022.in"));
        String s = readLine();
        for (int i = 4; i < s.length(); i++) {
            if (s.substring(i - 4, i).chars().distinct().count() == 4) {
                System.out.println(i);
                break;
            }
        }
        for (int i = 14; i < s.length(); i++) {
            if (s.substring(i - 14, i).chars().distinct().count() == 14) {
                System.out.println(i);
                break;
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