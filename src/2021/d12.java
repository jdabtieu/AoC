import java.io.*;
import java.util.*;
public class d12 {
    static BufferedReader br;
    static StringTokenizer in;
    
    static HashMap<String, ArrayList<String>> adj = new HashMap<>();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/12.in"));
        for (int i = 0; i < 22; i++) {
            String[] tok = readLine().split("-");
            ArrayList<String> x = adj.getOrDefault(tok[0], new ArrayList<>());
            x.add(tok[1]);
            adj.put(tok[0], x);
            x = adj.getOrDefault(tok[1], new ArrayList<>());
            x.add(tok[0]);
            adj.put(tok[1], x);
        }
        System.out.println(dfs("start", new HashSet<String>()));
        System.out.println(dfs2("start", new HashSet<String>(), null));
    }
    
    static int dfs(String curr, HashSet<String> vis) {
        int ans = 0;
        for (String e : adj.get(curr)) {
            if (e.equals("start")) continue;
            if (e.equals("end")) {
                ans++;
                continue;
            }
            if (e.equals(e.toLowerCase()) && !vis.contains(e)) {
                vis.add(e);
                ans += dfs(e, vis);
                vis.remove(e);
            } else if (!e.equals(e.toLowerCase())){
                ans += dfs(e, vis);
            }
        }
        return ans;
    }
    
    static int dfs2(String curr, HashSet<String> vis, String v2) {
        int ans = 0;
        for (String e : adj.get(curr)) {
            if (e.equals("start")) continue;
            if (e.equals("end")) {
                ans++;
                continue;
            }
            if (e.equals(e.toLowerCase()) && !vis.contains(e)) {
                vis.add(e);
                ans += dfs2(e, vis, v2);
                vis.remove(e);
            } else if (e.equals(e.toLowerCase()) && v2 == null) {
                ans += dfs2(e, vis, e);
            } else if (!e.equals(e.toLowerCase())){
                ans += dfs2(e, vis, v2);
            }
        }
        return ans;
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