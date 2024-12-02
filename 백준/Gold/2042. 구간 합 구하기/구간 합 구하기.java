import java.io.*;
import java.util.*;
public class Main  {
    static long limit, tree[], arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m, k, a, b;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        tree = new long[n+1];
        arr = new long[n+1];
        for (int i=1; i<=n; i++) arr[i] = Long.parseLong(br.readLine());
        limit = n;

        for (int i=1; i<=n; i++) update(i, arr[i]);

        for (int i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a==1) {
                long dif = c - arr[b];
                arr[b] = c;
                update(b, dif);
            }
            else bw.write(sum(b, c)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static long prefix(int n) {
        long ret = 0;
        while (n>0) {
            ret += tree[n];
            n -= (n & -n);
        }
        return ret;
    }
    static long sum(int start, long end) {
        return prefix((int)end) - prefix(start-1);
    }
    static void update(int n, long dif) {
        while (n<=limit) {
            tree[n] += dif;
            n += (n & -n);
        }
    }

}