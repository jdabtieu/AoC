import java.util.*;
import java.io.*;

public class d4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int valid = 0, valid2 = 0;
        int criteria = 0, criteria2 = 0;
        for (int i = 0; i < 1000; i++) {
            String in = readLine();
            if (in.equals("")) {
                if (criteria == 127) valid++;
                if (criteria2 == 127) valid2++;
                criteria = 0;
                criteria2 = 0;
            }
            if (in.contains("byr:")) {
                criteria += 64;
                String tmp = in.substring(in.indexOf("byr:")).split(":")[1].split(" ")[0];
                if (tmp.length() == 4 && Integer.parseInt(tmp) >= 1920 && Integer.parseInt(tmp) <= 2002) criteria2 += 64;
            }
            if (in.contains("iyr:")) {
                criteria += 32;
                String tmp = in.substring(in.indexOf("iyr:")).split(":")[1].split(" ")[0];
                if (tmp.length() == 4 && Integer.parseInt(tmp) >= 2010 && Integer.parseInt(tmp) <= 2020) criteria2 += 32;
            }
            if (in.contains("eyr:")) {
                criteria += 16;
                String tmp = in.substring(in.indexOf("eyr:")).split(":")[1].split(" ")[0];
                if (tmp.length() == 4 && Integer.parseInt(tmp) >= 2020 && Integer.parseInt(tmp) <= 2030) criteria2 += 16;
            }
            if (in.contains("hgt:")) {
                criteria += 8;
                String tmp = in.substring(in.indexOf("hgt:")).split(":")[1].split(" ")[0];
                if (tmp.contains("cm") && Integer.parseInt(tmp.substring(0, tmp.indexOf("cm"))) >= 150 && Integer.parseInt(tmp.substring(0, tmp.indexOf("cm"))) <= 193) {
                    criteria2 += 8;
                } else if (tmp.contains("in") && Integer.parseInt(tmp.substring(0, tmp.indexOf("in"))) >= 59 && Integer.parseInt(tmp.substring(0, tmp.indexOf("in"))) <= 76) {
                    criteria2 += 8;
                }
            }
            if (in.contains("hcl:")) {
                criteria += 4;
                String tmp = in.substring(in.indexOf("hcl:")).split(":")[1].split(" ")[0];
                if (tmp.length() == 7 && tmp.charAt(0) == '#') {
                    for (int j = 1; j < 7; j++) {
                        if (!(tmp.charAt(j) <= '9' && tmp.charAt(j) >= '0' || tmp.charAt(j) <= 'f' && tmp.charAt(j) >= 'a')) break;
                        if (j == 6) criteria2 += 4;
                    }
                }
            }
            if (in.contains("ecl:")) {
                criteria += 2;
                String tmp = in.substring(in.indexOf("ecl:")).split(":")[1].split(" ")[0];
                List<String> c = Arrays.asList(new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"});
                if(c.contains(tmp)) criteria2 += 2;
            }
            if (in.contains("pid:")) {
                criteria += 1;
                String tmp = in.substring(in.indexOf("pid:")).split(":")[1].split(" ")[0];
                if (tmp.length() == 9) {
                    for (int j = 0; j < 9; j++) {
                        if (!(tmp.charAt(j) <= '9' && tmp.charAt(j) >= '0')) break;
                        if (j == 8) criteria2 += 1;
                    }
                }
            }
        }
        if (criteria == 127) valid++;
        if (criteria2 == 127) valid2++;
        System.out.println(valid);
        System.out.println(valid2);
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