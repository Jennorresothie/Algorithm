import java.io.*;

public class Main {
    static final int MOD = 1000000007;
    static final int MAX = 200001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long tree_cnt[], tree_sum[];

        tree_cnt = new long[MAX+1];
        tree_sum = new long[MAX+1];

        int t, n;
        long answer=1;
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine())+1;
            if (i > 0) {
                long l = n*interval(tree_cnt, 1, n-1) - interval(tree_sum, 1, n-1);
                long r = interval(tree_sum, n+1, MAX) - n*interval(tree_cnt, n+1, MAX);
                answer *= (l+r)%MOD;
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
    static long prefix(long arr[], int n) {
        long ret = 0;
        while (n>0) {
            ret += arr[n];
            n -= (n & -n);
        }
        return ret;
    }
    static long interval(long arr[], int start, int end) {
        return prefix(arr, end) - prefix(arr, start-1);
    }
    static void update(long arr[], int n, int dif) {
        while(n<MAX) {
            arr[n] += dif;
            n += (n & -n);
        }
    }
}