import java.util.*;
import java.io.*;

public class d9 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> nums = new ArrayList();
        ArrayList<Long> psa = new ArrayList();
        long target = -1;
        nums.add(readInt());
        psa.add((long) nums.get(0));
        for (int i = 1; i < 25; i++) {
            nums.add(readInt());
            psa.add(psa.get(i - 1) + nums.get(i));
        }
        boolean flag = false;
        for (int i = 25; i < 1000; i++) {
            int num = readInt();
            for (int j = 0; j < 25; j++) {
                if (nums.contains(num - nums.get(j))) {
                    break;
                }
                if (j == 24) {
                    target = num;
                    flag = true;
                }
            }
            if (flag) break;
            nums.add(num);
            nums.remove(0);
            psa.add(psa.get(i - 1) + nums.get(24));
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < psa.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (psa.get(i) - psa.get(j) == target) {
                    for (int k = j + 1; k <= i; k++) {
                        if (psa.get(k) - psa.get(k - 1) < min) min = (int) (psa.get(k) - psa.get(k - 1));
                        if (psa.get(k) - psa.get(k - 1) > max) max = (int) (psa.get(k) - psa.get(k - 1));
                    }
                }
            }
        }
        System.out.println(target);
        System.out.println(min + max);
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