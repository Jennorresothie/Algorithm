import java.util.*;
import java.io.*;
public class Main {
    static int n, arr[][], dp[][] = new int[1001][1001];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][3];
        visited = new boolean[n+1];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<1001; i++)
            Arrays.fill(dp[i], -1);

        bw.write(go(1,1)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int go (int STR, int INT) {
        if(dp[STR][INT] != -1) return dp[STR][INT];

        dp[STR][INT] = 0;
        int point = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if(arr[i][0] <= STR || arr[i][1] <= INT) {
                dp[STR][INT]++; // 해당 수치일때 깰 수 있는 퀘스트 카운트
                if(!visited[i]) {
                    visited[i] = true;
                    point += arr[i][2];
                    list.add(i);
                }
            }
        }

        for (int p=0; p<=point; p++) {
            int a = Math.min(1000, STR + p);
            int b = Math.min(1000, INT + point - p);
            dp[STR][INT] = Math.max(dp[STR][INT], go(a, b));
        }

        for (int h : list) visited[h] = false;

        return dp[STR][INT];
    }
}