import java.io.*;
import java.util.*;
public class Main {
    static int n, m, dp[] = new int[41];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int prev = 0;
        for (int i=0; i<m; i++) {
            int temp = Integer.parseInt(br.readLine());
            list.add(temp - prev - 1);
            prev = temp;
        }
        list.add(n - prev);

        dp[1]=1;
        dp[2]=2;
        int ret = 1;
        for (Integer i : list) ret *= go(i);

        bw.write(ret+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int go(int num) {
        if(num==0) return 1;
        if(dp[num]!=0) return dp[num];

        dp[num] = go(num-2)+go(num-1);
        return dp[num];
    }
}