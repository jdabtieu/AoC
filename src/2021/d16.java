import java.io.*;
import java.util.*;
public class d16 {
    static BufferedReader br;
    static StringTokenizer in;
    static String input = "";
    static int i = 0;
    static int ans1 = 0;
    
    static void convert(String s) {
        for (int i = 0; i < s.length(); i++) {
            int x = Integer.parseInt(s.substring(i, i + 1), 16);
            input += ((x & 8) >> 3) + "" + ((x & 4) >> 2) + "" + ((x & 2) >> 1) + "" + (x & 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/16.in"));
        convert(br.readLine());
        long ans2 = parse();
        System.out.println(ans1);
        System.out.println(ans2);
    }
    
    static long parse() {
        int version = Integer.parseInt(input.substring(i, i + 3), 2);
        int type = Integer.parseInt(input.substring(i + 3, i + 6), 2);
        i += 6;
        ans1 += version;
        if (type == 4) {
            long res = 0;
            while (input.charAt(i) != '0') {
                i++;
                res <<= 4;
                res += Long.parseLong(input.substring(i, i + 4), 2);
                i += 4;
            }
            i++;
            res <<= 4;
            res += Long.parseLong(input.substring(i, i + 4), 2);
            i += 4;
            return res;
        } else { // operator packet
            ArrayList<Long> results = new ArrayList<>();
            if (input.charAt(i++) == '0') { // next 15 bits = length
                int len = Integer.parseInt(input.substring(i, i + 15), 2);
                i += 15;
                len += i;
                while (i < len) {
                    results.add(parse());
                }
            } else { // next 11 bits = # of subpackets
                int len = Integer.parseInt(input.substring(i, i + 11), 2);
                i += 11;
                for (int i = 0; i < len; i++) {
                    results.add(parse());
                }
            }
            return op(results, type);
        }
    }
    
    static long op(ArrayList<Long> results, int type) {
        if (type == 0) {
            return results.stream().mapToLong(e -> e).sum();
        } else if (type == 1) {
            long res = 1;
            for (long e : results) res *= e;
            return res;
        } else if (type == 2) {
            return results.stream().mapToLong(e -> e).reduce(Long::min).getAsLong();
        } else if (type == 3) {
            return results.stream().mapToLong(e -> e).reduce(Long::max).getAsLong();
        } else if (type == 5) {
            return results.get(0) > results.get(1) ? 1 : 0;
        } else if (type == 6) {
            return results.get(0) < results.get(1) ? 1 : 0;
        } else {
            return results.get(0) == results.get(1) ? 1 : 0;
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