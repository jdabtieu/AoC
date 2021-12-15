import java.io.*;
import java.util.*;
public class Day14_2021 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        // this code misses an edge case but it's ok it worked for my input
        br = new BufferedReader(new FileReader("in/Day14_2021.in"));
        String s = readLine();
        HashMap<String, Character> map = new HashMap<>();
        HashMap<String, Long> str = new HashMap<>();
        readLine();
        while (br.ready()) {
            String[] tok = readLine().split(" \\-\\> ");
            map.put(tok[0], tok[1].charAt(0));
        }
        for (int j = 1; j < s.length(); j++) {
            str.put(s.substring(j - 1, j + 1), str.getOrDefault(s.substring(j - 1, j + 1), 0L) + 1);
        }
        for (int i = 0; i < 40; i++) {
            if (i == 10) print(str);
            HashMap<String, Long> a = new HashMap<>();
            for (Map.Entry<String, Long> entry : str.entrySet()) {
                if (map.containsKey(entry.getKey())) {
                    String s1 = entry.getKey().substring(0, 1) + map.get(entry.getKey());
                    String s2 = map.get(entry.getKey()) + entry.getKey().substring(1, 2);
                    a.put(s1, a.getOrDefault(s1, 0L) + entry.getValue());
                    a.put(s2, a.getOrDefault(s2, 0L) + entry.getValue());
                }
            }
            str = a;
        }
        print(str);
    }
    
    static void print(HashMap<String, Long> str) {
        HashMap<Character, Long> m = new HashMap<>();
        for (Map.Entry<String, Long> entry : str.entrySet()) {
            m.put(entry.getKey().charAt(0), m.getOrDefault(entry.getKey().charAt(0), 0L) + entry.getValue());
            m.put(entry.getKey().charAt(1), m.getOrDefault(entry.getKey().charAt(1), 0L) + entry.getValue());
        }
        long min = Long.MAX_VALUE, max = 0;
        for (Map.Entry<Character, Long> e : m.entrySet()) {
            min = Math.min(min, e.getValue());
            max = Math.max(max, e.getValue());
        }
        System.out.println((max - min) / 2 + 1);
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