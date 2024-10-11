import java.io.*;
import java.util.*;
public class Main {
    static final int INF = 987654321;
    static int arr[] = new int[100_001], len, dp[][][], ret=INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (; len<100_001; len++ ){
            int com = Integer.parseInt(st.nextToken());
            if(com==0) break;
            arr[len] = com;
        }
        dp = new int[len][5][5];

        bw.write(go(0,0,0)+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static int go(int ind, int L, int R) {
        if(ind==len) return 0;
        if(dp[ind][L][R]!=0) return dp[ind][L][R];

        int left, right;
        left = right = INF;

        if(R !=arr[ind]) left = go(ind+1, arr[ind], R) + check(L, arr[ind]);
        if(L !=arr[ind]) right = go(ind+1, L, arr[ind]) + check(R, arr[ind]);

        return dp[ind][L][R]=Math.min(left, right);
    }

    static int check(int from, int to) {
        if(from==0) return 2;
        if(from==to) return 1;
        if(Math.abs(from-to)==2) return 4;
        return 3;
    }
}