import java.util.*;
import java.io.*;

public class Main {
    static int n,m,k;

    public static long solution(int b){
        if(b==1) return n%k;

        long temp = solution(b/2);

        temp = (temp * temp)%k;

        if(b%2==1)
            temp =  (temp*n) % k;

        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(solution(m));


    }
}