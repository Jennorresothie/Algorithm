import java.io.*;
import java.util.*;
public class Main {
    static int[] dp, coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        dp = new int[k+1];

        dp[0]=1;

        for (int i=0; i<n; i++) {
            int temp = Integer.parseInt(br.readLine());
            for(int j=temp; j<=k; j++) {
                dp[j] += dp[j-temp];
            }
        }

        bw.write(dp[k]+"");
        bw.flush();
        bw.close();
    }
}