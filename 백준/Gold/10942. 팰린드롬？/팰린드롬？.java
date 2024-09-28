import java.io.*;
import java.util.*;
public class Main {
    static boolean dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new boolean[n][n];
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            for(int j=0; j<i; j++) {
                if(arr[j]==num) dp[j][i] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            boolean flag = true;
            while (a<=b) {
                if(!dp[a++][b--]) {
                    flag = false;
                    break;
                }
            }
            bw.write((flag?1:0)+"\n");
        }
        bw.close();
    }
}