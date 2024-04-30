import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ret = Integer.MIN_VALUE, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            sum += Integer.parseInt(st.nextToken());
            if(ret<sum) ret = sum;
            if(sum<0) sum=0;
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}