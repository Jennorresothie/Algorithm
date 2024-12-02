import java.io.*;
import java.util.*;

public class Main {
    static int DVD[] = new int[200002], limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            st = new StringTokenizer(br.readLine());
            int n, m, index[] = new int[100001];
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            limit = n+m;

            for (int i=1; i<=n; i++) {
                index[i] = m+i;
                update(m+i, 1);
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++) {
                int temp = Integer.parseInt(st.nextToken());
                int ind = index[temp];
                bw.write(sum(ind) - 1+" ");
                update(ind, -1);
                index[temp] = m-i;
                update(m-i, 1);
            }
            Arrays.fill(DVD, 0);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void update(int n, int dif) {
        while ( n<=limit ) {
            DVD[n] += dif;
            n += (n & -n);
        }
    }
    static int sum(int n) {
        int ret = 0;
        while(n>0) {
            ret += DVD[n];
            n -= (n & -n);
        }
        return ret;
    }
}