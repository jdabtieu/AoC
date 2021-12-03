import java.io.*;
import java.util.*;
public class Day1_2016 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day1_2016.in"));
        int x = 0, y = 0, idx = 0;
        int[] mx = {1, 0, -1, 0};
        int[] my = {0, 1, 0, -1};
        String[] inst = readLine().split(", ");
        Set<Coord> s = new HashSet<Coord>();
        int ans2 = 0;
        for (String e : inst) {
            if (e.charAt(0) == 'R') idx = (idx + 1) % 4;
            else idx = (idx + 3) % 4;
            int p = Integer.parseInt(e.substring(1));
            while (p-- > 0) {
                x += mx[idx];
                y += my[idx];
                Coord curr = new Coord(x, y);
                if (s.contains(curr) && ans2 == 0) {
                    ans2 = Math.abs(x) + Math.abs(y);
                }
                s.add(curr);
            }
        }
        System.out.println(Math.abs(x) + Math.abs(y));
        System.out.println(ans2);
    }
    
    static class Coord {
        int x, y;

        public Coord(int x, int y) {
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
            if (!(obj instanceof Coord))
                return false;
            Coord other = (Coord) obj;
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