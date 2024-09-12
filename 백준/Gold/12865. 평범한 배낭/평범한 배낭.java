import java.io.*;
import java.util.*;
public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        dp = new int[k+1];
                
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            for (int j=k; j>=w; j--) {
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
        }
        bw.write(dp[k]+"");
        bw.flush();
        bw.close();
    }
}