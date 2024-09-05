import java.util.*;
import java.io.*;
public class Main {
    static int time[], w, dp[][], answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        time = new int[t];
        for (int i=0; i<t; i++)
            time[i] = Integer.parseInt(br.readLine());

        dp = new int[t][w+1];

        if (time[0] == 1) dp[0][0] = 1;

        for (int i=1; i<t; i++)
            dp[i][0] = time[i]==1?dp[i-1][0]+1:dp[i-1][0];

        if(w>=1){
            if(time[0]==2)
                dp[0][1]++;

            for (int i=1; i<t; i++) {
                for (int j=1; j<=w; j++) {
                    if(i+1<j) continue;
                    int temp = dp[i-1][j];
                    int move = dp[i-1][j-1];

                    if(j%2==1&&time[i]==2) {
                        temp++;
                        move++;
                    } else if(j%2==0&&time[i]==1) {
                        temp++;
                        move++;
                    }
                    dp[i][j] = Math.max(temp, move);
                }
            }
        }
        
        for (int j=0; j<=w; j++)
            answer = Math.max(answer, dp[t-1][j]);

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}