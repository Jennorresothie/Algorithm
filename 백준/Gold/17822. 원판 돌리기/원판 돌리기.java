import java.util.*;
import java.io.*;
public class Main {
    static int n, m, t, disk[][], ret, dx[] = {1,0,-1,0}, dy[]={0,-1,0,1};
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        disk = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) disk[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            rotate(x,d,z);
            if(!search()) setAvg();
        }
        for (int i=0; i<n; i++) for (int j=0; j<m; j++) ret += disk[i][j];
        bw.write(String.valueOf(ret));
        bw.close();
    }
    static void rotate(int x, int d, int z) {
        z = d==0?z:m-z;
        int temp[] = new int[m];
        for (int i=x; i<=n; i+=x) {
            for (int j=0; j<m; j++) {
                temp[(j+z)%m] = disk[i-1][j];
            }
            disk[i-1] = Arrays.copyOf(temp, m);
        }
    }
    static boolean search() {
        boolean flag = false;
        visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(visited[i][j]||disk[i][j]==0) continue;
                dfs(i, j, disk[i][j]);
                if(visited[i][j]) {
                    flag=true;
                    disk[i][j] = 0;
                }
            }
        }
        return flag;
    }
    static void dfs(int y, int x, int aim) {
        for (int i=0; i<4; i++) {
            int nx = (x+m+dx[i]) % m;
            int ny = dy[i] + y;
            if(ny<0||ny>=n||visited[ny][nx]) continue;
            if(aim == disk[ny][nx]) {
                visited[y][x] = visited[ny][nx] = true;
                dfs(ny, nx, aim);
                disk[ny][nx] = 0;
            }
        }
    }
    static void setAvg() {
        double sum, cnt;
        sum = cnt =0;
        for (int i=0; i<n; i++) for (int j=0; j<m; j++) if(disk[i][j]!=0) {
            cnt++;
            sum += disk[i][j];
        }
        sum = sum / cnt;
        for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
            if(disk[i][j]==0) continue;
            if((double)disk[i][j]>sum) disk[i][j]--;
            else if ((double)disk[i][j]<sum) disk[i][j]++;
        }
    }
}