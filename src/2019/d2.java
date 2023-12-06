import java.util.*;
import java.io.*;

public class d2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        String[] tmp = readLine().split(",");
        int[] num = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) num[i] = Integer.parseInt(tmp[i]);
        int[] original = num.clone();
        
        num[1] =  12;
        num[2] = 2;
        
        int ptr = 0;
        while (ptr < tmp.length) {
            switch(num[ptr]) {
                case 1:
                    num[num[ptr + 3]] = num[num[ptr + 2]] + num[num[ptr + 1]];
                    break;
                case 2:
                    num[num[ptr + 3]] = num[num[ptr + 2]] * num[num[ptr + 1]];
                    break;
                case 99:
                    System.out.println(num[0]);
                    ptr = tmp.length;
            }
            ptr += 4;
        }
        
        for (int i = 1;; i++) {
            for (int j = 0; j <= i; j++) {
                num = original.clone();
                num[1] = i;
                num[2] = j;
                ptr = 0;
                while (ptr < tmp.length) {
                    switch(num[ptr]) {
                        case 1:
                            num[num[ptr + 3]] = num[num[ptr + 2]] + num[num[ptr + 1]];
                            break;
                        case 2:
                            num[num[ptr + 3]] = num[num[ptr + 2]] * num[num[ptr + 1]];
                            break;
                        case 99:
                            if (num[0] == 19690720) {
                                System.out.println(100 * i + j);
                                return;
                            }
                            ptr = tmp.length;
                    }
                    ptr += 4;
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