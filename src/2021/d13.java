import java.io.*;
import java.util.*;
public class d13 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/13.in"));
        HashSet<pair> s = new HashSet<>();
        for (int i = 0; i < 820; i++) {
            String[] t = readLine().split(",");
            s.add(new pair(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
        }
        readLine();
        for (int i = 0; i < 12; i++) {
            HashSet<pair> n = new HashSet<>();
            String f = readLine();
            int p = Integer.parseInt(f.split("=")[1]);
            if (f.contains("x")) {
                for (pair e : s) {
                    if (e.x > p) e.x(p);
                    n.add(e);
                }
            } else {
                for (pair e : s) {
                    if (e.y > p) e.y(p);
                    n.add(e);
                }
            }
            s = n;
            if (i == 0) System.out.println(s.size());
        }
        char[][] g = new char[10][100];
        for (pair e : s) {
            g[e.y][e.x] = 'X'; 
        }
        for (char[] a : g) {
            System.out.println(a);
        }
    }
    
    static class pair {
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public void x(int d) {
            x = d - x + d;
        }
        
        public void y(int d) {
            y = d - y + d;
        }

        int x, y;

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof pair)) {
                return false;
            }
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