import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 4;
    static int n, m, h, ladder[][], ret = INF;
    static boolean[][] visited;

    static boolean check() {
        for(int i=1; i<=n; i++) {
            int start = i;
            for(int j=1; j<=h; j++){
                if(visited[j][start])
                    start++;
                else if(visited[j][start-1])
                    start--;
            }
            if(start!=i)
                return false;
        }
        return true;
    }

    static void dfs(int cnt, int here) {
        if(cnt>3||cnt>ret)
            return;
        if(check()){
            ret = Math.min(ret, cnt);
            return;
        }

        for(int i = here; i<=h; i++) {
            for(int j = 1; j<=n; j++) {
                if(visited[i][j]||visited[i][j-1]||visited[i][j+1])
                    continue;
                visited[i][j] = true;
                dfs(cnt+1, i);
                visited[i][j] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());

        ladder = new int[h+2][n+2];
        visited = new boolean[h+1][n+2];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited[a][b]=true;
        }

        dfs(0,1);
        System.out.println(ret==INF?-1:ret);
    }
}