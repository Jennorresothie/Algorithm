import java.io.*;
import java.util.*;
public class Main {
    static int n, map[][], dp[][];
    static final int INF = 16000000 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][1<<n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        int ret = tsp(0,1);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    static int tsp(int cur, int visited) {
        if(visited == (1<<n)-1)
            // cur -> 0(출발도시)로 가는 경로가 존재해야 돌아갈 수 있음
            return map[cur][0]!=0 ? map[cur][0]:INF; 

        if(dp[cur][visited] > 0) return dp[cur][visited];

        dp[cur][visited] = INF;
        for(int i=0; i<n; i++) {
            // 방문 체크
            if((visited & (1<<i)) > 0) continue;
            // 길 유무 체크
            if(map[cur][i]==0) continue;

            dp[cur][visited] = Math.min(dp[cur][visited], tsp(i, visited | (1<<i))+ map[cur][i]) ;
        }
        return dp[cur][visited];
    }
}