import java.io.*;
import java.util.*;

public class Main {
    static int v,e,count;
    static ArrayList<Integer> graph[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        visit = new boolean[v+1];
        graph = new ArrayList[v+1];
        for(int i=0;i<=v;i++){
            graph[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        DFS(1);
        System.out.println(count-1);

    }

    static void DFS(int start){
        if(visit[start])return;
        visit[start]=true;

        count++;
        for(int i : graph[start]){
            if(!visit[i])
                DFS(i);
        }
    }
}