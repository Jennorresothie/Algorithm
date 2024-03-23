import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t, map[][], temp[][], airPuri[][], dire[][]={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strs;

        strs = br.readLine().split(" ");
        r = Integer.parseInt(strs[0]);
        c = Integer.parseInt(strs[1]);
        t = Integer.parseInt(strs[2]);

        map = new int[r][c];
        temp = new int[r][c];
        airPuri = new int[2][2];

        for(int i=0; i<r; i++) {
            strs = br.readLine().split( " ");
            for(int j=0; j<c; j++) {
                int v = Integer.parseInt(strs[j]);
                map[i][j] = v;

                if(v==-1){
                    if(airPuri[0][0]==0) {
                        airPuri[0][0] = i;
                        airPuri[0][1] = j;
                    } else {
                        airPuri[1][0] = i;
                        airPuri[1][1] = j;
                    }
                }
            }
        }

        for (int T = 0; T<t; T++) {
            diffusion();
            cleaner(0);
            cleaner(1);
        }

        int ret = 0;
        for (int y=0; y<r; y++) {
            for (int x=0; x<c; x++) ret += map[y][x];
        }

        ret += 2;

        System.out.println(ret);
    }
    static void diffusion() {
        // 초기화
        for(int[] _1D : temp) Arrays.fill(_1D, 0);

        for(int y=0; y<r; y++) {
            for(int x=0; x<c; x++) {
                if(map[y][x]<=0) continue;

                int origin = map[y][x];
                int diff = origin/5;

                for(int idx=0; idx<4; idx++) {
                    int dy = y + dire[idx][0];
                    int dx = x + dire[idx][1];

                    if(dy<0||dy>=r||dx<0||dx>=c||map[dy][dx]==-1) continue;
                    temp[dy][dx] += diff;
                    origin -= diff;
                }
                map[y][x] = origin;
            }
        }

        for(int y=0; y<r; y++) {
            for(int x=0; x<c; x++) {
                map[y][x] += temp[y][x];
            }
        }
    }

    static void cleaner(int input) {
        int sy = airPuri[input][0];
        int sx = airPuri[input][1];

        int dire[][];
        int bottom, top;
        if(input==0) {
            // 위쪽, 오른쪽 -> 왼쪽, 아래 -> 위, 왼 -> 오
            dire = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
            top = 0;
            bottom = sy;
        }
        else {
            // 아래 -> 위, 오 -> 완, 위-> 아래, 왼 -> 오
            dire = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
            top = sy;
            bottom = r-1;
        }

        int bearing = 0;
        int y = sy;
        int x = sx;
        while(bearing<4){
            int dy = y + dire[bearing][0];
            int dx = x + dire[bearing][1];

            if(dy==sy && dx==sx) break;

            if(dy<top||dy>bottom||dx<0||dx>=c) {
                bearing++;
                continue;
            }

            map[y][x] = map[dy][dx];
            y = dy; x = dx;
        }
        map[sy][sx+1] = 0;
        map[sy][sx] = -1;
    }
}