import java.io.*;
import java.util.*;
public class Main {
    static int p,n,m, ret, arr[], brr[], aCnt[], bCnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        p = Integer.parseInt(br.readLine());
        aCnt = new int[p+1];
        bCnt = new int[p+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr=new int[n*2+1];
        brr=new int[m*2+1];
        for(int i=1; i<=n; i++) arr[i+n]=arr[i]=Integer.parseInt(br.readLine());
        for(int i=1; i<=m; i++) brr[i+m]=brr[i]=Integer.parseInt(br.readLine());
        returnCnt(n, arr, aCnt);
        returnCnt(m, brr, bCnt);
        ret = aCnt[p]+bCnt[p];
        for(int i=1; i<p; i++) ret+=(aCnt[i]*bCnt[p-i]);
        bw.write(String.valueOf(ret));
        bw.close();
    }
    static void returnCnt(int size, int[] array, int[] cnt){
        for(int i=2; i<=size*2; i++) array[i]+=array[i-1];

        for(int i=1; i<=size; i++) {
            for(int j=i; j<=size+i-1; j++) {
                int temp = array[j] - array[j-i];
                if(temp<=p) cnt[temp]++;
                if(i==size) break;
            }
        }
    }
}