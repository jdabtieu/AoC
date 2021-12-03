import java.util.*;
import java.io.*;

public class Day15_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int[] start = new int[6];
        {
            String[] n = readLine().split(",");
            for (int i = 0; i < 6; i++) start[i] = Integer.parseInt(n[i]);
        }
        
        Map<Integer, Integer> secondLastIndex = new TreeMap();
        Map<Integer, Integer> lastIndex = new TreeMap();
        
        int index = 1, prev = start[5];
        for (int i = 0; i < 6; i++) {
            lastIndex.put(start[i], index++);
        }
        
        for (; index < 2021; index++) {
            if (!secondLastIndex.containsKey(prev)) {
                prev = 0;
                if (lastIndex.containsKey(0)) secondLastIndex.put(0, lastIndex.get(0));
                lastIndex.put(0, index);
            } else {
                prev = lastIndex.get(prev) - secondLastIndex.get(prev);
                if (lastIndex.containsKey(prev)) secondLastIndex.put(prev, lastIndex.get(prev));
                lastIndex.put(prev, index);
            }
        }
        System.out.println(prev);
        
        for (; index < 30000001; index++) {
            if (!secondLastIndex.containsKey(prev)) {
                prev = 0;
                if (lastIndex.containsKey(0)) secondLastIndex.put(0, lastIndex.get(0));
                lastIndex.put(0, index);
            } else {
                prev = lastIndex.get(prev) - secondLastIndex.get(prev);
                if (lastIndex.containsKey(prev)) secondLastIndex.put(prev, lastIndex.get(prev));
                lastIndex.put(prev, index);
            }
        }
        System.out.println(prev);
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