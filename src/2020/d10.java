import java.util.*;
import java.io.*;

public class d10 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> adapters = new ArrayList();
        int one = 0, three = 1, current = 0;
        long ways = 1;
        for (int i = 0; i < 103; i++) adapters.add(readInt());
        Collections.sort(adapters);
        for (int i = 0; i < 103; i++) {
            int a = adapters.get(i);
            if (a - current == 1) one++;
            else if (a - current == 3) three++;
            current = a;
        }
        System.out.println(one * three);
        
        long[] dp = new long[104];
        dp[0] = 1;
        adapters.add(0, 0);
        for (int i = 1; i < 104; i++) {
            current = adapters.get(i);
            if (adapters.contains(current - 1)) dp[i] += dp[i - 1];
            if (adapters.contains(current - 2)) dp[i] += dp[i] == 0 ? dp[i - 1] : dp[i - 2];
            if (adapters.contains(current - 3)) dp[i] += dp[i] == 0 ? dp[i - 1] : 
                                                         dp[i] == dp[i - 1] ? dp[i - 2] : dp[i - 3];
            
        }
        System.out.println(dp[103]);
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