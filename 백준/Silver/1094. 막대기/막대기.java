import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = new char[8];
        int ret=0, n;
        n = Integer.parseInt(br.readLine());
        chars = Integer.toBinaryString(n).toCharArray();
        for(char c : chars){
            if(c=='1')
                ret++;
        }
        System.out.println(ret);
    }
}