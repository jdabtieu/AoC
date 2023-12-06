import java.util.*;
import java.io.*;

public class d2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int valid = 0, valid2 = 0;
        for (int i = 0; i < 1000; i++) {
            String[] tmp = next().split("-");
            int min = Integer.parseInt(tmp[0]), max = Integer.parseInt(tmp[1]);
            byte letter = (byte) readChar();
            byte[] str = next().getBytes();
            int count = 0;
            for (byte j : str) if (j == letter) count++;
            
            if (count <= max && count >= min) valid++;
            if (str[min - 1] == letter ^ str[max - 1] == letter) valid2++;
        }
        System.out.println(valid);
        System.out.println(valid2);
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