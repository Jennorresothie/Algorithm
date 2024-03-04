import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        int aSize = a.length;
        int bSize = b.length;
        int temp = 0;

        while(aSize>0||bSize>0){

            if(aSize>0) {
                aSize--;
                temp+=a[aSize]-'0';
            }
            if(bSize>0) {
                bSize--;
                temp+=b[bSize]-'0';
            }
            sb.append(temp%10);
            temp /= 10;
        }
        if(temp>0) sb.append(1);
        System.out.println(sb.reverse());
    }
}