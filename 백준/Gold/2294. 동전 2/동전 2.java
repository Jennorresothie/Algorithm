import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int coins[] = new int[n];
        int dp[] = new int[k+1];
        for (int i=0; i<n; i++) coins[i] = Integer.parseInt(br.readLine());

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i=0; i<n; i++) {
            int temp = coins[i];
            for (int j=temp; j<=k; j++) {
                dp[j] = Math.min(dp[j], dp[j-temp]+1);
            }
        }

        bw.write((dp[k]==100001?-1:dp[k])+"");
        bw.flush();
        bw.close();
    }
}