import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;
public class d20 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/20.in"));
        String key = readLine();
        ArrayList<Integer>[] ie = new ArrayList[2];
        ie[0] = new ArrayList<>();
        ie[1] = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == '.') {
                ie[0].add(i);
            } else {
                ie[1].add(i ^ 511);
            }
        }
        HashSet<pair> set = new HashSet<>();
        readLine();
        for (int i = 0; i < 100; i++) {
            String l = readLine();
            for (int j = 0; j < 100; j++) {
                if (l.charAt(j) == '#') {
                    set.add(new pair(j, i));
                }
            }
        }
        for (int i = 0; i < 50; i++) {
            int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
            for (pair e : set) {
                x1 = Math.min(x1, e.x);
                x2 = Math.max(x2, e.x);
                y1 = Math.min(y1, e.y);
                y2 = Math.max(y2, e.y);
            }
            HashSet<pair> n = new HashSet<>();
            for (int j = x1 - 1; j < x2 + 2; j++) {
                for (int k = y1 - 1; k < y2 + 2; k++) {
                    int s = 0;
                    for (int l = 0; l < 9; l++) {
                        if (set.contains(new pair(j - 1 + l % 3, k - 1 + l / 3))) {
                            s += 1 << (8 - l);
                        }
                    }
                    if (ie[i % 2].contains(s)) {
                        n.add(new pair(j, k));
                    }
                }
            }
            set = n;
            if (i == 1 || i == 49) System.out.println(set.size());
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