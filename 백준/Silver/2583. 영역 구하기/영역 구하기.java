import java.util.*;
import java.io.*;

public class Main {
    static int[][] map, dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int N, M, depth;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K, cnt = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visit = new boolean[M][N];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int[] range = new int[4];
            for(int j=0; j<4; j++) {
                range[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=range[0]; j<range[2]; j++) {
                for(int k=range[1]; k<range[3]; k++) {
                    visit[j][k]=true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==0&&visit[i][j]==false) {
                    cnt++;
                    depth=0;
                    dfs(i,j);
                    list.add(depth);
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);
        for(int i : list){
            System.out.print(i+" ");
        }

    }

    private static void dfs(int x, int y){
        map[x][y] = depth++;
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int dx = dire[i][0] + x;
            int dy = dire[i][1] + y;

            if(0>dx||dx>=M||0>dy||dy>=N||visit[dx][dy])
                continue;

            dfs(dx, dy);
        }
    }
}