import java.io.*;
import java.util.*;
public class Main {
    static final int INF = 100_001;
    static int dp[], coins[], n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k+1];
        coins = new int[n];

        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i]<=k)
                dp[coins[i]] = 1;
        }

        int ret = search(k);
        ret = ret>=INF?-1: ret;

        bw.write(ret+"");
        bw.flush();
        bw.close();
    }


    static int search(int t) {
        if(dp[t]>0) return dp[t];

        dp[t] = INF;
        for(int i=0; i<n; i++) {
            if(t<coins[i]) continue;

            dp[t] = Math.min(dp[t], search(t-coins[i]) + 1 );
        }
        return dp[t];
    }
}