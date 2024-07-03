import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long x, y, z, r, l=0;
        boolean flag = false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = (y*100)/x;
        r = 1000000001;
        while(l<r) {
            long mid = (l+r)/2;
            long temp = (y+mid)*100/(x+mid);
            if(temp>z) {
                flag=true;
                r = mid;
            }
            else l=mid+1;
        }
        bw.write(flag?String.valueOf(r):String.valueOf(-1));
        bw.close();
    }
}