import java.io.*;
import java.util.*;
public class Main {
    static int n, m, c, arr[], dp[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1480
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[m][1<<n][c+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        bw.write(go(0,0,0)+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static int go (int bag, int N, int cap) {
        if(bag==m) return 0;
        if(dp[bag][N][cap]!=0) return dp[bag][N][cap];

        dp[bag][N][cap] = Math.max(dp[bag][N][cap], go(bag+1, N, 0));

        for (int i=0; i<n; i++) {
            // 1. 보석 확인
            if(((1<<i)&N)>0) continue;
            // 2. 가방 무게 확인
            if(cap+arr[i]>c) continue;
            dp[bag][N][cap] = Math.max(dp[bag][N][cap], go(bag, (1<<i) | N, cap+arr[i])+1);
        }

        return dp[bag][N][cap];
    }
}