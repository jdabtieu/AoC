import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;
public class d4 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        br = new BufferedReader(new FileReader("../../in/2015/4.in"));
        String s = readLine();
        int i = 1;
        for (;; i++) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((s + i).getBytes());
            String hsh = DatatypeConverter.printHexBinary(md.digest());
            if (hsh.startsWith("00000")) {
                System.out.println(i);
                break;
            }
        }
        for (;; i++) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((s + i).getBytes());
            String hsh = DatatypeConverter.printHexBinary(md.digest());
            if (hsh.startsWith("000000")) {
                System.out.println(i);
                break;
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