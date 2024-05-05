
import java.io.*;
import java.util.*;
public class Main {
    static class Cctv {
        int x,y,dire;

        public Cctv(int y, int x, int dire){
            this.x = x;
            this.y = y;
            this.dire = dire;
        }
    }
    static int n, m, zone, ret = 65, dx[] = new int[]{-1,0,1,0}, dy[] = new int[]{0,-1,0,1}, role[][][] = {
            {},
            {{0},{1},{2},{3}},
            {{0,2}, {1,3}},
            {{0,1}, {1,2}, {2,3}, {3,0}},
            {{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}},
            {{1,2,3,0}}
    };
    static List<Cctv> cctvs = new ArrayList<>();
    static int[][] map;

    static void dfs(int depth, int sum) {
        if(depth == cctvs.size()){
            ret = Math.min(ret, zone-sum);
            return;
        }

        Cctv cctv = cctvs.get(depth);
       for(int i=0; i<role[cctv.dire].length; i++) {
           int[] d = role[cctv.dire][i];
           int cnt = scan(cctv, d, -1);
           dfs(depth+1, sum+cnt);
           scan(cctv, d, 1);
       }

    }

    static int scan(Cctv cctv, int[] d, int command){
        int cnt = 0;
        for(int i=0; i<d.length; i++) {
            for(int j=1;;j++) {
                int nx = cctv.x + dx[d[i]]*j;
                int ny = cctv.y + dy[d[i]]*j;

                if(0>nx||nx>=m||0>ny||ny>=n||map[ny][nx]==6) break;
                if(map[ny][nx]>0) continue;
                if(map[ny][nx]==0) cnt++;
                map[ny][nx] += command;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        zone = n*m;
        map = new int[n][m];
        boolean visited[][] = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) {
                    visited[i][j] = true;
                    zone--;
                    if(map[i][j]!=6) {
                        cctvs.add(new Cctv(i, j, map[i][j]));
                    }
                }
            }
        }
        dfs(0, 0);
        bw.write(String.valueOf(ret));
        bw.close();
    }
}