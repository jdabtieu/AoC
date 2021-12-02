import java.io.*;
import java.util.*;
public class Day2_2021 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("Day2_2021.in"));
        int h = 0, d = 0;
        int h2 = 0, d2 = 0, aim = 0;
        while (br.ready()) {
            String s = next();
            int x = readInt();
            switch(s) {
                case "forward":
                    h += x;
                    h2 += x;
                    d2 += aim * x;
                    break;
                case "down":
                    d += x;
                    aim += x;
                    break;
                case "up":
                    d -= x;
                    aim -= x;
                    break;
            }
        }
        System.out.println(h * d);
        System.out.println(h2 * d2);
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