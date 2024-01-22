import java.util.*;
import java.io.*;

public class Main {
    static int n,m, swanX, swanY, IceCnt;
    static char[][] map;
    static boolean checkSwan[][], visited[][];
    static Queue<int[]> Swan = new LinkedList<>();
    static Queue<int[]> temp = new LinkedList<>();
    static Queue<int[]> Ice = new LinkedList<>();

    // 백조
    // 1. 처음에 백조 위치 하나만 잡아서 큐에 넣음
    // 2. x만나면 다른 큐에 넣음
    // 3.
    static boolean findSwan(){
        int[][] dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while (!Swan.isEmpty()) {
           int[] cur = Swan.poll();

            if(cur[0]==swanY&&cur[1]==swanX){
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dire[i][1];
                int ny = cur[0] + dire[i][0];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || checkSwan[ny][nx])
                    continue;

                checkSwan[ny][nx] = true;

                if(map[ny][nx]=='X'){
                    temp.add(new int[]{ny, nx});
                    continue;
                }

                Swan.add(new int[]{ny, nx});

            }

        }
        return false;
    }

    // 얼음 녹이기
    static void breakIce(){
        int[][] dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};


        for(int j=0; j<IceCnt; j++){
            int[] cur = Ice.poll();

            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dire[i][1];
                int ny = cur[0] + dire[i][0];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx])
                    continue;

                if (map[ny][nx] == 'X') {
                    Ice.add(new int[]{ny, nx});
                    map[ny][nx] = '.';
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<int[]> list = new LinkedList<>();
        int ret=0;

        map = new char[n][m];
        checkSwan = new boolean[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='L'&& Swan.isEmpty()){
                    Swan.add(new int[]{i,j});
                    checkSwan[i][j]=true;
                    Ice.add(new int[]{i,j});
                }

                else if(map[i][j]=='L'&& !Swan.isEmpty()){
                    swanX=j;
                    swanY=i;
                    Ice.add(new int[]{i,j});
                }

                else if(map[i][j]=='.')
                    Ice.add(new int[]{i,j});
            }
        }

        while (true) {
            /*
            * 백조 먼저 작동
            * 그 다음 얼음 녹이기
            * */

            // 백조 찾기 작동
            // 반대쪽 백조 찾기으면 종료
            if( findSwan()) {
                System.out.println(ret);
                break;
            }

            // 아니라면 얼음 녹이기
            IceCnt=Ice.size();
            breakIce();

            // 다음에 시작할 백조 위치 옮기기
            while (!temp.isEmpty()){
                Swan.add(temp.poll());
            }

            ret++;

        }

    }
}