import java.io.*;
import java.util.*;
public class Day9_2021 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day9_2021.in"));
        int[][] g = new int[100][100];
        ArrayList<Integer> p = new ArrayList<>(), sz = new ArrayList<>();
        for (int i = 0; i < 100; i++) g[i] = readLine().chars().map(e -> e - '0').toArray();
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                boolean good = true;
                if (i != 0 && g[i-1][j] <= g[i][j]) good = false;
                if (i != 99 && g[i+1][j] <= g[i][j]) good = false;
                if (j != 0 && g[i][j-1] <= g[i][j]) good = false;
                if (j != 99 && g[i][j+1] <= g[i][j]) good = false;
                if (good) {
                    ans += 1 + g[i][j];
                    p.add(100 * i + j);
                }
            }
        }
        boolean[][] vis = new boolean[100][100];
        for (int pos : p) {
            Queue<Integer> q = new LinkedList<>();
            q.add(pos);
            vis[pos/100][pos%100] = true;
            int size = 0;
            while (!q.isEmpty()) {
                int i = q.peek() / 100;
                int j = q.poll() % 100;
                size++;
                if (i != 0 && !vis[i-1][j] && g[i-1][j] != 9) {
                    vis[i-1][j] = true;
                    q.add(100 * (i - 1) + j);
                }
                if (i != 99 && !vis[i+1][j] && g[i+1][j] != 9) {
                    vis[i+1][j] = true;
                    q.add(100 * (i + 1) + j);
                }
                if (j != 0 && !vis[i][j-1] && g[i][j-1] != 9) {
                    vis[i][j-1] = true;
                    q.add(100 * i + j - 1);
                }
                if (j != 99 && !vis[i][j+1] && g[i][j+1] != 9) {
                    vis[i][j+1] = true;
                    q.add(100 * i + j + 1);
                }
            }
            sz.add(size);
        }
        System.out.println(ans);
        Collections.sort(sz, Collections.reverseOrder());
        System.out.println(sz.get(0) * sz.get(1) * sz.get(2));
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