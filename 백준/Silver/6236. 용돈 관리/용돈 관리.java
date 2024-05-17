import java.io.*;
import java.util.*;
public class Main {
    static int l=1, r, cnt, money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int spends[] = new int[n];
        for(int i=0; i<n; i++) {
            spends[i] = Integer.parseInt(br.readLine());
            r += spends[i];
        }
        while(l<r) {
            int k = (l+r) / 2;
            cnt = 1;
            money = k;
            for(int s : spends) {
                if(k<s) {
                    cnt+=m;
                    break;
                }
                if(money>=s) money-= s;
                else {
                    cnt++;
                    money = k - s;
                }
            }
            if(cnt>m) l = k+1;
            else r = k;
        }
        bw.write(String.valueOf(r));
        bw.close();
    }
}