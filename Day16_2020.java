import java.util.*;
import java.io.*;

public class Day16_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int i = 0;
        ArrayList<Triple> fields = new ArrayList();
        for (; i < 262; i++) {
            String[] item = readLine().split(":");
            if (item.length == 1) break;
            String[] ranges = item[1].split(" ");
            fields.add(new Triple(item[0], ranges[1].split("-")[0], ranges[1].split("-")[1]));
            fields.add(new Triple(item[0], ranges[3].split("-")[0], ranges[3].split("-")[1]));
        }
        readLine();
        String myTicket = readLine();
        readLine();
        readLine();
        
        int total = 0;
        for (i += 5; i < 262; i++) {
            String[] ticket = readLine().split(",");
            for (String num : ticket) {
                boolean flag = false;
                int n = Integer.parseInt(num);
                for (Triple item : fields) {
                    if (n <= item.end && n >= item.start) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) total += n;
            }
        }
        System.out.println(total);
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
    
    static class Triple {
        String item;
        int start, end;
        Triple (String a, String b, String c) { item = a; start = Integer.parseInt(b); end = Integer.parseInt(c); }
    }
}