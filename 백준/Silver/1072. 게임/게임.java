import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long r=1000000000, l=1, x, y, ret=-1, avg;
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        avg = (y*100)/x;
        while(l<=r) {
            long mid = (l+r)/2;
            long temp = (y+mid)*100/(x+mid);
            if(temp>avg) {
                ret=mid;
                r=mid-1;
            }
            else l = mid+1;
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}