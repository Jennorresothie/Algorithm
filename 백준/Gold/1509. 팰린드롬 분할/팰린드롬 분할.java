import java.io.*;
import java.util.*;
public class Main {
    static char str[];
    static int ret, dp[][], dp2[];
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack = new ArrayDeque<>();

        str = br.readLine().toCharArray();
        int len = str.length;
        dp = new int[len][len+1];
        dp2 = new int[len];

        for (int i=0; i<len; i++) dp[i][1] = 1;
        for (int i=0; i < len - 1; i++) {
            if(str[i] == str[i+1]) dp[i][2] = 1;
        }
        for (int size = 3; size <= len; size++) {
            for (int j=0; j+size <= len; j++) {
                if (str[j] == str[j+size-1] && dp[j+1][size-2]==1)
                    dp[j][size] = 1;
            }
        }

        Arrays.fill(dp2, INF);

        bw.write(go(0)+"");
        bw.close();
    }

    static int go(int here) {
        if(here== str.length) return 0;
        if(dp2[here]!=INF) return dp2[here];

        for(int i=1; here+i<=str.length; i++)
            if(dp[here][i]>0)
                dp2[here] = Math.min(dp2[here], go(here+i) + 1);

        return dp2[here];
    }
}