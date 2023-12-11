import java.util.*;
import java.io.*;

public class Main {
    static int n, l, r, sum, cnt;
    static int map[][];
    static boolean visit[][];
    static List<int[]> list;
    static int[][] dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];


        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            if(check()){
                ret++;
            }
            else
                break;
        }

        System.out.println(ret);

    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visit[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            list.add(cur);
            sum += map[cur[0]][cur[1]];
            cnt++;

            for(int i=0; i<4; i++) {
                int dy = cur[0] + dire[i][0];
                int dx = cur[1] + dire[i][1];

                if(0>dx||dx>=n||dy<0||dy>=n||visit[dy][dx])
                    continue;
                int val = Math.abs(map[dy][dx] - map[cur[0]][cur[1]]);
                if(l<=val&&val<=r){
                    visit[dy][dx] = true;
                    q.add(new int[]{dy, dx});
                }

            }
        }
    }

    private static boolean check() {
        boolean flag = false;
        visit = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visit[i][j]){
                    list = new ArrayList<>();
                    sum = cnt = 0;
                    bfs(i, j);
                    if(list.size()>1) {
                        flag= true;
                        sum = sum/cnt;
                        for(int[] point : list){
                            map[point[0]][point[1]] = sum;
                        }
                    }
                    else {
                        visit[i][j] = false;
                    }
                }
            }
        }

        return flag;
    }
}