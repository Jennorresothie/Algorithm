import java.io.*;
import java.util.*;
public class Main {
    static int tree[][] = new int[1025][1025], n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) update(i, j, Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c, d, e;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            if(a==0) {
              e =  d - inter(b, c, b, c);
              update(b, c, e);
            }
            else {
                int sum = 0;
                e = Integer.parseInt(st.nextToken());
                for (int j=b; j<=d; j++) sum += inter(j, c, j, e);
                bw.write(sum+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void update(int x, int y, int dif) {
        while (y<=n) {
            tree[x][y] += dif;
            y += (y & -y);
        }
    }
    static int prefix(int x, int y) {
        int ret = 0;
        while (y>0) {
            ret += tree[x][y];
            y -= (y & -y);
        }
        return ret;
    }
    static int inter(int startX, int startY, int endX, int endY) {
        return prefix(endX, endY) - prefix(startX, startY-1);
    }

}