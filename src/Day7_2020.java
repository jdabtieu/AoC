import java.util.*;
import java.io.*;

public class Day7_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static HashMap<String, ArrayList<String>> map = new HashMap();
    static HashMap<String, ArrayList<Pair>> map2 = new HashMap();
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 594; i++) {
            String input = readLine();
            if (input.contains("no other bags")) continue;
            String name = input.substring(0, input.indexOf(" bags"));
            input = input.substring(input.indexOf(" contain") + 9, input.length() - 1);
            String[] stuffs = input.split(", ");
            map2.put(name, new ArrayList<Pair>());
            for (String stuff : stuffs) {
                String tmp = stuff.substring(stuff.indexOf(" ") + 1, stuff.indexOf(" bag"));
                if (!map.containsKey(tmp)) map.put(tmp, new ArrayList<String>());
                map.get(tmp).add(name);
                int quantity = Integer.parseInt(stuff.substring(0, stuff.indexOf(" ")));
                map2.get(name).add(new Pair(tmp, quantity));
            }
        }
        Queue<String> toVisit = new LinkedList();
        toVisit.add("shiny gold");
        ArrayList<String> visited = new ArrayList();
        int count = 0;
        visited.add("shiny gold");
        
        while (!toVisit.isEmpty()) {
            String color = toVisit.poll();
            if (!map.containsKey(color)) continue;
            for (String tmp : map.get(color)) {
                if (visited.contains(tmp)) continue;
                count++;
                visited.add(tmp);
                toVisit.add(tmp);
            }
        }
        System.out.println(count);
        System.out.println(recurse("shiny gold"));
        
    }
    
    static int recurse(String key) {
        if (!map2.containsKey(key)) return 0;
        ArrayList<Pair> tmp = map2.get(key);
        int total = 0;
        for (Pair p : tmp) {
            total += p.a;
            total += recurse(p.color) * p.a;
        }
        return total;
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
    
    static class Pair {
        String color;
        int a;
        public Pair (String color, int a) { this.color = color; this.a = a; }
        public String toString() { return a + " " + color; }
    }
}