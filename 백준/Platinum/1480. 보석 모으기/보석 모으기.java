import java.io.*;
import java.util.*;
public class Main {
    static int n, m, c, arr[], dp[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[m][1<<n][c+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        bw.write(go(0,0,0)+"");
        bw.close();
        br.close();
    }

    static int go (int bag, int jewelry, int capacity) {
        if(bag == m) return 0;
        if(dp[bag][jewelry][capacity]!=0) return dp[bag][jewelry][capacity];

        // 다음 가방으로 넘어감
        dp[bag][jewelry][capacity] = Math.max(dp[bag][jewelry][capacity], go(bag+1, jewelry, 0));

        // 가방에 넣지 않음음
       for(int i=0; i<n; i++) {
            if(((1<<i) & jewelry) > 0) continue;
            if(capacity+arr[i]>c) continue;
            dp[bag][jewelry][capacity] = Math.max(dp[bag][jewelry][capacity], go(bag, jewelry | (1<<i), capacity+arr[i]) + 1);
        }

        return dp[bag][jewelry][capacity];
    }
}