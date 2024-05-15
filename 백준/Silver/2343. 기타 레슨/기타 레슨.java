import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m, videos[], l=1, r=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        videos = new int[n];
        for(int i=0; i<n; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            r+=videos[i];
        }
        while (l<r) {
            int mid = (l+r)/2;
            int cnt = 1, sum = 0;
            for(int v : videos) {
                if(v>mid) {
                    cnt += m;
                    break;
                }
                if(sum+v<=mid) sum += v;
                else {
                    cnt++;
                    sum=v;
                }
            }
            if(cnt>m) l = mid+1;
            else r = mid;
        }
        bw.write(String.valueOf(r));
        bw.close();
    }
}