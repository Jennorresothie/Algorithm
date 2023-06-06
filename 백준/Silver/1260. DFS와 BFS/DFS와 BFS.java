import java.util.*;
import java.io.*;

public class Main {
    static boolean visit[];
    static ArrayList<Integer> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] temp = str.split(" ");

        int v = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);
        int start = Integer.parseInt(temp[2]);

        visit = new boolean[v+1];
        graph = new ArrayList[v+1];
        for(int i=1; i<=v; i++)
            graph[i] = new ArrayList<Integer>();

        for(int i=0; i<e; i++){
            str = br.readLine();
            temp = str.split(" ");

            // 양반향이니까
            graph[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            graph[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));

        }

        // 연결된 정점들 오름차순으로 정렬
        for(int i=1; i<=v; i++)
            Collections.sort(graph[i]);

        DFS(start, Arrays.copyOf(visit, visit.length));
        System.out.println();
        BFS(start, Arrays.copyOfRange(visit,0,visit.length));
    }

    static void DFS(int start, boolean[] visit2){
        // 스택, 재귀함수(주로 사용)
        System.out.print(start+" ");
        visit2[start]=true;

        for(int i : graph[start]){
            if(!visit2[i])
                DFS(i, visit2);
        }

    }

    static void BFS(int start, boolean[] visit){
        // 큐
        Queue<Integer> q = new LinkedList();

        // 큐에 BFS를 시작 할 노드 번호를 넣어줍니다.
        q.add(start);

        // 시작노드 방문처리
        visit[start]=true;

        while (!q.isEmpty()){
            int n = q.poll();
            System.out.print(n+" ");

            for(int i : graph[n]){
                if(!visit[i]){
                    q.add(i);
                    visit[i]=true;
                }

            }
        }

    }
}