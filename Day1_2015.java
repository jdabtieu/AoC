import java.util.*;
import java.io.*;

public class Day1_2015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        String input = readLine();
        int floor = 0, firstbasement = -1;
        for (int i = 0; i < input.length(); i++) {
            floor += input.charAt(i) == '(' ? 1 : -1;
            if (floor < 0 && firstbasement == -1) firstbasement = i + 1;
        }
        System.out.println(floor);
        System.out.println(firstbasement);
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