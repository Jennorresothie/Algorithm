import java.io.*;
import java.util.*;
public class Main {
    static int n, m, k, arr[][], ret = Integer.MAX_VALUE, rotateArr[][] = new int[6][4];

    static int[][] rotate(int[][] map, int r, int c, int s) {
        int[][] temp = new int[n][m];
        for(int i=0; i<n; i++) temp[i] = Arrays.copyOf(map[i], m);

        int[] p1 = new int[]{r-s, c-s};
        int[] p4 = new int[]{r+s, c+s};


        while(true) {
            if(p1[0]==p4[0]&&p1[1]==p4[1]) break;
            int next, pre;
            pre = temp[p1[0]][p1[1]];
            for(int i=p1[1]; i<p4[1]; i++) {
                next = temp[p1[0]][i+1];
                temp[p1[0]][i+1] = pre;
                pre = next;
            }
            for(int i=p1[0]; i<p4[0]; i++) {
                next = temp[i+1][p4[1]];
                temp[i+1][p4[1]] = pre;
                pre = next;
            }
            for(int i=p4[1]; i>p1[1]; i--) {
                next = temp[p4[0]][i-1];
                temp[p4[0]][i-1] = pre;
                pre = next;
            }
            for(int i=p4[0]; i>p1[0]; i--) {
                next = temp[i-1][p1[1]];
                temp[i-1][p1[1]] = pre;
                pre = next;
            }
            p1[0]++;
            p1[1]++;
            p4[0]--;
            p4[1]--;

        }

        return temp;
    }
    static void findArr(int[][] map) {
        for(int i=0; i<n; i++) {
            int sum=0;
            for (int j=0; j<m; j++) sum+=map[i][j];
            ret = Math.min(sum, ret);
        }
    }

    static void dfs(int depth, int[][] map) {
        if(depth>=k) {
            findArr(map);
            return;
        }

        for(int i=0; i<k; i++) {
            if(rotateArr[i][0]==1) continue;
            rotateArr[i][0]=1;
            dfs(depth+1, rotate(map, rotateArr[i][1], rotateArr[i][2], rotateArr[i][3]));
            rotateArr[i][0]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++) {
                rotateArr[i][j] = Integer.parseInt(st.nextToken());
                if(j<3)
                    --rotateArr[i][j];
            }
        }
        dfs(0, arr);
        bw.write(String.valueOf(ret));
        bw.close();
    }
}