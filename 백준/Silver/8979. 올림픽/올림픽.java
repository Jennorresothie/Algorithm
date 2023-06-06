import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] temp = str.split(" ");
        int testcase = Integer.parseInt(temp[0]);
        int target = Integer.parseInt(temp[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1])
                    return o2[1]-o1[1];
                if(o1[2]!=o2[2])
                    return o2[2]-o1[2];
                if(o1[3]!=o2[3])
                    return o2[3]-o1[3];
                return 0;
            }
        });

        for(int i=0; i<testcase; i++){
            str = br.readLine();
            temp = str.split(" ");
            pq.add(new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
                    Integer.parseInt(temp[2]), Integer.parseInt(temp[3])});
        }

        int[] pre = pq.peek();
        int count=1;
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if(!(pre[1]==curr[1]&&pre[2]==curr[2]&&pre[3]==curr[3])) {
                count++;
                pre = curr;
            }
            if(curr[0]==target){
                System.out.println(count);
                break;
            }

        }

    }
}