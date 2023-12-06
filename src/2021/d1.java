import java.io.*;
import java.util.*;
public class d1 {
    static BufferedReader br;
    static {
        try {
            br = new BufferedReader(new FileReader("../../in/2021/1.in"));
        } catch (FileNotFoundException e) {}
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        while (br.ready()) list.add(readInt());
        int cnt = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)) cnt++;
        }
        System.out.println(cnt);
        
        //part 2
        cnt = 0;
        for (int i = 3; i < list.size(); i++) {
            if (list.get(i) > list.get(i-3)) cnt++;
        }
        System.out.println(cnt);
    }
    
    static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
