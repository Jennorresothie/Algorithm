import java.io.*;
import java.util.*;
public class Main {
    static int n, dp[] = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            double temp = Double.parseDouble(st.nextToken());
            int k = (int) (temp * 100 + 0.5);
            if(n==0)
                break;

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                
                int w = Integer.parseInt(st.nextToken());
                double price = Double.parseDouble(st.nextToken());
                int p = (int)(price*100+0.5);

                for (int j=p; j<=k; j++) {
                    dp[j] = Math.max(dp[j], dp[j-p]+w);
                }
            }

            bw.write(dp[k]+"\n");

            Arrays.fill(dp, 0);
        }
        bw.flush();
        bw.close();
    }
}