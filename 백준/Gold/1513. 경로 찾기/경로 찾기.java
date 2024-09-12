import java.io.*;
import java.util.*;
public class Main {
    static int map[][], n, m, dire[][]={{1,0},{0,1}}, dp[][][][];
    static final int mod = 1000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m][c+1][c+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k <= c; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        for (int i=1; i<=c; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = i;
        }

        for (int i=0; i<=c; i++) 
            bw.write(search(0, 0, i, 0) + " ");
        bw.flush();
        bw.close();
    }

    static int search(int y, int x, int cnt, int prev) {
        if(n-1==y&&m-1==x) {
            // 학원과 오락실의 위치가 다른 경우
            if(map[y][x]==0&&cnt==0) return 1;

            // 학원과 오락실의 위치가 같은 경우
            if(map[y][x]>prev&&cnt==1) return 1;

            return 0;
        }

        if(dp[y][x][cnt][prev]>-1) return dp[y][x][cnt][prev];

        dp[y][x][cnt][prev] = 0;
        for (int i=0; i<2; i++) {
            int dx = x + dire[i][1];
            int dy = y + dire[i][0];

            if(dx>=m||dy>=n) continue;

            // 현재 위치가 오락실일 수도 있으니 확인
            if(map[y][x]==0)
                dp[y][x][cnt][prev] += search(dy, dx, cnt, prev);
            else if(map[y][x]>prev && cnt>0)
                dp[y][x][cnt][prev] += search(dy, dx, cnt-1, map[y][x]);
        }
        return dp[y][x][cnt][prev] % mod;
    }

}