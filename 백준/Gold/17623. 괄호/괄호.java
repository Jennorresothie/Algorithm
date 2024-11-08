import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        String dp[] = new String[1001];
        Arrays.fill(dp, "");
        char a[] = {'(', ')', '{', '}', '[', ']'};

        for(int i = 0; i < 6; i++) map.put(Character.toString(i+'1'), a[i]+"");

        dp[1] = "12";
        dp[2] = "34";
        dp[3] = "56";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        int max = 0;
        int arr[] = new int[test];
        for (int t = 0; t<test; t++) {
            arr[t] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[t]);
        }

        for (int i=1; i<=max; i++) {
            if ( i%2==0 && check(dp[i], "1" + dp[i/2] +"2")) dp[i] = "1" + dp[i/2] +"2";
            if ( i%3==0 && check(dp[i], "3" + dp[i/3] +"4")) dp[i] = "3" + dp[i/3] +"4";
            if ( i%5==0 && check(dp[i], "5" + dp[i/5] +"6")) dp[i] = "5" + dp[i/5] +"6";

            for (int j=1; j<=i; j++) if (check(dp[i], dp[j]+dp[i-j])) dp[i] = dp[j]+dp[i-j];
        }

        for (int i : arr) {
            for (int j=0; j<dp[i].length(); j++)
                bw.write(map.get(dp[i].substring(j,j+1)));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check(String before, String after) {
        if (before.equals("") && after.equals("")) return false;
        if (before.equals("")) return true;
        if (before.length() == after.length()) return after.compareTo(before)<0;
        return after.length() < before.length();
    }
}