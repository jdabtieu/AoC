import java.io.*;
import java.util.*;
public class Day7_2022 {
    static BufferedReader br;
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("in/Day7_2022.in"));
        dir root = new dir(null);
        root.pa = root;
        
        dir cur = null;
        next();
        while (br.ready()) {
            String prog = next();
            if (prog.equals("cd")) {
                String dir = next();
                if (dir.equals("..")) cur = cur.pa;
                else if (dir.equals("/")) cur = root;
                else {
                    if (!cur.dirs.containsKey(dir)) {
                        cur.dirs.put(dir, new dir(cur));
                    }
                    cur = cur.dirs.get(dir);
                }
                next();
            } else {
                while (true) {
                    if (!br.ready()) break;
                    String t = next();
                    if (t.equals("$")) break;
                    String u = next();
                    if (t.charAt(0) == 'd') {
                        if (!cur.dirs.containsKey(u)) {
                            cur.dirs.put(u, new dir(cur));
                        }
                    } else {
                        file f = new file(u, Integer.parseInt(t));
                        cur.files.add(f);
                    }
                }
            }
        }
        rsz = 30000000 - (70000000 - dfs(root));
        dfs2(root);
        System.out.println(ans1);
        System.out.println(ans2);
    }
    
    static long ans1 = 0;
    static long rsz = 0;
    static long ans2 = 2147483647;

    static long dfs(dir cur) {
        long sz = 0;
        sz += cur.files.stream().mapToInt(e -> e.sz).sum();
        for (Map.Entry<String, dir> dir : cur.dirs.entrySet()) {
            sz += dfs(dir.getValue());
        }
        if (sz <= 100000) ans1 += sz;
        return sz;
    }
    
    static long dfs2(dir cur) {
        long sz = 0;
        sz += cur.files.stream().mapToInt(e -> e.sz).sum();
        for (Map.Entry<String, dir> dir : cur.dirs.entrySet()) {
            sz += dfs2(dir.getValue());
        }
        if (sz >= rsz) ans2 = Math.min(ans2, sz);
        return sz;
    }
    
    static class dir {
        ArrayList<file> files;
        HashMap<String, dir> dirs;
        dir pa;
        public dir(dir pa) {
            files = new ArrayList<>();
            dirs = new HashMap<>();
            this.pa = pa;
        }
    }
    
    static class file {
        String name;
        int sz;
        public file(String name, int sz) {
            this.name = name;
            this.sz = sz;
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
