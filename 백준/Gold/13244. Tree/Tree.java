import java.io.*;
import java.util.*;

public class Main {
    static int node, v;
    static List<Integer>[] egdes = new ArrayList[1001];
    static boolean visited[] = new boolean[1001];
    static void dfs(int ver){
        visited[ver] = true;
        for(int i : egdes[ver]){
            if(!visited[i])
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<testcase; t++){
            node = stoi(br.readLine());
            int cnt=0;
            v = stoi(br.readLine());
            Arrays.fill(visited, false);

            for(int i=0; i<=node; i++){
                egdes[i] = new ArrayList<Integer>();
            }


            for(int i=0; i<v; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v1, v2;
                v1 = stoi(st.nextToken());
                v2 = stoi(st.nextToken());

                egdes[v1].add(v2);
                egdes[v2].add(v1);
            }

            for(int i=1; i<=node; i++){
                if(!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            if(v==node-1&&cnt==1){
                sb.append("tree\n");
            }
            else sb.append("graph\n");

        }
        System.out.println(sb.toString());

    }
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}