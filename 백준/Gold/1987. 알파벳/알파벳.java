import java.util.*;
import java.io.*;

public class Main {
    static int n, m, ret=0;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] alpa = new boolean[27];

    static int[][] dire = {{1,0},{-1,0},{0,1},{0,-1}};

    static void dfs(int y, int x, int depth) {
        visited[y][x]=true;
        alpa[map[y][x]-'A']=true;

        for(int i=0; i<4; i++) {
            int nx = x + dire[i][0];
            int ny = y + dire[i][1];

            if(nx<0||nx>=m||ny<0||ny>=n||visited[ny][nx]||alpa[map[ny][nx]-'A'])
                continue;

            dfs(ny, nx, depth+1);
            alpa[map[ny][nx]-'A']=false;
            visited[ny][nx]=false;
        }

        if(ret<depth)
            ret=depth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            map[i]=str.toCharArray();
        }

        dfs(0,0,1);

        System.out.println(ret);

    }
}