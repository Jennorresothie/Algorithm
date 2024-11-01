import java.io.*;
import java.util.*;
public class Main {
    static int n, m, dp[] = new int[41];
    static boolean change[] = new boolean[41];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int prev = 0;
        for (int i=0; i<m; i++) {
            int temp = Integer.parseInt(br.readLine());
            change[temp - 1] = true;
        }

        Arrays.fill(dp, -1);

        bw.write(go(0)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int go(int num) {
        if(num >=n-1) return 1;
        if(change[num]) return go(num+1);
        if(dp[num]!=-1) return dp[num];

        dp[num] = 0;
        if(!change[num+1]) dp[num] += (go(num+2) + go(num+1));
        else dp[num] += go(num+1);

        return dp[num];
    }
}