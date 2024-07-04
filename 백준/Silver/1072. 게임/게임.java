import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long x, y, l=1, r, ret=-1, z;
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        r = x+1;
        z = y*100/x;
        while(l<r){
            long mid = (l+r)/2;
            long avg = ((y+mid)*100)/(x+mid);
            if(avg>z) ret = r = mid;
            else l = mid + 1;
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}