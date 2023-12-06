import java.io.*;
import java.util.*;
public class d3 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2015/3.in"));
        String s = readLine();
        HashSet<pair> hs = new HashSet<>(), h2 = new HashSet<>();
        int x = 0, y = 0;
        int[] xa = {0, 0};
        int[] ya = {0, 0};
        hs.add(new pair(0, 0));
        h2.add(new pair(0, 0));
        int i = -1;
        for (char c : s.toCharArray()) {
            i = (i + 1) % 2;
            if (c == '^') {
                y--;
                ya[i]--;
            } else if (c == 'v') {
                y++;
                ya[i]++;
            } else if (c == '>') {
                x++;
                xa[i]++;
            } else {
                x--;
                xa[i]--;
            }
            hs.add(new pair(x, y));
            h2.add(new pair(xa[0], ya[0]));
            h2.add(new pair(xa[1], ya[1]));
        }
        System.out.println(hs.size());
        System.out.println(h2.size());
    }
    
    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof pair))
                return false;
            pair other = (pair) obj;
            return x == other.x && y == other.y;
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