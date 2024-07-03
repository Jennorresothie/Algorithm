import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long x, y, z, r, l=1, ret=-1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = (y*100)/x;
        r = 1000000000;
        while(l<=r) {
            long mid = (l+r)/2;
            long temp = (y+mid)*100/(x+mid);
            if(temp>z) {
                ret = mid;
                r = mid-1;
            }
            else l=mid+1;
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}