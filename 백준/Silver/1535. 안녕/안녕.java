import java.io.*;
import java.util.*;
public class Main {
    static int dp[] = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int list[][] = new int[2][n];

        for(int i=0; i<2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                list[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            int energy = list[0][i];
            for(int j=100; j>0; j--) {
                if(energy>=j) break;
                dp[j] = Math.max(dp[j], dp[j-energy]+list[1][i]);
            }
        }

        bw.write(dp[100]+"");
        bw.flush();
        bw.close();
    }
}