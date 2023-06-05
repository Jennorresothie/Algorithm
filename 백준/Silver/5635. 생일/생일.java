import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt(str);

        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(!o1[3].equals(o2[3])){
                    int a = Integer.parseInt(o1[3]);
                    int b = Integer.parseInt(o2[3]);
                    return b-a;
                }
                if(!o1[2].equals(o2[2])){
                    int a = Integer.parseInt(o1[2]);
                    int b = Integer.parseInt(o2[2]);
                    return b-a;
                }
                if(!o1[1].equals(o2[1])){
                    int a = Integer.parseInt(o1[1]);
                    int b = Integer.parseInt(o2[1]);
                    return b-a;
                }


                return 0;
            }
        });

        for(int i=0;i<n;i++){
            str = br.readLine();
            String[] temp = str.split(" ");

            pq.add(new String[]{temp[0], temp[1], temp[2], temp[3]});
        }
        System.out.println(pq.poll()[0]);
        for(int i=0;i<n-2;i++){
            pq.poll();
        }
        System.out.println(pq.poll()[0]);
    }
}