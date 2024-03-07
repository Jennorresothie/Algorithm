import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int ret=0, n, time=0;
        List<int[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        for (int i=0; i<n; i++) {
            String[] num = br.readLine().split(" ");
            list.add(new int[]{stoi(num[0]), stoi(num[1])});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {return o1[0]-o2[0];};
        });
        for(int[] i: list){
            if(time<i[0]) time = i[0]+i[1];
            else time += i[1];
        }
        System.out.println(time);
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}