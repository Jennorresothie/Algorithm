import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        long ret=0;
        List<int[]> list = new ArrayList<>();
        
        // 입력
        for (int i=0; i<n; i++){
         StringTokenizer st = new StringTokenizer(br.readLine());
         list.add(new int[]{stoi(st.nextToken()), stoi(st.nextToken())});
        }
        // 데드라인으로 오름차순 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {return o1[0]-o2[0];};
        });
        
        // 우선순위 큐에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] i : list) {
            pq.add(i[1]);
            // 우선순위 큐 크기가 데드라인보다 크면 top을 pop
            if(pq.size()>i[0])
                pq.poll();
        }
        
        // 우선순위 큐 값의 합 
        for(int i : pq) ret+=i;

        System.out.println(ret);
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}