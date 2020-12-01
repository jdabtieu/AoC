import java.util.*;
import java.io.*;

public class Day1_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    final static int INPUT_SIZE = 200;

    public static void main(String[] args) throws IOException {
        HashSet<Integer> hashSet = new HashSet<>();
        
        int[] p2 = new int[200];
        
        for(int i = 0; i < INPUT_SIZE; i++) {
            p2[i] = readInt();
            if(hashSet.contains(2020 - p2[i])) {
                System.out.println(p2[i] * (2020 - p2[i]));
                break;
            }
            hashSet.add(p2[i]);
        }
        
        for (int i = 0; i < INPUT_SIZE; i++) {
            for (int j = i + 1; j < INPUT_SIZE; j++) {
                if (p2[i] + p2[j] >= 2020) continue;
                for (int k = j + 1; k < INPUT_SIZE; k++) {
                    if (p2[i] + p2[j] + p2[k] == 2020) {
                        System.out.println(p2[i] * p2[j] * p2[k]);
                        return;
                    }
                }
            }
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