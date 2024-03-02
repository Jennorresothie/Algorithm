import java.io.*;
import java.util.*;

public class Main {
    static int n, m, map[][], visited[][], max=0, cnt=1, total=0;
    static List<Integer> roomSize = new ArrayList<>();

    static void bfs(int y, int x) {
        int dire[][] = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        int ret=1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x]=cnt;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int dx = cur[1] + dire[i][1];
                int dy = cur[0] + dire[i][0];

                if((map[cur[0]][cur[1]]&(1<<i))>0||visited[dy][dx]!=0)
                    continue;

                visited[dy][dx]=cnt;
                ret++;
                queue.add(new int[]{dy, dx});
            }
        }
        max = Math.max(max,ret);
        roomSize.add(ret);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=stoi(st.nextToken());
        m=stoi(st.nextToken());

        map = new int[m][n];
        visited = new int[m][n];

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j]=stoi(st.nextToken());
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==0){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i+1<m){
                    int a = visited[i+1][j];
                    int b = visited[i][j];
                    if(a!=b)
                        total = Math.max(total, roomSize.get(a-1)+roomSize.get(b-1));
                }
                if(j+1<n){
                    int a = visited[i][j+1];
                    int b = visited[i][j];
                    if(a!=b)
                        total = Math.max(total, roomSize.get(a-1)+roomSize.get(b-1));
                }
            }
        }

        System.out.println(cnt-1);
        System.out.println(max);
        System.out.println(total);

    }
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}