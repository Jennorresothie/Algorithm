import java.io.*;
import java.util.*;
public class Main  {
    static int n, dp[][][], dire[][] = {{0,1},{1,1},{1,0}}, ret;
    static boolean map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        dp= new int[3][n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                if(st.nextToken().charAt(0)=='0') map[i][j] = true;
        }
        dpFun(0, 1, 0);
        ret = dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1];
        bw.write( ret+"");
        bw.flush();
        bw.close();
    }

    static void dpFun(int y, int x, int type) {
        if(y==n-1 && x==n-1)
            return;

        for(int i=-1; i<2; i++) {
            int ind = type + i;

            if(ind>-1&&ind<3) {
                int dx = x + dire[ind][1];
                int dy = y + dire[ind][0];

                if(dx>=n||dy>=n||map[dy][dx]==false)
                    continue;

                if(ind==1&&!check(y,x))
                    continue;

                dp[ind][dy][dx]++;
                dpFun(dy, dx, ind);
            }
        }
    }

    static boolean check(int y, int x) {
        for(int i=0; i<3; i++) {
            int dy = y + dire[i][0];
            int dx = x + dire[i][1];

            if(dx<0||dx>=n||dy<0||dy>=n||map[dy][dx]==false)
                return false;
        }
        return true;
    }
}