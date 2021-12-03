import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Day3_2021 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day3_2021.in"));
        ArrayList<String> i1 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            i1.add(readLine());
        }
        int[] cnt = generate(i1);
        int a = 0;
        for (int i = 0; i < 12; i++) {
            a <<= 1;
            a += cnt[i] >= 500 ? 1 : 0;
        }
        int b = a ^ ((1 << 12) - 1);
        System.out.println(a * b);
        
        ArrayList<Integer> l = (ArrayList<Integer>) (i1.stream().mapToInt(e -> Integer.parseInt(e, 2)).boxed().collect(Collectors.toList()));
        System.out.println(solve((List<Integer>) l.clone(), 0) * solve((List<Integer>) l.clone(), 1));
    }
    
    static int solve(List<Integer> io, int flip) {
        for (int i = 11; i >= 0; i--) {
            Collections.sort(io);
            int bit = io.get(io.size()/2) >> i ^ flip;
            final int f = i;
            io = io.stream().filter(e -> ((e >> f) ^ bit) == 0).collect(Collectors.toList());
            if (io.size() < 2) {
                return io.get(0);
            }
        }
        return 0;
    }
    
    static int[] generate(ArrayList<String> inputs) {
        int[] cnt = new int[12];
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < 12; j++) {
                if (inputs.get(i).charAt(j) == '1') cnt[j]++;
            }
        }
        return cnt;
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