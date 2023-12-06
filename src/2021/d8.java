import java.io.*;
import java.util.*;
public class d8 {
    static BufferedReader br;
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/8.in"));
        int ans = 0, ans2 = 0;
        for (int _c = 0; _c < 200; _c++) {
            String[] inp = readLine().split(" \\| ");
            String[] tok = inp[0].split(" ");
            String[] map = new String[10];
            HashMap<Character, Character> cm = new HashMap<>();
            HashSet<Character> used = new HashSet<>();
            for (String e : tok) {
                if (e.length() == 2) map[1] = e;
                else if (e.length() == 4) map[4] = e;
                else if (e.length() == 3) map[7] = e;
                else if (e.length() == 7) map[8] = e;
            }// missing 0, 2, 3, 4, 5, 9
            for (String e : tok) {
                if (e.length() == 6) {
                    if (e.contains(map[1].substring(0, 1)) && e.contains(map[1].substring(1, 2))) {
                        // 0 or 9
                    } else {
                        map[6] = e;
                    }
                }
            }
            // solve a
            for (int i = 0; i < 3; i++) {
                if (!map[1].contains(map[7].substring(i, i+1))) {
                    cm.put('a', map[7].charAt(i));
                    used.add(map[7].charAt(i));
                }
            }
            // solve c
            for (int i = 0; i < 7; i++) {
                if (!map[6].contains(map[8].substring(i, i+1))) {
                    cm.put('c', map[8].charAt(i));
                    used.add(map[8].charAt(i));
                }
            }
            // solve f
            if (map[1].charAt(0) == cm.get('c')) {
                cm.put('f', map[1].charAt(1));
                used.add(map[1].charAt(1));
            } else {
                cm.put('f', map[1].charAt(0));
                used.add(map[1].charAt(0));
            }
            // solve 2
            for (String e : tok) {
                if (!e.contains(Character.toString(cm.get('f')))) {
                    map[2] = e;
                }
            }
            // solve d, b
            for (char c : map[4].toCharArray()) {
                if (used.contains(c)) continue;
                if (map[2].contains(Character.toString(c))) {
                    cm.put('d', c);
                    used.add(c);
                } else {
                    cm.put('b', c);
                    used.add(c);
                }
            }
            // solve 0,9
            {
                ArrayList<String> s = new ArrayList<>();
                for (String e : tok) {
                    if (e.length() == 6 && e != map[6]) s.add(e);
                }
                if (s.get(0).contains(Character.toString(cm.get('d')))) {
                    // 9
                    map[9] = s.get(0);
                    map[0] = s.get(1);
                } else {
                    map[0] = s.get(0);
                    map[9] = s.get(1);
                }
            }
            // solve e
            for (int i = 0; i < 7; i++) {
                if (!map[9].contains(map[8].substring(i, i+1))) {
                    cm.put('e', map[8].charAt(i));
                    used.add(map[8].charAt(i));
                }
            }
            
            // solve g
            for (char c : map[8].toCharArray()) {
                if (!used.contains(c)) {
                    cm.put('g', c);
                    used.add(c);
                }
            }
            
            String a = ""; 
            for (String e : inp[1].split(" ")) {
                if (e.length() == 7 || e.length() == 3 || e.length() == 4 || e.length() == 2) ans++;
                if (e.length() == 2) a += 1;
                else if (e.length() == 5 && e.contains(Character.toString(cm.get('e')))) a += 2;
                else if (e.length() == 5 && e.contains(Character.toString(cm.get('c')))) a += 3;
                else if (e.length() == 4) a += 4;
                else if (e.length() == 5) a += 5;
                else if (e.length() == 6 && !e.contains(Character.toString(cm.get('c')))) a += 6;
                else if (e.length() == 3) a += 7;
                else if (e.length() == 7) a += 8;
                else if (e.contains(Character.toString(cm.get('d')))) a += 9;
                else a += 0;
            }
            ans2 += Integer.parseInt(a);
        }
        System.out.println(ans);
        System.out.println(ans2);
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