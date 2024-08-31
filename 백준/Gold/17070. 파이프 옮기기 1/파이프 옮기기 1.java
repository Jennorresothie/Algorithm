import java.io.*;
import java.util.*;
public class Main  {
    static int n, dp[][][], dire[][]={{0,1},{1,1},{1,0}}, ret;
    static char map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                map[i][j] = st.nextToken().charAt(0);
        }

        dp = new int[n][n][3];
        dfs(0, 1, 0);
        for (int i=0; i<3; i++) ret += dp[n-1][n-1][i];
        bw.write(ret+"");
        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x, int type) {
        if(y==n-1&&x==n-1) return;

        for(int i=-1; i<2; i++) {
            int ind = type + i;
            if(ind>=0&&ind<=2) {
                int dx = x + dire[ind][1];
                int dy = y + dire[ind][0];

                if(dx>=n||dy>=n||map[dy][dx]=='1')
                    continue;
                if(ind==1&&!check(y, x))
                    continue;

                dp[dy][dx][ind]++;
                dfs(dy, dx, ind);
            }
        }
    }

    static boolean check(int y, int x) {
        for (int i=0; i<3; i++) {
            int dx = x + dire[i][1];
            int dy = y + dire[i][0];

            if(dx>=n||dy>=n||map[dy][dx]=='1')
                return false;
        }
        return true;
    }
}