import java.io.*;
import java.util.*;
public class Day15_2021 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day15_2021.in"));
        boolean[][] vis = new boolean[100][100];
        int[][] g = new int[100][100];
        for (int i = 0; i < 100; i++) {
            g[i] = readLine().chars().map(e -> e - '0').toArray();
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0, 0));
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            if (vis[p.x][p.y]) continue;
            vis[p.x][p.y] = true; 
            if (p.x == 99 && p.y == 99) {
                System.out.println(p.risk);
                break;
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            for (int i = 0; i < 4; i++) {
                try {
                    if (vis[p.x+dx[i]][p.y+dy[i]]) continue;
                    pq.add(new pair(p.x+dx[i], p.y+dy[i], p.risk + g[p.x+dx[i]][p.y+dy[i]]));
                } catch (Exception e) {}
            }
        }
        p2(g);
    }
    
    static void p2(int[][] g0) {
        boolean[][] vis = new boolean[500][500];
        int[][] g = new int[500][500];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100; k++) {
                    for (int l = 0; l < 100; l++) {
                        g[i*100+k][j*100+l] = g0[k][l]+i+j;
                        while (g[i*100+k][j*100+l] > 9) g[i*100+k][j*100+l] -= 9;
                    }
                }
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0, 0));
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            if (vis[p.x][p.y]) continue;
            vis[p.x][p.y] = true; 
            if (p.x == 499 && p.y == 499) {
                System.out.println(p.risk);
                break;
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            for (int i = 0; i < 4; i++) {
                try {
                    if (vis[p.x+dx[i]][p.y+dy[i]]) continue;
                    pq.add(new pair(p.x+dx[i], p.y+dy[i], p.risk + g[p.x+dx[i]][p.y+dy[i]]));
                } catch (ArrayIndexOutOfBoundsException e) {}
            }
        }          
    }
    
    static class pair implements Comparable<pair> {
        int x, y, risk;

        public pair(int x, int y, int risk) {
            this.x = x;
            this.y = y;
            this.risk = risk;
        }

        @Override
        public int compareTo(pair o) {
            if (risk != o.risk) return Integer.compare(risk, o.risk);
            if (x != o.risk) return Integer.compare(x, o.x);
            return Integer.compare(y, o.y);
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