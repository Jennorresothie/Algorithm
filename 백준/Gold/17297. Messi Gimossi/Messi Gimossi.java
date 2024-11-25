import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine())-1;
        int dp[] = new int[41];
        dp[1] = 5;
        dp[2] = 13;
        for (int i=3; i<40; i++) dp[i] = dp[i-2] + dp[i-1] + 1;
        for (int i=39; i>=2; i-- )
            if ( n>= dp[i])
                n-=(dp[i]+1);

        String s = "Messi Gimossi";

        if(n == 5 || n == -1) bw.write("Messi Messi Gimossi");
        else bw.write(s.charAt(n));
        bw.close();
    }
}