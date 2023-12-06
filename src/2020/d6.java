import java.util.*;
import java.io.*;

public class d6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        HashSet<Character> set = new HashSet();
        int[] c2 = new int[26];
        int c2c = 0;
        int count = 0, count2 = 0;
        for (int i = 0; i < 2262; i++) {
            String input = readLine();
            if (input.equals("")) {
                count += set.size();
                for (int j : c2) if (j == c2c) count2++;
                set = new HashSet();
                c2c = 0;
                c2 = new int[26];
                continue;
            }
            c2c++;
            for (int j = 0; j < input.length(); j++) {
                set.add(input.charAt(j));
                c2[input.charAt(j) - 'a']++;
            }
        }
        count += set.size();
        for (int j : c2) if (j == c2c) count2++;
        System.out.println(count);
        System.out.println(count2);
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