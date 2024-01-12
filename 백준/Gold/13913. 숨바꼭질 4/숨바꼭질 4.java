import java.util.*;
import java.io.*;
public class Main {
    static int su, si, ret;
    static int[] visit = new int[200004];
    static int[] prev = new int[200004];
    static List<Integer> list = new LinkedList<>();
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(su);
        visit[su] = 1;

        while (!q.isEmpty()){
            int cur = q.poll();
            int np;

            if(cur == si) { // 동생 찾음
                ret = visit[si]-1;

                for(int i = si; i != su; i = prev[i]){ // 기록 옮김
                    list.add(i);
                }
                list.add(su);

                return;
            }

            for(int i=0; i<3; i++){
                switch (i){
                    case 0:
                        np = cur+1;
                        break;
                    case 1:
                        np = cur-1;
                        break;
                    case 2:
                        np = cur*2;
                        break;
                    default:
                        np=-1;
                }

                if(np<0||np>=200004||visit[np]>0)
                    continue;
                visit[np] = visit[cur] + 1;
                prev[np] = cur; // 기록
                q.add(np);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        su = Integer.parseInt(st.nextToken());
        si = Integer.parseInt(st.nextToken());

        bfs();
        Collections.reverse(list);

        System.out.println(ret);
        for(int i: list){
            System.out.print(i+" ");
        }

    }
}