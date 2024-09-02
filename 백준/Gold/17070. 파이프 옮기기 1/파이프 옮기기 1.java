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
        dp[0][0][1] = 1;
        for (int i=0; i<n; i++) {
            for (int j=1; j<n; j++) {
                for (int k=0; k<3; k++) {
                    for (int l=-1; l<2; l++) {
                        int ind = l + k;

                        if(ind>=0&&ind<=2) {
                            int dx = j + dire[ind][1];
                            int dy = i + dire[ind][0];

                            if(dx>=n||dy>=n||map[dy][dx]==false)
                                continue;

                            if(ind==1&&!check(i, j))
                                continue;

                            dp[ind][dy][dx] += dp[k][i][j];
                        }
                    }
                }
            }
        }

        ret = dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1];
        bw.write( ret+"");
        bw.flush();
        bw.close();
    }
    static boolean check(int y, int x) {
        for(int i=0; i<3; i++) {
            int dy = y + dire[i][0];
            int dx = x + dire[i][1];

            if(dx>=n||dy>=n||map[dy][dx]==false)
                return false;
        }
        return true;
    }
}