import java.util.*;
import java.io.*;
public class Main {
    static int dp[] = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int prev = 0;
        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num-prev-1);
            prev = num;
        }
        list.add(n-prev);

        int ret = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i : list) ret *= go(i);
        bw.write(ret+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int go (int num) {
        if(num==0) return 1;
        if(dp[num]!=0) return dp[num];

        dp[num] = go(num - 2) +  go(num - 1);
        return dp[num];
    }
}