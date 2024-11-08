import java.io.*;
import java.util.*;
public class Main {
    static int n, pass[], stand[], dp[][][][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        pass = new int[n];
        stand = new int[n];

        toArray(br.readLine(), pass);
        toArray(br.readLine(), stand);

        dp = new int[n][10][10][10][2];

        for (int i=0; i<n; i++)
            for (int j=0; j<10; j++)
                for (int k=0; k<10; k++)
                    for (int l=0; l<10; l++)
                        Arrays.fill(dp[i][j][k][l], -1);

        bw.write(Math.min(go(0, 0,0,0, 1),go(0, 0,0,0, 0))+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void toArray(String str, int[] arr) {
        for (int i=0; i<str.length(); i++)
            arr[i] = str.charAt(i) - '0';
    }

    static int go(int index, int here, int next, int next2, int dire) {
        if(index==n) return 0;
        if(dp[index][here][next][next2][dire]!=-1) return dp[index][here][next][next2][dire];
        if(value(index, here) == pass[index]) return dp[index][here][next][next2][dire] = Math.min(go(index+1, next, next2, 0, 1) , go(index+1, next, next2, 0, 0));

        dp[index][here][next][next2][dire] = 987654321;
        if(dire==1) {
            for (int i=1; i<=3; i++) {
                dp[index][here][next][next2][dire] = Math.min(dp[index][here][next][next2][dire], 1 + go(index, (here+i)%10, next, next2, dire));
                dp[index][here][next][next2][dire] = Math.min(dp[index][here][next][next2][dire], 1 + go(index, (here+i)%10, (next+i)%10, next2, dire));
                dp[index][here][next][next2][dire] = Math.min(dp[index][here][next][next2][dire], 1 + go(index, (here+i)%10, (next+i)%10, (next2+i)%10, dire));
            }
        }
        else {
            for (int i=1; i<=3; i++) {
                dp[index][here][next][next2][dire] = Math.min(dp[index][here][next][next2][dire], 1 + go(index, (here+(10-i))%10, next, next2, dire));
                dp[index][here][next][next2][dire] = Math.min(dp[index][here][next][next2][dire], 1 + go(index, (here+(10-i))%10, (next+(10-i))%10, next2, dire));
                dp[index][here][next][next2][dire] = Math.min(dp[index][here][next][next2][dire], 1 + go(index, (here+(10-i))%10, (next+(10-i))%10, (next2+(10-i))%10, dire));
            }
        }
        return dp[index][here][next][next2][dire];
    }

    static int value(int index, int here) {
        return (stand[index]+here) % 10;
    }
}