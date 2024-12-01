import java.io.*;
import java.util.*;
public class Main {
    static int arr[] = new int[200002], limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n, m;
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[] movieIdx = new int[n+1];
            limit = n+m;

            for (int j=1; j<=n; j++) {
                movieIdx[j] = m+j;
                update(movieIdx[j], 1);
            }

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                int index = movieIdx[temp];

                bw.write(prefix(index)-1+" ");
                update(index, -1);
                movieIdx[temp] = m-j;
                update(movieIdx[temp], 1);
            }
            bw.newLine();
            Arrays.fill(arr, 0);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int prefix(int n) {
        int ret = 0;
        while(n>0) {
            ret += arr[n];
            n -= (n & -n);
        }
        return ret;
    }
    
    static void update(int n, int dif) {
        while (n <= limit) {
            arr[n] += dif;
            n += (n & -n);
        }
    }
}