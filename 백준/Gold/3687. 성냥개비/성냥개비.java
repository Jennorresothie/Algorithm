import java.io.*;
import java.util.*;
public class Main {
    static final String INF = "111111111111111111111111111111111111111111111111119";
    static String dp[] = new String[101];
    static int num[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6}, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 3687
        int test = Integer.parseInt(br.readLine());
        for (int t=0; t<test; t++) {
            n = Integer.parseInt(br.readLine());
            Arrays.fill(dp, INF);
            dp[0] = "";
            // 최소값 bottomUp 방식
            //bw.write(bottom(n)+" "+findMax(n)+"\n");

            // 최소값 topdown 방식
            bw.write(top(n)+" "+findMax(n)+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static String findMax(int n) {
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            if((n&1)>0) {
                sb.append("7");
                n-=3;
            }
            else {
                sb.append("1");
                n-=2;
            }
        }
        return sb.toString();
    }

    static String bottom(int n) {
        for (int march=2; march<=n; march++) {
            for (int i=0; i<9; i++) {
                if(march-num[i]<0) continue; // 전체 성냥 개수 - 추가하려는 숫자의 성냥 개수
                if(dp[march-num[i]].equals("") && i==0) continue;
                dp[march] = min(dp[march], dp[march-num[i]]+String.valueOf(i));
            }
        }
        return dp[n];
    }

    static String top(int march) {
        // base case
        if(march==1) return dp[1];
        if(dp[march]!=INF) return dp[march];

        for (int i=0; i<10; i++) {
            if(march-num[i]<0) continue;
            if(march==n && i==0) continue;
            dp[march] = min(dp[march], String.valueOf(i)+top(march-num[i]));
        }

        return dp[march];
    }

    static String min(String a, String b) {
        if(a.length()>b.length()) return b;
        if(a.length()==b.length() && a.compareTo(b)>0) return b;
        return a;
    }

}