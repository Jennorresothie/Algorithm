import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        long ret=0;
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        List<int[]> jewelys = new ArrayList<>();
        for (int i=0; i<n; i++) {
            str = br.readLine().split(" ");
            int m, v;
            m = Integer.parseInt(str[0]);
            v = Integer.parseInt(str[1]);

            jewelys.add(new int[]{m, v});
        }

        int[] bags = new int[k];
        for (int i=0; i<k; i++) bags[i] = Integer.parseInt(br.readLine());

        Collections.sort(jewelys, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2) { return o1[0]-o2[0];}
        });
        Arrays.sort(bags);

        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int bag : bags) {
            while(i<n&&bag>=jewelys.get(i)[0]) pq.add(jewelys.get(i++)[1]);
            if(pq.size()>0) ret+=pq.poll();
        }
        System.out.println(ret);
    }
}