import java.util.*;
import java.io.*;

public class Main {
    static int n, ret = Integer.MAX_VALUE;
    static int[][][] scv = new int[61][61][61];
    static int[] input = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dire = new int[][]{{-9,-3,-1},{-9,-1,-3},
            {-3,-9,-1},{-3,-1,-9},
            {-1,-3,-9},{-1,-9,-3}};

        Queue<int[]> q = new LinkedList<>();
        q.add(input);
        scv[input[0]][input[1]][input[2]] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<6; i++) {
                int da = cur[0] + dire[i][0];
                int db = cur[1] + dire[i][1];
                int dc = cur[2] + dire[i][2];

                if(da<0)
                    da=0;
                if(db<0)
                    db=0;
                if(dc<0)
                    dc=0;

                if(da==0&&db==0&&dc==0) {
                    ret = Math.min(ret, scv[cur[0]][cur[1]][cur[2]]);
                    continue;
                }

                if(scv[da][db][dc]!=0)
                    continue;

                scv[da][db][dc] = scv[cur[0]][cur[1]][cur[2]] + 1;
                q.add(new int[]{da, db, dc});
            }
        }

        System.out.println(ret);
    }
}