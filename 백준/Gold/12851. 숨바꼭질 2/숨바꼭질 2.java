import java.util.*;
import java.io.*;

public class Main {

    static int su, si;
    static int[] position = new int[100001];
    static int[] visit = new int[100001];

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(su);
        visit[su] = 1;
        position[su] = 1;

        while (!q.isEmpty()){
            int po = q.poll();

            if(po+1<100001 && visit[(po+1)]==0){
                visit[(po+1)] = visit[po] + 1;
                q.add(po+1);
                position[po+1] += position[po];
            }
            else if(po+1<100001 && (visit[po+1] == visit[po]+1))
                position[po+1] += position[po];

            if(po-1>-1 && visit[(po-1)]==0){
                visit[(po-1)] = visit[po] + 1;
                q.add(po-1);
                position[po-1] += position[po];
            }
            else if(po-1>-1 && (visit[po-1] == visit[po]+1))
                position[po-1] += position[po];

            if(po*2<100001 &&visit[(po*2)]==0){
                visit[(po*2)] = visit[po] + 1;
                q.add(po*2);
                position[po*2] += position[po];
            }
            else if(po*2<100001 &&(visit[po*2] == visit[po]+1))
                position[po*2] += position[po];

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        su = Integer.parseInt(st.nextToken());
        si = Integer.parseInt(st.nextToken());

        if(su==si){
            System.out.println(0);
            System.out.println(1);
        }

        else{
            bfs();
            System.out.println(visit[si]-1);
            System.out.println(position[si]);
        }



    }
}