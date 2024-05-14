import java.io.*;
import java.util.*;
public class Main {
    static int child, jewelry, j[], l, r, mid, ret=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        l = r = 1;
        child = Integer.parseInt(st.nextToken());
        jewelry = Integer.parseInt(st.nextToken());
        j = new int[jewelry];
        for(int i=0; i<jewelry; i++) {
            j[i] = Integer.parseInt(br.readLine());
            if(r<j[i]) r = j[i];
        }
        while(l<=r) {
            mid = (l+r) / 2;
            int cnt = 0;
            for (int i : j) {
                cnt += i/mid;
                if(i%mid>0) cnt++;
            }
            if(cnt>child) l = mid+1;
            else {
                r = mid-1;
                if(ret>mid) ret = mid;
            }
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}