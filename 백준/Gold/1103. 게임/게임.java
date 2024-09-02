import java.util.*;
import java.io.*;
public class Main {
    static int n, m, ret, dp[][], dire[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static char map[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        dp = new int[n][m];
        visit = new boolean[n][m];
        for (int i=0; i<n; i++) map[i] = br.readLine().toCharArray();

        bw.write(dfs(0,0)+"");
        bw.flush();
        bw.close();
    }
    static int dfs(int y, int x) {
        if(x<0||x>=m||y<0||y>=n||map[y][x]=='H')
            return 0;

        if(visit[y][x]) {
            System.out.println(-1);
            System.exit(0);
        }

        if(dp[y][x]>0) return dp[y][x];

        visit[y][x] = true;
        int a = map[y][x]-'0';
        for(int i=0; i<4; i++) {
            int dx = x + dire[i][1] * a;
            int dy = y + dire[i][0] * a;

            dp[y][x] = Math.max(dp[y][x], dfs(dy, dx) + 1);

        }
        visit[y][x] = false;
        return dp[y][x];
    }
}