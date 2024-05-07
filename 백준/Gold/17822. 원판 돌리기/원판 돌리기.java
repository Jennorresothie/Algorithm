import java.util.*;
import java.io.*;
public class Main {
    static int n, m, t, map[][], dire[][] = {{1,0},{0,1},{-1,0},{0,-1}}, ret;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            rotate(x, d, k);
            if(!check()) setAvg();
        }

        for(int i=0; i<n; i++) for (int j=0; j<m; j++) ret += map[i][j];

        bw.write(String.valueOf(ret));
        bw.close();
    }

    static void rotate(int x, int d, int k) {
        int temp[] = new int[m];
        if(d==1) k = m - k;
        for (int i=x; i<=n; i+=x){
            for (int j=0; j<m; j++) {
                temp[(j+k)%m] = map[i-1][j];
            }
            map[i-1] = Arrays.copyOf(temp,m);
        }
    }

    static boolean check(){
        boolean flag = false;
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(map[i][j]==0) continue;
                if(visited[i][j]) continue;
                dfs(i, j, map[i][j]);
                if(visited[i][j]) {
                    flag = true;
                    map[i][j] = 0;
                }
            }
        }
        return flag;
    }

    static void dfs(int y, int x, int target) {
        for(int i=0; i<4; i++) {
            int dx = (x + dire[i][0] + m) % m;
            int dy = y + dire[i][1];
            if(dy<0||dy>=n||visited[dy][dx]) continue;
            if(target==map[dy][dx]) {
                visited[y][x] = visited[dy][dx] = true;
                dfs(dy, dx, target);
                map[dy][dx] = 0;
            }
        }
    }

    static void setAvg() {
        double cnt, total;
        cnt = total = 0;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(map[i][j]==0) continue;
                cnt++;
                total += map[i][j];
            }
        }
        double avg = total / cnt;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(map[i][j]==0) continue;
                if(avg<(double) map[i][j]) map[i][j]--;
                else if(avg>(double) map[i][j]) map[i][j]++;
            }
        }
    }
}