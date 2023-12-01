import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int x, y;

    private static int bfs(){
        int ret=0;
        int[][] dire = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visit = new boolean[y][x];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int dx = cur[1] + dire[i][1];
                int dy = cur[0] + dire[i][0];

                if(0>dx||dx>=x||0>dy||dy>=y||visit[dy][dx]==true)
                    continue;
                if(map[dy][dx]==1){
                    ret++;
                    map[dy][dx]=0;
                }
                else
                    q.add(new int[]{dy, dx});
                visit[dy][dx] = true;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];
        for(int i= 0; i<y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret, prev=0;
        for(ret=0; ; ret++){
            int temp = bfs();
            if(temp==0){
                System.out.println(ret);
                System.out.println(prev);
                break;
            }
            else
                prev = temp;
        }
    }
}