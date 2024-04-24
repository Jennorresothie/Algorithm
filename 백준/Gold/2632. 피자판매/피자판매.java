import java.io.*;
import java.util.*;
public class Main {
    static int p, n, m, ret, narr[], marr[], nCnt[], mCnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        p = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        narr = new int[n*2+1];
        marr = new int[m*2+1];
        nCnt = new int[p+1];
        mCnt = new int[p+1];
        for(int i=1; i<=n; i++) narr[i+n] = narr[i] = Integer.parseInt(br.readLine());
        for(int i=1; i<=m; i++) marr[i+m] = marr[i] = Integer.parseInt(br.readLine());
        makeSum(n, narr, nCnt);
        makeSum(m, marr, mCnt);
        ret = nCnt[p] + mCnt[p];
        for(int i=1; i<p; i++) ret += (nCnt[i]*mCnt[p-i]);

        bw.write(String.valueOf(ret));
        bw.close();
    }

    static void makeSum(int size, int[] arr, int[] cnt){
        for(int i=1; i<=size*2; i++) arr[i]+=arr[i-1];

        for(int i=1; i<=size; i++) {
            for(int j=i; j<=size+i-1; j++) {
                int temp = arr[j] - arr[j-i];
                if(temp>p) continue;
                cnt[temp]++;
                if(size==i)break;
            }
        }

    }

}