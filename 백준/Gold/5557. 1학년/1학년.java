import java.io.*;
import java.util.*;
public class Main {
    static int n, last, arr[];
    static long dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n-1];
        dp = new long[n-1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n-1; i++) arr[i] = Integer.parseInt(st.nextToken());
        last = Integer.parseInt(st.nextToken());

        bw.write(go(1, arr[0])+"");
        bw.close();
    }
    static long go(int here, int sum) {
        if(sum<0 || sum>20) return 0;
        if(here==n-1) {
            if(sum==last)
                return 1;
            return 0;
        }

        if(dp[here][sum]!=0) return dp[here][sum];

        dp[here][sum]+=go(here+1, sum+arr[here]);
        dp[here][sum]+=go(here+1, sum-arr[here]);

        return dp[here][sum];
    }
}