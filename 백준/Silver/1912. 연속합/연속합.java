import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, ret = Integer.MIN_VALUE, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
            if(sum>ret) ret=sum;
            if(sum<0) sum=0;
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}