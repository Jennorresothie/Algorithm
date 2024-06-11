import java.io.*;
import java.util.*;
public class Main {

    static long l=1, r=1;
    static int room[][], n, ack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ack = Integer.parseInt(st.nextToken());
        room = new int[n][3];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) room[i][j] = Integer.parseInt(st.nextToken());
            if(room[i][0]==1) r += (long)(room[i][2]/ack)*room[i][1];
        }
        while(l<r) {
            long mid = (l+r)/2;
            if(check(mid)) r = mid;
            else l = mid+1;
        }
        bw.write(String.valueOf(r));
        bw.close();
    }

    static boolean check(long mid) {
        long attack = ack;
        long hp = mid;

        for(int[] r : room) {
            if(r[0]==1) {
                long damage = r[2]%attack==0?(r[2]/attack)-1:r[2]/attack;
                hp-=damage*r[1];
                if(hp<=0) return false;
            }
            else{
                attack += r[1];
                hp += r[2];
                if(hp>mid) hp = mid;
            }
        }
        return true;
    }

}