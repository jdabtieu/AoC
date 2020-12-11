import java.util.*;
import java.io.*;

public class Day8_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int a = 0;
    static boolean[] visited = new boolean[631];
    
    public static void main(String[] args) throws IOException {
        Pair[] instructions = new Pair[631];
        for (int i = 0; i < 631; i++) instructions[i] = new Pair(next(), readInt());
        
        int pointer = 0;
        while(true) {
            if (visited[pointer]) {
                System.out.println(a);
                break;
            }
            visited[pointer] = true;
            String inst = instructions[pointer].inst;
            int val = instructions[pointer].a;
            switch (inst) {
                case "nop":
                    pointer++;
                    break;
                case "acc":
                    a += val;
                    pointer++;
                    break;
                case "jmp":
                    pointer += val;
                    break;
            }
        }
        
        for (int i = 0; i < 631; i++) {
            if (instructions[i].inst.equals("acc")) continue;
            else if (instructions[i].inst.equals("nop")) instructions[i].inst = "jmp";
            else instructions[i].inst = "nop";
            
            a = 0;
            visited = new boolean[631];
            pointer = 0;
            while(true) {
                if (pointer == 631) {
                    System.out.println(a);
                    return;
                }
                if (visited[pointer]) break;
                visited[pointer] = true;
                String inst = instructions[pointer].inst;
                int val = instructions[pointer].a;
                switch (inst) {
                    case "nop":
                        pointer++;
                        break;
                    case "acc":
                        a += val;
                        pointer++;
                        break;
                    case "jmp":
                        pointer += val;
                        break;
                }
            }
            
            if (instructions[i].inst.equals("nop")) instructions[i].inst = "jmp";
            else instructions[i].inst = "nop";
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
    
    static class Pair {
        String inst;
        int a;
        public Pair (String inst, int a) { this.inst = inst; this.a = a; }
        public String toString() { return inst + " " + a; }
    }
}