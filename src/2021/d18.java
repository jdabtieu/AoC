import java.io.*;
import java.util.*;
public class d18 {
    static BufferedReader br;
    static StringTokenizer in;

    static boolean flag = true;
    static SFNum root = null;
    static String[] inputs = new String[100];
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("../../in/2021/18.in"));
        {
            SFNum r = new SFNum(null);
            inputs[0] = readLine();
            parse(inputs[0], r);
            root = r.nested[0];
            root.pa = null;
        }
        for (int i = 1; i < inputs.length; i++) {
            SFNum tmp = root;
            root = new SFNum(null);
            root.nested[0] = tmp;
            tmp.pa = root;
            
            SFNum r = new SFNum(null);
            inputs[i] = readLine();
            parse(inputs[i], r);
            root.nested[1] = r.nested[0];
            r.nested[0].pa = root;
            flag = true;
            while (flag) {
                flag = false;
                enumerate(root, 1);
                if (flag) continue;
                split(root);
            }
        }
        System.out.println(root.mag());
        long max = -1;
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (x == y) continue;
                root = null;
                {
                    SFNum r = new SFNum(null);
                    parse(inputs[x], r);
                    root = r.nested[0];
                    root.pa = null;
                }
                {
                    SFNum tmp = root;
                    root = new SFNum(null);
                    root.nested[0] = tmp;
                    tmp.pa = root;
                    
                    SFNum r = new SFNum(null);
                    parse(inputs[y], r);
                    root.nested[1] = r.nested[0];
                    r.nested[0].pa = root;
                    flag = true;
                    while (flag) {
                        flag = false;
                        enumerate(root, 1);
                        if (flag) continue;
                        split(root);
                    }
                }
                max = Math.max(max, root.mag());
            }
        }
        System.out.println(max);
    }
    
    static void parse(String inp, SFNum root) {
        {
            SFNum curr = root;
            int idx = 0;
            Stack<SFNum> stk = new Stack<>();
            Stack<Integer> indexes = new Stack<>();
            String tmp = "";
            for (int i = 0; i < inp.length(); i++) {
                if (inp.charAt(i) == '[') {
                    curr.nested[idx] = new SFNum(curr);
                    stk.push(curr);
                    indexes.push(idx);
                    curr = curr.nested[idx];
                    idx = 0;
                } else if (inp.charAt(i) == ']') {
                    if (tmp != "") {
                        curr.literal[idx] = Integer.parseInt(tmp);
                        tmp = "";
                    }
                    curr = stk.pop();
                    idx = indexes.pop();
                } else if (inp.charAt(i) == ',') {
                    if (tmp != "") {
                        curr.literal[idx] = Integer.parseInt(tmp);
                        tmp = "";
                    }
                    idx++;
                } else {
                    tmp += inp.substring(i, i+1);
                }
            }
        }
    }
    
    static boolean split(SFNum curr) {
        if (curr.nested[0] == null && curr.literal[0] >= 10) {
            curr.nested[0] = new SFNum(curr);
            curr.nested[0].literal[0] = curr.literal[0] / 2;
            curr.nested[0].literal[1] = curr.literal[0] - curr.nested[0].literal[0];
            curr.literal[0] = 0;
            flag = true;
            return false;
        } else if (curr.nested[0] != null) {
            if (!split(curr.nested[0])) {
                return false;
            }
        }
        if (curr.nested[1] == null && curr.literal[1] >= 10) {
            curr.nested[1] = new SFNum(curr);
            curr.nested[1].literal[0] = curr.literal[1] / 2;
            curr.nested[1].literal[1] = curr.literal[1] - curr.nested[1].literal[0];
            curr.literal[1] = 0;
            flag = true;
            return false;
        } else if (curr.nested[1] != null) {
            if (!split(curr.nested[1])) {
                return false;
            }
        }
        return true;
    }
    
    static boolean enumerate(SFNum curr, int level) {
        if (level == 5) {
            explode(curr);
            flag = true;
            return false;
        }
        if (curr.nested[0] != null) {
            if (!enumerate(curr.nested[0], level + 1)) {
                return false;
            }
        }
        if (curr.nested[1] != null) {
            if (!enumerate(curr.nested[1], level + 1)) {
                return false;
            }
        }
        return true;
    }
    
    static void explode(SFNum s) {
        SFNum og = s;
        SFNum pa = s.pa;
        if (pa.nested[0] == s) {
            pa.nested[0] = null;
            s = pa;
            while (s.pa != null) {
                if (s == s.pa.nested[0]) {
                    s = s.pa;
                } else {
                    break;
                }
            }
            if (s.pa != null) {
                s = s.pa;
                if (s.nested[0] == null) {
                    s.literal[0] += og.literal[0];
                } else {
                    s = s.nested[0];
                    while (s.nested[1] != null) {
                        s = s.nested[1];
                    }
                    s.literal[1] += og.literal[0];
                }
            }
        } else if (pa.nested[0] == null) {
            pa.literal[0] += og.literal[0];
        } else {
            s = pa.nested[0];
            while (s.nested[1] != null) {
                s = s.nested[1];
            }
            s.literal[1] += og.literal[0];
        }
        
        if (pa.nested[1] == s) {
            pa.nested[1] = null;
            s = pa;
            while (s.pa != null) {
                if (s == s.pa.nested[1]) {
                    s = s.pa;
                } else {
                    break;
                }
            }
            if (s.pa != null) {
                s = s.pa;
                if (s.nested[1] == null) {
                    s.literal[1] += og.literal[1];
                } else {
                    s = s.nested[1];
                    while (s.nested[0] != null) {
                        s = s.nested[0];
                    }
                    s.literal[0] += og.literal[1];
                }
            }
        } else if (pa.nested[1] == null) {
            pa.literal[1] += og.literal[1];
        } else {
            s = pa.nested[1];
            while (s.nested[0] != null) {
                s = s.nested[0];
            }
            s.literal[0] += og.literal[1];
        }
    }
    
    static class SFNum {
        SFNum[] nested;
        int[] literal;
        SFNum pa;
        public SFNum(SFNum pa) {
            nested = new SFNum[2];
            literal = new int[2];
            this.pa = pa;
        }
        public String toString() {
            return "[" + (nested[0] == null ? literal[0] : nested[0]) + "," + (nested[1] == null ? literal[1] : nested[1]) + "]";
        }
        
        public long mag() {
            long res = 0;
            if (nested[0] != null) res += 3 * nested[0].mag();
            else res += 3 * literal[0];
            if (nested[1] != null) res += 2 * nested[1].mag();
            else res += 2 * literal[1];
            return res;
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