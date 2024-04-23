import java.io.*;
import java.util.*;
public class Main {
    static int p, n, m, a[], b[], ret;
    static Map<Integer, Integer> aCnt, bCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        p = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        a = new int[m*2+1];
        b = new int[n*2+1];
        for(int i=1; i<=m; i++) {
            a[i] += Integer.parseInt(br.readLine());
            a[i+m] = a[i];
        }
        for(int i=1; i<=n; i++) {
            b[i] = Integer.parseInt(br.readLine());
            b[i+n] = b[i];
        }
        for(int i=1; i<=m*2; i++) a[i] += a[i-1];
        for(int i=1; i<=n*2; i++) b[i] += b[i-1];
        aCnt = new HashMap<>();
        bCnt = new HashMap<>();
        make(m, aCnt, a);
        make(n, bCnt, b);
        ret = aCnt.getOrDefault(p, 0) + bCnt.getOrDefault(p, 0);
        for(int i=1; i<p; i++) ret += (aCnt.getOrDefault(i,0)*bCnt.getOrDefault(p-i,0));
        bw.write(String.valueOf(ret));
        bw.close();
    }
    static void make(int len, Map<Integer, Integer> map, int[] arr){
        for(int 묶음개수 = 1; 묶음개수 <= len; 묶음개수++) {
            for(int startInd = 묶음개수; startInd<=len+묶음개수-1; startInd++) {
                int sum = arr[startInd] - arr[startInd-묶음개수];
                map.put(sum, map.getOrDefault(sum, 0)+1);
                if(묶음개수==len) break;
            }
        }
    }
}