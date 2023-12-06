import java.util.*;
import java.io.*;

public class d13 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> ids = new ArrayList();
        int arrival = readInt();
        {
            String[] tmp = readLine().split(",");
            for (String e : tmp) {
                if (e.equals("x")) continue;
                ids.add(Integer.parseInt(e));
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        int sid = -1;
        for (int id : ids) {
            if (id - arrival % id < shortest) {
                shortest = id - arrival % id;
                sid = id;
            }
        }
        System.out.println(sid * shortest);
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