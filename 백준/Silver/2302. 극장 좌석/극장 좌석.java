import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, dp[];
    static boolean flag[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        flag = new boolean[n+1];

        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(br.readLine());
            flag[num] = true;
        }

        bw.write(go(1)+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static int go(int num) {
        if(num>=n) return 1;
        if(dp[num]!=0) return dp[num];
        if(flag[num]) return go(num+1);

        if(!flag[num+1]) dp[num] += go(num+1) + go(num+2);
        else dp[num] += go(num+1);
        return dp[num];
    }
}