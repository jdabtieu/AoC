import java.util.*;
import java.io.*;

public class Day11_2020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        byte[][] seats = new byte[99][96];
        for (int i = 0; i < 99; i++) {
            String line = readLine();
            for (int j = 0; j < 96; j++) seats[i][j] = (byte) (line.charAt(j) == '.' ? -1 : 0);
        }
        byte[][] part2 = seats.clone(); 
        while (true) {
            int seatsMoved = 0;
            byte[][] newSeats = new byte[99][96];
            for (int i = 0; i < 99; i++) newSeats[i] = seats[i].clone();
            for (int i = 0; i < 99; i++) {
                for (int j = 0; j < 96; j++) {
                    if (part2[i][j] == -1) continue;
                    int occupancy = 0;
                    if (i > 0 && j > 0)   occupancy += seats[i - 1][j - 1] == 1 ? 1 : 0;
                    if (j > 0)            occupancy += seats[i][j - 1] == 1 ? 1 : 0;
                    if (i < 98 && j > 0)  occupancy += seats[i + 1][j - 1] == 1 ? 1 : 0;
                    if (i < 98)           occupancy += seats[i + 1][j] == 1 ? 1 : 0;
                    if (i < 98 && j < 95) occupancy += seats[i + 1][j + 1] == 1 ? 1 : 0;
                    if (j < 95)           occupancy += seats[i][j + 1] == 1 ? 1 : 0;
                    if (i > 0 && j < 95)  occupancy += seats[i - 1][j + 1] == 1 ? 1 : 0;
                    if (i > 0)            occupancy += seats[i - 1][j] == 1 ? 1 : 0;
                    
                    if (seats[i][j] == 0 && occupancy == 0) {
                        newSeats[i][j] = 1;
                        seatsMoved++;
                    } else if (seats[i][j] == 1 && occupancy >= 4) {
                        newSeats[i][j] = 0;
                        seatsMoved++;
                    }
                }
            }
            seats = newSeats;
            if (seatsMoved == 0) break;
        }
        int occupied = 0;
        for (int i = 0; i < 99; i++) for (int j = 0; j < 96; j++) if (seats[i][j] == 1) occupied++;
        System.out.println(occupied);
        
        while (true) {
            int seatsMoved = 0;
            byte[][] newSeats = new byte[99][96];
            for (int i = 0; i < 99; i++) newSeats[i] = part2[i].clone();
            for (int i = 0; i < 99; i++) {
                for (int j = 0; j < 96; j++) {
                    if (part2[i][j] == -1) continue;
                    int occupancy = 0;
                    occupancy += find(part2, i, j, -1, -1);
                    occupancy += find(part2, i, j, -1,  0);
                    occupancy += find(part2, i, j, -1,  1);
                    occupancy += find(part2, i, j,  0, -1);
                    occupancy += find(part2, i, j,  0,  1);
                    occupancy += find(part2, i, j,  1, -1);
                    occupancy += find(part2, i, j,  1,  0);
                    occupancy += find(part2, i, j,  1,  1);
                    
                    if (part2[i][j] == 0 && occupancy == 0) {
                        newSeats[i][j] = 1;
                        seatsMoved++;
                    } else if (part2[i][j] == 1 && occupancy >= 5) {
                        newSeats[i][j] = 0;
                        seatsMoved++;
                    }
                }
            }
            part2 = newSeats;
            if (seatsMoved == 0) break;
        }
        
        occupied = 0;
        for (int i = 0; i < 99; i++) for (int j = 0; j < 96; j++) if (part2[i][j] == 1) occupied++;
        System.out.println(occupied);
    }
    
    static int find(byte[][] seats, int i, int j, int h, int v) {
        int occupancy = 0;
        for (int p = 1;; p++) {
            try {
                if (seats[h == 1 ? i + p : (h == 0 ? i : i - p)][v == 1 ? j + p : (v == 0 ? j : j - p)] == -1) continue;
                occupancy += seats[h == 1 ? i + p : (h == 0 ? i : i - p)][v == 1 ? j + p : (v == 0 ? j : j - p)] == 1 ? 1 : 0;
            } catch (IndexOutOfBoundsException e) {}
            return occupancy;
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