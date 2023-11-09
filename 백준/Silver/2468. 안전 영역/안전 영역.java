import java.util.*;
import java.io.*;

public class Main {

    static int max, maxNum;
    static short[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        max = 0;
        maxNum = 0;
        int N = Integer.parseInt(br.readLine());
        map = new short[N][N];

        for(int i=0; i<N; i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                short temp = Short.parseShort(st.nextToken());
                if(temp>maxNum)
                    maxNum = temp;
                map[i][j] = temp;
            }
        }

        for(int i=maxNum; i>=0; i--){
            int temp = bfs(i, N);
            
            if(max<temp)
                max = temp;
        }
        System.out.println(max);
    }

    private static int bfs(int h, int n){
        boolean[][] visit = new boolean[n][n];
        int result = 0;
        short[][] dire = new short[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<short []> q = new LinkedList<>();

        for(short i=0; i<n; i++) {
            for(short j=0; j<n; j++){

                if(map[i][j]>h&&visit[i][j]==false){
                    result++;
                    q.add(new short[]{i,j});
                    visit[i][j] = true;

                    while (!q.isEmpty()){
                        short[] cur = q.poll();

                        for(short k=0; k<4; k++) {
                            short dx = (short) (dire[k][0] + cur[0]);
                            short dy = (short) (dire[k][1] + cur[1]);

                            if(0>dx||dx>=n||0>dy||dy>=n||visit[dx][dy]==true||map[dx][dy]<=h)
                                continue;

                            visit[dx][dy] = true;
                            q.add(new short[]{dx, dy});

                        }
                    }
                }
            }
        }

        return result;
    }
}