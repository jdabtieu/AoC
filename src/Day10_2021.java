import java.io.*;
import java.util.*;
public class Day10_2021 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day10_2021.in"));
        int[] scores = new int[4];
        ArrayList<Long> ascores = new ArrayList<>();
        for (int _ = 0; _ < 90; _++) {
            Stack<Character> stk = new Stack<>();
            boolean corrupted = false;
            for (char c : readLine().toCharArray()) {
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    stk.push(c);
                    continue;
                }
                char p = stk.pop();
                if (p != '(' && c == ')') {
                    scores[0] += 3;
                    corrupted = true;
                    break;
                }
                else if (p != '[' && c == ']') {
                    scores[1] += 57;
                    corrupted = true;
                    break;
                }
                else if (p != '{' && c == '}') {
                    scores[2] += 1197;
                    corrupted = true;
                    break;
                }
                else if (p != '<' && c == '>') {
                    scores[3] += 25137;
                    corrupted = true;
                    break;
                }
            }
            if (corrupted) continue;
            long ans = 0;
            while (!stk.isEmpty()) {
                ans *= 5;
                if (stk.peek() == '(') ans += 1;
                else if (stk.peek() == '[') ans += 2;
                else if (stk.peek() == '{') ans += 3;
                else ans += 4;
                stk.pop();
            }
            ascores.add(ans);
        }
        System.out.println(Arrays.stream(scores).reduce(Integer::sum).getAsInt());
        Collections.sort(ascores);
        System.out.println(ascores.get(ascores.size() / 2));
        
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