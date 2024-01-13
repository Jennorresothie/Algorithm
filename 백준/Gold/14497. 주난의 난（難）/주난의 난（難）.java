import java.util.*;
import java.io.*;

public class Main {
    static int n, m, t_x, t_y, s_x, s_y;
    static int visited[][];
    static char map[][];

    static void bfs2(int x, int y, Queue<int[]> pq) {
        int[][] dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int next_x = dire[i][1]+cur[1];
                int next_y = dire[i][0]+cur[0];

                if(next_x<0||next_x>=m||next_y<0||next_y>=n||visited[next_y][next_x] > 0)
                    continue;
                if(map[next_y][next_x]=='1'){
                    visited[next_y][next_x] = visited[cur[0]][cur[1]] + 1;
                    pq.add(new int[]{next_y, next_x});
                    continue;
                }

                visited[next_y][next_x] = visited[cur[0]][cur[1]];

                q.add(new int[]{next_y, next_x});
            }
        }

    }

    static void bfs() {
        int[][] dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s_y, s_x});
        visited[s_y][s_x]=1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(visited[t_y][t_x]>0)
                return;

            for(int i=0; i<4; i++) {
                int next_x = dire[i][1]+cur[1];
                int next_y = dire[i][0]+cur[0];

                if(next_x<0||next_x>=m||next_y<0||next_y>=n||visited[next_y][next_x] > 0)
                    continue;

                if(map[next_y][next_x]=='1') {
                    visited[next_y][next_x] = visited[cur[0]][cur[1]] + 1;
                    q.add(new int[]{next_y, next_x});
                }
                else{
                    visited[next_y][next_x] = visited[cur[0]][cur[1]];
                    bfs2(next_x, next_y, q);

                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s_y = Integer.parseInt(st.nextToken())-1;
        s_x = Integer.parseInt(st.nextToken())-1;
        t_y = Integer.parseInt(st.nextToken())-1;
        t_x = Integer.parseInt(st.nextToken())-1;

        map = new char[n][m];
        visited = new int[n][m];

        for(int i=0; i <n; i++){
            map[i] = br.readLine().toCharArray();
        }

        bfs();



        System.out.println(visited[t_y][t_x]);

    }
}