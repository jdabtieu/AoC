import java.io.*;
import java.util.*;
public class d2 {
    static BufferedReader br;
    static StringTokenizer in;
    static int[][][] boards = new int[100][5][5];
    static boolean[][][] hit = new boolean[100][5][5];
    static Set<Integer> winners = new HashSet<>();
    static int lastWin = -1;
    static int lastScore = -1;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2015/2.in"));
        int ans = 0;
        int ans2 = 0;
        for (int i = 0; i < 1000; i++) {
            int[] dim = Arrays.stream(readLine().split("x")).mapToInt(e -> Integer.parseInt(e)).toArray();
            Arrays.sort(dim);
            ans += 2 * (dim[0]*dim[1] + dim[1]*dim[2] + dim[0]*dim[2]);
            ans += dim[0]*dim[1];
            ans2 += 2*(dim[0]+dim[1]);
            ans2 += dim[0] * dim[1] * dim[2];
        }
        System.out.println(ans);
        System.out.println(ans2);
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