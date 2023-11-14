import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m, k, ret=0, burketHead=0, burketTail=0;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        burketTail += (m-1);

        k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++) {
            int apple = Integer.parseInt(br.readLine());
            apple--;
            int diff = 0;

            if(burketHead<=apple&&burketTail>=apple)
                continue;

            else if(burketHead>apple) {
                 diff = burketHead-apple;
                 burketHead-=diff;
                 burketTail-=diff;
            }

            else if(burketTail<apple) {
                diff = apple - burketTail;
                burketHead+=diff;
                burketTail+=diff;
            }

            ret+=diff;

        }

        System.out.println(ret);
    }
}