import java.io.*;
import java.util.*;
public class Main {
    static int p, n, m, ret, narr[], marr[], nCnt[], mCnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        p = Integer.parseInt(br.readLine());
        nCnt = new int[p+1];
        mCnt = new int[p+1];
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        narr = new int[n*2+1];
        marr = new int[m*2+1];

        for(int i=1; i<=n; i++) narr[i+n] = narr[i] = Integer.parseInt(br.readLine());
        for(int i=1; i<=m; i++) marr[i+m] = marr[i] = Integer.parseInt(br.readLine());

        makeArr(n, narr, nCnt);
        makeArr(m, marr, mCnt);

        ret = nCnt[p] + mCnt[p];
        for(int i=1; i<p; i++) ret+=(nCnt[i]*mCnt[p-i]);

        bw.write(String.valueOf(ret));
        bw.close();
    }

    static void makeArr(int size, int[] arr, int[] cnt) {
        // 누적합
        for(int i=2; i<=size*2; i++) arr[i] += arr[i-1];

        // 모든 가능성 구하기
        for(int i=1; i<=size; i++) {
            for(int j=i; j<=size+i-1; j++) {
                int temp = arr[j] - arr[j-i];
                if(temp<=p) cnt[temp]++;
                if(size==i) break;
            }
        }
    }

}