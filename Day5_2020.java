import java.util.*;
import java.io.*;

public class Day5_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 945; i++) {
            String pass = readLine();
            int row = Integer.parseInt(pass.substring(0, 7).replace('B', '1').replace('F', '0'), 2);
            int col = Integer.parseInt(pass.substring(7).replace('R', '1').replace('L', '0'), 2);
            
            list.add(row * 8 + col);
        }
        System.out.println(Collections.max(list));
        for (int i = 1; i < Collections.max(list); i++) {
            if (list.contains(i - 1) && !list.contains(i) && list.contains(i + 1)) {
                System.out.println(i);
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