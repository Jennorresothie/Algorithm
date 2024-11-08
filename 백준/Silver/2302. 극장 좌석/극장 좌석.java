import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int st=1;
        for (int i=1; i<=m; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num-st);
            st = num+1;
        }
        list.add(n-st+1);

        dp = new int[n+2];
        dp[1]=1;
        dp[2]=2;
        int ret = 1;
        for (int i : list) ret *= go(i);

        bw.write(ret+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int go(int num) {
        if(num==0) return 1;
        if(dp[num]!=0) return dp[num];
        dp[num] = go(num-1) + go(num-2);
        return dp[num];
    }


}