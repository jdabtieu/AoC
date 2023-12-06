import java.io.*;
import java.util.*;

public class d14 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static long[] mem = new long[100000];
    static Map<Long, Long> mem2 = new HashMap();
    static long maskAND = 0, maskOR = 0;
    static ArrayList<Mask> masks = new ArrayList();
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 571; i++) {
           String inst = next();
           next();
           if (inst.equals("mask")) {
               maskAND = 0;
               maskOR = 0;
               masks = new ArrayList();
               masks.add(new Mask(0, 0));
               String mask = next();
               for (int j = 0; j < 36; j++) {
                   switch(mask.charAt(j)) {
                       case '1':
                           maskAND++;
                           maskOR++;
                           for (Mask MASK : masks) {
                               MASK.and++;
                               MASK.or++;
                           }
                           break;
                       case '0':
                           for (Mask MASK : masks) MASK.and++;
                           break;
                       case 'X':
                           ArrayList<Mask> tmp = new ArrayList();
                           for (Mask MASK : masks) {
                               tmp.add(MASK);
                               tmp.add(new Mask(MASK.and + 1, MASK.or + 1));
                           }
                           masks = tmp;
                           maskAND++;
                           break;
                   }
                   maskAND <<= 1;
                   maskOR <<= 1;
                   for (Mask MASK : masks) {
                       MASK.and <<= 1;
                       MASK.or <<= 1;
                   }
               }
               maskAND >>= 1;
               maskOR >>= 1;
               for (Mask MASK : masks) {
                   MASK.and >>= 1;
                   MASK.or >>= 1;
               }
               continue;
           }
           int ptr = Integer.parseInt(inst.substring(4, inst.length() - 1));
           long val = readLong();
           
           mem[ptr] = val & maskAND | maskOR;
           for (Mask mask : masks) {
               long addr = ptr & mask.and | mask.or;
               if (mem2.containsKey(addr)) mem2.replace(addr, val);
               else mem2.put(addr, val);
           }
        }
        long sum = 0;
        for (long l : mem) sum += l;
        System.out.println(sum);
        sum = 0;
        for (Map.Entry<Long, Long> entry : mem2.entrySet()) sum += entry.getValue();
        System.out.println(sum);
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
    
    static class Mask {
        long and, or;
        Mask(long and, long or) { this.and = and; this.or = or; }
    }
}