import java.io.*;
import java.util.*;
public class Main {
    static int n, ret, dire[][]={{0,1},{1,1},{1,0}};
    static char map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = st.nextToken().charAt(0);
        }
        dfs(1, 0, 0);
        bw.write(ret+"");
        bw.flush();
        bw.close();
    }
    static void dfs(int x, int y, int type) {
        if(x==n-1&&y==n-1){
            ret++;
            return;
        }


        for (int i=-1; i<2; i++) {
            int ind = type + i;
            if(ind>=0&&ind<3) {
                int dx = x + dire[ind][1];
                int dy = y + dire[ind][0];

                if(dx<0||dx>=n||dy<0||dy>=n||map[dy][dx]=='1')
                    continue;

                if(ind==1&&!check(x, y))
                    continue;

                dfs(dx, dy, ind);
            }
        }
    }

    static boolean check(int x, int y){
        for (int i=0; i<3; i++) {
            int dx = x + dire[i][1];
            int dy = y + dire[i][0];

            if(dx<0||dx>=n||dy<0||dy>=n||map[dy][dx]=='1')
                return false;
        }
        return true;
    }
}