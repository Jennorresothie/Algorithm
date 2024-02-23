import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, box[][], ret=INF;
    static boolean visited[][];

    static int check(int x, int y) {
        int sum=0;
        int dire[][]={{0,0},{0,1},{0,-1},{1,0},{-1,0}};
        for(int d[] : dire){
            int dx = x+d[0];
            int dy = y+d[1];

            if(dx<0||dx>n||dy<0||dy>n||visited[dy][dx])
                return -1;

            sum+=box[dy][dx];
        }

        for(int d[] : dire){
            int dx = x+d[0];
            int dy = y+d[1];

            visited[dy][dx] = true;
        }

        return sum;
    }

    static void init(int x, int y){
        int dire[][]={{0,0},{0,1},{0,-1},{1,0},{-1,0}};

        for(int d[] : dire){
            int dx = x+d[0];
            int dy = y+d[1];

            visited[dy][dx] = false;
        }
    }

    static void dfs(int depth, int cnt){
        if(depth==3){
            ret=Math.min(cnt, ret);
            return;
        }

        for(int i=2; i<n; i++){
            for(int j=2; j<n; j++){
                int temp = check(j,i);
                if(temp==-1) continue;
                dfs(depth+1, cnt+temp);
                init(j,i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        box = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++)
                box[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(ret);
    }
}