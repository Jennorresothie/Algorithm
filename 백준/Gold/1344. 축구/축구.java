import java.io.*;
import java.util.*;
public class Main {
    /*
    * 확률은 경우의 수이다
    * 경우의 수는 더하기를 해야한다
    *
    * 특히 확률의 경우 각 상활이 일어날 확률을 곱해줘야한다다
    *
    *
    * 실수형 연산은 등로로 비교하기 어렵다
    * 그래서 부등하로 비교해야한다다
    *
    * 이문제의 상태값은 [각 5분][A팀의 골 개수][B팀의 골 개수]
   * * */
    static boolean sosu[] = new boolean[19];
    static double a, b, dp[][][] = new double[19][19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = Double.parseDouble(br.readLine()) / 100;
        b = Double.parseDouble(br.readLine()) / 100;

        // 각 팀당 최대 득점 : 18골 이기에 18까지 소수를 체크
        era(); // 소수 구하기 : 에라토스테네스의 체

        //-1로 초기화 -1은 방문하지 않았다는 표시
        for(int i=0; i<19; i++)
            for(int j=0; j<19; j++)
                Arrays.fill(dp[i][j], -1);
        
        // 골이 소수일때만 더한다
        bw.write(fun(0,0,0)+"");
        bw.close();
    }

    static double fun(int time, int A, int B){

        // 각 팀을 득점이 소수인지 판단
        if(time==18) return !sosu[A] || !sosu[B] ? 1.0 : 0.0;

        if(dp[time][A][B] > -1) return dp[time][A][B];

        dp[time][A][B] = 0;

        // 각 시간당 4가지 경우 더함
        //1. 두 팀 다 무득점
        dp[time][A][B] += fun(time+1, A, B) * (1-a) * (1-b);
        //2. 두 팀 다 득점
        dp[time][A][B] += fun(time+1, A+1, B+1) * a * b;
        //3. A 팀만 득점
        dp[time][A][B] += fun(time+1, A+1, B) * a * (1-b);
        //4. B 팀만 득점
        dp[time][A][B] += fun(time+1, A, B+1) * (1-a) * b;

        return dp[time][A][B];
    }

    static void era() {
        sosu[0]=true;
        sosu[1]=true;
        for(int i=2; i<=18; i++) {
            for(int j=i+i; j<=18; j+=i) {
                sosu[j] = true;
            }
        }
    }
}