import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, attract[];
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        attract = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) attract[i] = Integer.parseInt(st.nextToken());
        if(n<=m) bw.write(String.valueOf(n));
        else {
            long l=0, r=(long)n*30, ret=0, cnt;
            while(l<=r) {
                long mid = (l+r)/2;
                cnt = m;
                for(int j=0; j<m; j++) cnt += mid/attract[j];
                if(cnt>=n) {
                    ret=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            cnt = m;
            for (int i=0; i<m; i++) cnt += ((ret-1)/attract[i]);
            for(int j=0; j<m; j++) {
                if(ret%attract[j]==0) cnt++;
                if(cnt==n) {
                    bw.write(String.valueOf(j+1));
                    break;
                }
            }
        }
        bw.close();
    }
}