import java.io.*;
import java.util.*;
public class Main {
    static int n, m, k, arr[][], ret = Integer.MAX_VALUE, rotateArr[][] = new int[6][4], order[];
    static int temp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        order = new int[k];
        temp = new int[n][m];

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
        dfs(0);
        bw.write(String.valueOf(ret));
        bw.close();
    }

    static void dfs(int depth) {
        if(depth>=k) {
            copy();
            for(int a: order) rotate(rotateArr[a][1], rotateArr[a][2], rotateArr[a][3]);
            findArr();
            return;
        }

        for(int i=0; i<k; i++) {
            if(rotateArr[i][0]==1) continue;
            rotateArr[i][0]=1;
            order[depth] = i;
            dfs(depth+1);
            rotateArr[i][0]=0;
        }
    }

    static void findArr() {
        for(int i=0; i<n; i++) {
            int sum=0;
            for (int j=0; j<m; j++) sum+=temp[i][j];
            ret = Math.min(sum, ret);
        }
    }

    static void copy(){
        for(int i=0; i<n; i++) temp[i] = Arrays.copyOf(arr[i], m);
    }

    static void rotate(int r, int c, int s) {

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

    }
}