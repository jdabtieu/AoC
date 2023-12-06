import java.io.*;
import java.util.*;
public class d11 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/11.in"));
        int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
        int[] dy = {-1, 1, -1, 0, 1, -1, 0, 1};
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) grid[i] = readLine().chars().map(e -> e - '0').toArray();
        int ans1 = 0;
        for (int steps = 0;; steps++) {
            boolean[][] flash = new boolean[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    grid[i][j]++;
                }
            }
            boolean done = false;
            while (!done) {
                done = true;
                Queue<pair> q = new LinkedList<>();
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (grid[i][j] > 9 && !flash[i][j]) {
                            flash[i][j] = true;
                            done = false;
                            for (int k = 0; k < 8; k++) {
                                try {
                                    int p = grid[i+dx[k]][j+dy[k]];
                                    q.add(new pair(i+dx[k], j+dy[k]));
                                } catch (Exception e) {}
                            }
                        }
                    }
                }
                for (pair e : q) {
                    grid[e.f][e.s]++;
                }
            }
            int ans2 = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (flash[i][j]) {
                        ans1++;
                        grid[i][j] = 0;
                        ans2++;
                    }
                    
                }
            }
            if (steps == 99) System.out.println(ans1);
            if (ans2 == 100) {
                System.out.println(steps + 1);
                return;
            }
        }
    }
    
    static class pair {
        int f, s;
        public pair(int a, int b) {
            f = a;
            s = b;
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