import java.io.*;
import java.util.*;
public class Main {
    static long n, atk, l=1, r;
    static List<int[]>  list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new int[]{t,a,h});
            if(t==1) r += ((long)a*h);
        }
        while(l<r) {
            long mid = (l+r)/2;
            if(check(mid))
                r = mid;
            else l = mid + 1;
        }
        bw.write(String.valueOf(r));
        bw.close();
    }
    static boolean check(long mid) {
        long Atk = atk;
        long hp = mid;

        for(int[] room : list) {
            if(room[0]==1) {
                long damage = room[2]%Atk==0?(room[2]/Atk)-1:room[2]/Atk;
                hp -= (damage*room[1]);
                if(hp<=0) return false;
            }
            else {
                Atk += room[1];
                hp += room[2];
                if(hp>mid) hp = mid;
            }
        }
        return true;
    }
}