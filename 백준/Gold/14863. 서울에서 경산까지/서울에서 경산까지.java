import java.io.*;
import java.util.*;
public class Main {
    static int n, k, walk[][], bike[][], dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        walk = new int[n][2];
        bike = new int[n][2];
        dp = new int[n][k+1];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            walk[i][0] = Integer.parseInt(st.nextToken());
            walk[i][1] = Integer.parseInt(st.nextToken());
            bike[i][0] = Integer.parseInt(st.nextToken());
            bike[i][1] = Integer.parseInt(st.nextToken());

            Arrays.fill(dp[i],-234567891);
        }

        bw.write(go(0,0)+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static int go(int city, int time){
        if(city==n) return 0;
        if(dp[city][time]>0) return dp[city][time];

        if(time+walk[city][0]<=k) dp[city][time] = Math.max(dp[city][time], go(city+1, time+walk[city][0])+walk[city][1]);
        if(time+bike[city][0]<=k) dp[city][time] = Math.max(dp[city][time], go(city+1, time+bike[city][0])+bike[city][1]);

        return dp[city][time];
    }
}