import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 200001;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long answer = 1;
        long tree_cnt[] = new long[MAX+1];
        long tree_sum[] = new long[MAX+1];

        Arrays.fill(tree_cnt, 0);
        Arrays.fill(tree_sum, 0);

        int test = Integer.parseInt(br.readLine());
        for (int t=0; t<test; t++) {
            int n = Integer.parseInt(br.readLine())+1;

            if (t>0) {
                long left = n * interval(tree_cnt, 1, n-1) - interval(tree_sum, 1, n-1);
                long right = interval(tree_sum, n+1, MAX) - n * interval(tree_cnt, n+1, MAX);

                answer *= (left + right) % MOD;
                answer %= MOD;
            }
            update(tree_cnt, n, 1);
            update(tree_sum, n, n);
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static long prefix(long[] arr, int n) { // 누적함
        long ret = 0;
        while ( n>0 ) {
            ret += arr[n];
            n -= (n & -n);
        }
        return ret;
    }

    static long interval(long[] arr, int start, int end) { // 구간합
        return prefix(arr, end) - prefix(arr, start-1);
    }

    static void update(long[] arr, int n, int dif) { // 값 추가
        while ( n < MAX) {
            arr[n] += dif;
            n += (n&-n);
        }
    }
}