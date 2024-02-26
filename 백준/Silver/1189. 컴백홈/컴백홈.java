import java.util.*;
import java.io.*;

public class Main {
    static int r, c, k, ret, dire[][]={{0,1},{1,0},{-1,0},{0,-1}};
    static boolean visited[][];
    static char box[][];

    static void dfs(int x, int y, int cnt){
        if(y==0&&x==(c-1)){
            if(cnt == k)
                ret++;
            return;
        }

        for(int i=0; i<4; i++){
            int dx = x + dire[i][0];
            int dy = y + dire[i][1];

            if(dx<0||dx>=c||dy<0||dy>=r||visited[dy][dx]||box[dy][dx]=='T')
                continue;
            if(k<cnt)
                continue;
            visited[dy][dx]=true;
            dfs(dx, dy,cnt+1);
            visited[dy][dx]=false;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[r][c];
        box = new char[r][c];

        for(int i=0; i<r; i++) {
            String str = br.readLine();
            box[i]=str.toCharArray();
        }

        visited[r-1][0]=true;
        dfs(0,r-1,1);

        System.out.println(ret);
    }
}