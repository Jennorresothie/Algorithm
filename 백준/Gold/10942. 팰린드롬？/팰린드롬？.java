import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            dp[i][i] = 1;
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            if(i>0&&arr[i-1]==num) dp[i-1][i] = 1;
        }

        for (int i=2; i<n; i++)
            for (int j=0; j<n-i; j++)
                if(arr[j]==arr[j+i]&&dp[j+1][j+i-1]==1)
                    dp[j][j+i]=1;

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            bw.write(dp[a][b]+"\n");
        }
        bw.close();
    }
}