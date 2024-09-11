import java.io.*;
import java.util.*;
public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine()," .");
            int n = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            int budget = b1*100 + b2;

            if(n==0) break;

            dp = new int[budget+1];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine()," .");
                int cal = Integer.parseInt(st.nextToken());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                int price = p1*100+p2;

                for(int j=price; j<=budget; j++) {
                    dp[j] = Math.max(dp[j], dp[j-price] + cal);
                }
            }
            bw.write(dp[budget]+"\n");
        }
        bw.flush();
        bw.close();
    }
}