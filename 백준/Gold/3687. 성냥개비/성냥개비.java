import java.io.*;
import java.util.*;
public class Main {
    static final String INF = "11111111111111111111111111111111111111111111111111111119";
    static String dp[] = new String[102];
    static int a[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6}, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int test=0; test<t; test++) {
            n = Integer.parseInt(br.readLine());
            Arrays.fill(dp, INF);
            dp[0] = "";
            // 최소값 bottomup 방식
            bw.write(findMin_bottomUp(n)+" "+findMax(n)+"\n");

            // 최소값 top down 방식
            //bw.write(findMin_topDown(n)+" "+findMax(n)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String findMax(int march) {
        // 최대값은 숫자 길이를 최대로 만들면 된다
        // 성냥개비 100개 기준 1로 했을때 최대 50자리 수이다
        // int 10자리 long 20자리 -> String으로 값 표현
        // 문자열의 길이가 길수록 큰 수이다 그래서 그리디로 풀 수 있음
        StringBuilder sb = new StringBuilder();
        while (march>0) {
            if((march&1)>0) {
                sb.append('7');
                march-=3;
            }
            else {
                sb.append('1');
                march-=2;
            }
        }
        return sb.toString();
    }

    static String findMin_bottomUp(int march) {
        // 가장 작은 수는 모든 경우의 수에서 찾아야한다
        // dp[성냥개비의 수] = "최소값"
        for (int i=2; i<=march; i++) {
            for (int j=0; j<10; j++) {
                if (i - a[j] <0) continue; // 성냥개비 개수
                if(j==0 && dp[i - a[j]].equals("")) continue; // 맨 앞이 0일때 제외
                dp[i] = min(dp[i], dp[i-a[j]]+String.valueOf(j));
            }
        }
        return dp[march];
    }

    static String findMin_topDown(int march) {
        if(march==1) return dp[1];
        if(!dp[march].equals(INF)) return dp[march];
        
        for (int i=0; i<9; i++) {
            if(march-a[i]<0) continue; // 성낭개비 개수 확인
            if(march == n && i==0) continue; // 맨 처음에 0 방지
            dp[march] = min(dp[march], String.valueOf(i)+findMin_topDown(march - a[i]));
        }

        return dp[march];
    }

    static String min(String a, String b) {
        // 두 숫자 비교해서 최소값 반환
        if(a.length() > b.length()) return b.toString();
        else if (a.length() == b.length() && a.compareTo(b.toString())>0) return b.toString();
        return a;
    }
}