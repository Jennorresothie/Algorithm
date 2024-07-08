import java.io.*;
import java.util.*;
public class Main {
    static long c, total, l=1, r, ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int arr[] = new int[s];
        for (int i=0; i<s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        r=1000000000;
        while(l<=r) {
            long mid = (l+r)/2;
            int cnt = 0;
            for (int n : arr) cnt += n/mid;
            if(cnt<c) r=mid-1;
            else {
                l=mid+1;
                ret = mid;
            }
        }
        total -= (ret*c);
        bw.write(String.valueOf(total));
        bw.close();
    }
}