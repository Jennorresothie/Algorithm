import java.io.*;
import java.util.*;
public class Main {
    static int n, ret, dire[][] = new int[][]{{0,1},{-1,0},{0,-1},{1,0}}, next[] = new int[]{1,2,3,0};
    static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            map[y][x] = true;
            makeCurve(x, y, d, g);
        }

        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(map[i][j]&&map[i][j+1]&&map[i+1][j]&&map[i+1][j+1]) ret++;
            }
        }

        bw.write(String.valueOf(ret));
        bw.close();
    }
    static void makeCurve(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        int dx = x + dire[d][1];
        int dy = y + dire[d][0];
        d = next[d];
        list.add(d);
        map[dy][dx] = true;
        for(int i=0; i<g; i++) {
            for(int j=list.size()-1; j>=0; j--) {
                int D = list.get(j);
                dx = dx + dire[D][1];
                dy = dy + dire[D][0];
                list.add(next[D]);
                map[dy][dx] = true;
            }
        }
    }
}