import java.io.*;
import java.util.*;
public class Main {
    /*
        @ n : 도시의 크기
        @ m : 사건 개수
        @ point : 경찰차 위치 0, 1 / 사건 위치 2 ~ m+2
        @ dp : 각 경찰차 위치마다 최소값, dp[경찰차 1][경찰차 2];
     */
    static int n, w, point[][], dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());
        point = new int[w+2][2];
        dp = new int[w+2][w+2];

        point[0][0] = 1;
        point[0][1] = 1;
        point[1][0] = n;
        point[1][1] = n;

        for (int i=2; i < w+2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(getSum(0, 1)+"\n");
        bw.write(route());
        bw.flush();
        bw.close();
        br.close();
    }

    static int getSum(int a, int b) {
        if(a==w+1 || b==w+1) return 0;
        if(dp[a][b]!=0) return dp[a][b];

        int next = Math.max(a, b) + 1; // 다음 사건을 가르킴

        return dp[a][b] = Math.min(getSum(a, next) + d(b, next), getSum(next, b) + d(a, next));
    }

    static String route() {
        StringBuilder sb = new StringBuilder();
        int cap1 = 0, cap2 = 1;
        for (int i=2; i<w+2; i++) {
            if( dp[i][cap2] + d(cap1, i) < dp[cap1][i] + d(cap2, i) )  {
                sb.append('1').append('\n');
                cap1 = i;
            }
            else {
                sb.append('2').append('\n');
                cap2 = i;
            }
        }
        return sb.toString();
    }

    static int d(int a, int b) {
        return Math.abs(point[a][0] - point[b][0]) + Math.abs(point[a][1] - point[b][1]);
    }
}