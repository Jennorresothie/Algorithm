import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, c, arr[], dp[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[m][1<<n][c+1]; //[m번째 가방][보석][m번째 가방 용량]

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        bw.write(go(0,0,0)+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static int go(int bag, int taken, int capa) {
        // 종료 조건
        if(bag==m) return 0;
        if(dp[bag][taken][capa]!=0) return dp[bag][taken][capa];

        // 현재 가방에 보석 안 넣기
        dp[bag][taken][capa] = Math.max(dp[bag][taken][capa], go(bag+1, taken, 0));

        // 넣기
        for (int i=0; i<n; i++) {
            if((taken&(1<<i))>0) continue; // 가방에 넣은 보석인지 확인
            if(capa+arr[i]>c) continue; // 용량 넘어가는 확인
            dp[bag][taken][capa] = Math.max(dp[bag][taken][capa], go(bag, taken | (1<<i), capa+arr[i]) + 1);
        }

        return dp[bag][taken][capa];
    }
}