import java.util.*;
import java.io.*;
public class Main {
    static int a, b, c, d;
    static Map<String, Integer> map = new HashMap<>();
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        bw.write(bfs(0,0)+"");
        bw.close();
    }

    static int bfs(int A, int B) {
        map.put(A+" "+B, 1); // 현재 물통 조합에 대한 방문 처리
        q.add(new int[]{A, B});

        while(!q.isEmpty()) {
            int temp[] = q.poll();
            String str = temp[0]+" "+temp[1];

            enq(a, temp[1], map.get(str));
            enq(0, temp[1], map.get(str));
            enq(temp[0], b, map.get(str));
            enq(temp[0], 0, map.get(str));

            enq(Math.min(temp[0]+temp[1], a), Math.max(temp[0]+temp[1]-a, 0), map.get(str)); // a -> b 로 물 넘길때
            enq(Math.max(temp[0]+temp[1]-b, 0), Math.min(temp[0]+temp[1], b),  map.get(str)); // b -> a 로 물 넘길때

        }

//        map.getOrDefault(new int[]{c, d}, -1);
//
//        return map.get(new int[]{c, d});

        String str = c+" "+d;

        return map.containsKey(str)?map.get(str)-1:-1;

    }

    static void enq(int x, int y, int d) {
        String str = x+" "+y;
        // 값 있으면 그대로 반환
        if(map.containsKey(str)) return;

        // 없으면 추가
        map.put(str, d+1);
        q.add(new int[]{x, y});
    }}