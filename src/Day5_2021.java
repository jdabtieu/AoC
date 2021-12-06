import java.io.*;
import java.util.*;
public class Day5_2021 {
    static BufferedReader br;
    static StringTokenizer in;
    static int[][][] boards = new int[100][5][5];
    static boolean[][][] hit = new boolean[100][5][5];
    static Set<Integer> winners = new HashSet<>();
    static int lastWin = -1;
    static int lastScore = -1;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day5_2021.in"));
        int[][] grid = new int[1000][1000];
        int[][] grid2 = new int[1000][1000];
        for (int i = 0; i < 500; i++) {
            String[] s = readLine().split(" \\-> ");
            int x1 = Integer.parseInt(s[0].split(",")[0]);
            int y1 = Integer.parseInt(s[0].split(",")[1]);
            int x2 = Integer.parseInt(s[1].split(",")[0]);
            int y2 = Integer.parseInt(s[1].split(",")[1]);
            if (x1 == x2) {
                if (y2 < y1) {
                    y2 ^= y1;
                    y1 ^= y2;
                    y2 ^= y1;
                }
                for (; y1 <= y2; y1++) {
                    grid[x1][y1]++;
                    grid2[x1][y1]++;
                }
            } else if (y1 == y2) {
                if (x2 < x1) {
                    x2 ^= x1;
                    x1 ^= x2;
                    x2 ^= x1;
                }
                for (; x1 <= x2; x1++) {
                    grid[x1][y1]++;
                    grid2[x1][y1]++;
                }
            } else {
                int mx = x2 > x1 ? 1 : -1;
                int my = y2 > y1 ? 1 : -1;
                for (; x1 != x2; x1 += mx, y1 += my) {
                    grid2[x1][y1]++;
                }
                grid2[x1][y1]++;
            }
        }
        System.out.println(Arrays.stream(grid).mapToLong(a -> Arrays.stream(a).filter(e -> e > 1).count()).sum());
        System.out.println(Arrays.stream(grid2).mapToLong(a -> Arrays.stream(a).filter(e -> e > 1).count()).sum());
    }
    
    static void modify(int x) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (boards[i][j][k] == x) {
                        hit[i][j][k] = true;
                    }
                }
            }
        }
    }
    
    static int win() {
        int ret = -1;
        for (int i = 0; i < 100; i++) {
            if (winners.contains(i)) continue;
            for (int j = 0; j < 5; j++) {
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (hit[i][j][k]) {
                        cnt++;
                    }
                }
                if (cnt == 5) {
                    lastWin = i;
                    winners.add(i);
                    ret = i;
                    break;
                }
                cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (hit[i][k][j]) {
                        cnt++;
                    }
                }
                if (cnt == 5) {
                    lastWin = i;
                    winners.add(i);
                    ret = i;
                    break;
                }
            }
        }
        return ret;
    }
    
    static int lose() {
        int s = 0;
        int loser = -1;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (hit[i][j][k]) {
                        cnt++;
                    }
                }
                if (cnt == 5) {
                    s++;
                    break;
                }
                cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (hit[i][k][j]) {
                        cnt++;
                    }
                }
                if (cnt == 5) {
                    s++;
                    break;
                }
                if (j == 4) {
                    loser = i;
                }
            }
        }
        return s == 999 ? loser : -1;
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