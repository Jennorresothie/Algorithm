import java.io.*;
import java.util.*;
public class Main {
    static int n, m, k, visited[][][], ret=Integer.MAX_VALUE;
    static char[][] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        box = new char[n][m];
        visited = new int[k+1][n][m];
        for (int i=0; i<n; i++)
            box[i] = br.readLine().toCharArray();

        bfs();

        for(int i=0; i<=k; i++) {
            if(visited[i][n-1][m-1]!=0)
                ret = Math.min(ret,visited[i][n-1][m-1]);
        }

        if(ret==Integer.MAX_VALUE) ret=-1;

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    static void bfs(){
        int dire[][] = {{1,0},{0,1},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, k});
        visited[k][0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i=0; i<4; i++) {
                int ny = cur[0] + dire[i][0];
                int nx = cur[1] + dire[i][1];
                int t = cur[2];

                if(nx<0||nx>=m||ny<0||ny>=n)
                    continue;

                if(t>0&&box[ny][nx]=='1') {

                    if(visited[t][cur[0]][cur[1]]%2==0) {
                        if(visited[t-1][ny][nx]==0||visited[t-1][ny][nx]>visited[t][cur[0]][cur[1]] + 2) {
                            q.add(new int[]{ny, nx, t-1});
                            visited[t-1][ny][nx] = visited[t][cur[0]][cur[1]] + 2;
                        }
                    }

                    else {
                        if(visited[t-1][ny][nx]==0||visited[t-1][ny][nx]>visited[t][cur[0]][cur[1]] + 1) {
                            q.add(new int[]{ny, nx, t-1});
                            visited[t-1][ny][nx] = visited[t][cur[0]][cur[1]] + 1;
                        }
                    }

                }
                else if(box[ny][nx]=='0') {
                    if(visited[t][ny][nx]==0||visited[t][ny][nx]>visited[t][cur[0]][cur[1]] + 1) {
                        q.add(new int[]{ny, nx, t});
                        visited[t][ny][nx] = visited[t][cur[0]][cur[1]] + 1;
                    }
                }

            }
        }
    }
}