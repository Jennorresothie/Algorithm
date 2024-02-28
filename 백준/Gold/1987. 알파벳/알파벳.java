import java.util.*;
import java.io.*;

public class Main {
    static int r, c, ret, dire[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}}, alpa;
    static char box[][];

    static void dfs(int y, int x, int depth, int alpabet){

        ret = Math.max(depth, ret);

        for(int i=0; i<4; i++){
            int dx = x + dire[i][0];
            int dy = y + dire[i][1];

            if(dx<0||dx>=c||dy<0||dy>=r)
                continue;

            int temp = 1<<box[dy][dx]-'A';
            if((alpabet&temp)==0){
                dfs(dy, dx, depth+1, alpabet|temp);
            }

        }

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        box = new char[r][c];

        for(int i=0; i<r; i++)
            box[i]=br.readLine().toCharArray();

        dfs(0,0,1, 1<<box[0][0]-'A');
        System.out.println(ret);
    }
}