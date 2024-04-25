import java.io.*;

public class Main {
    static int n, ret = Integer.MIN_VALUE, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            sum += Integer.parseInt(str[i-1]);
            ret = Math.max(ret, sum);
            if(sum<0) sum=0;
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}