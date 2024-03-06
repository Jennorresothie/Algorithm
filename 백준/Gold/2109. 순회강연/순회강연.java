import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();
        int ret = 0;
        int n = stoi(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = stoi(st.nextToken());
            int day = stoi(st.nextToken());

            list.add(new int[]{pay, day});
        }

        // 날짜 오름차순 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            pq.add(list.get(i)[0]);
            if(pq.size()>list.get(i)[1]) pq.poll();
        }

        for (int i: pq) ret+=i;
        System.out.println(ret);
    }
    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}