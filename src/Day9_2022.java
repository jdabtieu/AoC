import java.io.*;
import java.util.*;
public class Day9_2022 {
    static BufferedReader br;
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day9_2022.in"));
        HashSet<pii>[] s = new HashSet[11];
        for (int i = 1; i <= 10; i++) s[i] = new HashSet<pii>();
        for (int i = 1; i <= 10; i++) s[i].add(new pii(0, 0));
        int hx = 0, hy = 0;
        int[] tx = new int[11];
        int[] ty = new int[11];
        while (br.ready()) {
            char dir = readChar();
            int amt = readInt();
            int dx = 0, dy = 0;
            switch(dir) {
            case 'L':
                dx--;
                break;
            case 'R':
                dx++;
                break;
            case 'U':
                dy++;
                break;
            default:
                dy--;
            }
            for (int i = 0; i < amt; i++) {
                hx += dx;
                hy += dy;
                tx[0] = hx;
                ty[0] = hy;
                for (int j = 1; j <= 10; j++) {
                    if (Math.abs(tx[j] - tx[j-1]) <= 1 && Math.abs(ty[j] - ty[j-1]) <= 1) continue;
                    if (tx[j] != tx[j-1]) {
                        tx[j] += (tx[j-1] - tx[j]) / Math.abs(tx[j-1] - tx[j]);
                    }
                    if (ty[j] != ty[j-1]) {
                        ty[j] += (ty[j-1] - ty[j]) / Math.abs(ty[j-1] - ty[j]);
                    }
                    s[j].add(new pii(tx[j], ty[j]));
                }
                    
            }
        }
        System.out.println(s[1].size());
        System.out.println(s[9].size());
    }
    
    static class pii {
        int x, y;

        public pii(int x, int y) {
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
            if (!(obj instanceof Day9_2022.pii))
                return false;
            pii other = (pii) obj;
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
