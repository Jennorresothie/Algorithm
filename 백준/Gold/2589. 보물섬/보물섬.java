import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char map[][];
    static int route[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max= 0;

        map = new char[n][m];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]=='L'){
                    route = new int[n][m];
                    max = Math.max(bfs(i, j), max);
                }
            }
        }

        System.out.println(--max);
    }

    private static int bfs(int y, int x) {
        int ret = 1;
        int[][] dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        route[y][x]= ret;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int dx = cur[1] + dire[i][1];
                int dy = cur[0] + dire[i][0];

                if(0>dx||dx>=m||0>dy||dy>=n||route[dy][dx]>0||map[dy][dx]=='W')
                    continue;
                route[dy][dx] = route[cur[0]][cur[1]] + 1;
                ret = Math.max(ret, route[dy][dx]);
                q.add(new int[]{dy, dx});
            }
        }
        return ret;
    }
}